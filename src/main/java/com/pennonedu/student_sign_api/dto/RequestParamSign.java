package com.pennonedu.student_sign_api.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author jishuai
 */
public class RequestParamSign {
    @NotBlank(message = "账户id不能为空")
    private String account_id;

    @NotBlank(message = "流程id不能为空")
    private String flow_id;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getFlow_id() {
        return flow_id;
    }

    public void setFlow_id(String flow_id) {
        this.flow_id = flow_id;
    }
}
