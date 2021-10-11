package tbh.articlesix.board.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.notice.service.NoticeService;
import tbh.articlesix.board.notice.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet({"/noticelist", "/notice"})
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//  1. 공지사항 테이블 출력 ==> 완료 테이블 출력 잘됨
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		
//		ArrayList<Notice> nolist = new NoticeService().selectNoticeList();
//		if (nolist.size() > 0) {
//			for (Notice no : nolist) {
//				out.println("<p>"+no.toString()+"</p>");
//			}
//		}
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ArrayList<Notice> nolist = new NoticeService().selectNoticeList();
		
		request.setAttribute("noticenolist", nolist);
		
		request.getRequestDispatcher("/WEB-INF/noticelist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
