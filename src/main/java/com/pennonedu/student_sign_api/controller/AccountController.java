package com.pennonedu.student_sign_api.controller;

import com.pennonedu.student_sign_api.bo.Response;
import com.pennonedu.student_sign_api.dto.RequestParamAccount;
import com.pennonedu.student_sign_api.service.AccountService;
import com.pennonedu.student_sign_api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author jishuai
 */
@RequestMapping("account")
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@Valid @RequestBody RequestParamAccount params) {
        return ResponseUtil.respondWithSuccess(accountService.getP12(Integer.parseInt(params.getAccountId())));
    }
}
