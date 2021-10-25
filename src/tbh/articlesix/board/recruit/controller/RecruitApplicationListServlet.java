package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.recruit.model.service.RecruitApplicationService;
import tbh.articlesix.board.recruit.model.service.RecruitService;
import tbh.articlesix.board.recruit.model.vo.Recruit;
import tbh.articlesix.board.recruit.model.vo.RecruitApplication;

/**
 * Servlet implementation class RecruitApplicationListServlet
 */
@WebServlet("/RecruitApplicationList")
public class RecruitApplicationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitApplicationListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
	// DB에서 값 읽어오기
		ArrayList<RecruitApplication> rclist = new RecruitApplicationService().RecruitApplicationList();
			
			// Data 전달을 위해서 request에 set
			request.setAttribute("rclist", rclist);
			// Page 이동하면서 Data도 전달함.
			request.getRequestDispatcher("/RecruitMainShort.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
