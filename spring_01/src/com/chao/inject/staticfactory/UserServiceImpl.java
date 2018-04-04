package com.chao.inject.staticfactory;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("hello spring ioc-staticFactory");
	}

}
