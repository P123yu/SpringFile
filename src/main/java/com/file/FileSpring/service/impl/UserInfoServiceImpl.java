package com.file.FileSpring.service.impl;

import com.file.FileSpring.model.UserInfo;
import com.file.FileSpring.repository.UserInfoRepository;
import com.file.FileSpring.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service

public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    private String uploadDir="C:\\Users\\piyush_kumar\\Desktop\\springFile";


    @Override
    public UserInfo uploadFile(String username, String folder, MultipartFile file) throws IOException {

        // data saved in table
        UserInfo userInfo= UserInfo.builder().username(username).folder(folder).fileName(file.getOriginalFilename()).build();
        UserInfo user=userInfoRepository.save(userInfo);

        // file or folder directory
        Path FilePath = Path.of(uploadDir, folder, file.getOriginalFilename());
        Files.createDirectories(FilePath.getParent());
        Files.copy(file.getInputStream(), FilePath, StandardCopyOption.REPLACE_EXISTING);

        return user;
    }
}
