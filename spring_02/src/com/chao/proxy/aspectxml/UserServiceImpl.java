package com.chao.proxy.aspectxml;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("proxy.aspectxml addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("proxy.aspectxml updateUser");

	}

	@Override
	public void deleteUser() {

		System.out.println("proxy.aspectxml deleteUser");
	}

}
