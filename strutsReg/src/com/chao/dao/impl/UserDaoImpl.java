package com.chao.dao.impl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.chao.dao.IUserDao;
import com.chao.domain.User;
import com.chao.utils.DBCPUtil;

public class UserDaoImpl implements IUserDao {

	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public User selectUserByUsername(String username) {
		try {
			return qr.query("select * from user where username=?", new BeanHandler<User>(User.class), username);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addUser(User user) {
		try {
			System.out.println(user);
			int update = qr.update("insert into user(username,password,birthday,hobby,married)values(?,?,?,?,?)",
					user.getUsername(), user.getPassword(), user.getBirthday(), user.getHobby(), user.isMarried());
			System.out.println(update);
			return update;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
