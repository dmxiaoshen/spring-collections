package com.dmxiaoshen.service.impl;

import com.dmxiaoshen.config.FileConfig;
import com.dmxiaoshen.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by hzhsg on 2018/9/30.
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService{
    @Autowired
    private FileConfig fileConfig;

    @Override
    public String upload(MultipartFile file, String filePath) {
        String fileName = file.getOriginalFilename();
        if(filePath!=null && !"".equals(filePath)){
            fileName = filePath+File.separator+fileName;
        }
        String distFile = fileConfig.getDir()+ File.separator+fileName;
        File f = new File(distFile);
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(f));
            in = new BufferedInputStream(file.getInputStream());
            byte[] b = new byte[1024];
            int len = 0;
            while ((len=in.read(b))!=-1){
                out.write(b,0,len);
            }
            out.flush();
        } catch (Exception e) {
            log.error("上传文件失败",e);
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return distFile;
    }

}
