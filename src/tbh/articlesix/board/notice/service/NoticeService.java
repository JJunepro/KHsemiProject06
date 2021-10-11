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
//	public ArrayList<Notice> selectNoticeList(int start, int end) {
//		ArrayList<Notice> nolist = null;
//		Connection con = JDBCTemplate.getConnection();
//		
//		nolist = new NoticeDao().selectNoticeList(con, start, end);
//		
//		JDBCTemplate.close(con);
//		return nolist;
//	}
	
	
	public int getNoticeCount() {
		int result = 0;
		Connection con = JDBCTemplate.getConnection();
		result = new NoticeDao().getNoticeCount(con);
		JDBCTemplate.close(con);
		return result;
	}
	
	public String getDate() {
		String result = "";
		Connection con = JDBCTemplate.getConnection();
		result = new NoticeDao().getDate(con);
		JDBCTemplate.close(con);
		return result;
	}
	
//	public int writeNotice(String m_id, String bn_title, String bn_content) {
//		int result = -1;
//		Connection con = JDBCTemplate.getConnection();
//		result = new NoticeDao().writeNotice(con, m_id, bn_title, bn_content);
//		return result;
//	}
	
	public int insertNotice(Notice no) {
		int result = -1;
		Connection con = JDBCTemplate.getConnection();
		
		result = new NoticeDao().insertNotice(con, no);
		
		JDBCTemplate.close(con);
		return result;
	}
	
	public Notice getNotice(int bn_n) {
		Notice no = null;
		Connection con = JDBCTemplate.getConnection();
		no = new NoticeDao().getNotice(con, bn_n);
		JDBCTemplate.close(con);
		return no;
	}

}
