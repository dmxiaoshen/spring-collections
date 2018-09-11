package com.dmxiaoshen.user.sdk;

import com.dmxiaoshen.user.sdk.client.UserClient;
import com.dmxiaoshen.user.sdk.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceUserSdkApplicationTests.class)
@SpringBootApplication
@EnableFeignClients
public class ServiceUserSdkApplicationTests {

	@Autowired
	private UserClient userClient;

	@Test
	public void contextLoads() {
		UserDTO dto = userClient.get("1");
		System.out.println(dto);
	}

}
