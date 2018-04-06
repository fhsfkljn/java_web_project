package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.domain.User;
import com.itheima.service.UserService;


public class TestApp {
	
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Test
	public void demo01(){
		
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		userService  = (UserService) applicationContext.getBean("userService");
		
		User user = new User();
		user.setUsername("jack");
		user.setPassword("1234");
		user.setAge(18);
		
		userService.register(user);
	}
}
