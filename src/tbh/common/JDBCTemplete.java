package tbh.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplete {
	public JDBCTemplete() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		
		String dr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracl:thin:@localhost:1521:xe";
		String uid = "tiger";
		String pwd = "gyoung";
		try {
			InitialContext initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env"); //tomcat resource 설정을 찾기  server.xml, context.xml
			DataSource ds = (DataSource)envContext.lookup("jdbc/mylocaloracle");
			conn = ds.getConnection();
			if(conn != null) System.out.println("연결 성공");
			else{
				System.out.println("실패");
			}
		} catch (Exception e) {
			
		}
		
		
		
//		try {
//			Class.forName(dr);
//			conn = DriverManager.getConnection(url,uid,pwd);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return conn;
	}
	
	public static void close(Connection con) {
		try {
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {
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
