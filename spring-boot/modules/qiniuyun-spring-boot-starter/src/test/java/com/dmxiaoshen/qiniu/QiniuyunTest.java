package com.dmxiaoshen.qiniu;

import com.dmxiaoshen.qiniu.support.QiniuYunSupport;
import com.ulisesbocchio.jasyptspringboot.JasyptSpringBootAutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.URL;

/**
 * Created by hzhsg on 2018/9/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = QiniuAutoConfiguration.class)
@EnableAutoConfiguration
@PropertySource("classpath:security.properties")
public class QiniuyunTest {
    @Autowired
    private QiniuProperties qiniuProperties;

    @Test
    public void test(){
        System.out.println(QiniuYunSupport.getBucketName());
        System.out.println(qiniuProperties.getAccessKey());
        System.out.println(qiniuProperties.getSecretKey());
    }

    @Test
    public void testPut(){
        URL path = this.getClass().getResource("/");
        File file = new File(path.getFile() + File.separator + "test.png");
        String result = QiniuYunSupport.put("123.jpg",file);
        System.out.println(result);
    }
}
