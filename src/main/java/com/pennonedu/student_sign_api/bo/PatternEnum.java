package com.pennonedu.student_sign_api.bo;

public enum PatternEnum {
    //测试队列
    TEST("test"),
    //
    SEAL_POSITION("seal-position"),
    //
    FAIL_DF("fail-pdf");

    private String name;

    PatternEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
