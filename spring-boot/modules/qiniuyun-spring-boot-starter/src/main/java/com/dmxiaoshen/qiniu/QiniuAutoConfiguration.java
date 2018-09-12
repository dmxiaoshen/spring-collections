package com.dmxiaoshen.qiniu;

import com.dmxiaoshen.qiniu.support.QiniuYunSupport;
import com.qiniu.common.Zone;
import com.qiniu.storage.*;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by hzhsg on 2018/9/12.
 */
@EnableConfigurationProperties(QiniuProperties.class)
@Conditional(QiniuAutoConfiguration.QiniuCondition.class)
public class QiniuAutoConfiguration {

    @Autowired
    private QiniuProperties qiniuProperties;

    @Bean
    public Configuration configuration(){
        return new Configuration(Zone.zone0());
    }

    @Bean
    public UploadManager uploadManager(Configuration configuration){
        return new UploadManager(configuration);
    }

    @Bean
    public Auth auth(){
        return Auth.create(qiniuProperties.getAccessKey(),qiniuProperties.getSecretKey());
    }

    @Bean
    public BucketManager bucketManager(Auth auth,Configuration configuration){
        return new BucketManager(auth,configuration);
    }

    @Bean("qiniuYunSupport")
    public QiniuYunSupport qiniuYunSupport(QiniuProperties qiniuProperties,UploadManager uploadManager,Auth auth,BucketManager bucketManager){
        return new QiniuYunSupport(qiniuProperties,uploadManager,auth,bucketManager);
    }

    public static class QiniuCondition implements Condition{

        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            String enabled = conditionContext.getEnvironment().getProperty("qiniu.enabled");
            if(enabled!=null && "true".equals(enabled)){
                return true;
            }
            return false;
        }
    }
}
