package tbh.articlesix.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTemplate {

	// JDBCTemplate 내부모양은 수십가지~
	public JDBCTemplate() {
	}

	public static Connection getConnection() {
		Connection con = null;
		String dr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // TODO: 설명
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
}
