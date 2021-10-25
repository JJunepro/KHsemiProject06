package tbh.articlesix.board.recruit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tbh.articlesix.board.recruit.model.vo.RecruitApplication;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitApplicationDao {
	public RecruitApplicationDao() {
	}

	public ArrayList<RecruitApplication> RecruitApplicationList(Connection conn) {
		ArrayList<RecruitApplication> rcapplist = null;

		String sql = "select * from Application order by ap_timestamp asc";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			rcapplist = new ArrayList<RecruitApplication>();
			if (rset.next()) {
				do {
					RecruitApplication ra = new RecruitApplication();
					ra.setAp_n(rset.getInt("ca_n"));
					ra.setM_id(rset.getString("m_id"));
					ra.setB_n(rset.getInt("b_n"));
					ra.setAp_agree(rset.getString("ap_agree").charAt(0));
					ra.setAp_timestamp(rset.getDate("ap_timestamp"));
					rcapplist.add(ra);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		return rcapplist;
	}
}
