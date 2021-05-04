package com.example.security.config;

import com.example.security.handler.*;
import com.example.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/swagger-ui/*",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/webjars/**",
            "/images/**",
            "/login.html"
    };
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                AUTH_WHITELIST
        );
    }

    //密码加密处理类
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //登录成功处理器
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    //登录失败处理器
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    //权限不足处理方案
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    //未登录，或者登录状态过期失效处理器
    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    //自定义用户登录接口
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
        dap.setUserDetailsService(userDetailsServiceImpl);
        dap.setPasswordEncoder(passwordEncoder);
        dap.setHideUserNotFoundExceptions(false);
        return dap;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Autowired
    private UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    @Autowired
    private UrlAccessDecisionManager urlAccessDecisionManager;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //所有请求都需要认证
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                // 设置登录页面
                .formLogin().loginPage("/login.html")
                //登录表单form中action的地址，也就是处理认证请求的路径
                .loginProcessingUrl("/login")

                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(myAuthenticationEntryPoint)
                .accessDeniedHandler(myAccessDeniedHandler)
                .and()
                .logout().permitAll()
                //退出之后删除cookie
                .deleteCookies("JSESSIONID");
        //配置头部
        http.headers()
                .contentTypeOptions()
                .and()
                .xssProtection()
                .and()
                //禁用缓存
                .cacheControl()
                .and()
                .httpStrictTransportSecurity()
                .and()
                //禁用页面镶嵌frame劫持安全协议  // 防止iframe 造成跨域
                .frameOptions().disable();
        //关闭CSRF跨域
        http.csrf().disable();
    }
}
