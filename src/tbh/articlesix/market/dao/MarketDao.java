package tbh.articlesix.market.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import tbh.articlesix.common.JDBCTemplate;
import tbh.articlesix.market.vo.Market;

public class MarketDao {

	public MarketDao() {
	}

	public ArrayList<Market> ListMarket(Connection conn, int startRnum, int endRnum) {
		ArrayList<Market> mkList = null;
		String sql = "select * from (select Rownum r, t1.* from (select * from BOARD_MARKET order by bm_timestamp desc) t1) t2 join image t3 on t2.bm_n=t3.img_n\r\n"
				+ "where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
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
				mk.setImgScr(rs.getString("img_scr"));
				mk.setPrice(rs.getInt("bm_price"));
				mkList.add(mk);

			}
		} catch (Exception e) {
			System.out.println("error");
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return mkList;
	}

	public ArrayList<Market> ListOne(Connection conn, int startRnum, int endRnum) {
		ArrayList<Market> mkList = null;
		String sql ="select * from (select Rownum r, t1.* from (select * from BOARD_MARKET order by bm_timestamp desc) t1) t2 join image t3 on t2.bm_n=t3.img_p\r\n" + 
				"where t3.img_n in(select max(img_n) from image group by img_p) and r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
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
				mk.setImgScr(rs.getString("img_scr"));
				mk.setPrice(rs.getInt("bm_price"));
				mkList.add(mk);

			}
		} catch (Exception e) {
			System.out.println("error");
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return mkList;
	}

	public ArrayList<Market> ImgListMarket(Connection conn, Market mk) {
		ArrayList<Market> mkList = null;
		String sql = "select * from (select * from BOARD_MARKET t1 join image t2 on t1.bm_n=t2.img_n where t2.img_p=? order by t2.img_p desc)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			mkList = new ArrayList<Market>();
			while (rs.next()) {
				Market imgMk = new Market();
				imgMk.setBmN(rs.getInt("bm_n"));
				imgMk.setmId(rs.getString("m_id"));
				imgMk.setCaN(rs.getInt("ca_n"));
				imgMk.setImgN(rs.getInt("img_n"));
				imgMk.setcN(rs.getInt("c_n"));
				imgMk.setBmTitle(rs.getString("bm_title"));
				imgMk.setBmContent(rs.getString("bm_content"));
				imgMk.setBmTimeStamp(rs.getDate("bm_timestamp"));
				imgMk.setBmView(rs.getInt("bm_view"));
				imgMk.setImgScr(rs.getString("img_scr"));
				mk.setPrice(rs.getInt("bm_price"));
				mkList.add(imgMk);

			}
		} catch (Exception e) {
			System.out.println("error");
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return mkList;
	}

	public ArrayList<Market> DetailListOne(Connection conn, int bmN) {
		ArrayList<Market> mkList = null;
		String sql = "select * from (select * from BOARD_MARKET t1 join image t2 on t1.bm_n=t2.img_p  \r\n" + 
				"where t2.img_n in(select max(img_n) from image group by img_p) and t1.bm_n=?)";
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
				mk.setImgScr(rs.getString("img_scr"));
				mk.setPrice(rs.getInt("bm_price"));
				mkList.add(mk);
			}
		} catch (Exception e) {
			System.out.println("error");
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return mkList;
	}

	public ArrayList<Market> HotListMarket(Connection conn) {
		ArrayList<Market> mkList = null;
		String sql ="select * from BOARD_MARKET t1 join image t2 on t1.bm_n=t2.img_p\r\n" + 
				"where t2.img_n in(select max(img_n) from image group by img_p) order by bm_view desc";
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
				mk.setImgScr(rs.getString("img_scr"));
				mk.setPrice(rs.getInt("bm_price"));
				mkList.add(mk);

			}
		} catch (Exception e) {
			System.out.println("error");
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return mkList;
	}

	public ArrayList<Market> SearchMarket(String title, Connection conn, int startRnum, int endRnum) {
		ArrayList<Market> mkList = null;
		String sql = "select * from (select Rownum r, t1.* from (select * from BOARD_MARKET where bm_title=? order by bm_timestamp desc) t1) t2 join image t3 on t2.bm_n=t3.img_p\r\n" + 
				"where t3.img_n in(select max(img_n) from image group by img_p) and r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, startRnum);
			pstmt.setInt(3, endRnum);
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
				mk.setImgScr(rs.getString("img_scr"));
				mk.setPrice(rs.getInt("bm_price"));
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
		String sql = "select * from BOARD_MARKET t1 join image t2 on t1.bm_n=t2.img_p where t1.bm_n=?";
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
				mk.setImgScr(rs.getString("img_scr"));
				mk.setPrice(rs.getInt("bm_price"));
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
	
	public ArrayList<Market> ChatMarket(Connection conn, int bmN) {
		ArrayList<Market> mkList = null;
		String sql = "select * from market_comment where bm_n=?";
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
				mk.setcContent(rs.getString("c_content"));
				mk.setBref(rs.getInt("bref"));
				mk.setBreLevel(rs.getInt("bre_level"));
				mk.setBreStep(rs.getInt("bre_step"));
				mk.setcTimeStamp(rs.getDate("c_timestamp"));
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

	public int TotalCount(Connection conn) {
		int count = 0;
		;
		String sql = "select count(bm_n) from BOARD_MARKET";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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

	public int CountList(Connection conn) {
		int count = 0;
		;
		String sql = "select max(bm_n) from BOARD_MARKET";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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

	public int CountImg(Connection conn) {
		int count = 0;
		;
		String sql = "select max(img_n) from image";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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

	public int AddMarket(Market mk, Connection conn) {
		int result = -1;

		String sqlAdd = "insert into BOARD_MARKET(bm_n,m_id,ca_n,img_n,c_n,bm_title,bm_content,bm_timestamp,bm_view,bm_price) "
				+ "values(?,?,2,2,2,?,?,to_date(sysdate,'yyyy.mm.dd hh24:mi'),1,?)"; // 시퀀스 필요, 날짜, memberId받아와야하고 이미지 해결해야함

		PreparedStatement pstmt = null;
		try {
			Date date = new Date();
			pstmt = conn.prepareStatement(sqlAdd);
			pstmt.setInt(1, mk.getBmN());
			pstmt.setString(2, mk.getmId());
			pstmt.setString(3, mk.getBmTitle());
			pstmt.setString(4, mk.getcContent());
			pstmt.setInt(5, mk.getPrice());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}

	public int UpdateMarket(Market mk, Connection conn) {
		int result = -1;

		String sqlUpdate = "update BOARD_MARKET set bm_title=?,bm_content=? where bm_n=?"; // 시퀀스 필요

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

		if (result == 1) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}

	public int DeleteMarket(int bmN, Connection conn) {
		int result = -1;

		String sqlDelete = "delete from BOARD_MARKET where bm_n=?"; // 시퀀스 필요

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, bmN);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		if (result == 1) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}

	public int AddImg(Connection conn, Market mk, int i) {
		int result = -1;

		String sql = "insert into image(img_p,img_n,img_scr) values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mk.getBmN());
			pstmt.setInt(2, i);
			pstmt.setString(3, mk.getImgScr());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		if (result == 1) {
			JDBCTemplate.commit(conn);
		}

		return result;
	}

	
	public int ViewCount(Connection conn, int bm_n) {
		int count=0;
		String sql = "select bm_view from BOARD_MARKET where bm_n=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bm_n);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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
	
	public int ViewAddCount(Connection conn, int viewCount, int bm_n) {
		int result=-1;
		String sql = "update BOARD_MARKET set bm_view=? where bm_n=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viewCount);
			pstmt.setInt(2, bm_n);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int AddChatMarket(Market mk, Connection conn) {
		int result = -1;

		String sqlAdd = "insert into market_comment(bm_n,m_id,c_content,bref,bre_level,bre_step) values(?,?,?,?,1,?)";

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlAdd);
			pstmt.setInt(1, mk.getBmN());
			pstmt.setString(2, mk.getmId());
			pstmt.setString(3, mk.getcContent());
			pstmt.setInt(4, mk.getBref());
			pstmt.setInt(5, mk.getBreStep());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}
		return result;
	}
}
