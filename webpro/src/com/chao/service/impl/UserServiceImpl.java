package com.chao.service.impl;

import com.chao.dao.UserDao;
import com.chao.dao.impl.UserDaoImpl;
import com.chao.domain.User;
import com.chao.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public void register(User user) throws Exception {
		userDao.addUser(user);

	}

	@Override
	public User login(User user) throws Exception {
		return userDao.findUser(user);
	}

	@Override
	public boolean isUserExist(String name) throws Exception {
		return userDao.isUserExist(name);
	}

}
