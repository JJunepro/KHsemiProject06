package tbh.articlesix.board.recruit.model.service;

import java.sql.Connection;
import java.util.*;

import tbh.articlesix.board.recruit.model.dao.RecruitDao;
import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.common.JDBCTemplate;
import tbh.articlesix.market.dao.MarketDao;

public class RecruitService {
	public RecruitService() {
	}

	public ArrayList<Recruit> RecruitList() {
		ArrayList<Recruit> rclist = null;
		Connection conn = JDBCTemplate.getConnection();
		rclist = new RecruitDao().RecruitList(conn);
		JDBCTemplate.close(conn);
		return rclist;
	}

	public ArrayList<Recruit> RecruitList(int startRnum, int endRnum) {
		ArrayList<Recruit> rclist = null;
		Connection conn = JDBCTemplate.getConnection();
		rclist = new RecruitDao().RecruitList(conn, startRnum, endRnum);
		JDBCTemplate.close(conn);
		return rclist;
	}

	public ArrayList<Recruit> RecruitShortList() {
		ArrayList<Recruit> rcshortlist = null;
		Connection conn = JDBCTemplate.getConnection();
		rcshortlist = new RecruitDao().RecruitList(conn);
		JDBCTemplate.close(conn);
		return rcshortlist;
	}

	public ArrayList<Recruit> RecruitShortList(int startRnum, int endRnum) {
		ArrayList<Recruit> rcshortlist = null;
		Connection conn = JDBCTemplate.getConnection();
		rcshortlist = new RecruitDao().RecruitList(conn, startRnum, endRnum);
		JDBCTemplate.close(conn);
		return rcshortlist;
	}

	public ArrayList<Recruit> RecruitLongList() {
		ArrayList<Recruit> rcLonglist = null;
		Connection conn = JDBCTemplate.getConnection();
		rcLonglist = new RecruitDao().RecruitList(conn);
		JDBCTemplate.close(conn);
		return rcLonglist;
	}

	public ArrayList<Recruit> RecruitLongList(int startRnum, int endRnum) {
		ArrayList<Recruit> rcLonglist = null;
		Connection conn = JDBCTemplate.getConnection();
		rcLonglist = new RecruitDao().RecruitList(conn, startRnum, endRnum);
		JDBCTemplate.close(conn);
		return rcLonglist;
	}

	public Recruit DetailRecruit(int b_n) {
		Recruit no = null;
		Connection conn = JDBCTemplate.getConnection();
		no = new RecruitDao().DetailRecruit(conn, b_n);
		return no;
	}

	public ArrayList<Recruit> searchRecruit(String b_title, int startRnum, int endRnum) {
		ArrayList<Recruit> rclist = null;
		Connection conn = JDBCTemplate.getConnection();
		rclist = new RecruitDao().searchRecruit(conn, b_title, startRnum, endRnum);
		JDBCTemplate.close(conn);
		return rclist;
	}

	public int TotalRecruitCount() {
		Connection conn = JDBCTemplate.getConnection();
		int result = new RecruitDao().TotalRecruitCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int RecruitMake(Recruit rc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new RecruitDao().RecruitMake(conn, rc);
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

	public int ViewCount(int b_n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().ViewCount(conn, b_n);
		return result;
	}

	public int ViewAddCount(int viewCount, int b_n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().ViewAddCount(conn, viewCount, b_n);
		return result;
	}

}
