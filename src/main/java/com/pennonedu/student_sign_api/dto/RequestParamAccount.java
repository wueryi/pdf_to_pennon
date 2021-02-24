package com.pennonedu.student_sign_api.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author jishuai
 */
public class RequestParamAccount {
    @NotBlank(message = "账户id不能为空")
    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
