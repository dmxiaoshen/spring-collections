package com.dmxiaoshen;

import com.dmxiaoshen.aliyun.oss.support.AliyunOSSSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AliyunossSpringBootStarterExampleApplication.class)
public class AliyunossSpringBootStarterExampleApplicationTests {

	@Test
	public void contextLoads() {
		String url = AliyunOSSSupport.getUrl("456.jpg");
		System.out.println(url);
	}

}
