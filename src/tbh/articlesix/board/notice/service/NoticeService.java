package tbh.articlesix.board.notice.service;

import java.sql.Connection;
import java.util.ArrayList;

import tbh.articlesix.board.notice.dao.NoticeDao;
import tbh.articlesix.board.notice.vo.Notice;
import tbh.articlesix.common.JDBCTemplate;

public class NoticeService {
	
	//1. 공지사항 테이블 출력
	public ArrayList<Notice> selectNoticeList() {
		ArrayList<Notice> nolist = null;
		Connection con = JDBCTemplate.getConnection();
		
		nolist = new NoticeDao().selectNoticeList(con);
		
		JDBCTemplate.close(con);
		return nolist;
	}
	
	//2. 공지사항 화면에 보여줄 것들만 골라서 출력
	public ArrayList<Notice> selectNoticeList(int start, int end) {
		ArrayList<Notice> nolist = null;
		Connection con = JDBCTemplate.getConnection();
		
		nolist = new NoticeDao().selectNoticeList(con, start, end);
		
		JDBCTemplate.close(con);
		return nolist;
	}
	
}
