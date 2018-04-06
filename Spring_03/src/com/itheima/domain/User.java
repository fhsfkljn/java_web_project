package com.itheima.domain;

public class User {
	/*
	 * create table t_user(
		  id int primary key auto_increment,
		  username varchar(50),
		  password varchar(32),
		  age int 
		);
	 */
	private Integer id;
	private String username;
	private String password;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
