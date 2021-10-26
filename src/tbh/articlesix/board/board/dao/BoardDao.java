package tbh.articlesix.board.board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tbh.articlesix.board.board.vo.Board;
import tbh.articlesix.common.JDBCTemplate;

public class BoardDao {

	public BoardDao() {
		// TODO Auto-generated constructor stub
	}

	public Board getBoard(Connection conn, int bf_n) {
		Board vo = null;
		String sql = "SELECT * FROM BOARD_FREE WHERE BF_N = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bf_n);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Board board = new Board();
				board.setBf_n(rset.getInt(1));
				board.setM_nick(rset.getString("m_nick"));
				board.setBf_title(rset.getString("bf_title"));
				board.setBf_content(rset.getString("bf_content"));
				board.setBf_timestamp(rset.getDate("bf_timestamp"));
				int bf_view = rset.getInt(6);
				board.setBf_view(bf_view);
				bf_view++;
				countUpdate(conn, bf_view, bf_n);
				return board;
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

	public ArrayList<Board> getBoardList (Connection conn, String item, int search, int start, int end) {
		ArrayList<Board> volist = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if (search == 0) {
			sql = "SELECT * FROM BOARD_FREE "
				+ " WHERE BF_TITLE LIKE ? "
				+ " ORDER BY BF_N DESC";
		} else if (search == 1) {
			sql = "SELECT * FROM BOARD_FREE "
					+ " WHERE BF_CONTENT LIKE ? "
					+ " ORDER BY BF_N DESC";
		} 
		
		System.out.println(sql);
		System.out.println(item);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' +item+ '%');
			rs = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if (rs.next()) {
				do {
					Board vo = new Board();
					vo.setBf_n(rs.getInt("bf_n"));
					vo.setM_nick(rs.getString("m_nick"));
					vo.setBf_title(rs.getString("bf_title"));
					vo.setBf_content(rs.getString("bf_content"));
					vo.setBf_timestamp(rs.getDate("bf_timestamp"));
					vo.setBf_view(rs.getInt("bf_view"));
					vo.setBf_category(rs.getInt("bf_category"));
					volist.add(vo);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		System.out.println(sql);
		return volist;
	}
	
	public int getBoardCount(Connection conn, int search, String item) {
		int result = 0;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		if (search == 0) {
			sql = "SELECT COUNT(BF_N) FROM BOARD_FREE "
				+ " WHERE BF_TITLE LIKE ? "
				+ " ORDER BY BF_N DESC";
		} else if (search == 1) {
			sql = "SELECT COUNT(BF_N) FROM BOARD_FREE "
					+ " WHERE BF_CONTENT LIKE ? "
					+ " ORDER BY BF_N DESC";
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
	
	public int getBoardCount(Connection conn) {
		int result = 0;
		String sql = "select count(bf_n) from board_free";
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
	
	public int getBoardCountC(Connection conn, int category) {
		int result = 0;
		String sql = "select count(bf_n) from board_free where bf_category=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
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
	
	//전체 글 보기
	public ArrayList<Board> selectBoardList(Connection conn, int start, int end) {
		ArrayList<Board> volist = null;

		String sql = "select * from "
				+ " (select Rownum r, t1.* from "
				+ " (select * from board_free order by bf_n desc) t1 ) t2 "
				+ " where r between ? and ? order by bf_n desc";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if (rs.next()) {
				do {
					Board vo = new Board();
					vo.setBf_n(rs.getInt("bf_n"));
					vo.setM_nick(rs.getString("m_nick"));
					vo.setBf_title(rs.getString("bf_title"));
					vo.setBf_content(rs.getString("bf_content"));
					vo.setBf_timestamp(rs.getDate("bf_timestamp"));
					vo.setBf_view(rs.getInt("bf_view"));
					vo.setBf_category(rs.getInt("bf_category"));
					volist.add(vo);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	
	public ArrayList<Board> selectBoardListC(Connection conn, int category, int start, int end) {
		ArrayList<Board> volist = null;

		String sql = "select * from "
				+ " (select Rownum r, t1.* from "
				+ " (select * from board_free where bf_category=? order by bf_n desc) t1 ) t2 "
				+ " where r between ? and ? order by bf_n desc";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if (rs.next()) {
				do {
					Board vo = new Board();
					vo.setBf_n(rs.getInt("bf_n"));
					vo.setM_nick(rs.getString("m_nick"));
					vo.setBf_title(rs.getString("bf_title"));
					vo.setBf_content(rs.getString("bf_content"));
					vo.setBf_timestamp(rs.getDate("bf_timestamp"));
					vo.setBf_view(rs.getInt("bf_view"));
					vo.setBf_category(rs.getInt("bf_category"));
					volist.add(vo);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return volist;
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
	
	// 전체 조회수 TOP5
	public ArrayList<Board> selectBoardList(Connection conn) {
		ArrayList<Board> volist = null;

		String sql = "select * from "
				+ " (select rownum r, a1.* from (select * from BOARD_FREE where bf_category = 1 order by bf_view desc) a1) "
				+ " a2 where r between 1 and 5 order by bf_view desc";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if (rset.next()) {
				do {
					Board vo = new Board();
					vo.setBf_n(rset.getInt("bf_n"));
					vo.setM_nick(rset.getString("m_nick"));
					vo.setBf_title(rset.getString("bf_title"));
					vo.setBf_content(rset.getString("bf_content"));
					vo.setBf_timestamp(rset.getDate("bf_timestamp"));
					vo.setBf_view(rset.getInt("bf_view"));
					vo.setBf_category(rset.getInt("bf_category"));
					volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

		public ArrayList<Board> selectBoardList2(Connection conn) {
			ArrayList<Board> volist = null;

			String sql = "select * from "
					+ " (select rownum r, t1.* from (select * from BOARD_FREE where bf_category = 2 order by bf_view desc) t1) "
					+ " t2 where r between 1 and 5 order by bf_view desc";

			PreparedStatement pstmt = null;
			ResultSet rset = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				volist = new ArrayList<Board>();
				if (rset.next()) {
					do {
						Board vo = new Board();
						vo.setBf_n(rset.getInt("bf_n"));
						vo.setM_nick(rset.getString("m_nick"));
						vo.setBf_title(rset.getString("bf_title"));
						vo.setBf_content(rset.getString("bf_content"));
						vo.setBf_timestamp(rset.getDate("bf_timestamp"));
						vo.setBf_view(rset.getInt("bf_view"));
						vo.setBf_category(rset.getInt("bf_category"));
						volist.add(vo);
					} while (rset.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return volist;
		}
		
		public ArrayList<Board> selectBoardList3(Connection conn) {
			ArrayList<Board> volist = null;

			String sql = "select * from "
					+ " (select rownum r, t1.* from (select * from BOARD_FREE where bf_category = 3 order by bf_view desc) t1) "
					+ " t2 where r between 1 and 5 order by bf_view desc";

			PreparedStatement pstmt = null;
			ResultSet rset = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				volist = new ArrayList<Board>();
				if (rset.next()) {
					do {
						Board vo = new Board();
						vo.setBf_n(rset.getInt("bf_n"));
						vo.setM_nick(rset.getString("m_nick"));
						vo.setBf_title(rset.getString("bf_title"));
						vo.setBf_content(rset.getString("bf_content"));
						vo.setBf_timestamp(rset.getDate("bf_timestamp"));
						vo.setBf_view(rset.getInt("bf_view"));
						vo.setBf_category(rset.getInt("bf_category"));
						volist.add(vo);
					} while (rset.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return volist;
		}
		
		public ArrayList<Board> selectBoardList4(Connection conn) {
			ArrayList<Board> volist = null;

			String sql = "select * from "
					+ " (select rownum r, t1.* from (select * from BOARD_FREE where bf_category = 4 order by bf_view desc) t1) "
					+ " t2 where r between 1 and 5 order by bf_view desc";

			PreparedStatement pstmt = null;
			ResultSet rset = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				volist = new ArrayList<Board>();
				if (rset.next()) {
					do {
						Board vo = new Board();
						vo.setBf_n(rset.getInt("bf_n"));
						vo.setM_nick(rset.getString("m_nick"));
						vo.setBf_title(rset.getString("bf_title"));
						vo.setBf_content(rset.getString("bf_content"));
						vo.setBf_timestamp(rset.getDate("bf_timestamp"));
						vo.setBf_view(rset.getInt("bf_view"));
						vo.setBf_category(rset.getInt("bf_category"));
						volist.add(vo);
					} while (rset.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return volist;
		}
		
		public ArrayList<Board> selectBoardList5(Connection conn) {
			ArrayList<Board> volist = null;

			String sql = "select * from "
					+ " (select rownum r, t1.* from (select * from BOARD_FREE where bf_category = 5 order by bf_view desc) t1) "
					+ " t2 where r between 1 and 5 order by bf_view desc";

			PreparedStatement pstmt = null;
			ResultSet rset = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				volist = new ArrayList<Board>();
				if (rset.next()) {
					do {
						Board vo = new Board();
						vo.setBf_n(rset.getInt("bf_n"));
						vo.setM_nick(rset.getString("m_nick"));
						vo.setBf_title(rset.getString("bf_title"));
						vo.setBf_content(rset.getString("bf_content"));
						vo.setBf_timestamp(rset.getDate("bf_timestamp"));
						vo.setBf_view(rset.getInt("bf_view"));
						vo.setBf_category(rset.getInt("bf_category"));
						volist.add(vo);
					} while (rset.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return volist;
		}
		
		public ArrayList<Board> selectBoardList6(Connection conn) {
			ArrayList<Board> volist = null;

			String sql = "select * from "
					+ " (select rownum r, t1.* from (select * from BOARD_FREE where bf_category = 6 order by bf_view desc) t1) "
					+ " t2 where r between 1 and 5 order by bf_view desc";

			PreparedStatement pstmt = null;
			ResultSet rset = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				volist = new ArrayList<Board>();
				if (rset.next()) {
					do {
						Board vo = new Board();
						vo.setBf_n(rset.getInt("bf_n"));
						vo.setM_nick(rset.getString("m_nick"));
						vo.setBf_title(rset.getString("bf_title"));
						vo.setBf_content(rset.getString("bf_content"));
						vo.setBf_timestamp(rset.getDate("bf_timestamp"));
						vo.setBf_view(rset.getInt("bf_view"));
						vo.setBf_category(rset.getInt("bf_category"));
						volist.add(vo);
					} while (rset.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return volist;
		}

	public int insertBoard(Connection conn, Board vo) {
		int result = -1;
		int nextVal = 0;
		int bnv = 0;
		String sql = "INSERT INTO" + " BOARD_FREE" + " (BF_N, M_NICK, BF_TITLE, BF_CONTENT, BF_TIMESTAMP, BF_VIEW, BF_CATEGORY)"
				+ " VALUES (?, ?, ?, ?, sysdate, ?, ?)";

		String sqlSeqNextVal = "SELECT SEQ_FREE.NEXTVAL FROM DUAL";

		

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
			pstmt.setString(2, vo.getM_nick());
			pstmt.setString(3, vo.getBf_title());
			pstmt.setString(4, vo.getBf_content());
			pstmt.setInt(5, bnv);
			pstmt.setInt(6, vo.getBf_category());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateBorad(Connection conn, String bf_title, String bf_content, int bf_category, int bf_n) {
		int result = -1;
		String sql = "UPDATE BOARD_FREE SET BF_TITLE=?, BF_CONTENT=?, BF_CATEGORY=? WHERE BF_N=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bf_title);
			pstmt.setString(2, bf_content);
			pstmt.setInt(3, bf_category);
			pstmt.setInt(4, bf_n);
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
	
	public int deleteBorad(Connection conn, int bf_n) {
		int result = -1;
		String sql = "DELETE * FROM BOARD_FREE WHERE BF_N=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bf_n);
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
	
	public int countUpdate(Connection conn, int bf_view, int bf_n) {
		int result = -1;
		String sql = "UPDATE BOARD_FREE SET BF_VIEW = ? WHERE BF_N = ?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bf_view);
			pstmt.setInt(2, bf_n);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}