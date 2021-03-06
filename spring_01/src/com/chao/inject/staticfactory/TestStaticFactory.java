package com.chao.inject.staticfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {

		public static void main(String[] args) {
			String xmlPaht = "com/chao/inject/staticfactory/beans.xml";
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPaht);
			
			UserService userService = applicationContext.getBean("userServiceId", UserService.class);
			userService.addUser();
		}
}
