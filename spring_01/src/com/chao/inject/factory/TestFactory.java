package com.chao.inject.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {

	public static void main(String[] args) {
		String xmlPaht = "com/chao/inject/factory/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPaht);

		UserService userService = applicationContext.getBean("userServiceId", UserService.class);
		userService.addUser();
	}
}
