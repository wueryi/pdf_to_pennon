package com.pennonedu.student_sign_api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author jishuai
 */
public class RequestParamFill {
    @NotNull(message = "表单数据不能缺失")
    private Map<String, String> txt_fields;

    @NotBlank(message = "模板地址不能为空")
    private String src_file_url;

    @NotBlank(message = "目标地址不能忘为空")
    private String dst_file_url;

    public Map<String, String> getTxt_fields() {
        return txt_fields;
    }

    public void setTxt_fields(Map<String, String> txt_fields) {
        this.txt_fields = txt_fields;
    }

    public String getSrc_file_url() {
        return src_file_url;
    }

    public void setSrc_file_url(String src_file_url) {
        this.src_file_url = src_file_url;
    }

    public String getDst_file_url() {
        return dst_file_url;
    }

    public void setDst_file_url(String dst_file_url) {
        this.dst_file_url = dst_file_url;
    }
}
