package tbh.articlesix.board.recruit.model.service;

import java.sql.Connection;
import java.util.*;

import tbh.articlesix.board.recruit.model.dao.RecruitDao;
import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitService {
	public RecruitService() {
	}
//	
//	public int getNext() {
//		int result = -1;
//		Connection conn = JDBCTemplate.getConnection();
//		result = new RecruitDao().getNext(conn, result);
//		JDBCTemplate.close(conn);
//		return result;
//	}

	public String getDate() {
		String result = "";
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().getDate(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	public ArrayList<Recruit> RecruitList(int startRnum, int endRnum) {
		ArrayList<Recruit> rclist = null;
		Connection conn = JDBCTemplate.getConnection();
		rclist = new RecruitDao().RecruitList(conn, startRnum, endRnum);
		JDBCTemplate.close(conn);
		return rclist;
	}

	public Recruit detailRecruit(int b_n) {
		Recruit rc = null;
		Connection conn = JDBCTemplate.getConnection();
		rc = new RecruitDao().detailRecruit(conn, b_n);
		return rc;
	}

	public ArrayList<Recruit> searchRecruit(String b_title, int startRnum, int endRnum) {
		ArrayList<Recruit> rclist = null;
		Connection conn = JDBCTemplate.getConnection();
		rclist = new RecruitDao().searchRecruit(conn, b_title, startRnum, endRnum);
		JDBCTemplate.close(conn);
		return rclist;
	}

	public int getRecruitCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().getRecruitCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int recruitCountList() {
		Connection conn = JDBCTemplate.getConnection();
		int result = new RecruitDao().recruitCountList(conn);
		return result;
	}

	public int recruitMake(Recruit rc) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().recruitMake(conn, rc);
		JDBCTemplate.close(conn);
		return result;
	}

	public int update(Recruit rc) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().update(conn, rc);
		JDBCTemplate.close(conn);
		return result;
	}

	public int delete(int b_n) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().delete(conn, b_n);
		JDBCTemplate.close(conn);
		return result;
	}

	public int viewCount(int b_n) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().viewCount(conn, b_n);
		JDBCTemplate.close(conn);
		return result;
	}
}
