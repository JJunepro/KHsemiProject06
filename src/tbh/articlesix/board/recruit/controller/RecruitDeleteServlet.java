package tbh.articlesix.board.recruit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tbh.articlesix.board.recruit.model.dao.RecruitDao;
import tbh.articlesix.board.recruit.model.service.RecruitService;
import tbh.articlesix.member.service.MemberService;

/**
 * Servlet implementation class RecruitDeleteServlet
 */
@WebServlet("/RecruitDelete")
public class RecruitDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecruitDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RecruitService rcs = new RecruitService();
//		int result = rcs.delete(request.getParameter("b_n"));
//		if(result > 0) {
//			HttpSession session = request.getSession(false);
//			session.invalidate();
//		}
		response.sendRedirect("/WEB-INF/RecruitAdminList.jsp");
	}

}
