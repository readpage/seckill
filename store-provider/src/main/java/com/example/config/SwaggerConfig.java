package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Value("${swagger.show}")
    private boolean swaggerShow;

    @Bean  //配置了Swagger的Docket的bean实例
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A")
                .apiInfo(apiInfo())
                .enable(swaggerShow)
                .select()
                //RequestHandlerSelectors ,配置要扫描接口的方式
                //basePackage指定要扫描的包
                //apy():扫描全部
                //none():都不扫描
                //withClassAnnotation: 扫描类上的注解
                //withMethodAnnotation: 扫描方法上的注解
                //withClassAnnotation: 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                //paths()过滤扫描路径
//                .paths(PathSelectors.ant("/test/**"))
                .build()
                ;
    }
    @Bean
    public Docket Docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B").enable(swaggerShow);
    }
    //配置Swagger信息=apiInfo
    private ApiInfo apiInfo() {
        //作者信息
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("即使再小的帆也能远航😂")
                .contact(new Contact("f1dao😥", "http://gitee.com/f1dao", "final1dao@qq.com"))
                .version("1.0")
                .build();
    }
}
