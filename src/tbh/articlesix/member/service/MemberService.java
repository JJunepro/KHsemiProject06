package tbh.articlesix.member.service;

import java.sql.Connection;

import tbh.articlesix.common.JDBCTemplate;
import tbh.articlesix.member.dao.MemberDao;
import tbh.articlesix.member.model.vo.Member;


public class MemberService {
	
	public MemberService() {
	}

	public int createMember(Member member) {
		int result = -1;
		int result2 = -1;
		Connection conn = JDBCTemplate.getConnection();
		JDBCTemplate.setAutoCommit(conn, false);

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int login(String m_id, String m_pw) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().loginMember(conn, m_id, m_pw);
		JDBCTemplate.close(conn);
		return result;
	}


}
