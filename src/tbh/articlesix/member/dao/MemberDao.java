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
				+ "M_CREATEDATE, M_DELETEDATE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_pw());
			pstmt.setString(3, String.valueOf(member.getM_auth()));
			pstmt.setString(4, member.getM_name());
			pstmt.setString(5, member.getM_nick());
			pstmt.setDate(6, member.getM_birth());
			pstmt.setString(7, String.valueOf(member.getM_gender()));
			pstmt.setString(8, member.getM_phone());
			pstmt.setString(9, member.getM_email());
			pstmt.setString(10, member.getM_address());
			pstmt.setString(11, member.getM_address_detail());
			pstmt.setDate(12, member.getM_createDate());
			pstmt.setDate(13, member.getM_deleteDate());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int loginMember(Connection conn, String m_id, String m_pw) {
		int result = 0;
		String sql = "select m_id from member where m_id=? and m_pw=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
