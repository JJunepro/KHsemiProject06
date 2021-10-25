package tbh.articlesix.board.recruit.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import tbh.articlesix.board.recruit.model.dao.RecruitApplicationDao;

import tbh.articlesix.board.recruit.model.vo.RecruitApplication;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitApplicationService {
	public ArrayList<RecruitApplication> RecruitApplicationList() {
		ArrayList<RecruitApplication> rcapplist = null;

		Connection conn = JDBCTemplate.getConnection();
		rcapplist = new RecruitApplicationDao().RecruitApplicationList(conn);
		JDBCTemplate.close(conn);
		return rcapplist;
	}
}
