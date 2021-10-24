package tbh.articlesix.board.recruit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tbh.articlesix.board.recruit.model.vo.RecruitChat;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitChatDao {
	// 채팅 가져오기 기능
	public RecruitChatDao() {
	}
	
	public RecruitChat getRecruitchat(Connection conn, int b_n) {
		RecruitChat ch = null;
		String sql = "select b_n, m_id, chat_time, chat_message" + " from chat where b_n";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			ch = new RecruitChat();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_n);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				ch.setB_n(rset.getInt("b_n"));
				ch.setM_id(rset.getString("m_id"));
				ch.setChat_time(rset.getDate("chat_time"));
				ch.setChat_message(rset.getString("chat_message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return ch;
	}

	// 채팅 조회
	public ArrayList<RecruitChat> RecruitChatList(Connection conn) {
		ArrayList<RecruitChat> chlist = null;

		String sql = "select * from chat";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			chlist = new ArrayList<RecruitChat>();
			if (rset.next()) {
				do {
					RecruitChat ch = new RecruitChat();
					ch.setB_n(rset.getInt("b_n"));
					ch.setM_id(rset.getString("m_id"));
					ch.setChat_time(rset.getDate("chat_time"));
					ch.setChat_message(rset.getString("chat_message"));
					chlist.add(ch);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("리턴" + chlist);
		return chlist;
	}

	// 작성일자
	public String getDate(Connection conn) {
		String sql = "select now()";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				return rset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 채팅 메세지 입력
	public int recruitChatInsert(Connection conn, RecruitChat ch) {
		int result = -1;
		String sql = "insert into chat" + "(b_n, m_id, chat_time, chat_message)" + " values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			ch = new RecruitChat();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ch.getB_n());
			pstmt.setString(2, ch.getM_id());
			pstmt.setDate(3, ch.getChat_time());
			pstmt.setString(4, getDate(conn));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 모집방 삭제시 채팅 삭제
	public int recruitChatDelete(Connection conn, int b_n) {
		int result = -1;
		String sql = "delete from chat where num=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_n);
			pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
