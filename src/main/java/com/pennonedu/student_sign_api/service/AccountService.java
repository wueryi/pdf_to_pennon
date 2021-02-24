package com.pennonedu.student_sign_api.service;

import com.pennonedu.student_sign_api.entity.AccountCert;

/**
 * @author jishuai
 */
public interface AccountService {
    public AccountCert getP12(int accountId);
}
