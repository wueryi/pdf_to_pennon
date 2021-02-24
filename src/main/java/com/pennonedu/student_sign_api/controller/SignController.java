package com.pennonedu.student_sign_api.controller;

import com.pennonedu.student_sign_api.bo.Response;
import com.pennonedu.student_sign_api.dto.RequestParamSign;
import com.pennonedu.student_sign_api.service.PdfService;
import com.pennonedu.student_sign_api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author jishuai
 */
@RestController
@RequestMapping(value = "/sign")
public class SignController {
    @Autowired
    private PdfService pdfService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Response> sign(@Valid @RequestBody RequestParamSign params) {

        return ResponseUtil.respondWithSuccess(pdfService.sign(Integer.parseInt(params.getAccount_id()), Integer.parseInt(params.getFlow_id())));
    }
}
