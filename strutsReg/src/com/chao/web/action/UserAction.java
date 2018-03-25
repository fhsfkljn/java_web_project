package com.chao.web.action;

import com.chao.domain.User;
import com.chao.service.IUserService;
import com.chao.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * �û���ز����Ķ�����
 * @author 89591
 *
 */

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private IUserService service = new UserServiceImpl();
	
	//����һ���û�������ģ�ͣ�����ʹ����ģ������������ʵ����
	private User user = new User();
	
	public String register() {
		//1.�ȸ����û���ȡ����ǰ�Ķ���
		//2���ж��Ƿ��Ѿ����ڸö���
		//3.������󲻴��ڣ���ע��ö���
		User dbUser = service.findUserByUsername(user.getUsername());
		System.out.println(dbUser);
		if(dbUser!=null){
			return "exists";
		}else {
			int res = service.register(user);
			if(res>0){
				return SUCCESS;
			}else {
				System.out.println("ע��ʧ�ܣ�");
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
