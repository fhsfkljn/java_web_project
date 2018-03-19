package play;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//�õ�һ������Դ
	private static DataSource ds = new ComboPooledDataSource();
	
	
	
	public static DataSource getDs() {
		return ds;
	}

	//�õ����Ӷ���
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("����������");
		}
	}
	
	//�ر���Դ
	public static void release(Connection conn,Statement stmt,ResultSet rs){
		//�ر���Դ
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(C3P0Util.getConnection());
	}
}
