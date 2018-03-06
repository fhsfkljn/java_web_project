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
		
		//��ȡ������
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
		
		//����ҵ���߼�
		
		UserService us = new UserServiceImpl();
		try {
			if(us.isUserExist(user.getUsername())){
				req.setAttribute("nameexist", "���û����Ѵ��ڣ�");
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
				return;
			}
			us.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//�ַ�ת��
		resp.getWriter().write("ע��ɹ���1�����ת����ҳ");
		resp.setHeader("Refresh", "1;url="+req.getContextPath()+"/index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
