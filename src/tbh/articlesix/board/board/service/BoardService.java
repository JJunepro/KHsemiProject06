package tbh.articlesix.board.board.service;

import java.sql.Connection;
import java.util.ArrayList;

import tbh.articlesix.board.board.dao.BoardDao;
import tbh.articlesix.board.board.vo.Board;
import tbh.articlesix.common.JDBCTemplate;

public class BoardService {

	public BoardService() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Board> selectBoardList(){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList(conn);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Board> selectBoardList2(){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList2(conn);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Board> selectBoardList3(){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList3(conn);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Board> selectBoardList4(){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList4(conn);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Board> selectBoardList5(){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList5(conn);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Board> selectBoardList6(){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList6(conn);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Board> selectBoardList(int start, int end){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList(conn, start, end);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Board> selectBoardListC(int category, int start, int end){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardListC(conn, category, start, end);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int getBoardCount(){
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getBoardCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int getBoardCountC(int category){
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getBoardCountC(conn, category);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public String getDate() {
		String result = "";
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getDate(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertBoard(Board vo) {
		int result =-1;
		Connection conn = JDBCTemplate.getConnection();
		
		result = new BoardDao().insertBoard(conn, vo);
			
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Board getBoard(int bf_n) {
		Board vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new BoardDao().getBoard(conn, bf_n);
		JDBCTemplate.close(conn);
		return vo;
	}
	
	public int updateBoard(String bf_title, String bf_content, int bf_category, int bf_n) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		
		result = new BoardDao().updateBorad(conn, bf_title, bf_content, bf_category, bf_n);
		JDBCTemplate.close(conn);
		return result;
	}

}