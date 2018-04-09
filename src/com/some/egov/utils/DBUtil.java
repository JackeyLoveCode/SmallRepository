package com.some.egov.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static  ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		conn = threadLocal.get();
		if(conn==null){
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			//<strong>jdbc:oracle:thin:@127.0.0.1:1521:orcl</strong>
			 String url="jdbc:oracle:thin:@localhost:1521:xe"; //URL地址  
	         String username="egov02";  
	         String password="111";  
	         conn=DriverManager.getConnection(url, username, password);
	         threadLocal.set(conn);
		}
		    return conn;
	}
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException{
		if(rs!=null&&!rs.isClosed()){
			rs.close();
		}
		if(ps!=null&&!ps.isClosed()){
			ps.close();
		}
		if(conn!=null&&!conn.isClosed()){
			threadLocal.remove();;
			conn.close();
		}
	}
	public static void beginTransaction(Connection conn) throws SQLException{
		if(conn!=null){
		conn.setAutoCommit(false);
		}
	}
	public static void commitTransaction(Connection conn) throws SQLException{
		if(conn!=null){
		conn.commit();
		}
	}
	public static void rollbackTransaction(Connection conn){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void endTransaction(Connection conn){
		if(conn!=null){
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
}
