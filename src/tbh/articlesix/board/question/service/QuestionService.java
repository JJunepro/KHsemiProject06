package tbh.articlesix.board.question.service;

import java.sql.Connection;
import java.util.ArrayList;

import tbh.articlesix.board.question.dao.QuestionDao;
import tbh.articlesix.board.question.vo.Question;
import tbh.articlesix.common.JDBCTemplate;

public class QuestionService {
	
	public ArrayList<Question> selectQuestionList(int start, int end) {
		ArrayList<Question> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new QuestionDao().selectQuestionList(conn, start, end);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int getQuestionCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new QuestionDao().getQuestionCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertQuestion(Question vo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		
		result = new QuestionDao().insertQuestion(conn, vo);
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Question getQuestion(int bq_n) {
		Question no = null;
		Connection conn = JDBCTemplate.getConnection();
		no = new QuestionDao().getQuestion(conn, bq_n);
		JDBCTemplate.close(conn);
		return no;
	}
	
	public int updateQuestion(String bq_title, String bq_content, int bq_n) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		
		result = new QuestionDao().updateQuestion(conn, bq_title, bq_content, bq_n);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteQuestion(int bq_n) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		QuestionDao bDAO = new QuestionDao();
		
		result = bDAO.deleteQuestion(conn, bq_n);
		
//		if(result > 0) {
//		} else {
//
//		}
		JDBCTemplate.close(conn);
		return result;
	}
}
