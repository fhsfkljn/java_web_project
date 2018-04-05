package com.chao.proxy.factorybean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {
	@Test
	public void demo01() {
		
		String xmlPath = "com/chao/proxy/factorybean/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//��ô�����
		UserService userService = (UserService) applicationContext.getBean("proxyServiceId");
		
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
