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
				result.setM_auth(rset.getString("m_auth").charAt(0));
				result.setM_name(rset.getString("m_name"));
				result.setM_nick(rset.getString("m_nick"));
				result.setM_birth(rset.getString("m_birth"));
				result.setM_gender(rset.getString("m_gender").charAt(0));
				result.setM_phone(rset.getString("m_phone"));
				result.setM_email(rset.getString("m_email"));
				result.setM_address(rset.getString("m_address"));
				result.setM_address_detail(rset.getString("m_address_detail"));
				result.setM_degree(rset.getDouble("m_degree"));
				result.setM_createDate(rset.getString("m_createdate"));
				result.setM_deleteDate(rset.getString("m_deletedate"));
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
		String sql = "update member set m_pw=?, m_nick=?, m_phone=?, m_email=?, m_address=?, m_address_detail=? where m_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_pw());
			pstmt.setString(2, member.getM_nick());
			pstmt.setString(3, member.getM_phone());
			pstmt.setString(4, member.getM_email());
			pstmt.setString(5, member.getM_address());
			pstmt.setString(6, member.getM_address_detail());
			pstmt.setString(7, member.getM_id());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Connection conn, String m_id, String m_pw, String m_deletedate) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "update member set M_DELETEDATE=TO_DATE(?,'yyyy/mm/dd') where m_id=? and m_pw=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_deletedate);
			pstmt.setString(2, m_id);
			pstmt.setString(3, m_pw);
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
	
	public int duplicationNick(Connection conn, String m_nick) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from member where m_nick=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_nick);
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
	public int duplicationPhone(Connection conn, String m_phone) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from member where m_phone=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_phone);
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
	public int duplicationEmail(Connection conn, String m_email) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from member where m_email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_email);
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
	public String findId(Connection conn, String m_name, String m_email) {
		String result = "";
		PreparedStatement pstmt = null;
		ResultSet  rset = null;
		String sql = "select m_id from member where m_name=? and m_email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_name);
			pstmt.setString(2, m_email);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public String findPw(Connection conn, String m_id, String m_email) {
		String result = "";
		PreparedStatement pstmt = null;
		ResultSet  rset = null;
		String sql = "select m_pw from member where m_id=? and m_email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_email);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
