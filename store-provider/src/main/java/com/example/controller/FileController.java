package com.example.controller;

import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.FileService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

@RestController
@Api(tags = "文件上传")
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file, @ApiIgnore Authentication authentication) throws IOException {
        if (fileService.upload(file, authentication.getName())) {
            ResultUtils.ok().message("上传成功!");
        }
        return ResultUtils.error().message("上传失败!");
    }
}
