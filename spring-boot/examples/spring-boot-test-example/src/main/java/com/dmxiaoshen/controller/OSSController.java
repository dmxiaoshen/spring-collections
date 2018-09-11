package com.dmxiaoshen.controller;

import com.dmxiaoshen.aliyun.oss.support.AliyunOSSSupport;
import com.dmxiaoshen.dto.OSSUploadResp;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * Created by hzhsg on 2018/8/24.
 */
@RestController
@RequestMapping("/oss")
@Validated
public class OSSController {

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public OSSUploadResp upload(@NotNull @RequestParam("file")MultipartFile file, @NotBlank @RequestParam("suffix")String suffix,@RequestParam(value = "perpetual",required = false)boolean perpetual){
        OSSUploadResp res = new OSSUploadResp();
        try {
            System.out.println(perpetual);
            String fileKey = AliyunOSSSupport.put(suffix,file.getInputStream());
            String fileUrl = perpetual?AliyunOSSSupport.getUrl(fileKey,-1):AliyunOSSSupport.getUrl(fileKey);
            res.setFileKey(fileKey);
            res.setUrl(fileUrl);
        } catch (IOException e) {
            throw new RuntimeException("上传文件失败");
        }
        return res;
    }
}
