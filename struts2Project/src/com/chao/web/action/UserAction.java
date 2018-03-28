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
	
	//----------------------------用户登陆的动作方法-----------------------
	
	public String login(){
		User dbUser = service.login(user.getLogonName(), user.getLogonPwd());
		//判断用户是否查到
		if(dbUser==null){
			addActionError("用户名或密码错误");
			return "input";
		}
		//登陆成功
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);
		
		return SUCCESS;
	}
	
	

}
