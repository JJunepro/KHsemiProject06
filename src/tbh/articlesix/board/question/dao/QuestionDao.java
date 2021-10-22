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
				+ " (select * from board_question order by bq_n desc) a1) a2 "
				+ " where r between ? and ? order by bq_n desc";

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
					vo.setM_id(rs.getString("m_id"));
					vo.setBq_title(rs.getString("bq_title"));
					vo.setBq_content(rs.getString("bq_content"));
					vo.setBq_timestamp(rs.getDate("bq_timestamp"));
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
	
	// 글 등록 (C)
	public int insertQuestion(Connection conn, Question vo) {
		int result = -1;
		int nextVal = 0;
		String sql = "INSERT INTO" + " BOARD_QUESTION" + " (BQ_N, M_ID, BQ_TITLE, BQ_CONTENT, BQ_TIMESTAMP)"
						+ " VALUES (?, ?, ?, ?, sysdate)";
		
		String sqlSeqNextVal = "SELECT SEQ_QUESTION.NEXTVAL FROM DUAL";
				
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
			pstmt.setString(2, vo.getM_id());
			pstmt.setString(3, vo.getBq_title());
			pstmt.setString(4, vo.getBq_content());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	// 게시글 보기 (R)
	public Question getQuestion(Connection conn, int bq_n) {
		Question vo = null;
		
		String sql = "SELECT * FROM BOARD_QUESTION WHERE BQ_N = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bq_n);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Question question = new Question();
				question.setBq_n(rs.getInt(1));
				question.setM_id(rs.getString("m_id"));
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
