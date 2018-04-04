package com.chao.dixml.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollection {
	public static void main(String[] args) {
		
		String xmlPath = "com/chao/dixml/collection/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		CollData collData  = (CollData) applicationContext.getBean("collDataId");
		System.out.println(collData);
	}
}
 