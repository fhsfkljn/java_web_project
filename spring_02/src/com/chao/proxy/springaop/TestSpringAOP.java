package com.chao.proxy.springaop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAOP {
	@Test
	public void demo01() {
		
		String xmlPath = "com/chao/proxy/springaop/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		////���Ŀ����
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
