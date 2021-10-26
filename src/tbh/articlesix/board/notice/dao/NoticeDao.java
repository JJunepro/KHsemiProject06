package tbh.articlesix.board.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tbh.articlesix.board.notice.vo.Notice;
import tbh.articlesix.common.JDBCTemplate;

public class NoticeDao {
	
	public NoticeDao() {
	}
	
	//공지사항 테이블 출력
	//TODO 검색 기능 포함 구현중
//	public ArrayList<Notice> selectNoticeList(Connection conn) {
//		ArrayList<Notice> nolist = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		StringBuffer sql = new StringBuffer();
//		String opt = (String)list.get("opt");
//		try {
//			if (opt == null) {
//				sql.append("SELECT * FROM BOARD_NOTICE ORDER BY BN_N DESC");
//				
//				sql.delete(start, sql.toString().length());
//				
//			} else if(opt.equals("0")) {
//				sql.append("SELECT * FROM BOARD_NOTICE");
//				sql.append(" WHERE BN_TITLE like ?");
//				sql.append(" ORDER BY BN_N DESC");
//				
//				pstmt = conn.prepareStatement(sql.toString());
//				pstmt.setInt(1, "%"+condition+"%");
//				
//				sql.delete(start, sql.toString().length());
//			}
//			
//			rset = pstmt.executeQuery();
//			
//			nolist = new ArrayList<Notice>();
//			if (rset.next()) {
//				do {
//					Notice no = new Notice();
//					no.setBn_n(rset.getInt("bn_n"));
//					no.setM_id(rset.getString("m_id"));
//					no.setBn_title(rset.getString("bn_title"));
//					no.setBn_content(rset.getString("bn_content"));
//					no.setBn_timestamp(rset.getDate("bn_timestamp"));
//					no.setBn_view(rset.getInt("bn_view"));
//					nolist.add(no);
//				} while(rset.next());
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(pstmt);
//		}
//		return nolist;
//	}
	
//	public ArrayList<Notice> getNoticeList(HashMap<String, Object> listOpt, Connection conn) {
//		ArrayList<Notice> list = new ArrayList<Notice>();
//		
//		String opt = (String)listOpt.get("opt"); //검색 옵션(제목, 내용, 글쓴이 등등)
//		String condition = (String)listOpt.get("condition"); //검색내용
//		int start = (Integer)listOpt.get("start");
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			StringBuffer sql = new StringBuffer();
//			
//			if (opt == null) {
//				sql.append("SELECT * FROM BOARD_NOTICE ORDER BY BN_N DESC");
//				pstmt = conn.prepareStatement(sql.toString());
//				pstmt.setInt(1, start);
//				
//				sql.delete(start, sql.toString().length());
//			} else if(opt.equals("0")) {
//				sql.append("SELECT * FROM BOARD_NOTICE");
//				sql.append(" WHERE BN_TITLE like ?");
//				sql.append(" ORDER BY BN_N DESC");
//				
//				pstmt = conn.prepareStatement(sql.toString());
//				pstmt.setString(1, "%"+condition+"%");
//				
//				sql.delete(start, sql.toString().length());
//			}
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				Notice no = new Notice();
//				no.setBn_n(rs.getInt("bn_n"));
//				no.setM_nick(rs.getString("m_nick"));
//				no.setBn_title(rs.getString("bn_title"));
//				no.setBn_content(rs.getString("bn_content"));
//				no.setBn_timestamp(rs.getDate("bn_timestamp"));
//				no.setBn_view(rs.getInt("bn_view"));
//				list.add(no);
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		}finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
//		};
//		return list;
//	}
	
	public ArrayList<Notice> getNoticeList (Connection conn, String item, int search, int start, int end) {
		ArrayList<Notice> nolist = new ArrayList<Notice>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if (search == 0) {
			sql = "SELECT * FROM BOARD_NOTICE "
				+ " WHERE BN_TITLE LIKE ? "
				+ " ORDER BY BN_N DESC";
		} else if (search == 1) {
			sql = "SELECT * FROM BOARD_NOTICE "
					+ " WHERE BN_CONTENT LIKE ? "
					+ " ORDER BY BN_N DESC";
		} 
		
		System.out.println(sql);
		System.out.println(item);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' +item+ '%');
			rs = pstmt.executeQuery();
			nolist = new ArrayList<Notice>();
			if (rs.next()) {
				do {
					Notice no = new Notice();
					no.setBn_n(rs.getInt("bn_n"));
					no.setM_nick(rs.getString("m_nick"));
					no.setBn_title(rs.getString("bn_title"));
					no.setBn_content(rs.getString("bn_content"));
					no.setBn_timestamp(rs.getDate("bn_timestamp"));
					no.setBn_view(rs.getInt("bn_view"));
					nolist.add(no);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		System.out.println(sql);
		return nolist;
	}

	//공지사항 테이블 출력
	public ArrayList<Notice> selectNoticeList(Connection conn) {
		ArrayList<Notice> nolist = null;
		
		String sql = "SELECT * FROM BOARD_NOTICE ORDER BY BN_N DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			nolist = new ArrayList<Notice>();
			if (rset.next()) {
				do {
					Notice no = new Notice();
					no.setBn_n(rset.getInt("bn_n"));
					no.setM_nick(rset.getString("m_nick"));
					no.setBn_title(rset.getString("bn_title"));
					no.setBn_content(rset.getString("bn_content"));
					no.setBn_timestamp(rset.getDate("bn_timestamp"));
					no.setBn_view(rset.getInt("bn_view"));
					nolist.add(no);
				} while(rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nolist;
	}
	
	//공지사항 테이블 출력2 row number 추가 
	public ArrayList<Notice> selectNoticeList(Connection conn, int start, int end) {
		ArrayList<Notice> nolist = null;

		String sql = "select * from "
				+ " (select rownum r, a1.* from "
				+ " (select * from board_notice order by bn_n desc) a1) a2 "
				+ " where r between ? and ? order by bn_n desc";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			nolist = new ArrayList<Notice>();
			if (rs.next()) {
				do {
					Notice no = new Notice();
					no.setBn_n(rs.getInt("bn_n"));
					no.setM_nick(rs.getString("m_nick"));
					no.setBn_title(rs.getString("bn_title"));
					no.setBn_content(rs.getString("bn_content"));
					no.setBn_timestamp(rs.getDate("bn_timestamp"));
					no.setBn_view(rs.getInt("bn_view"));
					nolist.add(no);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return nolist;
	}
	
	// 게시글 번호 가져오기
	public int getNoticeCount(Connection conn) {
		int result = 0;
		String sql = "select count(bn_n) from BOARD_NOTICE";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
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
	
	public int getNoticeCount(Connection conn, int search, String item) {
		int result = 0;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		if (search == 0) {
			sql = "SELECT COUNT(BN_N) FROM BOARD_NOTICE "
				+ " WHERE BN_TITLE LIKE ? "
				+ " ORDER BY BN_N DESC";
		} else if (search == 1) {
			sql = "SELECT COUNT(BN_N) FROM BOARD_NOTICE "
					+ " WHERE BN_CONTENT LIKE ? "
					+ " ORDER BY BN_N DESC";
		} 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' +item+ '%');
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
	public String getDate(Connection conn) {
		String sql = "SELECT TO_DATE(SYSDATE, 'YYYYMMDD') FROM DUAL";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
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
	public int insertNotice(Connection conn, Notice no) {
		int result = -1;
		int nextVal = 0;
		int bnv = 0;
		String sql = "INSERT INTO" + " BOARD_NOTICE" + " (BN_N, M_NICK, BN_TITLE, BN_CONTENT, BN_TIMESTAMP, BN_VIEW)"
						+ " VALUES (?, ?, ?, ?, sysdate, ?)";
		
		String sqlSeqNextVal = "SELECT SEQ_NOTICE.NEXTVAL FROM DUAL";
				
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sqlSeqNextVal);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				nextVal = rset.getInt(1);
			}
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nextVal);
			pstmt.setString(2, no.getM_nick());
			pstmt.setString(3, no.getBn_title());
			pstmt.setString(4, no.getBn_content());
			pstmt.setInt(5, bnv);
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
			return result;
}
	
//	 게시글 보기 
	public Notice getNotice(Connection conn, int bn_n) {
		Notice no = null;
		String sql = "SELECT * FROM BOARD_NOTICE WHERE BN_N = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bn_n);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Notice notice = new Notice();
				notice.setBn_n(rset.getInt(1));
				notice.setM_nick(rset.getString("m_nick"));
				notice.setBn_title(rset.getString("bn_title"));
				notice.setBn_content(rset.getString("bn_content"));
				notice.setBn_timestamp(rset.getDate("bn_timestamp"));
				int bn_view = rset.getInt(6);
				notice.setBn_view(bn_view);
				bn_view++;
				countUpdate(conn, bn_view, bn_n);
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
	

	public int updateNotice(Connection conn, String bn_title, String bn_content, int bn_n) {
		int result = -1;
		String sql = "UPDATE BOARD_NOTICE SET BN_TITLE=?, BN_CONTENT=? WHERE BN_N=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bn_title);
			pstmt.setString(2, bn_content);
			pstmt.setInt(3, bn_n);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;	
	}
	
	//게시글 삭제
//		public int deleteNotice(Connection con, int bId) {
//			int result = -1;
//			
//			String sql = "UPDATE BOARD_NOTICE SET BN_DELETE_YN = 'Y'"
//						+ " WHERE BN_N = ? AND BN_DELETE_YN = 'N'";
//			
//			PreparedStatement pstmt = null;
//			try {
//				pstmt = con.prepareStatement(sql);
//				pstmt.setInt(1, bId);
//				result = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				JDBCTemplate.close(pstmt);
//			}
//			return result;
//		}
		
		public int deleteNotice(Connection conn, int bn_n) {
			int result = -1;
			String sql = "DELETE * FROM BOARD_NOTICE WHERE BN_N=?";
			
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bn_n);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
		
		public int countUpdate(Connection conn, int bn_view, int bn_n) {
			int result = -1;
			String sql = "UPDATE BOARD_NOTICE SET BN_VIEW = ? WHERE BN_N = ?";
			
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bn_view);
				pstmt.setInt(2, bn_n);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
}