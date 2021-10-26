package tbh.articlesix.board.notice.service;

import java.sql.Connection;
import java.util.ArrayList;

import tbh.articlesix.board.notice.dao.NoticeDao;
import tbh.articlesix.board.notice.vo.Notice;
import tbh.articlesix.common.JDBCTemplate;

public class NoticeService {
	
	public ArrayList<Notice> getNoticeList(String item, int start, int end, int search) {
		ArrayList<Notice> nolist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		nolist = new NoticeDao().getNoticeList(conn, item, search, start, end);
		
		JDBCTemplate.close(conn);
		return nolist;
	}
	
	//1. 공지사항 테이블 출력
	public ArrayList<Notice> selectNoticeList() {
		ArrayList<Notice> nolist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		nolist = new NoticeDao().selectNoticeList(conn);
		
		JDBCTemplate.close(conn);
		return nolist;
	}
	
	public ArrayList<Notice> selectNoticeList(int start, int end) {
		ArrayList<Notice> nolist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		nolist = new NoticeDao().selectNoticeList(conn, start, end);
		
		JDBCTemplate.close(conn);
		return nolist;
	}
	
	public int getNoticeCount() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new NoticeDao().getNoticeCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int getNoticeCount(int search, String item) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new NoticeDao().getNoticeCount(conn, search, item);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public String getDate() {
		String result = "";
		Connection conn = JDBCTemplate.getConnection();
		result = new NoticeDao().getDate(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertNotice(Notice no) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		
		result = new NoticeDao().insertNotice(conn, no);
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Notice getNotice(int bn_n) {
		Notice no = null;
		Connection conn = JDBCTemplate.getConnection();
		no = new NoticeDao().getNotice(conn, bn_n);
		JDBCTemplate.close(conn);
		return no;
	}
	
	public int updateNotice(String bn_title, String bn_content, int bn_n) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		
		result = new NoticeDao().updateNotice(conn, bn_title, bn_content, bn_n);
		JDBCTemplate.close(conn);
		return result;
	}
	
//	public int deleteNotice(int bId) {
//		int result = 0;
//		Connection conn = JDBCTemplate.getConnection();
//		NoticeDao bDAO = new NoticeDao();
//		
//		result = bDAO.deleteNotice(conn, bId);
//		
//		if(result > 0) {
//
//		} else {
//
//		}
//		JDBCTemplate.close(conn);
//		return result;
//	}
	
	//TODO
	public int deleteNotice(int bn_n) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao bDAO = new NoticeDao();
		
		result = bDAO.deleteNotice(conn, bn_n);
		
//		if(result > 0) {
//
//		} else {
//
//		}
		JDBCTemplate.close(conn);
		return result;
	}

}