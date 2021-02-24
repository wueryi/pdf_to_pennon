package com.pennonedu.student_sign_api.exception;

/**
 * @author jishuai
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
