package com.chao.dixml.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetter {
	public static void main(String[] args) {
		
		String xmlPath = "com/chao/dixml/setter/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		Person person  = (Person) applicationContext.getBean("personId");
		System.out.println(person);
	}
}
 