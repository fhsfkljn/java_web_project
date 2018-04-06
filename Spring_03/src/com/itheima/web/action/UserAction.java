package com.itheima.web.action;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	//1 封装数据
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}
	
	//2 service
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//////////////////////////////////
	
	/**
	 * 注册
	 * @return
	 */
	public String register(){
		userService.register(user);
		return "success";
	}
	

}
