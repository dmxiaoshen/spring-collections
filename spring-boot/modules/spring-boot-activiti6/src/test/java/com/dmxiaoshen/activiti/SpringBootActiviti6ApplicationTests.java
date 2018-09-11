package com.dmxiaoshen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootActiviti6Application.class)
public class SpringBootActiviti6ApplicationTests {

	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ProcessEngineConfiguration processEngineConfiguration;

	@Test
	public void test(){
		ProcessEngine p = processEngine;
		repositoryService.createDeployment().addClasspathResource("diagrams/leave.bpmn20.xml.bpmn").name("请假流程").category("请假流程").deploy();
//		System.out.println(processEngine);
//		System.out.println(repositoryService);
//		ProcessEngineConfiguration x = processEngineConfiguration;
//		System.out.println(processEngineConfiguration);
//		int a = 9;
//		System.out.println(a);
//		repositoryService.deleteDeployment("6660142f42604d0b9340fabe205789d3",true);
	}

}
