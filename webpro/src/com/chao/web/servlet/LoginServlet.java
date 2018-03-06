package com.chao.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

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

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		User user = new User();
		User u = null;
		
		try {
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, req.getParameterMap());
			
			UserService us = new UserServiceImpl();
			u = us.login(user);
			
			if(u!=null){
				req.getSession().setAttribute("u", u);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}else{
				req.setAttribute("msg", "用户名或密码不正确！");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
