package tbh.articlesix.market.service;

import java.sql.Connection;

import tbh.articlesix.common.JDBCTemplate;
import tbh.articlesix.market.dao.MarketDao;
import tbh.articlesix.market.vo.Market;

public class MarketService {

	public MarketService() {
		// TODO Auto-generated constructor stub
	}
	
	public Market ListMarket(Market mk) {
		Connection connection = JDBCTemplate.getConnection();
	
		return mk;
	}
	
	public Market SearchMarket(Market mk, String title) {
		
		return mk;
	}
	
	public Market DetailMarket() {
		Market mk = new Market();
		return mk;
	}
	
	public int AddMarket(Market mk) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MarketDao().AddMarket(mk, conn);
		return result;
	}
	
	public int UpdateMarket() {
		int result = -1;
		return result;
	}
	
	public int DeleteMarket() {
		int result = -1;
		return result;
	}

}
