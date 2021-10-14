package tbh.articlesix.board.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.notice.service.NoticeService;
import tbh.articlesix.board.notice.vo.Notice;

/**
 * Servlet implementation class AddNoticeServlet
 */
@WebServlet("/noticewrite.do")
public class AddNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.getRequestDispatcher("/WEB-INF/noticewrite.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String bn_title = request.getParameter("bn_title");
		String m_id = request.getParameter("m_id");
		String bn_content = request.getParameter("bn_content");
		
		out.println("입력된 title: "+ bn_title);
		out.println("<br>입력된 content: "+ bn_content);
		
//		String m_id = (String)request.getSession().getAttribute("memberLoginInfo");
		if (m_id == null) {
			m_id = "Manager";
		}
		
		Notice no = new Notice(bn_title, m_id, bn_content);
		
		int result = new NoticeService().insertNotice(no);
		response.sendRedirect("noticelist");
		
	
	}
}