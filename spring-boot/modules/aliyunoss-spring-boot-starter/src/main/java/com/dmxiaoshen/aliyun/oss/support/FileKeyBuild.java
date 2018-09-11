package com.dmxiaoshen.aliyun.oss.support;

import java.util.UUID;

/**
 * Created by hzhsg on 2018/8/14.
 */
@FunctionalInterface
public interface FileKeyBuild {

    /**
     * 构建fileKey
     * @param suffix  文件后缀名
     * @return fileKey
     */
    String build(String suffix);

    /**
     * 默认已uuid生成fileKey
     * @return
     */
    static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
