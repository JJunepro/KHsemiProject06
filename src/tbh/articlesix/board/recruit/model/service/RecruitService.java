package tbh.articlesix.board.recruit.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.*;

import tbh.articlesix.board.recruit.model.dao.RecruitDao;
import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitService {
	public RecruitService() {
	}
	public Recruit getRecruit(int b_n) {
		Recruit vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new RecruitDao().getRecruit(conn, b_n);
		JDBCTemplate.close(conn);
		return vo;
	}

	public ArrayList<Recruit> selectRecruitList() {
		ArrayList<Recruit> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new RecruitDao().selectRecruitList(conn);

		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Recruit> selectRecruitList(int start, int end) {
		ArrayList<Recruit> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new RecruitDao().selectRecruitList(conn, start, end);

		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int recruitMake(double b_n, String m_id, int ca_n, char b_type, String b_title,
			String b_content, Date b_start, Date b_end, double b_total, double b_attend, String b_place, int b_fee,
			char b_match, char b_gender, char b_age, char b_equip, int b_minpeople, String b_progress, char b_shower,
			char b_parking, char b_rental, char b_cloth, String b_facility, Date b_timestamp, double b_view) {
		RecruitDao vo = new RecruitDao();
		Connection conn = JDBCTemplate.getConnection();
//		vo = new RecruitDao().recruitMake(conn, b_n, b_facility, b_minpeople, b_cloth, b_facility, b_facility, b_timestamp, b_timestamp, b_view, b_view, b_facility, b_minpeople, b_cloth, b_cloth, b_cloth, b_cloth, b_minpeople, b_facility, b_cloth, b_cloth, b_cloth, b_cloth, b_facility, b_timestamp, b_view);
		JDBCTemplate.close(conn);
		return 0;
	}
	public int getRecruitCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().getRecruitCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

}
