package com.chao.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.chao.utils.HibernateUtils;


public class TransactionFilter implements Filter {

    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		
		try {
			chain.doFilter(request, response);
			if(session!=null && session.isOpen()){
				session.getTransaction().commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			if(session!=null && session.isOpen()){
				session.getTransaction().rollback();
			}
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
