package com.pennonedu.student_sign_api.controller;

import com.pennonedu.student_sign_api.bo.Response;
import com.pennonedu.student_sign_api.service.LoginService;
import com.pennonedu.student_sign_api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jishuai
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ResponseEntity<Response> index() {
        return ResponseUtil.respondWithSuccess(loginService.getToken());
    }
}
