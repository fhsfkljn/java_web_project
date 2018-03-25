package com.chao.web.action;

import com.chao.domain.User;
import com.chao.service.IUserService;
import com.chao.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 用户相关操作的动作类
 * @author 89591
 *
 */

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private IUserService service = new UserServiceImpl();
	
	//定义一个用户的数据模型，由于使用了模型驱动，必须实例化
	private User user = new User();
	
	public String register() {
		//1.先根据用户名取出当前的对象
		//2。判断是否已经存在该对象
		//3.如果对象不存在，则注册该对象
		User dbUser = service.findUserByUsername(user.getUsername());
		System.out.println(dbUser);
		if(dbUser!=null){
			return "exists";
		}else {
			int res = service.register(user);
			if(res>0){
				return SUCCESS;
			}else {
				System.out.println("注册失败！");
				return null;
			}
		}
	}

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
	
	
}
