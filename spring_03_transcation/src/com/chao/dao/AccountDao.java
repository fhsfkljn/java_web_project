package com.chao.dao;

public interface AccountDao {
	/**
	 * ���
	 * 
	 * @param outer
	 * @param money
	 */
	public void out(String outer, Integer money);

	/**
	 * �տ�
	 * 
	 * @param inner
	 * @param money
	 */
	public void in(String inner, Integer money);
}
