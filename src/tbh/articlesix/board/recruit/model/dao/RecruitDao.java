package tbh.articlesix.board.recruit.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import tbh.articlesix.board.*;
import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitDao {
	private static final String getM_id = null;

	public RecruitDao() {
	}

	// 가져오기
	public Recruit getRecruit(Connection conn, int b_n) {
		Recruit vo = null;
		String sql = "select b_n, String m_id, int ca_n, char b_type, String b_title, String b_content, Date b_start,"
				+ "Date b_end, int b_total, int b_attend, String b_place, int b_fee, char b_match, char b_gender, char b_age,"
				+ "char b_equip, int b_minpeople, String b_progress, char b_shower, char b_parking, char b_rental,"
				+ "char b_cloth, String b_facility, Date b_timestamp, int b_view" + " from board_recruit where b_n = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_n);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vo = new Recruit();
				vo.setB_n(rset.getInt("b_n"));
				vo.setM_id(rset.getString("m_id"));
				vo.setCa_n(rset.getInt("ca_n"));
				vo.setB_type(rset.getString("b_type").charAt(0));
				vo.setB_title(rset.getString("b_title"));
				vo.setB_content(rset.getString("b_content"));
				vo.setB_start(rset.getDate("b_start"));
				vo.setB_total(rset.getInt("b_total"));
				vo.setB_attend(rset.getInt("b_attend"));
				vo.setB_place(rset.getString("b_place"));
				vo.setB_fee(rset.getInt("b_fee"));
				vo.setB_match(rset.getString("b_match").charAt(0));
				vo.setB_gender(rset.getString("b_gender").charAt(0));
				vo.setB_age(rset.getString("b_age").charAt(0));
				vo.setB_equip(rset.getString("b_equip").charAt(0));
				vo.setB_minpeople(rset.getInt("b_minpeople"));
				vo.setB_progress(rset.getString("b_progress"));
				vo.setB_shower(rset.getString("b_shower").charAt(0));
				vo.setB_parking(rset.getString("b_parking").charAt(0));
				vo.setB_rental(rset.getString("b_rental").charAt(0));
				vo.setB_cloth(rset.getString("b_cloth").charAt(0));
				vo.setB_facility(rset.getString("b_facility"));
				vo.setB_timestamp(rset.getDate("b_timestamp"));
				vo.setB_view(rset.getInt("b_view"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return vo;
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
		ArrayList<Recruit> volist = null;

		String sql = "select * from board";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Recruit>();
			if (rset.next()) {
				do {
					Recruit vo = new Recruit();
					vo = new Recruit();
					vo.setB_n(rset.getInt("b_n"));
					vo.setM_id(rset.getString("m_id"));
					vo.setCa_n(rset.getInt("ca_n"));
					vo.setB_type(rset.getString("b_type").charAt(0));
					vo.setB_title(rset.getString("b_title"));
					vo.setB_content(rset.getString("b_content"));
					vo.setB_start(rset.getDate("b_start"));
					vo.setB_total(rset.getInt("b_total"));
					vo.setB_attend(rset.getInt("b_attend"));
					vo.setB_place(rset.getString("b_place"));
					vo.setB_fee(rset.getInt("b_fee"));
					vo.setB_match(rset.getString("b_match").charAt(0));
					vo.setB_gender(rset.getString("b_gender").charAt(0));
					vo.setB_age(rset.getString("b_age").charAt(0));
					vo.setB_equip(rset.getString("b_equip").charAt(0));
					vo.setB_minpeople(rset.getInt("b_minpeople"));
					vo.setB_progress(rset.getString("b_progress"));
					vo.setB_shower(rset.getString("b_shower").charAt(0));
					vo.setB_parking(rset.getString("b_parking").charAt(0));
					vo.setB_rental(rset.getString("b_rental").charAt(0));
					vo.setB_cloth(rset.getString("b_cloth").charAt(0));
					vo.setB_facility(rset.getString("b_facility"));
					vo.setB_timestamp(rset.getDate("b_timestamp"));
					vo.setB_view(rset.getInt("b_view"));
					volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("라턴" + volist);
		return volist;
	}

	public ArrayList<Recruit> selectRecruitList(Connection conn, int start, int end) {
		ArrayList<Recruit> volist = null;

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
			volist = new ArrayList<Recruit>();
			if (rset.next()) {
				do {
					Recruit vo = new Recruit();
					vo.setB_n(rset.getInt("b_n"));
					vo.setM_id(rset.getString("m_id"));
					vo.setCa_n(rset.getInt("ca_n"));
					vo.setB_type(rset.getString("b_type").charAt(0));
					vo.setB_title(rset.getString("b_title"));
					vo.setB_content(rset.getString("b_content"));
					vo.setB_start(rset.getDate("b_start"));
					vo.setB_total(rset.getInt("b_total"));
					vo.setB_attend(rset.getInt("b_attend"));
					vo.setB_place(rset.getString("b_place"));
					vo.setB_fee(rset.getInt("b_fee"));
					vo.setB_match(rset.getString("b_match").charAt(0));
					vo.setB_gender(rset.getString("b_gender").charAt(0));
					vo.setB_age(rset.getString("b_age").charAt(0));
					vo.setB_equip(rset.getString("b_equip").charAt(0));
					vo.setB_minpeople(rset.getInt("b_minpeople"));
					vo.setB_progress(rset.getString("b_progress"));
					vo.setB_shower(rset.getString("b_shower").charAt(0));
					vo.setB_parking(rset.getString("b_parking").charAt(0));
					vo.setB_rental(rset.getString("b_rental").charAt(0));
					vo.setB_cloth(rset.getString("b_cloth").charAt(0));
					vo.setB_facility(rset.getString("b_facility"));
					vo.setB_timestamp(rset.getDate("b_timestamp"));
					vo.setB_view(rset.getInt("b_view"));
					volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
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
		}
		return -1;
	}
	// TODO 카테고리 가져오기

	// 모집방 생성
	public int recruitMake(Connection conn, Recruit recruit) {
		String sql = "insert into board_recruit(b_n, m_id, ca_n, b_type, b_title,"
				+ "b_content, b_start, b_end, b_total, b_attend, b_place, b_fee,"
				+ "b_match, b_gender, b_age, b_equip, b_minpeople, b_progress, b_shower,"
				+ "b_parking, b_rental, b_cloth, b_facility, b_timestamp, b_view) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		PreparedStatement pstmt = null;

		try {
			Recruit vo = new Recruit();
			vo = new Recruit();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext(conn));
			pstmt.setString(2, vo.getM_id());
			pstmt.setInt(3, vo.getCa_n());
			pstmt.setString(4, String.valueOf(vo.getB_type()));
			pstmt.setString(5, vo.getB_title());
			pstmt.setString(6, vo.getB_content());
			pstmt.setDate(7, vo.getB_start());
			pstmt.setInt(8, vo.getB_total());
			pstmt.setInt(9, vo.getB_attend());
			pstmt.setString(10, vo.getB_place());
			pstmt.setInt(11, vo.getB_fee());
			pstmt.setString(12, String.valueOf(vo.getB_match()));
			pstmt.setString(13, String.valueOf(vo.getB_gender()));
			pstmt.setString(14, String.valueOf(vo.getB_age()));
			pstmt.setString(15, String.valueOf(vo.getB_equip()));
			pstmt.setInt(16, vo.getB_minpeople());
			pstmt.setString(17, vo.getB_progress());
			pstmt.setString(18, String.valueOf(vo.getB_shower()));
			pstmt.setString(19, String.valueOf(vo.getB_parking()));
			pstmt.setString(20, String.valueOf(vo.getB_rental()));
			pstmt.setString(21, String.valueOf(vo.getB_cloth()));
			pstmt.setString(22, vo.getB_facility());
			pstmt.setString(23, getDate(conn));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 모집방 수정
	public int update(Connection conn, int b_n, String m_id, int ca_n, char b_type, String b_title, String b_content,
			Date b_start, Date b_end, int b_total, int b_attend, String b_place, int b_fee, char b_match, char b_gender,
			char b_age, char b_equip, int b_minpeople, String b_progress, char b_shower, char b_parking, char b_rental,
			char b_cloth, String b_facility, Date b_timestamp, int b_view) {
		String sql = "update board_recruit where b_n = ? ca_n = ? set b_title = ? b_content = ? b_total = ? "
				+ "b_attend = ? b_place = ? b_fee = ? b_match = ? b_gender = ? b_age = ? b_equip = ? b_minpeople = ?"
				+ "b_progress = ? b_shower = ? b_parking = ? b_rental = ? b_cloth = ? b_facility = ? b_timestamp = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_n);
			pstmt.setInt(2, ca_n);
			pstmt.setString(3, b_title);
			pstmt.setString(4, b_content);
			pstmt.setString(5, String.valueOf(b_type));
			pstmt.setDouble(6, b_total);
			pstmt.setDouble(9, b_attend);
			pstmt.setString(10, b_place);
			pstmt.setInt(11, b_fee);
			pstmt.setString(12, String.valueOf(b_match));
			pstmt.setString(13, String.valueOf(b_gender));
			pstmt.setInt(14, b_age);
			pstmt.setString(15, String.valueOf(b_equip));
			pstmt.setInt(16, b_minpeople);
			pstmt.setString(17, String.valueOf(b_progress));
			pstmt.setString(18, String.valueOf(b_shower));
			pstmt.setString(19, String.valueOf(b_parking));
			pstmt.setString(20, String.valueOf(b_rental));
			pstmt.setString(21, String.valueOf(b_cloth));
			pstmt.setString(22, b_facility);
			pstmt.setString(23, getDate(conn));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 모집방 삭제
	public int delete(Connection conn, int b_n) {
		String sql = "delete from board where num=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_n);
			pstmt.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public void chat() {
		
	}
//	B_N	NUMBER		FK	O
//	M_ID	VARCHAR2	30	FK	O
//	CHAT_TIME	DATE			O
//	CHAT_MESSAGE	VARCHAR2	500		O
}
