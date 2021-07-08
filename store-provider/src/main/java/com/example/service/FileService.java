package com.example.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    Boolean upload(MultipartFile file, String username) throws IOException;
}
