package com.chao.inject.factory;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("hello spring ioc-factory");
	}

}
