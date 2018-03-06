package com.chao.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.chao.dao.UserDao;
import com.chao.domain.User;

public class UserDaoImpl implements UserDao {
	
	private Connection connMysql() throws Exception{
		String url = "jdbc:mysql://localhost:3306/webuser?useSSL=false";
		String user = "root";
		String password = "8520123456";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	@Override
	public void addUser(User user) throws Exception {
		Connection conn = null;
		try {
			conn = this.connMysql();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username,password,email,birthday) VALUES(?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirthday());
			System.out.println(date);
			ps.setString(4, date);
			
			int executeUpdate = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("ÃÌº” ß∞‹!");
		}finally {
			conn.close();
		}
		
		
	}

	@Override
	public User findUser(User user) throws Exception {
		Connection conn = null;
		User u = null;
		try {
			conn = this.connMysql();
			PreparedStatement ps = conn.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return u;
		
	}

	@Override
	public boolean isUserExist(String name) throws Exception {
		Connection conn = null;
		try {
			conn = this.connMysql();
			PreparedStatement ps = conn.prepareStatement("select * from users where username=?");
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return false;
	}

}
