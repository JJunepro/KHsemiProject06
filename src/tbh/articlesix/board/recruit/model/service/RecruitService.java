package tbh.articlesix.board.recruit.model.service;

import java.sql.Connection;
import java.util.*;

import tbh.articlesix.board.recruit.model.dao.RecruitDao;
import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitService {
	public RecruitService() {
	}

	public Recruit getRecruit(int b_n) {
		Recruit rc = null;
		Connection conn = JDBCTemplate.getConnection();
		rc = new RecruitDao().getRecruit(conn, b_n);
		JDBCTemplate.close(conn);
		return rc;
	}

	public int getRecruitCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().getRecruitCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Recruit> selectRecruitList() {
		ArrayList<Recruit> rclist = null;
		Connection conn = JDBCTemplate.getConnection();
		rclist = new RecruitDao().selectRecruitList(conn);

		JDBCTemplate.close(conn);
		return rclist;
	}

	public ArrayList<Recruit> selectRecruitList(int start, int end) {
		ArrayList<Recruit> rclist = null;
		Connection conn = JDBCTemplate.getConnection();
		rclist = new RecruitDao().selectRecruitList(conn, start, end);

		JDBCTemplate.close(conn);
		return rclist;
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

}
