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
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("nullpointer error");
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

	public ArrayList<Market> DetailMarket(Connection conn) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}

		return mkList;
	}

	public int AddMarket(Market mk, Connection conn) {
		int result = -1;
		String sqlAdd = "insert into BOARD_MARKET2(bm_n,m_id,ca_n,img_n,c_n,bm_title,bm_content,bm_timestamp,bm_view) "
				+ "values(1,'memberId',1,1,1,?,?,1,1)"; // 시퀀스 필요

		PreparedStatement pstmt = null;
		try {
			Date date = new Date();

			pstmt = conn.prepareStatement(sqlAdd);
			pstmt.setString(1, mk.getBmTitle());
			pstmt.setString(1, mk.getcContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
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

		return result;
	}
}
