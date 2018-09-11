package com.dmxiaoshen.message.sdk;

import com.dmxiaoshen.message.sdk.client.SMSClient;
import com.dmxiaoshen.message.sdk.dto.SMSMessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceMessageSdkApplicationTests.class)
@EnableFeignClients
@SpringBootApplication
public class ServiceMessageSdkApplicationTests {

	@Autowired
	private SMSClient smsClient;

	@Test
	public void contextLoads() {
		SMSMessageDTO dto = smsClient.get("1");
		System.out.println(dto);
	}

}
