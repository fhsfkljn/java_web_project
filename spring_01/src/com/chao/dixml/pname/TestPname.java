package com.chao.dixml.pname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPname {
	public static void main(String[] args) {
		
		String xmlPath = "com/chao/dixml/pname/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		Person person  = (Person) applicationContext.getBean("personId");
		System.out.println(person);
	}
}
 