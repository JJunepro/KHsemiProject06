package tbh.articlesix.board.recruit.model.service;

import java.sql.Connection;

import tbh.articlesix.board.recruit.model.dao.RecruitDao;
import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitService {

	public RecruitService() {
	}

	public Recruit getRecruit(int b_n) {
		Recruit vo = null;
		Connection conn = JDBCTemplate.getConnection();
		JDBCTemplate.close(conn);
		return vo;
	}
	
	public int getRecruit() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitDao().getRecruit(conn);
		JDBCTemplate.close(conn);
		return result;
		
	}

	public int getBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
