package com.pennonedu.student_sign_api.service.impl;

import com.pennonedu.student_sign_api.bo.RectangleCentre;
import com.pennonedu.student_sign_api.bo.SealPosition;
import com.pennonedu.student_sign_api.bo.SignatureInfo;
import com.pennonedu.student_sign_api.dao.AccountMapper;
import com.pennonedu.student_sign_api.dao.FlowAccountMapper;
import com.pennonedu.student_sign_api.dao.FlowFileAccountMapper;
import com.pennonedu.student_sign_api.dao.FlowFileMapper;
import com.pennonedu.student_sign_api.entity.*;
import com.pennonedu.student_sign_api.exception.BusinessException;
import com.pennonedu.student_sign_api.service.AccountService;
import com.pennonedu.student_sign_api.service.PdfService;
import com.pennonedu.student_sign_api.util.DateUtil;
import com.pennonedu.student_sign_api.util.FileUtil;
import com.pennonedu.student_sign_api.util.ITextUtil;
import com.pennonedu.student_sign_api.util.UUIDutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jishuai
 */
@Service
public class PdfServiceImpl implements PdfService {
    @Value("${private.filePrefix}")
    private String filePrefix;

    @Value("${private.certSavePath}")
    private String certSavePath;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private FlowAccountMapper flowAccountMapper;

    @Autowired
    private FlowFileAccountMapper flowFileAccountMapper;

    @Autowired
    private FlowFileMapper flowFileMapper;

    @Override
    public String fill(String srcFileUrl, String dstFileUrl, Map<String, String> textFields) {
        //检测文件是否存在
        if (!FileUtil.checkFile(srcFileUrl)) {
            throw new BusinessException("模板文件不存在");
        }
        try {
            return ITextUtil.fill(srcFileUrl, dstFileUrl, textFields);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BusinessException("填充数据失败");
        }
    }

    @Override
    public FlowAccount sign(int accountId, int flowId) {
        //是否存在证书，不存在重新创建
        AccountCert accountCert = this.accountService.getP12(accountId);
        String accountCertFile = this.certSavePath + accountCert.getPath();
        //检测文件是否存在
        if (!FileUtil.checkFile(accountCertFile)) {
            throw new BusinessException("证书文件不存在");
        }

        //是否已签字
        FlowAccountExample flowAccountExample = new FlowAccountExample();
        FlowAccountExample.Criteria criteriaFlowAccount = flowAccountExample.createCriteria();
        criteriaFlowAccount.andAccountIdEqualTo(accountId);
        criteriaFlowAccount.andFlowIdEqualTo(flowId);
        List<FlowAccount> flowAccounts = this.flowAccountMapper.selectByExample(flowAccountExample);
        if (flowAccounts.isEmpty()) {
            throw new BusinessException("暂无合同流程信息");
        }
        FlowAccount flowAccount = flowAccounts.get(0);

        //签字印章文件获取
        FlowFileAccountExample flowFileAccountExample = new FlowFileAccountExample();
        FlowFileAccountExample.Criteria criteriaFlowFileAccount = flowFileAccountExample.createCriteria();
        criteriaFlowFileAccount.andAccountIdEqualTo(accountId);
        criteriaFlowFileAccount.andFlowIdEqualTo(flowId);
        List<FlowFileAccount> flowFileAccounts = this.flowFileAccountMapper.selectByExample(flowFileAccountExample);
        if (flowFileAccounts.isEmpty()) {
            throw new BusinessException("暂无印章文件信息");
        }
        List<String> sealPaths = flowFileAccounts.stream().map(FlowFileAccount::getSealPath).collect(Collectors.toList());
        if (!FileUtil.checkFiles(sealPaths, filePrefix)) {
            throw new BusinessException("签章文件不存在");
        }

        //合同文件路径
        FlowFileExample flowFileExample = new FlowFileExample();
        FlowFileExample.Criteria criteriaFlowFile = flowFileExample.createCriteria();
        List<Integer> flowFileAccountFileIds = flowFileAccounts.stream().map(FlowFileAccount::getFileId).collect(Collectors.toList());

        criteriaFlowFile.andFlowIdEqualTo(flowId);
        criteriaFlowFile.andIdIn(flowFileAccountFileIds);
        List<FlowFile> flowFiles = this.flowFileMapper.selectByExample(flowFileExample);
        if (flowFiles.isEmpty()) {
            throw new BusinessException("暂无合同文件信息");
        }
        List<String> paths = flowFiles.stream().map(FlowFile::getPath).collect(Collectors.toList());
        if (!FileUtil.checkFiles(paths, filePrefix)) {
            throw new BusinessException("合同文件不存在");
        }

        try {
            //遍历生成签章信息
            for (FlowFileAccount flowFileAccount : flowFileAccounts) {
                KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
                ks.load(new FileInputStream(accountCertFile), accountCert.getPassword().toCharArray());
                String alias = ks.aliases().nextElement();
                PrivateKey pk = (PrivateKey) ks.getKey(alias, accountCert.getPassword().toCharArray());
                Certificate[] chain = ks.getCertificateChain(alias);

                SignatureInfo signInfo = new SignatureInfo();
                signInfo.setReason("签署合同@" + flowAccount.getFlowId());
                signInfo.setLocation("青岛");
                signInfo.setPk(pk);
                signInfo.setChain(chain);
                signInfo.setFieldName(flowFileAccount.getSealPosition() + "@" + UUIDutil.getUUID());
                // 签章图片
                String sealPath = FileUtil.getAbsolutePath(filePrefix, flowFileAccount.getSealPath());
                signInfo.setImagePath(sealPath);

                //查找对应合同文件
                List<FlowFile> flowFilesByFileId = flowFiles.stream().filter(flowFile -> flowFile.getId().equals(flowFileAccount.getFileId())).collect(Collectors.toList());
                if (flowFilesByFileId.isEmpty()) {
                    throw new BusinessException("暂无对应暂无合同文件信息");
                }
                FlowFile flowFile = flowFilesByFileId.get(0);

                //文件地址
                String flowFilePath = FileUtil.getAbsolutePath(filePrefix, flowFile.getPath());

                //是否已计算位置
                if (flowFileAccount.getSealPage() == 0) {
                    RectangleCentre rectangleCentre = ITextUtil.getRectangleByKeywords(flowFilePath, flowFileAccount.getSealPosition());

                    //根据账户类型判断图标大小
                    Account account = this.accountMapper.selectByPrimaryKey(accountId);
                    //普通签名
                    float height = flowFileAccount.getSealHeight();
                    float width = flowFileAccount.getSealWidth();
                    SealPosition sealPosition = rectangleCentre.getPosition(height, width);

                    flowFileAccount.setSealPage((byte) rectangleCentre.getPage());
                    flowFileAccount.setSealLlx(sealPosition.getLlx());
                    flowFileAccount.setSealLly(sealPosition.getLly());
                    flowFileAccount.setSealUrx(sealPosition.getUrx());
                    flowFileAccount.setSealUry(sealPosition.getUry());
                    flowFileAccount.setUpdatedAt(DateUtil.currentTimestamp());
                    this.flowFileAccountMapper.updateByPrimaryKeySelective(flowFileAccount);

                    signInfo.setPage(rectangleCentre.getPage());
                    signInfo.setLlx(sealPosition.getLlx());
                    signInfo.setLly(sealPosition.getLly());
                    signInfo.setUrx(sealPosition.getUrx());
                    signInfo.setUry(sealPosition.getUry());
                } else {
                    signInfo.setPage(flowFileAccount.getSealPage());
                    signInfo.setLlx(flowFileAccount.getSealLlx());
                    signInfo.setLly(flowFileAccount.getSealLly());
                    signInfo.setUrx(flowFileAccount.getSealUrx());
                    signInfo.setUry(flowFileAccount.getSealUry());
                }

                ITextUtil.sign(flowFilePath, flowFilePath, signInfo);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BusinessException("合同签署失败");
        }

        return flowAccount;
    }
}
