package com.example.service.impl;

import com.example.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public Boolean upload(MultipartFile file, String username) throws IOException {
        File path = new File("");
        if (!file.isEmpty()) {
            String filename = file.getOriginalFilename();
            File upload = new File(path.getAbsolutePath(), "/static/upload/" + filename);
            if (!upload.exists()) {
                upload.mkdirs();
            }
            System.out.println(upload);
            file.transferTo(upload);
            System.out.println(username+ "用户将" +filename+ "文件上传成功");
            return true;
        }
        return false;
    }
}
