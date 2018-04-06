package com.chao.service.impl;

import com.chao.dao.AccountDao;
import com.chao.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String outer, String inner, Integer money) {
		accountDao.out(outer, money);
		// ¶Ïµç
		// int i = 1/0;
		accountDao.in(inner, money);
	}

}
