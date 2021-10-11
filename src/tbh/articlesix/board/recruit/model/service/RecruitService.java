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
		Recruit vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new RecruitDao().getRecruit(conn, b_n);
		JDBCTemplate.close(conn);
		return vo;
	}

	public int getBoardCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().getRecruitCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Recruit> selectRecruitList(int start, int end) {
		ArrayList<Recruit> volist = null;
		Connection conn = JDBCTemplate.getConnection();

		volist = new RecruitDao().selectRecruitList(conn, start, end);

		JDBCTemplate.close(conn);
		return volist;
	}

	public ArrayList<Recruit> selectRecruitList() {
		ArrayList<Recruit> volist = null;
		Connection conn = JDBCTemplate.getConnection();

		volist = new RecruitDao().selectRecruitList(conn);

		JDBCTemplate.close(conn);
		return volist;
	}

	public int insertBoard(Recruit vo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();

		result = new RecruitDao().RecruitBoard(conn, vo);

		JDBCTemplate.close(conn);
		return result;
	}

}
