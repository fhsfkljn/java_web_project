package com.chao.service.impl;

import com.chao.dao.IUserDao;
import com.chao.dao.impl.UserDaoImpl;
import com.chao.domain.User;
import com.chao.service.IUserService;

public class UserServiceImpl implements IUserService{
	
	private IUserDao dao = new UserDaoImpl();

	@Override
	public User findUserByUsername(String username) {
		return dao.selectUserByUsername(username);
	}

	@Override
	public int register(User user) {
		return dao.addUser(user);
	}
	
}
