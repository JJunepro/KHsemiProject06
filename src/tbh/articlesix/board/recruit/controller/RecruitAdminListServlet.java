package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import tbh.articlesix.board.recruit.model.service.RecruitService;
/**
 * Servlet implementation class RecruitListServlet
 */
import tbh.articlesix.board.recruit.model.vo.Recruit;

@WebServlet({ "/recruitadminlist" })
public class RecruitAdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecruitAdminListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final int PAGE_SIZE = 10; // 한 페이지 당 글수
		final int PAGE_BLOCK = 5; // 한 화면에 나타날 페이지 링크 수
		int bCount = 0; // 총 글수
		int pageCount = 0; // 총 페이지수
		int startPage = 1; // 화면에 나타날 시작페이지
		int endPage = 1; // 화면에 나타날 마지막페이지
		int currentPage = 1;
		int startRnum = 1; // 화면에 글
		int endRnum = 1; // 화면에 글

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		String nickName = (String) session.getAttribute("nickName");

		String pageNum = request.getParameter("pagenum");
		if (pageNum != null) { // 눌려진 페이지가 있음.
			currentPage = Integer.parseInt(pageNum); // 눌려진 페이지
		}
		// 총 글수
		bCount = new RecruitService().TotalRecruitCount();
		// 총 페이지수 = (총글개수 / 페이지당글수) + (총글개수에서 페이지당글수로 나눈 나머지가 0이 아니라면 페이지개수를 1 증가)
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
		// rownum 조건 계산
		startRnum = (currentPage - 1) * PAGE_SIZE + 1; // 1//6//11/16//21
		endRnum = startRnum + PAGE_SIZE - 1;
		if (endRnum > bCount)
			endRnum = bCount;

		if (currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK - 1) * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK) * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK - 1;
		if (endPage > pageCount)
			endPage = pageCount;

		// DB에서 값 읽어오기
		ArrayList<Recruit> rclist = new RecruitService().RecruitList(startRnum, endRnum);

		// Data 전달을 위해서 request에 set
		request.setAttribute("rclist", rclist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currentPage", currentPage);

		request.setAttribute("memberId", memberId);
		request.setAttribute("nickName", nickName);

		// Page 이동하면서 Data도 전달함.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/RecruitAdminList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
