package tbh.articlesix.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import tbh.articlesix.market.service.MarketService;
import tbh.articlesix.market.vo.Market;

/**
 * Servlet implementation class marketDetailServlet
 */
@WebServlet("/marketDetail")
public class DetailMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailMarketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String no =request.getParameter("no");
		int bmN = Integer.parseInt(no);
		
		int startRnum=1;
		int endRnum=50;

		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		String nickName = (String)session.getAttribute("nickName");
		
		if(memberId==null) {
			memberId="null";
		}
		
		String title = request.getParameter("title"); // 파라미터 받아와야 함
		ArrayList<Market> mkList = new MarketService().DetailMarket(bmN);
		ArrayList<Market> searchList = new MarketService().SearchMarket(title,startRnum,endRnum);
		ArrayList<Market> detailListOne = new MarketService().DetailListOne(bmN);
		ArrayList<Market> chatMarket = new MarketService().ChatMarket(bmN);
		int viewCount = new MarketService().ViewCount(bmN);
		viewCount++;
		int view = new MarketService().ViewAddCount(viewCount, bmN);
		
		request.setAttribute("mkList", mkList);
		request.setAttribute("detailListOne", detailListOne);
		request.setAttribute("searchList", searchList);
		request.setAttribute("chatMarket", chatMarket);
		request.setAttribute("memberId", memberId);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/MarketDetail.jsp");
    	requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
