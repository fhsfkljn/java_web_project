package com.chao.web.action;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.chao.domain.User;
import com.chao.service.IUserService;
import com.chao.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private IUserService service = new UserServiceImpl();
	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//----------------------------�û���½�Ķ�������-----------------------
	
	public String login(){
		User dbUser = service.login(user.getLogonName(), user.getLogonPwd());
		//�ж��û��Ƿ�鵽
		if(dbUser==null){
			addActionError("�û������������");
			return "input";
		}
		//��½�ɹ�
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);
		
		return SUCCESS;
	}
	
	

}
