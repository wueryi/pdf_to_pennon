package com.pennonedu.student_sign_api.exception;

public class MethodNotAllowedException extends RuntimeException {
    public MethodNotAllowedException(String message) {
        super(message);
    }

    public MethodNotAllowedException() {
        super();
    }
}
