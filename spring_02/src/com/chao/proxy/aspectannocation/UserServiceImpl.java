package com.chao.proxy.aspectannocation;

import org.springframework.stereotype.Service;

@Service("userServiceId")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("proxy.aspectannocation addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("proxy.aspectannocation updateUser");

	}

	@Override
	public void deleteUser() {

		System.out.println("proxy.aspectannocation deleteUser");
	}

}
