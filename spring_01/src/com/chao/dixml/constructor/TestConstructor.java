package com.chao.dixml.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructor {
	public static void main(String[] args) {
		
		//1.�������
		String xmlPath = "com/chao/dixml/constructor/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2.�������
		User user = (User) applicationContext.getBean("userId");
		System.out.println(user);
	}
}
 