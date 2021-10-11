package tbh.articlesix.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import tbh.articlesix.common.JDBCTemplate;
import tbh.articlesix.market.vo.Market;

public class MarketDao {

	public MarketDao() {
		// TODO Auto-generated constructor stub
	}
	
	public Market ListMarket(Market mk, Connection conn) {
		 mk = new Market();
		return mk;
	}
	
	public Market SearchMarket(Market mk, Connection conn) {
		 mk = new Market();
		return mk;
	}
	
	public Market DetailMarket(Market mk, Connection conn) {
		 mk = new Market();
		return mk;
	}
	
	public int AddMarket(Market mk, Connection conn) {
		int result = -1;
		String sqlAdd = "insert into board_market(bm_n,m_id,ca_n,img_n,c_n,bm_title,bm_content,bm_timestamp,bm_view) "
				+ "values(1,'memberId',1,1,1,?,?,1,1)";
		
		PreparedStatement pstmt = null;
		try {
			Date date = new Date();
			
			
			pstmt = conn.prepareStatement(sqlAdd);
			pstmt.setString(1, mk.getBmTitle());
			pstmt.setString(1, mk.getcContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int UpdateMarket(Market mk, Connection conn) {
		int result = -1;
		
		String sqlUpdate = "update from board_market(img_n,bm_title,bm_content) set(1,?,?) where bm_n=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, mk.getBmTitle());
			pstmt.setString(2, mk.getBmContent());
			pstmt.setInt(3, mk.getBmN());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int DeleteMarket(Market mk, Connection conn) {
		int result = -1;
		
		String sqlDelete = "delete from board_market where bm_n=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, mk.getBmN());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}
