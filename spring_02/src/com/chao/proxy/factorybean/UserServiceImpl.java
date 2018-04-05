package com.chao.proxy.factorybean;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("proxy.factorybean addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("proxy.factorybean updateUser");

	}

	@Override
	public void deleteUser() {

		System.out.println("proxy.factorybeandeleteUser");
	}

}
