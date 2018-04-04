package com.chao.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLife {
	public static void main(String[] args) {
		// 从spring容器中获取对象(Ioc:控制反转)
		// 1.获得容器
		String xmlPath = "com/chao/lifecycle/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		// 2.获得内容
		UserService userService = applicationContext.getBean("userServiceId", UserService.class);
		userService.addUser();

		// 要求：1.容器必须close，销毁方法执行; 2.必须是单例的
		// applicationContext.getClass().getMethod("close").invoke(applicationContext);
		// * 此方法接口中没有定义，实现类提供
		applicationContext.close();
	}
}
