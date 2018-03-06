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
			msg.put("username", "�û�������Ϊ�գ�");
		}else if(!username.matches("\\w{3,8}")){
			msg.put("username", "�û���Ӧ����3-8λ��ĸ��ɣ�");
		}
		
		if("".equals(password)){
			msg.put("password", "���벻��Ϊ�գ�");
		}else if(!password.matches("\\d{3,8}")){
			msg.put("password", "����Ӧ����3-8λ������ɣ�");
		}
		
		if(!repassword.equals(password )){
			msg.put("repassword", "�������벻һ�£�");
		}
		
		if("".equals(email)){
			msg.put("email", "���䲻��Ϊ�գ�");
		}else if(!email.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
			msg.put("email", "�����ʽ�Ƿ���");
		}
		
		if("".equals(birthday)){
			msg.put("birthday", "���ղ���Ϊ�գ�");
		}else{
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.parse(birthday);
				
			} catch (Exception e) {
				msg.put("birthday", "���ո�ʽ����ȷ��");
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
