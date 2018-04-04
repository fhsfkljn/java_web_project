package com.chao.di;

public class BookServiceImpl implements BookService {

	private BookDao dao;
	
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void addBook() {
		this.dao.save();
	}

}
