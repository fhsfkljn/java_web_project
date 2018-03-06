package com.chao.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.chao.domain.User;
import com.chao.service.UserService;
import com.chao.service.impl.UserServiceImpl;
import com.chao.utils.UserForm;

public class RegServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		User user = new User();
		
		//获取表单数据
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, req.getParameterMap());
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(!uf.isInvaild()){
			req.setAttribute("uf", uf);
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
			return;
		}
		
		
		try {
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, req.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//调用业务逻辑
		
		UserService us = new UserServiceImpl();
		try {
			if(us.isUserExist(user.getUsername())){
				req.setAttribute("nameexist", "该用户名已存在！");
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
				return;
			}
			us.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//分发转向
		resp.getWriter().write("注册成功！1秒后跳转到首页");
		resp.setHeader("Refresh", "1;url="+req.getContextPath()+"/index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
