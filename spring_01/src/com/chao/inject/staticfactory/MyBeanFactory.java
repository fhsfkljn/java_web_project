package com.chao.inject.staticfactory;

public class MyBeanFactory {

	/**
	 * ����ʵ��
	 * 
	 * @return
	 */
	public static UserService createService() {
		return new UserServiceImpl();
	}
}
