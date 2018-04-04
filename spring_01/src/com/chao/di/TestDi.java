package com.chao.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDi {
	public static void main(String[] args) {
		
		String xmlPath = "com/chao/di/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		BookService bookService  = (BookService) applicationContext.getBean("bookServiceId");
		bookService.addBook();
	}
}
 