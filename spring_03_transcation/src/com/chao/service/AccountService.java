package com.chao.service;

public interface AccountService {
	/**
	 * ת��
	 * 
	 * @param outer
	 * @param inner
	 * @param money
	 */
	public void transfer(String outer, String inner, Integer money);
}
