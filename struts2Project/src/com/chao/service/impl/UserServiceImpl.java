package com.chao.service.impl;

import java.util.List;

import com.chao.dao.IUserDao;
import com.chao.dao.impl.UserDaoImpl;
import com.chao.domain.User;
import com.chao.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao dao = new UserDaoImpl();
	
	@Override
	public User login(String loginName, String loginPwd) {
		return dao.selectUserByInfo(loginName,loginPwd);
	}

	@Override
	public int saveUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public int modify(User user) {
		return dao.updateUser(user);
	}

	@Override
	public int removeUser(Integer userID) {
		return dao.deleteUser(userID);
	}

	@Override
	public User findUserById(Integer userID) {
		return dao.selectUserById(userID);
	}

	@Override
	public List<User> findAllUser() {
		return dao.selectAllUser();
	}

	@Override
	public List<User> findUserByCondition(String userName, String gender, String education, String isUpload) {
		return dao.selectUserByCondition(userName,gender,education,isUpload);
	}

}
