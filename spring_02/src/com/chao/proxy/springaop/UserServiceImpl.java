package com.chao.proxy.springaop;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("proxy.springaop addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("proxy.springaop updateUser");

	}

	@Override
	public void deleteUser() {

		System.out.println("proxy.springaop deleteUser");
	}

}
