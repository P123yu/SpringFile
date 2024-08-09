package com.file.FileSpring.controller;


import com.file.FileSpring.model.UserInfo;
import com.file.FileSpring.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/upload")
    public ResponseEntity<?>uploadFiles(@RequestPart String username,@RequestPart String folder,@RequestPart MultipartFile file) throws IOException {
        UserInfo userInfo=userInfoService.uploadFile(username,folder,file);
        if(userInfo !=null){
            return ResponseEntity.ok(userInfo);
        }
        else{
            return ResponseEntity.badRequest().body("File upload failed");
        }
    }

}
