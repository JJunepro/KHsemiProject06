package tbh.articlesix.member.service;

import java.sql.Connection;

import tbh.articlesix.common.JDBCTemplate;
import tbh.articlesix.member.dao.MemberDao;
import tbh.articlesix.member.model.vo.Member;


public class MemberService {
	
	public MemberService() {
	}

	public int createMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().createMember(conn, member);
		JDBCTemplate.setAutoCommit(conn, false);
		if(result > 0) {
			try {
				JDBCTemplate.commit(conn);
			} catch (Exception e) {
				e.printStackTrace();
				JDBCTemplate.rollback(conn);
			} finally {
				JDBCTemplate.close(conn);
			}
		}
		return result;
		
	}

	public Member loginMember(String m_id, String m_pw) {
		Connection conn = JDBCTemplate.getConnection();
		Member result = new MemberDao().loginMember(conn, m_id, m_pw);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn, member);
		JDBCTemplate.setAutoCommit(conn, false);
		if(result > 0) {
			try {
				JDBCTemplate.commit(conn);
			}catch (Exception e) {
				e.printStackTrace();
				JDBCTemplate.rollback(conn);
			}finally {
				JDBCTemplate.close(conn);
			}
		}
		return result;
	}
	
	public int deleteMember(String m_id) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(conn, m_id);
		JDBCTemplate.setAutoCommit(conn, false);
		if(result > 0) {
			try {
				JDBCTemplate.commit(conn);
			}catch (Exception e) {
				e.printStackTrace();
				JDBCTemplate.rollback(conn);
			}finally {
				JDBCTemplate.close(conn);
			}
		}
		return result;
	}
	
	public int duplicationId(String m_id) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().duplicationId(conn, m_id);
		return result;
	}
	

}
