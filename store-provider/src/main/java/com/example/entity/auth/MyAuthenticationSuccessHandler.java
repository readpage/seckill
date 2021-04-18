package com.example.entity.auth;

import com.example.entity.User;
import com.example.response.Result;
import com.example.response.ResultUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//登录操作

@Component
public class MyAuthenticationSuccessHandler extends JsonAuthentication implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Object principal=authentication.getPrincipal();
        Map map=new HashMap();
        map.put("username", ((User)principal).getUsername());
        Result result= ResultUtils.ok().data(principal).message("登录成功");
        toJson(httpServletRequest, httpServletResponse, result);
    }
}
