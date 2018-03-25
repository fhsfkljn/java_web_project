package com.chao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 使用开源数据源：
 * 	DBCP：DataBase Connection Pool 是apache公司实现的一个开源的数据源。
 * 使用步骤：
 * 	1.拷贝jar包
 *  2.写配置文件
 *  3.使用
 * @author zhy
 *
 */
public class DBCPUtil {
  
	//1.定义一个数据源
	private static DataSource ds;
	
	//2.使用静态代码块，给数据源赋值
	static{
		try {
			Properties prop = new Properties();
			InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化连接池失败！");
		}
	}
	
	
	
	//3.提供一个获取数据源的方法
	public static DataSource getDataSource(){
		return ds;
	}
	
	//4.提供一个获取连接的方法，注意，以后获取连接，必须使用该方法
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
