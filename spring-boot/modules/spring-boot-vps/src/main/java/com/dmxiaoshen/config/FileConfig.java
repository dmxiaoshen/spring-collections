package com.dmxiaoshen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hzhsg on 2018/9/30.
 */
@ConfigurationProperties(prefix = "file.base")
@Component
public class FileConfig {

    private String dir;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
