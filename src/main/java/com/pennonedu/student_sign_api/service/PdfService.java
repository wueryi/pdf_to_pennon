package com.pennonedu.student_sign_api.service;

import com.pennonedu.student_sign_api.entity.FlowAccount;

import java.util.Map;

/**
 * @author jishuai
 */
public interface PdfService {
    String fill(String srcFileUrl, String dstFileUrl, Map<String, String> textFields);

    FlowAccount sign(int accountId, int flowId);
}
