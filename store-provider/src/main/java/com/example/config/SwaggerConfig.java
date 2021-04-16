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
        return new Docket(DocumentationType.SWAGGER_2).groupName("seckill")
                .apiInfo(apiInfo())
                .enable(swaggerShow)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build();
    }
    //配置Swagger信息 apiInfo
    private ApiInfo apiInfo() {
        //作者信息
        return new ApiInfoBuilder()
                .title("seckill接口文档")
                .description("即使再小的帆也能远航")
                .contact(new Contact("f1dao", "http://gitee.com/f1dao", "final1dao@qq.com"))
                .version("1.0")
                .build();
    }
}
