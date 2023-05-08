package com.item.myitem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

// 定义接口路径
@RestController
@RequestMapping("/file")
public class FileController {

    // 找一个计算机的磁盘位置，比如 D:\\, 我这里使用的是本项目的路径
    private static final String BASE_DIR = "D:\\上传文件\\";

    // 定义接口类型和二级路径，完整的接口url是：/file/upload
    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        // 获取文件的名称
        String fileName = file.getOriginalFilename();
        try {
            // 新建一个文件路径
            File uploadFile = new File(BASE_DIR + fileName);

            // 当父级目录不存在时，自动创建
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
            // 存储文件到电脑磁盘
            file.transferTo(uploadFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

