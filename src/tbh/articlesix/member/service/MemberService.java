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
	public int duplicationNick(String m_nick) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().duplicationNick(conn, m_nick);
		return result;
	}
	public int duplicationPhone(String m_phone) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().duplicationPhone(conn, m_phone);
		return result;
	}
	public int duplicationEmail(String m_email) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().duplicationEmail(conn, m_email);
		return result;
	}
	
	public int findId(String m_name, String m_email) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().findId(conn, m_name, m_email);
		return result;
	}
	
	public String findPw(String m_id, String m_email) {
		Connection conn = JDBCTemplate.getConnection();
		String result = new MemberDao().findPw(conn, m_id, m_email);
		return result;
	}
	

}
