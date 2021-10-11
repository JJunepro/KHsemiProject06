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
	
	//공지사항 테이블 출력
	public ArrayList<Notice> selectNoticeList(Connection con) {
		ArrayList<Notice> nolist = null;
		
		String sql = "SELECT * FROM BOARD_NOTICE ORDER BY BN_N DESC";
		
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
	
	// 게시글 번호 가져오기
	public int getNoticeCount(Connection con) {
		int result = 0;
		String sql = "select count(bn_n) from BOARD_NOTICE";
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
	
	// 현재 시간 불러오기
	public String getDate(Connection con) {
		int result = 0;
		String sql = "SELECT TO_DATE(SYSDATE, 'YYYYMMDD') FROM DUAL";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				return rset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return "";
	}
	
	//글 등록 
	public int insertNotice(Connection con, Notice no) {
		int result = -1;
		int nextVal = 0;
		int bnv = 0;
		String sql = "INSERT INTO" + " BOARD_NOTICE" + " (BN_N, M_ID, BN_TITLE, BN_CONTENT, BN_TIMESTAMP, BN_VIEW)"
						+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		String sqlSeqNextVal = "SELECT SEQ_NOTICE.NEXTVAL FROM DUAL";
				
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(sqlSeqNextVal);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				nextVal = rset.getInt(1);
			}
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nextVal);
			pstmt.setString(2, no.getM_id());
			pstmt.setString(3, no.getBn_title());
			pstmt.setString(4, no.getBn_content());
			pstmt.setString(5, "2021-10-12");
			pstmt.setInt(6, bnv);
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
			return result;
}

//	public int writeNotice(Connection con, String m_id, String bn_title,String bn_content) {
//		int result = -1;
//		String sql = "INSERT INTO BOARD_NOTICE VALUES(?, ?, ?, ?, ?, ?)";
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, getNoticeCount(con));
//			pstmt.setString(2, m_id);
//			pstmt.setString(3, bn_title);
//			pstmt.setString(4, bn_content);
//			pstmt.setString(5, getDate(con));
//			pstmt.setInt(6, 1);
//			rset = pstmt.executeQuery();
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(pstmt);
//		}
//		return result;
//	}
	
	
	//TODO 진행중 글 수정
	public int updateNotice(Connection con) {
		int result = -1;
		String sql = "UPDATE BOARD_NOTICE SET BN_TITLE=?, BN_CONTENT=?, WHERE M_ID=?";
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
	
//	 게시글 보기 
	public Notice getNotice(Connection con, int bn_n) {
		Notice no = null;
		
		String sql = "SELECT * FROM BOARD_NOTICE WHERE BN_N = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bn_n);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Notice notice = new Notice();
				notice.setBn_n(rset.getInt(1));
				notice.setM_id(rset.getString("m_id"));
				notice.setBn_title(rset.getString("bn_title"));
				notice.setBn_content(rset.getString("bn_content"));
				notice.setBn_timestamp(rset.getDate("bn_timestamp"));
				notice.setBn_view(rset.getInt(6));
				return notice;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return null;
	}
	
}
