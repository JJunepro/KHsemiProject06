package tbh.articlesix.board.notice.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.notice.dao.NoticeDao;

/**
 * Servlet implementation class NoticeListActionServlet
 */
@WebServlet("/NoticeListActionServlet")
public class NoticeListActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListActionServlet() {
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
		int spage = 1;
		String page = request.getParameter("page");
		
		if(page != null)
			spage = Integer.parseInt(page);
		
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt",opt);
		listOpt.put("condition", condition);
		listOpt.put("start", spage*10-9);
		
//		NoticeDao dao = NoticeDao.getInstance();
//		int listCount = dao.getNoticeListCount(listOpt);
//		ArrayList<Notice> list = dao.getNoticeList(listOpt);
//		
//		int maxPage = (int)(listCount/10.0 + 0.9);
//		int startPage = (int)(spage/5.0 + 0.8) * 5-4;
//		int endPage = startPage + 4;
//		if(endPage > maxPage)	endPage = maxPage;
//		
//		request.setAttribute("spage", spage);
//		request.setAttribute("maxPage", maxPage);
//		request.setAttribute("startPage", startPage);
//		request.setAttribute("endPage", endPage);
//		
//		request.setAttribute("list", list);
//		
//		forward.sendRedirect(false);
		
		
	}

}
