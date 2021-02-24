package com.pennonedu.student_sign_api.component;

import com.pennonedu.student_sign_api.exception.MethodNotAllowedException;
import com.pennonedu.student_sign_api.exception.UnauthorizedException;
import com.pennonedu.student_sign_api.util.JwtUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jishuai
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) {
        //过滤非post请求
        if(!HttpMethod.POST.toString().equals(httpServletRequest.getMethod())) {
            throw new MethodNotAllowedException();
        }
        String authorization_token =  httpServletRequest.getHeader("Authorization");
        //token验证
        try{
            JwtUtil.parseToken(authorization_token);
        }catch (Exception exception){
            throw new UnauthorizedException();
        }
        return true;
    }
}
