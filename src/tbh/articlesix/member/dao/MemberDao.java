package tbh.articlesix.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tbh.articlesix.common.JDBCTemplate;
import tbh.articlesix.member.model.vo.Member;



public class MemberDao {

	public MemberDao() {
	}

	public int createMember(Connection conn, Member member) {
		int result = 0;
		String sql = "INSERT INTO MEMBER(M_ID, M_PW, M_AUTH, M_NAME, M_NICK, "
				+ "M_BIRTH, M_GENDER, M_PHONE, M_EMAIL, M_ADDRESS, M_ADDRESS_DETAIL, "
				+ "M_DEGREE, M_CREATEDATE, M_DELETEDATE) VALUES (?,?,?,?,?,TO_DATE(?,'yyyy/mm/dd'),?,?,?,?,?,?,TO_DATE(?,'yyyy/mm/dd'),TO_DATE(?,'yyyy/mm/dd'))";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_pw());
			pstmt.setString(3, String.valueOf(member.getM_auth()));
			pstmt.setString(4, member.getM_name());
			pstmt.setString(5, member.getM_nick());
			pstmt.setString(6, member.getM_birth());
			pstmt.setString(7, String.valueOf(member.getM_gender()));
			pstmt.setString(8, member.getM_phone());
			pstmt.setString(9, member.getM_email());
			pstmt.setString(10, member.getM_address());
			pstmt.setString(11, member.getM_address_detail());
			pstmt.setDouble(12, member.getM_degree());
			pstmt.setString(13, member.getM_createDate());
			pstmt.setString(14, member.getM_deleteDate());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member loginMember(Connection conn, String m_id, String m_pw) {
		Member result = null;
		String sql = "select * from member where M_ID=? and M_PW=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new Member();
				result.setM_id(rset.getString("m_id"));
				result.setM_pw(rset.getString("m_pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "insert member set m_pw=?, m_nick=?, m_phone=?, m_email=?, m_address=?, m_address=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_pw());
			pstmt.setString(2, member.getM_nick());
			pstmt.setString(3, member.getM_phone());
			pstmt.setString(4, member.getM_email());
			pstmt.setString(5, member.getM_address());
			pstmt.setString(6, member.getM_address_detail());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Connection conn, String m_id) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from member where m_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int duplicationId(Connection conn, String m_id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from member where m_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);;
		}
		return result;
	}
}
