package com.chao.dixml.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpEL {
	public static void main(String[] args) {
		
		String xmlPath = "com/chao/dixml/spel/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		Customer customer  = (Customer) applicationContext.getBean("customerId");
		System.out.println(customer);
	}
}
 