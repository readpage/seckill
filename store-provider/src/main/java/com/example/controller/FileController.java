package com.example.controller;

import com.example.response.Result;
import io.swagger.annotations.Api;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags = "文件上传")
@RequestMapping("/file")
public class FileController {
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file, @ApiIgnore Authentication authentication) {
        return  null;
    }
}
