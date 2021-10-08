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
		Connection con = JDBCTemplate.getConnection();
		JDBCTemplate.setAutoCommit(con, false);

		try {

			JDBCTemplate.commit(con);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(con);
		}
		return result;
	}

	public Member login(String m_id, String m_pw) {
		Connection con = JDBCTemplate.getConnection();
		Member result = new MemberDao().loginMember(con, m_id, m_pw);
		JDBCTemplate.close(con);
		return result;
	}

}
