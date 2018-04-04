package com.chao.lifecycle;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("hello spring lifeCycle");
	}
	
	public void myInit(){
		System.out.println("初始化方法");
	}
	
	public void myDestory(){
		System.out.println("销毁方法");
	}

}
