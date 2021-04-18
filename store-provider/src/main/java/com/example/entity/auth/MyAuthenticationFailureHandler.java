package com.example.entity.auth;

import com.example.response.Result;
import com.example.response.ResultCode;
import com.example.response.ResultUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationFailureHandler extends JsonAuthentication implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Result result=null;
        if (e instanceof BadCredentialsException) {
            result = ResultUtils.error(ResultCode.USER_CREDENTIALS_ERROR);
        } else if( e instanceof UsernameNotFoundException) {
            result = ResultUtils.error().message("用户名不存在");
        }
        else {
            //其他错误
            result = ResultUtils.error();
        }
        this.toJson(httpServletRequest, httpServletResponse, result);
    }
}
