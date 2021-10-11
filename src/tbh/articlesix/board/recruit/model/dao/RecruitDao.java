package tbh.articlesix.board.recruit.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import tbh.articlesix.board.*;
import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitDao {
	public RecruitDao() {
	}
	// 가져오기
	public Recruit getRecruit(Connection conn, int b_n) {
		Recruit vo = null;
		String sql = "select bno, bref, bre_level, bre_step"
				+ " ,title, content, createDate, writer, deletYn "
				+ " from board_r where bno = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_n);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vo = new Recruit();
				vo.setB_n(rset.getInt("b_n"));
				vo.setM_id(rset.getString("m_id"));
				vo.setCa_n(rset.getInt("ca_n"));
//				vo.setB_type(rset.getNCharacterStream("b_type"));
//				vo.setB_title(rset.getString("b_title"));
//				vo.setContent(rset.getString("content"));
//				vo.setCreateDate(rset.getDate("create_Date"));
//				vo.setWriter(rset.getString("writer"));
//				vo.setDeleteYn(rset.getString("delete_Yn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}
	
	public ArrayList<Recruit> selectRecruitList(Connection conn, int start, int end) {
		ArrayList<Recruit> volist = null;

		String sql = "select * from (select Rownum r, t1.* from (select * from board_r order by bref desc, bre_step asc) t1 ) t2 where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Recruit>();
			if (rset.next()) {
				do {
					Recruit vo = new Recruit();
//					vo.setBno(rset.getInt("bno"));
//					vo.setTitle(rset.getString("title"));
//					vo.setContent(rset.getString("content"));
//					vo.setCreateDate(rset.getDate("create_Date"));
//					vo.setWriter(rset.getString("writer"));
//					vo.setDeleteYn(rset.getString("delete_Yn"));
//					vo.setBref(rset.getInt("bref"));
//					vo.setBreLevel(rset.getInt("bre_Level"));
//					vo.setBreStep(rset.getInt("bre_Step"));
//					volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
//			try {
//				rset.close();
//				pstmt.close();
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("[ejkim]-- 리턴은" + volist);
		return volist;
	}

	public int getRecruitCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int RecruitBoard(Connection conn, Recruit vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Recruit> selectRecruitList(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}
}
