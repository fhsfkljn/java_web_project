package com.chao.dixml.setter;


public class Person {

	private String pname;
	private Integer age;

	private Address homeAddr; // 家庭地址
	private Address companyAddr; // 公司地址

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(Address homeAddr) {
		this.homeAddr = homeAddr;
	}

	public Address getCompanyAddr() {
		return companyAddr;
	}

	public void setCompanyAddr(Address companyAddr) {
		this.companyAddr = companyAddr;
	}

	@Override
	public String toString() {
		return "Person [pname=" + pname + ", age=" + age + ", homeAddr=" + homeAddr + ", companyAddr=" + companyAddr
				+ "]";
	}

}
