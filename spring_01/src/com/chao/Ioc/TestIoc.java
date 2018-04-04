package com.chao.Ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	public static void main(String[] args) {
		//从spring容器中获取对象(Ioc:控制反转)
		//1.获得容器
		String xmlPath = "com/chao/Ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2.获得内容
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
	}
}
 