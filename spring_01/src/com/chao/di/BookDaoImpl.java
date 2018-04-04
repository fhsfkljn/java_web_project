package com.chao.di;

public class BookDaoImpl implements BookDao {

	@Override
	public void save() {
		System.out.println("hello spring dao di");
	}

}
