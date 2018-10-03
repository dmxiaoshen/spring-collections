package com.dmxiaoshen.controller;

import com.dmxiaoshen.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhsg on 2018/9/30.
 */
@RestController
@RequestMapping("/file")
@Validated
@Api(value = "文件上传", description = "文件上传")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "文件上传", notes = "根据指定路径上传文件", httpMethod = "POST", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, response = Map.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", paramType = "form", required = true, dataType = "File"),
            @ApiImplicitParam(name = "filePath", value = "文件存放路径", paramType = "form", required = false, dataType = "String"),
    })
    public Map<String, Object> upload(@NotNull @RequestParam("file") MultipartFile file, @RequestParam(value = "filePath", required = false) String filePath) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("file", fileService.upload(file, filePath));
        return result;
    }
}
