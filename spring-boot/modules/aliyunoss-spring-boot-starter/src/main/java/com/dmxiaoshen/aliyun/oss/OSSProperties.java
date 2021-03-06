package com.dmxiaoshen.aliyun.oss;

import com.aliyun.oss.common.comm.Protocol;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hzhsg on 2018/8/10.
 */
@ConfigurationProperties(prefix = "aliyun-oss")
public class OSSProperties {

    private String endpointPublicUrl;//endpoint公网地址
    private String endpointInternalUrl;//endpoint内网地址
    private String accessKeyId;//id
    private String accessKeySecret;//secret
    private String bucketName;//仓库名称

    private Client client;

    public String getEndpointPublicUrl() {
        return endpointPublicUrl;
    }

    public void setEndpointPublicUrl(String endpointPublicUrl) {
        this.endpointPublicUrl = endpointPublicUrl;
    }

    public String getEndpointInternalUrl() {
        return endpointInternalUrl;
    }

    public void setEndpointInternalUrl(String endpointInternalUrl) {
        this.endpointInternalUrl = endpointInternalUrl;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static class Client {
        private int maxErrorRetry = 3; // 请求失败后最大的重试次数。默认3次
        private int maxConnections = 1024; // 允许打开的最大HTTP连接数。默认为1024
        private int socketTimeout = 50000; // Socket层传输数据的超时时间（单位：毫秒）。默认为50000毫秒
        private int connectionTimeout = 50000; // 建立连接的超时时间（单位：毫秒）。默认为50000毫秒
        private int connectionRequestTimeout; // 从连接池中获取连接的超时时间（单位：毫秒）。默认不超时
        private long idleConnectionTime = 60000; // 如果空闲时间超过此参数的设定值，则关闭连接（单位：毫秒）。默认为60000毫秒
        private boolean supportCname = true; // 是否支持CNAME作为Endpoint，默认支持CNAME
        private boolean sldEnabled = false; // 是否开启二级域名（Second Level Domain）的访问方式，默认不开启
        private String protocol = Protocol.HTTP.toString(); // 连接OSS所采用的协议（HTTP/HTTPS），默认为HTTP
        private String userAgent = "aliyun-sdk-java"; // 用户代理，指HTTP的User-Agent头。默认为”aliyun-sdk-java”

        public int getMaxErrorRetry() {
            return maxErrorRetry;
        }

        public void setMaxErrorRetry(int maxErrorRetry) {
            this.maxErrorRetry = maxErrorRetry;
        }

        public int getMaxConnections() {
            return maxConnections;
        }

        public void setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
        }

        public int getSocketTimeout() {
            return socketTimeout;
        }

        public void setSocketTimeout(int socketTimeout) {
            this.socketTimeout = socketTimeout;
        }

        public int getConnectionTimeout() {
            return connectionTimeout;
        }

        public void setConnectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
        }

        public int getConnectionRequestTimeout() {
            return connectionRequestTimeout;
        }

        public void setConnectionRequestTimeout(int connectionRequestTimeout) {
            this.connectionRequestTimeout = connectionRequestTimeout;
        }

        public long getIdleConnectionTime() {
            return idleConnectionTime;
        }

        public void setIdleConnectionTime(long idleConnectionTime) {
            this.idleConnectionTime = idleConnectionTime;
        }

        public boolean isSupportCname() {
            return supportCname;
        }

        public void setSupportCname(boolean supportCname) {
            this.supportCname = supportCname;
        }

        public boolean isSldEnabled() {
            return sldEnabled;
        }

        public void setSldEnabled(boolean sldEnabled) {
            this.sldEnabled = sldEnabled;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }
    }
}
