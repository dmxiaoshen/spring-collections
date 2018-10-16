package com.dmxiaoshen;

import com.dmxiaoshen.model.User;
import com.dmxiaoshen.service.UserService;
import com.dmxiaoshen.util.ApplicationContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTccTransactionExampleApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		for(int i=0;i<20;i++){
			User user = new User();
			user.setId(""+(i+1));
			user.setAge(i);
			user.setName("kk"+i);
			userService.addUser(user);
		}
	}

	/**
	 * HikariDataSource (HikariPool-1)
	 * org.springframework.jdbc.datasource.DataSourceTransactionManager@1f172892
	 */
	@Test
	public void testApplicationContext(){
		Object dataSource = ApplicationContextUtil.getBean("dataSource");
		Object transactionManager = ApplicationContextUtil.getBean("transactionManager");
		System.out.println(dataSource);
		System.out.println(transactionManager);
	}

}
