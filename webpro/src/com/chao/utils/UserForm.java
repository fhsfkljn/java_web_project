package com.chao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserForm {
	private int id;
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	Map<String, String> msg = new HashMap<String, String>();
	
	public boolean isInvaild(){
		
		if("".equals(username)){
			msg.put("username", "用户名不能为空！");
		}else if(!username.matches("\\w{3,8}")){
			msg.put("username", "用户名应该由3-8位字母组成！");
		}
		
		if("".equals(password)){
			msg.put("password", "密码不能为空！");
		}else if(!password.matches("\\d{3,8}")){
			msg.put("password", "密码应该由3-8位数字组成！");
		}
		
		if(!repassword.equals(password )){
			msg.put("repassword", "两次密码不一致！");
		}
		
		if("".equals(email)){
			msg.put("email", "邮箱不能为空！");
		}else if(!email.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
			msg.put("email", "邮箱格式非法！");
		}
		
		if("".equals(birthday)){
			msg.put("birthday", "生日不能为空！");
		}else{
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.parse(birthday);
				
			} catch (Exception e) {
				msg.put("birthday", "生日格式不正确！");
			}
		}
		
		return msg.isEmpty();
	}
	
	
	
	public String getRepassword() {
		return repassword;
	}



	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	
}
