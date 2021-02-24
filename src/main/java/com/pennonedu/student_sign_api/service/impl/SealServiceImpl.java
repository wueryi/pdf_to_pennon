package com.pennonedu.student_sign_api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pennonedu.student_sign_api.bo.PatternEnum;
import com.pennonedu.student_sign_api.bo.RectangleCentre;
import com.pennonedu.student_sign_api.bo.SealPosition;
import com.pennonedu.student_sign_api.dao.AccountMapper;
import com.pennonedu.student_sign_api.dao.FlowFileAccountMapper;
import com.pennonedu.student_sign_api.dao.FlowFileMapper;
import com.pennonedu.student_sign_api.entity.*;
import com.pennonedu.student_sign_api.exception.BusinessException;
import com.pennonedu.student_sign_api.service.SealService;
import com.pennonedu.student_sign_api.util.DateUtil;
import com.pennonedu.student_sign_api.util.FileUtil;
import com.pennonedu.student_sign_api.util.ITextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;

@Service("SealService")
public class SealServiceImpl implements SealService {
    @Value("${private.filePrefix}")
    private String filePrefix;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private FlowFileMapper flowFileMapper;

    @Autowired
    private FlowFileAccountMapper flowFileAccountMapper;

    @Override
    public List<Integer> dispatch(int flowId) {
        FlowFileAccountExample flowFileAccountExample = new FlowFileAccountExample();
        FlowFileAccountExample.Criteria criteria = flowFileAccountExample.createCriteria();
        criteria.andFlowIdEqualTo(flowId);
        List<FlowFileAccount> flowFileAccountList = this.flowFileAccountMapper.selectByExample(flowFileAccountExample);

        //分发处理消息
        for (FlowFileAccount flowFileAccount : flowFileAccountList) {
            try{
                ObjectMapper mapper = new ObjectMapper();
                redisTemplate.convertAndSend(PatternEnum.SEAL_POSITION.getName(), mapper.writeValueAsString(flowFileAccount));
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }

        return flowFileAccountList.stream().map(FlowFileAccount::getFileId).collect(Collectors.toList());
    }

    @Override
    public void handle(FlowFileAccount flowFileAccount) {
        FlowFileExample flowFileExample = new FlowFileExample();
        FlowFileExample.Criteria criteria = flowFileExample.createCriteria();
        criteria.andFlowIdEqualTo(flowFileAccount.getFlowId());
        criteria.andIdEqualTo(flowFileAccount.getFileId());
        List<FlowFile> flowFiles = this.flowFileMapper.selectByExample(flowFileExample);
        if (flowFiles.isEmpty()) {
            throw new BusinessException("暂无对应暂无合同文件信息");
        }
        FlowFile flowFile = flowFiles.get(0);
        //文件地址
        String flowFilePath = FileUtil.getAbsolutePath(filePrefix,flowFile.getPath());
        if (!FileUtil.checkFile(flowFilePath)) {
            throw new BusinessException("合同文件不存在");
        }
        Lock lock=redisLockRegistry.obtain(PatternEnum.SEAL_POSITION.getName());
        try {
            lock.lock();
            System.out.println(lock.toString());
            RectangleCentre rectangleCentre = ITextUtil.getRectangleByKeywords(flowFilePath, flowFileAccount.getSealPosition());

            //根据账户类型判断图标大小
            Account account = this.accountMapper.selectByPrimaryKey(flowFileAccount.getAccountId());
            //普通签名
            float height = 60;
            float width = 60;
            SealPosition sealPosition = rectangleCentre.getPosition(height, width);
            //企业印章
            if (account.getType().intValue()==1) {
                height = 160;
                width = 160;
                sealPosition = rectangleCentre.getPosition(height, width);
                sealPosition.setLlx(sealPosition.getLlx()+20);
                sealPosition.setLly(sealPosition.getLly()+20);
                sealPosition.setUrx(sealPosition.getUrx()+20);
                sealPosition.setUry(sealPosition.getUry()+20);
            }

            flowFileAccount.setSealPage((byte) rectangleCentre.getPage());
            flowFileAccount.setSealLlx(sealPosition.getLlx());
            flowFileAccount.setSealLly(sealPosition.getLly());
            flowFileAccount.setSealUrx(sealPosition.getUrx());
            flowFileAccount.setSealUry(sealPosition.getUry());
            flowFileAccount.setUpdatedAt(DateUtil.currentTimestamp());
            this.flowFileAccountMapper.updateByPrimaryKeySelective(flowFileAccount);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("获取签章位置出错");
        }finally {
            lock.unlock();
        }
    }
}
