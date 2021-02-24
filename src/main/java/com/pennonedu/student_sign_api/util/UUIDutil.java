package com.pennonedu.student_sign_api.util;

import java.util.UUID;

/**
 * @author jishuai
 */
public class UUIDutil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
