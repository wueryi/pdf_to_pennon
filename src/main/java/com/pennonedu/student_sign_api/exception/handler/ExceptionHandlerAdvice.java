package com.pennonedu.student_sign_api.exception.handler;

import com.itextpdf.text.DocumentException;
import com.pennonedu.student_sign_api.bo.Response;
import com.pennonedu.student_sign_api.bo.ResponseEnum;
import com.pennonedu.student_sign_api.exception.BusinessException;
import com.pennonedu.student_sign_api.exception.MethodNotAllowedException;
import com.pennonedu.student_sign_api.exception.NotFoundException;
import com.pennonedu.student_sign_api.exception.UnauthorizedException;
import com.pennonedu.student_sign_api.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.List;

/**
 * @author jishuai
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response> handBusinessException(BusinessException exception){
        return ResponseUtil.respondWithError(exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> handNotFoundException(NotFoundException exception){
        return ResponseUtil.respondWithError(ResponseEnum.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> handRuntimeException(RuntimeException exception){
        return ResponseUtil.respondWithError(exception.getMessage());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Response> handIOException(IOException exception){
        return ResponseUtil.respondWithError(ResponseEnum.IO_ERROR);
    }

    @ExceptionHandler(DocumentException.class)
    public ResponseEntity<Response> handDocumentException(DocumentException exception){
        return ResponseUtil.respondWithError("iText 文档异常："+exception.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Response> handUnauthorizedException(UnauthorizedException exception){
        return ResponseUtil.respondWithError(ResponseEnum.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<Response> handMethodNotAllowedException(MethodNotAllowedException exception){
        return ResponseUtil.respondWithError(ResponseEnum.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError error : fieldErrors) {
            stringBuilder.append( error.getDefaultMessage()+"\n");
        }
        return ResponseUtil.respondWithError("方法参数验证未通过:"+stringBuilder);
    }
}