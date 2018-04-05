package com.chao.proxy.jdk;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("proxy.jdk addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("proxy.jdk updateUser");

	}

	@Override
	public void deleteUser() {

		System.out.println("proxy.jdk deleteUser");
	}

}
