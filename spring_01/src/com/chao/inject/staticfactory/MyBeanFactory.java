package com.chao.inject.staticfactory;

public class MyBeanFactory {

	/**
	 * ´´½¨ÊµÀý
	 * 
	 * @return
	 */
	public static UserService createService() {
		return new UserServiceImpl();
	}
}
