package com.pennonedu.student_sign_api.service.impl;

import com.pennonedu.student_sign_api.service.LoginService;
import com.pennonedu.student_sign_api.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jishuai
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Map<String, String> getToken() {
        Map<String,String> map = new HashMap<>(16);
        String token = JwtUtil.getToken();
        map.put("expires_in","86400000");
        map.put("access_token", token);
        return map;
    }
}
