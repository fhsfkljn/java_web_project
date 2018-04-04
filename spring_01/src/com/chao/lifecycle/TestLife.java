package com.chao.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLife {
	public static void main(String[] args) {
		// ��spring�����л�ȡ����(Ioc:���Ʒ�ת)
		// 1.�������
		String xmlPath = "com/chao/lifecycle/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		// 2.�������
		UserService userService = applicationContext.getBean("userServiceId", UserService.class);
		userService.addUser();

		// Ҫ��1.��������close�����ٷ���ִ��; 2.�����ǵ�����
		// applicationContext.getClass().getMethod("close").invoke(applicationContext);
		// * �˷����ӿ���û�ж��壬ʵ�����ṩ
		applicationContext.close();
	}
}
