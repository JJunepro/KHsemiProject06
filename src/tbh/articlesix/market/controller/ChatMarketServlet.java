package tbh.articlesix.market.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tbh.articlesix.market.service.MarketService;
import tbh.articlesix.market.vo.Market;

/**
 * Servlet implementation class ChatMarketServlet
 */
@WebServlet("/chatMarket")
public class ChatMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatMarketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int bmN = Integer.parseInt( request.getParameter("bmN"));
		String memberId = request.getParameter("memberId");
		String cContent = request.getParameter("cContent");
		int bref = Integer.parseInt( request.getParameter("bref"));
		int breStep = Integer.parseInt( request.getParameter("breStep"));
		int breLevel = Integer.parseInt( request.getParameter("bre_level"));
		
		Market mk = new Market(bmN, cContent, memberId, bref, breStep, breLevel);
		System.out.println(bmN);
		System.out.println(memberId);
		System.out.println(cContent);
		System.out.println(bref);
		System.out.println(breStep);
		System.out.println(breLevel);
		new MarketService().AddChatMarket(mk);
	}

}
