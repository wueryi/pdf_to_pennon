package com.pennonedu.student_sign_api.controller;

import com.pennonedu.student_sign_api.bo.Response;
import com.pennonedu.student_sign_api.dto.RequestParamFill;
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
@RequestMapping("template")
@ResponseBody
public class TemplateController {
    @Autowired
    private PdfService pdfService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Response> fill(@Valid  @RequestBody RequestParamFill params) {
        return ResponseUtil.respondWithSuccess(pdfService.fill(params.getSrc_file_url(),params.getDst_file_url(),params.getTxt_fields()));
    }
}