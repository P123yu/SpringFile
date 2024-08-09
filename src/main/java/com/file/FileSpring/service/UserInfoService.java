package com.file.FileSpring.service;

import com.file.FileSpring.model.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface UserInfoService {
    // upload the file or image
    UserInfo uploadFile(String username, String folder, MultipartFile file) throws IOException;
}
