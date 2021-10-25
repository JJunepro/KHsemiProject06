package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.recruit.model.service.RecruitService;
import tbh.articlesix.board.recruit.model.vo.Recruit;

@WebServlet("/RecruitRoom")
public class RecruiRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecruiRoomServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response, Connection conn)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		int b_n = Integer.parseInt(no);
		
		Recruit rcdetail = new RecruitService().DetailRecruit(b_n);

		request.setAttribute("rcdetail", rcdetail);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/RecruitRoom.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
