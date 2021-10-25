package tbh.articlesix.market.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tbh.articlesix.market.service.MarketService;
import tbh.articlesix.market.vo.Market;

@WebServlet("/doMarketModify")
public class DoModifyMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoModifyMarketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String no = request.getParameter("no");
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		String nickName = (String)session.getAttribute("nickName");
		
		String title = request.getParameter("title");
		String img = request.getParameter("img");
		String content = request.getParameter("content");
		String price = request.getParameter("price");
		
		int priceInt = Integer.parseInt(price);
		int bmN = Integer.parseInt(no);
		
		Market mk = new Market(memberId,bmN, title, img, priceInt, content);
		int result = new MarketService().UpdateMarket(mk);
		
		response.sendRedirect("marketMain");
		
	}

}
