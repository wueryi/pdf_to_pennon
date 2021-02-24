package com.pennonedu.student_sign_api.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author jishuai
 */
public class RequestParamSeal {
    @NotBlank(message = "流程id不能为空")
    private String flow_id;

    public String getFlow_id() {
        return flow_id;
    }

    public void setFlow_id(String flow_id) {
        this.flow_id = flow_id;
    }
}
