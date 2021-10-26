package tbh.articlesix.board.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tbh.articlesix.board.question.vo.Question;
import tbh.articlesix.common.JDBCTemplate;

public class QuestionDao {
	public QuestionDao() {
	}

	// QnA 테이블 출력
	public ArrayList<Question> selectQuestionList(Connection conn, int start, int end) {
		ArrayList<Question> volist = null;

		String sql = "select * from "
				+ " (select rownum r, a1.* from "
				+ " (select * from board_question order by bref desc, bre_step asc) a1) a2 "
				+ " where r between ? and ?";
		System.out.println(sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			volist = new ArrayList<Question>();
			if (rs.next()) {
				do {
					Question vo = new Question();
					vo.setBq_n(rs.getInt("bq_n"));
					vo.setM_nick(rs.getString("m_nick"));
					vo.setBq_title(rs.getString("bq_title"));
					vo.setBq_content(rs.getString("bq_content"));
					vo.setBq_timestamp(rs.getDate("bq_timestamp"));
					vo.setBref(rs.getInt("bref"));
					vo.setBreLevel(rs.getInt("bre_Level"));
					vo.setBreStep(rs.getInt("bre_Step"));
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
	
	public ArrayList<Question> getQuestionList (Connection conn, String item, int search, int start, int end) {
		ArrayList<Question> volist = new ArrayList<Question>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if (search == 0) {
			sql = "SELECT * FROM BOARD_QUESTION "
				+ " WHERE BQ_TITLE LIKE ? "
				+ " ORDER BY BQ_N DESC";
		} else if (search == 1) {
			sql = "SELECT * FROM BOARD_NOTICE "
					+ " WHERE BQ_CONTENT LIKE ? "
					+ " ORDER BY BQ_N DESC";
		} 
		
		System.out.println(sql);
		System.out.println(item);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' +item+ '%');
			rs = pstmt.executeQuery();
			volist = new ArrayList<Question>();
			if (rs.next()) {
				do {
					Question vo = new Question();
					vo.setBq_n(rs.getInt("bq_n"));
					vo.setM_nick(rs.getString("m_nick"));
					vo.setBq_title(rs.getString("bq_title"));
					vo.setBq_content(rs.getString("bq_content"));
					vo.setBq_timestamp(rs.getDate("bq_timestamp"));
					vo.setBref(rs.getInt("bref"));
					vo.setBreLevel(rs.getInt("bre_Level"));
					vo.setBreStep(rs.getInt("bre_Step"));
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
	
	// 글 번호 가져오기
	public int getQuestionCount(Connection conn) {
		int result = 0;
		String sql = "select count(bq_n) from BOARD_QUESTION";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int getQuestionCount(Connection conn, int search, String item) {
		int result = 0;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		if (search == 0) {
			sql = "SELECT COUNT(BQ_N) FROM BOARD_QUESTION "
				+ " WHERE BQ_TITLE LIKE ? "
				+ " ORDER BY BQ_N DESC";
		} else if (search == 1) {
			sql = "SELECT COUNT(BQ_N) FROM BOARD_QUESTION "
					+ " WHERE BQ_CONTENT LIKE ? "
					+ " ORDER BY BQ_N DESC";
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
	
	// 글 등록 (C)
	public int insertQuestion(Connection conn, Question vo) {
		int result = -1;
		int nextVal = 0;
		String sqlUpdate = "UPDATE BOARD_QUESTION set bre_step=bre_step+1  where bref=? and bre_step>?";
		String sql = "INSERT INTO" + " BOARD_QUESTION" + " (BQ_N, M_NICK, BQ_TITLE, BQ_CONTENT, BQ_TIMESTAMP, BREF, BRE_LEVEL, BRE_STEP)"
					+ " VALUES (?, ?, ?, ?, sysdate, ?, ?, ?)";
		
		String sqlSeqNextVal = "SELECT SEQ_QUESTION.NEXTVAL FROM DUAL";
		
		int bref = 0;
		int bre_level = 0;
		int bre_step = 1;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sqlSeqNextVal);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				nextVal = rs.getInt(1);
			}
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			if(vo.getBq_n() != 0) {
				bref = vo.getBref();
				bre_step = vo.getBreStep();
				pstmt = conn.prepareStatement(sqlUpdate); // UPDATE
				pstmt.setInt(1, bref);
				pstmt.setInt(2, bre_step);
				result = pstmt.executeUpdate();
				JDBCTemplate.close(pstmt);
				
				bre_level = vo.getBreLevel() + 1;
				bre_step++; 
			}
			
			pstmt = conn.prepareStatement(sql);
			if (vo.getBq_n() != 0) {
				pstmt.setInt(5, bref);
			} else {
				pstmt.setInt(5, nextVal);
			}
			pstmt.setInt(6, bre_level);
			pstmt.setInt(7, bre_step);
			pstmt.setInt(1, nextVal);
			pstmt.setString(2, vo.getM_nick());
			pstmt.setString(3, vo.getBq_title());
			pstmt.setString(4, vo.getBq_content());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		System.out.println(result);
		System.out.println(sql);
		return result;
	}
	
	// 게시글 보기 (R)
	public Question getQuestion(Connection conn, int bq_n) {
		Question vo = null;
		
		String sql = "SELECT BQ_N, BREF, BRE_LEVEL, BRE_STEP, "
				+ " M_NICK, BQ_TITLE, BQ_CONTENT, BQ_TIMESTAMP "
				+ " FROM BOARD_QUESTION WHERE BQ_N = ?";
		
//		String sql = "SELECT * FROM BOARD_QUESTION WHERE BQ_N =?";	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bq_n);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Question question = new Question();
				question.setBq_n(rs.getInt(1));
				question.setBref(rs.getInt(2));
				question.setBreLevel(rs.getInt(3));
				question.setBreStep(rs.getInt(4));
				question.setM_nick(rs.getString("m_nick"));
				question.setBq_title(rs.getString("bq_title"));
				question.setBq_content(rs.getString("bq_content"));
				question.setBq_timestamp(rs.getDate("bq_timestamp"));
				
				return question;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return null;
	}
	
	// 게시글 수정 (U)
	public int updateQuestion(Connection conn, String bq_title, String bq_content, int bq_n) {
		int result = -1;
		String sql = "UPDATE BOARD_QUESTION SET BQ_TITLE=?, BQ_CONTENT=? WHERE BQ_N=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bq_title);
			pstmt.setString(2, bq_content);
			pstmt.setInt(3, bq_n);
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
	
	// 게시글 삭제 (D)
	public int deleteQuestion(Connection conn, int bq_n) {
		int result = -1;
		String sql = "DELETE * FROM BOARD_QUESTION WHERE BQ_N=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bq_n);
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
}
