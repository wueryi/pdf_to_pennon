package com.pennonedu.student_sign_api.exception;

/**
 * @author jishuai
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
