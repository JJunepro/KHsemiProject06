package tbh.articlesix.board.recruit.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import tbh.articlesix.board.recruit.model.dao.RecruitChatDao;
import tbh.articlesix.board.recruit.model.vo.RecruitChat;
import tbh.articlesix.common.JDBCTemplate;

public class RecruitChatService {
	public RecruitChatService() {	
	}
	// 채팅 가져오기
	public RecruitChat getRecruitChat(int b_n) {
		RecruitChat ch = null;
		Connection conn = JDBCTemplate.getConnection();
		ch = new RecruitChatDao().getRecruitchat(conn, b_n);
		JDBCTemplate.close(conn);
		return ch;
	}
	public ArrayList<RecruitChat> RecruitChatList() {
		ArrayList<RecruitChat> chlist = null;
		Connection conn = JDBCTemplate.getConnection();
		chlist = new RecruitChatDao().RecruitChatList(conn);
		JDBCTemplate.close(conn);
		return chlist;
	}
	public int recruitChatInsert(RecruitChat ch) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitChatDao().recruitChatInsert(conn, ch);
		return result;
	}
	public int recruitChatDelete(int b_n) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new RecruitChatDao().recruitChatDelete(conn, b_n);
		return result;
	}
}
