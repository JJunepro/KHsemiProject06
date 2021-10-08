package tbh.articlesix.board.recruit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import tbh.articlesix.board.recruit.model.vo.Recruit;

public class RecruitDao {
	public RecruitDao() {
		
	}

	public int getRecruit(Connection conn) {
		Recruit vo = null;
		String sql = "select bno, bref, bre_level, bre_step"
				+ " ,title, content, createDate, writer, deletYn "
				+ " from board_recruit where b_n = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
//	public ArrayList<> selectBoardList(Connection conn)
	
}
