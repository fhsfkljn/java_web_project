package com.chao.domain;

import java.io.Serializable;
/**
 * URL: uniform resource locator ͳһ��Դ��λ��
 * http://localhost:8080/day25_ee19_05struts2convert/register.jsp
 * Э��             ����	             �˿�		URI    
 * URI: uniform resource identifier ͳһ��Դ��ʶ��
 * /day25_ee19_05struts2convert/register.jsp
 * @author zhy
 *
 */
public class Student implements Serializable {
	private String username;//����Ϊnull�Ϳ��ַ�����Ҫȥ�ո�
	private int age;//����������18-100֮��
	private String email;//��������ĸ�ʽ����
	private String password;//���룬������3~8λ
	private String repassword;//ȷ�����룬���������һ�¡�д�����Ŀ�ģ���ȫ��Ϊ����ʾ��֤����ʹ�á�ʵ�ʿ����и������ᱣ��ȷ������
	private int score;//�ɼ�����������Ȼ��
	private String url;//������ҳ���������url��ʽ��
	private String gender;//�Ա�
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
