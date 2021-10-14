package tbh.articlesix.board.recruit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitDao {
	public RecruitDao() {
	}

	// 가져오기
	public Recruit getRecruit(Connection conn, int b_n) {
		Recruit rc = null;
		String sql = "select b_n, m_id, ca_n, b_type, b_title, b_content, b_start,"
				+ "b_end, b_total, b_attend, b_place, b_fee, b_match, b_gender, b_age,"
				+ "b_equip, b_minpeople, b_progress, b_shower, b_parking, b_rental,"
				+ "b_cloth, b_facility, b_timestamp, b_view" + " from board_recruit where b_n = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_n);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				rc = new Recruit();
				rc.setB_n(rset.getInt("b_n"));
				rc.setM_id(rset.getString("m_id"));
				rc.setCa_n(rset.getInt("ca_n"));
				rc.setB_type(rset.getString("b_type").charAt(0));
				rc.setB_title(rset.getString("b_title"));
				rc.setB_content(rset.getString("b_content"));
				rc.setB_start(rset.getString("b_start"));
				rc.setB_end(rset.getString("b_end"));
				rc.setB_total(rset.getInt("b_total"));
				rc.setB_attend(rset.getInt("b_attend"));
				rc.setB_place(rset.getString("b_place"));
				rc.setB_fee(rset.getInt("b_fee"));
				rc.setB_match(rset.getString("b_match").charAt(0));
				rc.setB_gender(rset.getString("b_gender").charAt(0));
				rc.setB_age(rset.getString("b_age").charAt(0));
				rc.setB_equip(rset.getString("b_equip").charAt(0));
				rc.setB_minpeople(rset.getInt("b_minpeople"));
				rc.setB_progress(rset.getString("b_progress"));
				rc.setB_shower(rset.getString("b_shower").charAt(0));
				rc.setB_parking(rset.getString("b_parking").charAt(0));
				rc.setB_rental(rset.getString("b_rental").charAt(0));
				rc.setB_cloth(rset.getString("b_cloth").charAt(0));
				rc.setB_facility(rset.getString("b_facility"));
				rc.setB_timestamp(rset.getString("b_timestamp"));
				rc.setB_view(rset.getInt("b_view"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return rc;
	}

	// 모집방 카운트
	public int getRecruitCount(Connection conn) {
		int result = 0;
		String sql = "select count(b_n) from board_recruit";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 글 조회
	public ArrayList<Recruit> selectRecruitList(Connection conn) {
		ArrayList<Recruit> rclist = null;

		String sql = "select * from board_recruit";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			rclist = new ArrayList<Recruit>();
			if (rset.next()) {
				do {
					Recruit rc = new Recruit();
					rc.setB_n(rset.getInt("b_n"));
					rc.setM_id(rset.getString("m_id"));
					rc.setCa_n(rset.getInt("ca_n"));
					rc.setB_type(rset.getString("b_type").charAt(0));
					rc.setB_title(rset.getString("b_title"));
					rc.setB_content(rset.getString("b_content"));
					rc.setB_start(rset.getString("b_start"));
					rc.setB_end(rset.getString("b_end"));
					rc.setB_total(rset.getInt("b_total"));
					rc.setB_attend(rset.getInt("b_attend"));
					rc.setB_place(rset.getString("b_place"));
					rc.setB_fee(rset.getInt("b_fee"));
					rc.setB_match(rset.getString("b_match").charAt(0));
					rc.setB_gender(rset.getString("b_gender").charAt(0));
					rc.setB_age(rset.getString("b_age").charAt(0));
					rc.setB_equip(rset.getString("b_equip").charAt(0));
					rc.setB_minpeople(rset.getInt("b_minpeople"));
					rc.setB_progress(rset.getString("b_progress"));
					rc.setB_shower(rset.getString("b_shower").charAt(0));
					rc.setB_parking(rset.getString("b_parking").charAt(0));
					rc.setB_rental(rset.getString("b_rental").charAt(0));
					rc.setB_cloth(rset.getString("b_cloth").charAt(0));
					rc.setB_facility(rset.getString("b_facility"));
					rc.setB_timestamp(rset.getString("b_timestamp"));
					rc.setB_view(rset.getInt("b_view"));
					rclist.add(rc);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("라턴" + rclist);
		return rclist;
	}

	public ArrayList<Recruit> selectRecruitList(Connection conn, int start, int end) {
		ArrayList<Recruit> rclist = null;

		String sql = "select * from" + " (select Rownum r, t1."
				+ "* from (select * from board_recruit order by bref desc, bre_step asc) t1 ) t2"
				+ " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			rclist = new ArrayList<Recruit>();
			if (rset.next()) {
				do {
					Recruit rc = new Recruit();
					rc.setB_n(rset.getInt("b_n"));
					rc.setM_id(rset.getString("m_id"));
					rc.setCa_n(rset.getInt("ca_n"));
					rc.setB_type(rset.getString("b_type").charAt(0));
					rc.setB_title(rset.getString("b_title"));
					rc.setB_content(rset.getString("b_content"));
					rc.setB_start(rset.getString("b_start"));
					rc.setB_end(rset.getString("b_end"));
					rc.setB_total(rset.getInt("b_total"));
					rc.setB_attend(rset.getInt("b_attend"));
					rc.setB_place(rset.getString("b_place"));
					rc.setB_fee(rset.getInt("b_fee"));
					rc.setB_match(rset.getString("b_match").charAt(0));
					rc.setB_gender(rset.getString("b_gender").charAt(0));
					rc.setB_age(rset.getString("b_age").charAt(0));
					rc.setB_equip(rset.getString("b_equip").charAt(0));
					rc.setB_minpeople(rset.getInt("b_minpeople"));
					rc.setB_progress(rset.getString("b_progress"));
					rc.setB_shower(rset.getString("b_shower").charAt(0));
					rc.setB_parking(rset.getString("b_parking").charAt(0));
					rc.setB_rental(rset.getString("b_rental").charAt(0));
					rc.setB_cloth(rset.getString("b_cloth").charAt(0));
					rc.setB_facility(rset.getString("b_facility"));
					rc.setB_timestamp(rset.getString("b_timestamp"));
					rc.setB_view(rset.getInt("b_view"));
					rclist.add(rc);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return rclist;
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

	// 게시글 번호 부여
	public int getNext(Connection conn) {
		// 현재 게시글을 내림차순으로 조회, 가장 마지막 글의 번호
		String sql = "select b_n from board_recruit order by b_n desc";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				return rset.getInt(1) + 1;
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return -1;
	}
	// TODO 카테고리 가져오기

	// 모집방 생성
	public int recruitMake(Connection conn, Recruit rc) {
		int result = -1;
		String sql = "insert into board_recruit(b_n, m_id, ca_n, b_type, b_title,"
				+ "b_content, b_start, b_end, b_total, b_attend, b_place, b_fee,"
				+ "b_match, b_gender, b_age, b_equip, b_minpeople, b_progress, b_shower,"
				+ "b_parking, b_rental, b_cloth, b_facility, b_timestamp, b_view) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext(conn));
			pstmt.setString(2, rc.getM_id());
			pstmt.setInt(3, rc.getCa_n());
			pstmt.setString(4, String.valueOf(rc.getB_type()));
			pstmt.setString(5, rc.getB_title());
			pstmt.setString(6, rc.getB_content());
			pstmt.setString(7, rc.getB_start());
			pstmt.setString(8, rc.getB_end());
			pstmt.setInt(9, rc.getB_total());
			pstmt.setInt(10, rc.getB_attend());
			pstmt.setString(11, rc.getB_place());
			pstmt.setInt(12, rc.getB_fee());
			pstmt.setString(13, String.valueOf(rc.getB_match()));
			pstmt.setString(14, String.valueOf(rc.getB_gender()));
			pstmt.setString(15, String.valueOf(rc.getB_age()));
			pstmt.setString(16, String.valueOf(rc.getB_equip()));
			pstmt.setInt(17, rc.getB_minpeople());
			pstmt.setString(18, rc.getB_progress());
			pstmt.setString(19, String.valueOf(rc.getB_shower()));
			pstmt.setString(20, String.valueOf(rc.getB_parking()));
			pstmt.setString(21, String.valueOf(rc.getB_rental()));
			pstmt.setString(22, String.valueOf(rc.getB_cloth()));
			pstmt.setString(23, rc.getB_facility());
			pstmt.setString(24, getDate(conn));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 모집방 수정
	public int update(Connection conn, Recruit rc) {
		int result = -1;
		String sql = "update board_recruit where b_n = ? ca_n = ? set b_title = ? b_content = ? b_total = ? "
				+ "b_attend = ? b_place = ? b_fee = ? b_match = ? b_gender = ? b_age = ? b_equip = ? b_minpeople = ?"
				+ "b_progress = ? b_shower = ? b_parking = ? b_rental = ? b_cloth = ? b_facility = ? b_timestamp = ?";
		PreparedStatement pstmt = null;
		try {
			rc = new Recruit();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext(conn));
			pstmt.setString(2, rc.getM_id());
			pstmt.setInt(3, rc.getCa_n());
			pstmt.setString(4, String.valueOf(rc.getB_type()));
			pstmt.setString(5, rc.getB_title());
			pstmt.setString(6, rc.getB_content());
			pstmt.setString(7, rc.getB_start());
			pstmt.setString(8, rc.getB_end());
			pstmt.setInt(9, rc.getB_total());
			pstmt.setInt(10, rc.getB_attend());
			pstmt.setString(11, rc.getB_place());
			pstmt.setInt(12, rc.getB_fee());
			pstmt.setString(13, String.valueOf(rc.getB_match()));
			pstmt.setString(14, String.valueOf(rc.getB_gender()));
			pstmt.setString(15, String.valueOf(rc.getB_age()));
			pstmt.setString(16, String.valueOf(rc.getB_equip()));
			pstmt.setInt(17, rc.getB_minpeople());
			pstmt.setString(18, rc.getB_progress());
			pstmt.setString(19, String.valueOf(rc.getB_shower()));
			pstmt.setString(20, String.valueOf(rc.getB_parking()));
			pstmt.setString(21, String.valueOf(rc.getB_rental()));
			pstmt.setString(22, String.valueOf(rc.getB_cloth()));
			pstmt.setString(23, rc.getB_facility());
			pstmt.setString(24, getDate(conn));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 모집방 삭제
	public int delete(Connection conn, int b_n) {
		int result = -1;
		String sql = "delete from board_recruit where b_n=?";
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