package com.dmxiaoshen;

import com.dmxiaoshen.dto.OSSUploadResp;
import com.dmxiaoshen.model.Course;
import com.dmxiaoshen.model.User;
import com.dmxiaoshen.service.CourseService;
import com.dmxiaoshen.service.UserService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTestExampleApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = RedisServerTestConfiguration.class)
public class SpringBootTestExampleApplicationTests {

	@Autowired
	private UserService userService;
	@MockBean
	private CourseService courseService;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private TestRestTemplate testRestTemplate;
	@Autowired
	private StringEncryptor stringEncryptor;

	@Test
	public void testAddUser() {
		User u = new User();
		u.setId("666");
		u.setAge(29);
		u.setMobilePhone("13387879898");
		u.setName("二愣子");
		userService.addUser(u);
	}

	@Test
	public void testGetUser() {
		System.out.println(userService.getUser("666"));
	}

	@Test
	public void test() {
		testAddUser();
		testGetUser();
		User u = new User();
		u.setAge(29);
		u.setMobilePhone("15478459865");
		u.setName("fss");
		userService.addUser(u);
		List<User> list = userService.page(1, 20).getList();
		list.forEach(System.out::println);
	}

	@Test
	public void testMockCourse() {
		Course course = new Course();
		course.setStudentId("666");
		course.setName("语文");
		course.setScore(new BigDecimal("98"));
		Mockito.when(courseService.getCourseByStudentId("666")).thenReturn(course);
		testAddUser();
		User u = userService.getUser("666");
		Course c = courseService.getCourseByStudentId(u.getId());
		System.out.println(c);
		redisTemplate.opsForValue().set("124", "fkcrrr");
		System.out.println(redisTemplate.opsForValue().get("124"));
	}

	@Test
	public void testFile(){
		URL path = this.getClass().getResource("/");
		File file = new File(path.getFile() + File.separator + "test.png");
		FileSystemResource resource = new FileSystemResource(file);
		MultiValueMap<String,Object> param = new LinkedMultiValueMap<>();
		param.add("file",resource);
		param.add("suffix",".png");
		HttpEntity<MultiValueMap<String,Object>> httpEntity = new HttpEntity<>(param);
		ResponseEntity<OSSUploadResp> resResponseEntity = testRestTemplate.exchange("/oss/upload", HttpMethod.POST,httpEntity,OSSUploadResp.class);
		System.out.println(resResponseEntity.getBody());
	}

	@Test
	public void testStringEncryptor(){
		String result = stringEncryptor.encrypt("123");
		System.out.println(result);
	}

}
