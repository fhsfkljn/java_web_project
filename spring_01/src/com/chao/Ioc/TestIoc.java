package com.chao.Ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	public static void main(String[] args) {
		//��spring�����л�ȡ����(Ioc:���Ʒ�ת)
		//1.�������
		String xmlPath = "com/chao/Ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2.�������
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
	}
}
 