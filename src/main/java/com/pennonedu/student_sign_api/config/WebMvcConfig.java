package com.pennonedu.student_sign_api.config;

import com.pennonedu.student_sign_api.component.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jishuai
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPa-thPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        /*要执行的拦截器*/
        registry.addInterceptor(jwtInterceptor).
//                excludePathPatterns("/login").
                addPathPatterns("/**");
    }
}
