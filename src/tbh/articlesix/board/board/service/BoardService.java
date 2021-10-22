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
	
	//Board oVo = new BoardService().getBoard(bno);  
	public Board getBoard(int bno) {
		Board vo = null;
		Connection conn = JDBCTemplate.getConnection();
		vo = new BoardDao().getBoard(conn, bno);
		JDBCTemplate.close(conn);
		return vo;
	}
	
	
	public int getBoardCount(){
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getBoardCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	
	
	public ArrayList<Board> selectBoardList(int start, int end){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList(conn, start, end);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Board> selectBoardList(){
		ArrayList<Board> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList(conn);
		
		JDBCTemplate.close(conn);
		return volist;
	}

	public int insertBoard(Board vo) {
		int result =-1;
		Connection conn = JDBCTemplate.getConnection();
		
		result = new BoardDao().insertBoard(conn, vo);
			
		JDBCTemplate.close(conn);
		return result;
	}

}