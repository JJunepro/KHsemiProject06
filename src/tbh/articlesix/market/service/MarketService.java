package tbh.articlesix.market.service;

import java.sql.Connection;
import java.util.ArrayList;

import tbh.articlesix.common.JDBCTemplate;
import tbh.articlesix.market.dao.MarketDao;
import tbh.articlesix.market.vo.Market;
import tbh.articlesix.member.dao.MemberDao;

public class MarketService {

	public MarketService() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Market> ListMarket(int startRnum, int endRnum) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().ListMarket(conn, startRnum, endRnum);
		return mkList;
	}
	
	public ArrayList<Market> ListOne(int startRnum, int endRnum) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().ListOne(conn,startRnum,endRnum);
		return mkList;
	}
	
	public ArrayList<Market> DetailListOne(int bmN) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().DetailListOne(conn, bmN);
		return mkList;
	}
	
	public ArrayList<Market> ImgListMarket(Market mk) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().ImgListMarket(conn, mk);
		return mkList;
	}

	public ArrayList<Market> HotListMarket() {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().HotListMarket(conn);
		return mkList;
	}

	public ArrayList<Market> SearchMarket(String title,int startRnum, int endRnum) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().SearchMarket(title, conn,startRnum,endRnum);
		return mkList;
	}

	public ArrayList<Market> DetailMarket(int bmN) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().DetailMarket(conn, bmN);
		return mkList;
	}
	
	public ArrayList<Market> ChatMarket(int bmN) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().ChatMarket(conn, bmN);
		return mkList;
	}

	public int TotalCount() {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().CountList(conn);
		return result;
	}

	public int CountList() {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().CountList(conn);
		return result;
	}
	
	public int CountImg() {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().CountImg(conn);
		return result;
	}

	public int AddMarket(Market mk) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().AddMarket(mk, conn);
		return result;
	}

	public int UpdateMarket(Market mk) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().UpdateMarket(mk, conn);
		return result;
	}

	public int DeleteMarket(int bmN) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().DeleteMarket(bmN, conn);
		return result;
	}

	public int AddImg(Market mk, int i) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().AddImg(conn, mk, i);
		return result;
	}
	
	public int ViewCount(int bm_n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().ViewCount(conn,bm_n);
		return result;
	}
	public int ViewAddCount(int viewCount,int bm_n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().ViewAddCount(conn,viewCount,bm_n);
		return result;
	}
	
	public int AddChatMarket(Market mk) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().AddChatMarket(mk, conn);
		return result;
	}

}
