package tbh.articlesix.board.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tbh.articlesix.board.notice.vo.Notice;
import tbh.articlesix.common.JDBCTemplate;

public class NoticeDao {
	
	public NoticeDao() {
		// TODO Auto-generated constructor stub
	}
	
	//1. 공지사항 테이블 출력
	public ArrayList<Notice> selectNoticeList(Connection con) {
		ArrayList<Notice> nolist = null;
		
		String sql = "select * from board_notice";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			nolist = new ArrayList<Notice>();
			if (rset.next()) {
				do {
					Notice no = new Notice();
					no.setBn_n(rset.getInt("bn_n"));
					no.setM_id(rset.getString("m_id"));
					no.setBn_title(rset.getString("bn_title"));
					no.setBn_content(rset.getString("bn_content"));
					no.setBn_timestamp(rset.getDate("bn_timestamp"));
					no.setBn_view(rset.getInt("bn_view"));
					nolist.add(no);
				} while(rset.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nolist;
	}
	
	public int getNoticeCount(Connection con) {
		int result = 0;
		String sql = "select count(bn_n) from board_notice";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
//	public int insertNotice(Connection con, Notice no) {
//		int result = -1;
//		
//		String sqlUpdate = "UPDATE BOARD_NOTICE SET BRE_STEP=BRE_STEP+1 WHERE BREF=? AND BRE_STEP>?";
//				String sqlInsert = "INSERT INTO" + " BOARD_NOTICE" + " (BN_N, M_ID, BN_TITLE, BN_CONTENT, BREF, BRE_LEVEL, BRE_STEP)"
//						+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
//				String sqlSeqNextVal = "SELECT SEQ.nextval from dual";
//				
//				int bref=0;
//				int bre_level = 0;
//				int bre_step = 1;
//				int nextVal = 0;
//				
//				PreparedStatement pstmt = null;
//				ResultSet rset = null;
//				try {
//					pstmt = con.prepareStatement(sqlSeqNextVal);
//					rset = pstmt.executeQuery();
//					if (rset.next()) {
//						nextVal = rset.getInt(1);
//					}
//					JDBCTemplate.close(rset);
//					JDBCTemplate.close(pstmt);
//					
//					if (no.getBn_n() != 0) { // 답,,,,,글 쓰기
//						bref = no.getBref();
//						bre_step = no.getBreStep();
//						pstmt = con.prepareStatement(sqlUpdate); // UPDATE
//						pstmt.setInt(1, bref);
//						pstmt.setInt(2, bre_step);
//						result = pstmt.executeUpdate();
//						JDBCTemplate.close(pstmt);
//
//						bre_level = no.getBreLevel() + 1;
//						bre_step++; 
//					}
//					
//					pstmt = con.prepareStatement(sqlInsert); // Insert
//					if (no.getBn_n() != 0) {// 답,,,,,글 쓰기
//						pstmt.setInt(5, bref);
//					} else {// 새글 쓰기
//						pstmt.setInt(5, nextVal);
//					}
//					pstmt.setInt(6, bre_level);
//					pstmt.setInt(7, bre_step);
//					pstmt.setInt(1, nextVal);
//					
//					pstmt.setString(2, no.getM_id());
//					pstmt.setString(3, no.getBn_title());
//					pstmt.setString(4, no.getBn_content());
//					result = pstmt.executeUpdate();
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					JDBCTemplate.close(rset);
//					JDBCTemplate.close(pstmt);
//				}
//				return result;
//	}
	
	public int updateNotice(Connection con) {
		int result = -1;
		String sql = "UPDATE NOTICE_BOARD SET BN_TITLE = ?, BN_CONTENT = ?, WHERE M_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}
	
	public int writeNotice(Connection con, String bn_title,String bn_content) {
		int result = -1;
		String sql = "INSERT INTO NOTICE_BOARD VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, getNext());
		} catch (Exception e) {
			// TODO: handle exception
		} {
			
		}
		return result;
	}
	
}
