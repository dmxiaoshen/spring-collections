package com.dmxiaoshen.qiniu;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hzhsg on 2018/9/11.
 */
@ConfigurationProperties(prefix = "qiniu")
public class QiniuProperties {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String prefixUrl;

    private long expires = 3600l;

    private Policy policy;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getPrefixUrl() {
        return prefixUrl;
    }

    public void setPrefixUrl(String prefixUrl) {
        this.prefixUrl = prefixUrl;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public static class Policy{
        private String mimeLimit;

        public String getMimeLimit() {
            return mimeLimit;
        }

        public void setMimeLimit(String mimeLimit) {
            this.mimeLimit = mimeLimit;
        }
    }
}
