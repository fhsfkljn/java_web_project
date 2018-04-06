package com.chao.dao;

public interface AccountDao {
	/**
	 * »ã¿î
	 * 
	 * @param outer
	 * @param money
	 */
	public void out(String outer, Integer money);

	/**
	 * ÊÕ¿î
	 * 
	 * @param inner
	 * @param money
	 */
	public void in(String inner, Integer money);
}
