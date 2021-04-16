package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("/admin/hello")
    public String admin() {
        return "hello user!";
    }

    @RequestMapping("/user/hello")
    public String user() {
        return "hello user!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/dba/hello")
    public String dba() {
        return "hello dba!";
    }
}
