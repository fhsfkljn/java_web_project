package com.chao.proxy.cglib;

import org.junit.Test;

public class TestCglib {
	@Test
	public void demo01() {
		UserServiceImpl userService = MyBeanFactory.createService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
