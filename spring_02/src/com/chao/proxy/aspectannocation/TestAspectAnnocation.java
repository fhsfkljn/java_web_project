package com.chao.proxy.aspectannocation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectAnnocation {
	
	
	public static void main(String[] args) {
		String xmlPath = "com/chao/proxy/aspectannocation/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		////获得目标类
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
