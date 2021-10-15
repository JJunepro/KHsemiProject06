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

	public ArrayList<Market> HotListMarket() {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().HotListMarket(conn);
		return mkList;
	}

	public ArrayList<Market> SearchMarket(String title) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().SearchMarket(title, conn);
		return mkList;
	}

	public ArrayList<Market> DetailMarket(int bmN) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().DetailMarket(conn, bmN);
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

}
