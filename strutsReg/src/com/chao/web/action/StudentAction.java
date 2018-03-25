package com.chao.web.action;

import com.chao.domain.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
 
public class StudentAction extends ActionSupport implements ModelDriven<Student>{

	private Student stu = new Student();
	
	@Override
	public Student getModel() {
		
		return stu;
	}
	
	public String addStudent(){
		return SUCCESS;
	}
	

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

}
