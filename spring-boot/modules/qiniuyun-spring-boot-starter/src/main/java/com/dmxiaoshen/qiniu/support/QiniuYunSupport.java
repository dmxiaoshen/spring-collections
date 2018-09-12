package com.dmxiaoshen.qiniu.support;

import com.dmxiaoshen.qiniu.QiniuProperties;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.File;

/**
 * Created by hzhsg on 2018/9/12.
 */
public class QiniuYunSupport {

    private static QiniuProperties qiniuProperties;

    private static UploadManager uploadManager;

    private static Auth auth;

    private static BucketManager bucketManager;

    private static String bucketName;


    public QiniuYunSupport(QiniuProperties qiniuProperties, UploadManager uploadManager, Auth auth, BucketManager bucketManager) {
        this.qiniuProperties = qiniuProperties;
        this.uploadManager = uploadManager;
        this.auth = auth;
        this.bucketManager = bucketManager;
        this.bucketName = qiniuProperties.getBucket();
    }

    public static String getBucketName(){
        return qiniuProperties.getBucket();
    }

    public static String put(String key,File file){
        try {
            Response response = uploadManager.put(file,key,auth.uploadToken(bucketName));
            return response.toString();
        } catch (QiniuException e) {
            throw new RuntimeException("qiniu put[key,file] error",e);
        }
    }
}
