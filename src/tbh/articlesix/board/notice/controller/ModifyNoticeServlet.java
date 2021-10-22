package tbh.articlesix.board.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.notice.dao.NoticeDao;
import tbh.articlesix.board.notice.service.NoticeService;
import tbh.articlesix.board.notice.vo.Notice;

/**
 * Servlet implementation class ModifyNoticeServlet
 */
@WebServlet("/noticemodify")
public class ModifyNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		
		int bn_n = Integer.parseInt(no);
		Notice bnn = new NoticeService().getNotice(bn_n);
		
		request.setAttribute("noticeno", bnn);
		request.getRequestDispatcher("/WEB-INF/noticemodify.jsp").forward(request, response);
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
		
		String no = request.getParameter("no");
		int bn_n = Integer.parseInt(no);
		
		String bn_title = request.getParameter("bn_title");
		String m_id = request.getParameter("m_id");
		String bn_content = request.getParameter("bn_content");
		
		out.println("입력된 title: "+ bn_title);
		out.println("<br>입력된 content: "+ bn_content);
		
//				String m_id = (String)request.getSession().getAttribute("memberLoginInfo");
		if (m_id == null) {
			m_id = "Manager";
		}
		
		Notice bnn = new Notice(bn_title, bn_content, bn_n);
		
		int result = new NoticeService().updateNotice(bn_title, bn_content, bn_n);
		
		if(result > 0) {
			request.setAttribute("noticeno", bnn);
//					request.getRequestDispatcher("WEB-INF/BranchModiPage.jsp").forward(request, response);
			response.sendRedirect("noticelist");
		} else {
			System.out.println("오류입니다.");
//					request.setAttribute("msg", "수정되지 않았습니다");
//					request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
