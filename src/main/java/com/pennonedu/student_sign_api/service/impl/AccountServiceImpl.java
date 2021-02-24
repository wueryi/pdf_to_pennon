package com.pennonedu.student_sign_api.service.impl;

import com.pennonedu.student_sign_api.bo.Subject;
import com.pennonedu.student_sign_api.dao.AccountCertMapper;
import com.pennonedu.student_sign_api.dao.AccountMapper;
import com.pennonedu.student_sign_api.entity.Account;
import com.pennonedu.student_sign_api.entity.AccountCert;
import com.pennonedu.student_sign_api.entity.AccountCertExample;
import com.pennonedu.student_sign_api.exception.BusinessException;
import com.pennonedu.student_sign_api.service.AccountService;
import com.pennonedu.student_sign_api.util.CertificateUtil;
import com.pennonedu.student_sign_api.util.DateUtil;
import com.pennonedu.student_sign_api.util.UUIDutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author jishuai
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Value("${private.certSavePath}")
    private String certSavePath;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountCertMapper accountCertMapper;

    @Override
    public AccountCert getP12(int accountId) {
        //返回值
        AccountCert accountCert;

        //获取用户
        Account account = this.accountMapper.selectByPrimaryKey(accountId);
        if (null == account) {
            throw new BusinessException("用户不存在");
        }
        if (account.getStatus() == 1) {
            //创建
            accountCert = this.createAccountCert(account);
        } else {
            //是否过期
            AccountCertExample accountCertExample = new AccountCertExample();
            AccountCertExample.Criteria accountCertExampleCriteria = accountCertExample.createCriteria();
            accountCertExampleCriteria.andAccountIdEqualTo(account.getId());
            accountCertExampleCriteria.andExpireAtGreaterThanOrEqualTo(DateUtil.currentTimestamp());
            accountCertExample.setOrderByClause("created_at DESC");
            List<AccountCert> accountCerts = this.accountCertMapper.selectByExample(accountCertExample);
            if (accountCerts.isEmpty()) {
                //创建
                accountCert = this.createAccountCert(account);
            } else {
                accountCert = accountCerts.get(0);
            }
        }

        return accountCert;
    }

    private AccountCert createAccountCert(Account account) {
        Subject subject = new Subject();
        subject.setOU(account.getId().toString() + "@" + account.getName() + "@" + account.getIdcard());
        String p12CertFileName = UUIDutil.getUUID() + ".p12";
        //证书密码
        String password = UUIDutil.getUUID();

        //当前时间+过期时间
        Date date = new Date();
        int createAt = new Long(date.getTime() / 1000).intValue();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, CertificateUtil.TERM_OF_VALIDITY_YEAR);
        int expireAt = new Long(calendar.getTime().getTime() / 1000).intValue();
        //存放地址

        String strDateFormat = "yyyy/MM/";
        SimpleDateFormat sim = new SimpleDateFormat(strDateFormat);
        String savedDest = sim.format(date) + p12CertFileName;
        String fileDest = this.certSavePath + sim.format(date) + p12CertFileName;

        CertificateUtil.createP12(fileDest, password, subject.toString());
        AccountCert addAccountCert = new AccountCert();

        try {
            //存储证书
            addAccountCert.setAccountId(account.getId());
            addAccountCert.setPath(savedDest);
            addAccountCert.setPassword(password);
            addAccountCert.setCreatedAt(createAt);
            addAccountCert.setExpireAt(expireAt);
            this.accountCertMapper.insert(addAccountCert);

            //修改account状态为已创建（2）
            account.setStatus((byte)2);
            account.setUpdatedAt(DateUtil.currentTimestamp());
            this.accountMapper.updateByPrimaryKeySelective(account);

        } catch (Exception exception) {
            throw new BusinessException("生成失败，证书信息存储失败");
        }


        return addAccountCert;
    }
}
