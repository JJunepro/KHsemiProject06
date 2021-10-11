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
	
	public ArrayList<Market> ListMarket() {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().ListMarket(conn);
		return mkList;
	}
	
	public ArrayList<Market> SearchMarket(String title) {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().SearchMarket(title, conn);
		return mkList;
	}
	
	public ArrayList<Market> DetailMarket() {
		ArrayList<Market> mkList = null;
		Connection conn = JDBCTemplate.getConnection();
		mkList = new MarketDao().DetailMarket(conn);
		return mkList;
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
	
	public int DeleteMarket(Market mk) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().DeleteMarket(mk, conn);
		return result;
	}

}
