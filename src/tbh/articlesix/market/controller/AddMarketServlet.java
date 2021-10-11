package tbh.articlesix.market.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.market.service.MarketService;
import tbh.articlesix.market.vo.Market;

/**
 * Servlet implementation class marketAddServlet
 */
@WebServlet("/marketAdd")
public class AddMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMarketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		String img = request.getParameter("img");
		String content = request.getParameter("content");
		String price = request.getParameter("price");
		
		int priceInt = Integer.parseInt("5500");
		
		Market mk = new Market(title, img, priceInt, content);
		int result = new MarketService().AddMarket(mk);
		
		if(result == 0) {
			out.print("success");
		}else {
			out.print("fail");
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/MarketAdd.jsp");
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
