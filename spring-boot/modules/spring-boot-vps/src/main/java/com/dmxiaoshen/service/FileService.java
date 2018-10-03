package com.dmxiaoshen.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by hzhsg on 2018/9/30.
 */
public interface FileService {

    String upload(MultipartFile file,String filePath);
}
