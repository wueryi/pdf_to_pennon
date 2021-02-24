package com.pennonedu.student_sign_api.controller;

import com.pennonedu.student_sign_api.bo.Response;
import com.pennonedu.student_sign_api.dto.RequestParamSeal;
import com.pennonedu.student_sign_api.service.SealService;
import com.pennonedu.student_sign_api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("seal")
public class SealController {
    @Autowired
    private SealService sealService;

    @RequestMapping(value = "get-position", method = RequestMethod.POST)
    public ResponseEntity<Response> getPosition(@Valid @RequestBody RequestParamSeal params){
        return ResponseUtil.respondWithSuccess(this.sealService.dispatch(Integer.parseInt(params.getFlow_id())));
    }
}
