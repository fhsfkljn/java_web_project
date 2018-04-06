package com.chao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chao.service.AccountService;

public class TestApp {
	
	public static void main(String[] args) {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.transfer("jerry", "tom", 100);
	}
	
}
