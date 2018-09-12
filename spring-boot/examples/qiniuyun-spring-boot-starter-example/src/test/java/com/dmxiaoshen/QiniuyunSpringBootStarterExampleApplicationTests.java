package com.dmxiaoshen;

import com.dmxiaoshen.qiniu.support.QiniuYunSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QiniuyunSpringBootStarterExampleApplication.class)
public class QiniuyunSpringBootStarterExampleApplicationTests {

	@Test
	public void contextLoads() {
		URL path = this.getClass().getResource("/");
		File file = new File(path.getFile() + File.separator + "test.png");
		String result = QiniuYunSupport.put("222.png",file);
		System.out.println(result);
	}

}
