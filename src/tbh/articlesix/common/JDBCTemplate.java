package tbh.articlesix.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTemplate {

	public JDBCTemplate() {
	}

	public static Connection getConnection() {
		Connection con = null;
		String dr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // TODO: ����
		String uid = "health";
		String pwd = "khtbh0123";

		try {
			Class.forName(dr);
			con = DriverManager.getConnection(url, uid, pwd);
			if (con == null) {
				System.out.println("연결실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			if (con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement p) {
		try {
			p.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet r) {
		try {
			r.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}public static void setAutoCommit(Connection con, boolean onOff) {
		try {
			con.setAutoCommit(onOff);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
