package com.chao.proxy.aspectxml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectXml {
	@Test
	public void demo01() {
		
		String xmlPath = "com/chao/proxy/aspectxml/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		////���Ŀ����
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
