package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.recruit.model.dao.RecruitDao;
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
		int b_n = Integer.parseInt(request.getParameter("b_n"));
		int b_view = new RecruitService().viewCount(b_n);

		RecruitDao rdao = RecruitDao.getInstance();
		rdao.viewCount(conn, b_n);
		Recruit rc = new RecruitService().detailRecruit(b_n);
		rc.setB_view(rc.getB_view() + 1);

		request.setAttribute("rc", rc);
		request.getRequestDispatcher("/WEB-INF/RecruitRoom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
