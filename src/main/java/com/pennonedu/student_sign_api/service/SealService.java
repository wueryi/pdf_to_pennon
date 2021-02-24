package com.pennonedu.student_sign_api.service;

import com.pennonedu.student_sign_api.entity.FlowFileAccount;

import java.util.List;

public interface SealService {
    List<Integer> dispatch(int flowId);

    void handle(FlowFileAccount flowFileAccount);
}
