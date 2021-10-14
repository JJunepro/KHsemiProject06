package tbh.articlesix.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.market.service.MarketService;
import tbh.articlesix.market.vo.Market;

/**
 * Servlet implementation class marketMainServlet
 */
@WebServlet("/marketMain")
public class MainMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainMarketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Market> mkList = new MarketService().ListMarket();
		ArrayList<Market> hotMkList = new MarketService().HotListMarket();
		
		
		request.setAttribute("mkList", mkList);
		request.setAttribute("hotMkList", hotMkList);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/MarketMain.jsp");
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
