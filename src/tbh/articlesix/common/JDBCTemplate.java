package tbh.articlesix.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");  //Tomcat resource 설정을 찾기. server.xml;, context.xml -> 설정값 넣기
			// TODO
			DataSource ds = (DataSource)envContext.lookup("jdbc/healthDclass"); //jdbc/healthLocal   //jdbc/healthDclass  
			conn = ds.getConnection();
			
			if(conn!=null) System.out.println("DBCP JNDI 연결성공");
			else System.out.println("DBCP JNDI 연결실패!!!!!!!!!!!!!");
		}catch(Exception e) {
			System.out.println("DBCP JNDI Exception 연결실패!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement s) {
		try {
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//	public static void close(PreparedStatement s) {
//		try {
//			s.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static void close(ResultSet s) {
		try {
			if(s!=null) s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void setAutoCommit(Connection conn, boolean onOff) {
		try {
			conn.setAutoCommit(onOff);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}