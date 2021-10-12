package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.recruit.model.dao.RecruitDao;

/**
 * Servlet implementation class RecruitDeleteServlet
 */
@WebServlet("/RecruitDeleteServlet")
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
		  int num = Integer.parseInt(request.getParameter("num"));
	        String password = request.getParameter("password");
	        String pass = request.getParameter("pass");
	        
	        // TODO 데이터 삭제 후 리스트화면 넘어가는 기능
	        // 패스워드가 같을 경우에는 데이터를 삭제하고 리스트화면을 보여준다.
//	        if (password.equals(pass)) {
//	 
//	            RecruitDao recruitDao = new RecruitDao();
//	            recruitDao.delete(num);
//	 
//	            RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
//	            dis.forward(request, response);
//	 
//	        } else {
//	 
//	            request.setAttribute("msg", 2);
//	            RequestDispatcher dis = request.getRequestDispatcher("BoardListcon.do");
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
