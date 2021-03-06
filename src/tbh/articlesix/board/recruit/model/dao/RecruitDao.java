package tbh.articlesix.board.recruit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitDao {
	public RecruitDao() {
	}

	// 모집방 목록
	public ArrayList<Recruit> RecruitList(Connection conn) {
		ArrayList<Recruit> rclist = null;

		String sql = "SELECT * FROM BOARD_RECRUIT ORDER BY B_N DESC";

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
		return rclist;
	}

	public ArrayList<Recruit> RecruitList(Connection conn, int startRnum, int endRnum) {
		ArrayList<Recruit> rclist = null;

		String sql = "select * from " + " (select rownum r, a1.* from "
				+ " (select * from board_recruit order by b_n desc) a1) a2 "
				+ " where r between ? and ? order by b_n desc";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
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

	// 모집방 단기 목록
	public ArrayList<Recruit> RecruitShortList(Connection conn) {
		ArrayList<Recruit> rcshortlist = null;

		String sql = "select * from board_recruit where 'b_start' = 'b_end' order by b_n desc";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			rcshortlist = new ArrayList<Recruit>();
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
					rcshortlist.add(rc);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		return rcshortlist;
	}

	public ArrayList<Recruit> RecruitShortList(Connection conn, int startRnum, int endRnum) {
		ArrayList<Recruit> rcshortlist = null;

		String sql = "select * from" + " (select Rownum r, t1."
				+ "* from (select * from board_recruit where b_start = b_end order by b_n desc) t1 ) t2"
				+ " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rset = pstmt.executeQuery();
			rcshortlist = new ArrayList<Recruit>();
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
					rcshortlist.add(rc);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		return rcshortlist;
	}

	// 모집방 장기 목록
	public ArrayList<Recruit> RecruitLongList(Connection conn) {
		ArrayList<Recruit> rcLonglist = null;

		String sql = "select * from board_recruit where b_start != b_end order by b_n desc";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			rcLonglist = new ArrayList<Recruit>();
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
					rcLonglist.add(rc);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		return rcLonglist;
	}

	public ArrayList<Recruit> RecruitLongList(Connection conn, int startRnum, int endRnum) {
		ArrayList<Recruit> rcLonglist = null;

		String sql = "select * from" + " (select Rownum r, t1."
				+ "* from (select * from board_recruit where b_start != b_end order by b_n desc) t1 ) t2"
				+ " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rset = pstmt.executeQuery();
			rcLonglist = new ArrayList<Recruit>();
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
					rcLonglist.add(rc);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		return rcLonglist;
	}

	// 모집방 상세 페이지
	public Recruit DetailRecruit(Connection conn, int b_n) {
		Recruit no = null;
		String sql = "select * from board_recruit where b_n = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_n);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Recruit recruit = new Recruit();
				recruit.setB_n(rset.getInt(1));
				recruit.setM_id(rset.getString("m_id"));
				recruit.setCa_n(rset.getInt("ca_n"));
				recruit.setB_type(rset.getString("b_type").charAt(0));
				recruit.setB_title(rset.getString("b_title"));
				recruit.setB_content(rset.getString("b_content"));
				recruit.setB_start(rset.getString("b_start"));
				recruit.setB_end(rset.getString("b_end"));
				recruit.setB_total(rset.getInt("b_total"));
				recruit.setB_attend(rset.getInt("b_attend"));
				recruit.setB_place(rset.getString("b_place"));
				recruit.setB_fee(rset.getInt("b_fee"));
				recruit.setB_match(rset.getString("b_match").charAt(0));
				recruit.setB_gender(rset.getString("b_gender").charAt(0));
				recruit.setB_age(rset.getString("b_age").charAt(0));
				recruit.setB_equip(rset.getString("b_equip").charAt(0));
				recruit.setB_minpeople(rset.getInt("b_minpeople"));
				recruit.setB_progress(rset.getString("b_progress"));
				recruit.setB_shower(rset.getString("b_shower").charAt(0));
				recruit.setB_parking(rset.getString("b_parking").charAt(0));
				recruit.setB_rental(rset.getString("b_rental").charAt(0));
				recruit.setB_cloth(rset.getString("b_cloth").charAt(0));
				recruit.setB_facility(rset.getString("b_facility"));
				recruit.setB_timestamp(rset.getString("b_timestamp"));
				int b_view = rset.getInt(25);
				recruit.setB_view(rset.getInt("b_view"));
				
				recruit.setB_view(b_view);
				b_view++;
				viewCount(conn, b_view, b_n);
				return recruit;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		return null;
	}

	// 모지방 제목 검색
	public ArrayList<Recruit> searchRecruit(Connection conn, String b_title, int startRnum, int endRnum) {
		ArrayList<Recruit> rclist = null;
		// sql문 다시 작성
		String sql = "select * from BOARD_RECRUIT t1 join image t2 on t1.b_n=t2.img_n where t1.rc_title=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_title);
			rset = pstmt.executeQuery();
			rclist = new ArrayList<Recruit>();
			while (rset.next()) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			JDBCTemplate.close(conn);
		}

		return rclist;
	}

	// 모집방 총 갯수
	public int TotalRecruitCount(Connection conn) {
		int count = 0;
		String sql = "select count(b_n) from board_recruit";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				count = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			JDBCTemplate.close(conn);
		}
		return count;
	}

	// 모집방 생성
	public int RecruitMake(Connection conn, Recruit rc) {
		int result = -1;

		String sql = "insert into board_recruit(b_n, m_id, ca_n, b_type, b_title,"
				+ "b_content, b_start, b_end, b_total, b_attend, b_place, b_fee,"
				+ "b_match, b_gender, b_age, b_equip, b_minpeople, b_progress, b_shower,"
				+ "b_parking, b_rental, b_cloth, b_facility, b_timestamp, b_view) "
				+ "values(rc_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
				+ " to_date(sysdate,'yyyy.mm.dd hh24:mi:ss'), 1)";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rc.getM_id());
			pstmt.setInt(2, rc.getCa_n());
			pstmt.setString(3, String.valueOf(rc.getB_type()));
			pstmt.setString(4, rc.getB_title());
			pstmt.setString(5, rc.getB_content());
			pstmt.setString(6, rc.getB_start());
			pstmt.setString(7, rc.getB_end());
			pstmt.setInt(8, rc.getB_total());
			pstmt.setString(9, rc.getB_place());
			pstmt.setInt(10, rc.getB_fee());
			pstmt.setString(11, String.valueOf(rc.getB_match()));
			pstmt.setString(12, String.valueOf(rc.getB_gender()));
			pstmt.setString(13, String.valueOf(rc.getB_age()));
			pstmt.setString(14, String.valueOf(rc.getB_equip()));
			pstmt.setInt(15, rc.getB_minpeople());
			pstmt.setString(16, rc.getB_progress());
			pstmt.setString(17, String.valueOf(rc.getB_shower()));
			pstmt.setString(18, String.valueOf(rc.getB_parking()));
			pstmt.setString(19, String.valueOf(rc.getB_rental()));
			pstmt.setString(20, String.valueOf(rc.getB_cloth()));
			pstmt.setString(21, rc.getB_facility());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}

	// 모집방 수정
	public int update(Connection conn, Recruit rc) {
		int result = -1;
		String sql = "update board_recruit set m_id = ? ca_n = ? b_type =? b_title = ? b_content = ? b_start =? b_end = ? "
				+ "b_total = ? b_attend = ? b_place = ? b_fee = ? b_match = ? b_gender = ? b_age = ? b_equip = ? b_minpeople = ?"
				+ "b_progress = ? b_shower = ? b_parking = ? b_rental = ? b_cloth = ? b_facility = ? b_timestamp = ?"
				+ " where b_n=?";
		PreparedStatement pstmt = null;
		try {
			rc = new Recruit();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rc.getM_id());
			pstmt.setInt(2, rc.getCa_n());
			pstmt.setString(3, String.valueOf(rc.getB_type()));
			pstmt.setString(4, rc.getB_title());
			pstmt.setString(5, rc.getB_content());
			pstmt.setString(6, rc.getB_start());
			pstmt.setString(7, rc.getB_end());
			pstmt.setInt(8, rc.getB_total());
			pstmt.setInt(9, rc.getB_attend());
			pstmt.setString(10, rc.getB_place());
			pstmt.setInt(11, rc.getB_fee());
			pstmt.setString(12, String.valueOf(rc.getB_match()));
			pstmt.setString(13, String.valueOf(rc.getB_gender()));
			pstmt.setString(14, String.valueOf(rc.getB_age()));
			pstmt.setString(15, String.valueOf(rc.getB_equip()));
			pstmt.setInt(16, rc.getB_minpeople());
			pstmt.setString(17, rc.getB_progress());
			pstmt.setString(18, String.valueOf(rc.getB_shower()));
			pstmt.setString(19, String.valueOf(rc.getB_parking()));
			pstmt.setString(20, String.valueOf(rc.getB_rental()));
			pstmt.setString(21, String.valueOf(rc.getB_cloth()));
			pstmt.setString(22, rc.getB_facility());
			pstmt.setString(23, rc.getB_timestamp());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 1) {
			JDBCTemplate.commit(conn);
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
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}

	// 조회수 증가 (TODO 같은날 동일 id 미 증가 코드 수정 필요)
	public int viewCount(Connection conn, int b_view, int b_n) {
		int result = -1;
		String sql = "select b_view from board_recruit where b_n = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_view);
			pstmt.setInt(2, b_n);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 운동 Top 10
	public ArrayList<Recruit> HotListRecruit(Connection conn) {
		ArrayList<Recruit> rclist = null;

		String sql = "SELECT * FROM BOARD_RECRUIT ORDER BY B_N DESC";

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
		return rclist;
	}

	// 모집 마감 임박
//	public ArrayList<Recruit> HotListRecruit(Connection conn) {
//		ArrayList<Recruit> rclist = null;
//		String sql = "select * from BOARD_MARKET2 t1 join image t2 on t1.bm_n=t2.img_n\r\n" + 
//				"order by bm_view desc";
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rset = pstmt.executeQuery();
//			rclist = new ArrayList<Recruit>();
//			while (rset.next()) {
//				Recruit rc = new Recruit();
//				rc.setB_n(rset.getInt("b_n"));
//				rc.setM_id(rset.getString("m_id"));
//				rc.setCa_n(rset.getInt("ca_n"));
//				rc.setB_type(rset.getString("b_type").charAt(0));
//				rc.setB_title(rset.getString("b_title"));
//				rc.setB_content(rset.getString("b_content"));
//				rc.setB_start(rset.getString("b_start"));
//				rc.setB_end(rset.getString("b_end"));
//				rc.setB_total(rset.getInt("b_total"));
//				rc.setB_attend(rset.getInt("b_attend"));
//				rc.setB_place(rset.getString("b_place"));
//				rc.setB_fee(rset.getInt("b_fee"));
//				rc.setB_match(rset.getString("b_match").charAt(0));
//				rc.setB_gender(rset.getString("b_gender").charAt(0));
//				rc.setB_age(rset.getString("b_age").charAt(0));
//				rc.setB_equip(rset.getString("b_equip").charAt(0));
//				rc.setB_minpeople(rset.getInt("b_minpeople"));
//				rc.setB_progress(rset.getString("b_progress"));
//				rc.setB_shower(rset.getString("b_shower").charAt(0));
//				rc.setB_parking(rset.getString("b_parking").charAt(0));
//				rc.setB_rental(rset.getString("b_rental").charAt(0));
//				rc.setB_cloth(rset.getString("b_cloth").charAt(0));
//				rc.setB_facility(rset.getString("b_facility"));
//				rc.setB_timestamp(rset.getString("b_timestamp"));
//				rc.setB_view(rset.getInt("b_view"));
//				rclist.add(rc);
//				
//			}
//		}catch (Exception e) {
//			System.out.println("error");
//		}
//		finally {
//			JDBCTemplate.close(pstmt);
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(conn);
//		}
//		return rclist;
//	}

	// 4인 이상 모임
//	public ArrayList<Recruit> HotListRecruit(Connection conn) {
//		ArrayList<Recruit> rclist = null;
//		String sql = "select * from BOARD_MARKET2 t1 join image t2 on t1.bm_n=t2.img_n\r\n" + 
//				"order by bm_view desc";
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rset = pstmt.executeQuery();
//			rclist = new ArrayList<Recruit>();
//			while (rset.next()) {
//				Recruit rc = new Recruit();
//				rc.setB_n(rset.getInt("b_n"));
//				rc.setM_id(rset.getString("m_id"));
//				rc.setCa_n(rset.getInt("ca_n"));
//				rc.setB_type(rset.getString("b_type").charAt(0));
//				rc.setB_title(rset.getString("b_title"));
//				rc.setB_content(rset.getString("b_content"));
//				rc.setB_start(rset.getString("b_start"));
//				rc.setB_end(rset.getString("b_end"));
//				rc.setB_total(rset.getInt("b_total"));
//				rc.setB_attend(rset.getInt("b_attend"));
//				rc.setB_place(rset.getString("b_place"));
//				rc.setB_fee(rset.getInt("b_fee"));
//				rc.setB_match(rset.getString("b_match").charAt(0));
//				rc.setB_gender(rset.getString("b_gender").charAt(0));
//				rc.setB_age(rset.getString("b_age").charAt(0));
//				rc.setB_equip(rset.getString("b_equip").charAt(0));
//				rc.setB_minpeople(rset.getInt("b_minpeople"));
//				rc.setB_progress(rset.getString("b_progress"));
//				rc.setB_shower(rset.getString("b_shower").charAt(0));
//				rc.setB_parking(rset.getString("b_parking").charAt(0));
//				rc.setB_rental(rset.getString("b_rental").charAt(0));
//				rc.setB_cloth(rset.getString("b_cloth").charAt(0));
//				rc.setB_facility(rset.getString("b_facility"));
//				rc.setB_timestamp(rset.getString("b_timestamp"));
//				rc.setB_view(rset.getInt("b_view"));
//				rclist.add(rc);
//				
//			}
//		}catch (Exception e) {
//			System.out.println("error");
//		}
//		finally {
//			JDBCTemplate.close(pstmt);
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(conn);
//		}
//		return rclist;
//	}

	// 코로나 대비 온라인 모임
//	public ArrayList<Recruit> HotListRecruit(Connection conn) {
//		ArrayList<Recruit> rclist = null;
//		String sql = "select * from BOARD_MARKET2 t1 join image t2 on t1.bm_n=t2.img_n\r\n" + 
//				"order by bm_view desc";
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rset = pstmt.executeQuery();
//			rclist = new ArrayList<Recruit>();
//			while (rset.next()) {
//				Recruit rc = new Recruit();
//				rc.setB_n(rset.getInt("b_n"));
//				rc.setM_id(rset.getString("m_id"));
//				rc.setCa_n(rset.getInt("ca_n"));
//				rc.setB_type(rset.getString("b_type").charAt(0));
//				rc.setB_title(rset.getString("b_title"));
//				rc.setB_content(rset.getString("b_content"));
//				rc.setB_start(rset.getString("b_start"));
//				rc.setB_end(rset.getString("b_end"));
//				rc.setB_total(rset.getInt("b_total"));
//				rc.setB_attend(rset.getInt("b_attend"));
//				rc.setB_place(rset.getString("b_place"));
//				rc.setB_fee(rset.getInt("b_fee"));
//				rc.setB_match(rset.getString("b_match").charAt(0));
//				rc.setB_gender(rset.getString("b_gender").charAt(0));
//				rc.setB_age(rset.getString("b_age").charAt(0));
//				rc.setB_equip(rset.getString("b_equip").charAt(0));
//				rc.setB_minpeople(rset.getInt("b_minpeople"));
//				rc.setB_progress(rset.getString("b_progress"));
//				rc.setB_shower(rset.getString("b_shower").charAt(0));
//				rc.setB_parking(rset.getString("b_parking").charAt(0));
//				rc.setB_rental(rset.getString("b_rental").charAt(0));
//				rc.setB_cloth(rset.getString("b_cloth").charAt(0));
//				rc.setB_facility(rset.getString("b_facility"));
//				rc.setB_timestamp(rset.getString("b_timestamp"));
//				rc.setB_view(rset.getInt("b_view"));
//				rclist.add(rc);
//				
//			}
//		}catch (Exception e) {
//			System.out.println("error");
//		}
//		finally {
//			JDBCTemplate.close(pstmt);
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(conn);
//		}
//		return rclist;
//	}

}