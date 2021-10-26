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

import tbh.articlesix.market.service.MarketService;
import tbh.articlesix.market.vo.Market;

@WebServlet("/marketModify")
public class ModifyMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyMarketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");
		int bmN = Integer.parseInt(no);
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		String nickName = (String) session.getAttribute("nickName");

		System.out.println(nickName);

		ArrayList<Market> mkList = new MarketService().DetailMarket(bmN);
		int viewCount = new MarketService().ViewCount(bmN);
		viewCount++;
		int view = new MarketService().ViewAddCount(viewCount, bmN);
		request.setAttribute("mkList", mkList);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/MarketDetailModify.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
