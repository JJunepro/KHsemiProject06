package tbh.articlesix.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import tbh.articlesix.common.JDBCTemplate;
import tbh.articlesix.market.vo.Market;

public class MarketDao {

	public MarketDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Market> ListMarket(Connection conn) {
		ArrayList<Market> mkList = null;
		String sql = "select * from BOARD_MARKET2";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			mkList = new ArrayList<Market>();
			while (rs.next()) {
				Market mk = new Market();
				mk.setBmN(rs.getInt("bm_n"));
				mk.setmId(rs.getString("m_id"));
				mk.setCaN(rs.getInt("ca_n"));
				mk.setImgN(rs.getInt("img_n"));
				mk.setcN(rs.getInt("c_n"));
				mk.setBmTitle(rs.getString("bm_title"));
				mk.setBmContent(rs.getString("bm_content"));
				mk.setBmTimeStamp(rs.getDate("bm_timestamp"));
				mk.setBmView(rs.getInt("bm_view"));
				mkList.add(mk);
				
			}
		}catch (Exception e) {
			System.out.println("error");
		}
		finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return mkList;
	}
	

	public ArrayList<Market> HotListMarket(Connection conn) {
		ArrayList<Market> mkList = null;
		String sql = "select * from BOARD_MARKET2 order by bm_view desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			mkList = new ArrayList<Market>();
			while (rs.next()) {
				Market mk = new Market();
				mk.setBmN(rs.getInt("bm_n"));
				mk.setmId(rs.getString("m_id"));
				mk.setCaN(rs.getInt("ca_n"));
				mk.setImgN(rs.getInt("img_n"));
				mk.setcN(rs.getInt("c_n"));
				mk.setBmTitle(rs.getString("bm_title"));
				mk.setBmContent(rs.getString("bm_content"));
				mk.setBmTimeStamp(rs.getDate("bm_timestamp"));
				mk.setBmView(rs.getInt("bm_view"));
				mkList.add(mk);
				
			}
		}catch (Exception e) {
			System.out.println("error");
		}
		finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return mkList;
	}

	public ArrayList<Market> SearchMarket(String title, Connection conn) {
		ArrayList<Market> mkList = null;
		String sql = "select * from BOARD_MARKET2 where bm_title=? order by bm_timestamp desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			mkList = new ArrayList<Market>();
			while (rs.next()) {
				Market mk = new Market();
				mk.setBmN(rs.getInt("bm_n"));
				mk.setmId(rs.getString("m_id"));
				mk.setCaN(rs.getInt("ca_n"));
				mk.setImgN(rs.getInt("img_n"));
				mk.setcN(rs.getInt("c_n"));
				mk.setBmTitle(rs.getString("bm_title"));
				mk.setBmContent(rs.getString("bm_content"));
				mk.setBmTimeStamp(rs.getDate("bm_timestamp"));
				mk.setBmView(rs.getInt("bm_view"));
				mkList.add(mk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}

		return mkList;
	}

	public ArrayList<Market> DetailMarket(Connection conn, int bmN) {
		ArrayList<Market> mkList = null;
		String sql = "select * from BOARD_MARKET2 where bm_n=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bmN);
			rs = pstmt.executeQuery();
			mkList = new ArrayList<Market>();
			while (rs.next()) {
				Market mk = new Market();
				mk.setBmN(rs.getInt("bm_n"));
				mk.setmId(rs.getString("m_id"));
				mk.setCaN(rs.getInt("ca_n"));
				mk.setImgN(rs.getInt("img_n"));
				mk.setcN(rs.getInt("c_n"));
				mk.setBmTitle(rs.getString("bm_title"));
				mk.setBmContent(rs.getString("bm_content"));
				mk.setBmTimeStamp(rs.getDate("bm_timestamp"));
				mk.setBmView(rs.getInt("bm_view"));
				mkList.add(mk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}

		return mkList;
	}
	
	public int CountList(Connection conn) {
		int count = 0;;
		String sql = "select count(bm_n) from BOARD_MARKET2";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return count;
	}

	public int AddMarket(Market mk, Connection conn, int countList) {
		int result = -1;
		
		String sqlAdd = "insert into BOARD_MARKET2(bm_n,m_id,ca_n,img_n,c_n,bm_title,bm_content,bm_timestamp,bm_view) "
				+ "values(?,'memberId',2,2,2,?,?,'2020-01-01',1)"; // 시퀀스 필요, 날짜, memberId받아와야하고 이미지 해결해야함

		PreparedStatement pstmt = null;
		try {
			Date date = new Date();
			pstmt = conn.prepareStatement(sqlAdd);
			pstmt.setInt(1, countList);
			pstmt.setString(2, mk.getBmTitle());
			pstmt.setString(3, mk.getcContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}

	public int UpdateMarket(Market mk, Connection conn) {
		int result = -1;

		String sqlUpdate = "update from BOARD_MARKET2(img_n,bm_title,bm_content) set(1,?,?) where bm_n=?"; // 시퀀스 필요

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, mk.getBmTitle());
			pstmt.setString(2, mk.getBmContent());
			pstmt.setInt(3, mk.getBmN());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		if(result ==1) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}

	public int DeleteMarket(Market mk, Connection conn) {
		int result = -1;

		String sqlDelete = "delete from BOARD_MARKET2 where bm_n=?"; // 시퀀스 필요

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, mk.getBmN());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		if(result ==1) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}
}
