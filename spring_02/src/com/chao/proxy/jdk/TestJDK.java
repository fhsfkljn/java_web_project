package com.chao.proxy.jdk;

import org.junit.Test;

public class TestJDK {
	@Test
	public void demo01() {
		UserService userService = MyBeanFactory.createService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
