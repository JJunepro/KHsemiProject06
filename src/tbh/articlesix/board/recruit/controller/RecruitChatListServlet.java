package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tbh.articlesix.board.recruit.model.service.RecruitChatService;
import tbh.articlesix.board.recruit.model.vo.RecruitChat;

@WebServlet("/RecruitChatList")
public class RecruitChatListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecruitChatListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		String nickName = (String) session.getAttribute("nickName");

		ArrayList<RecruitChat> chlist = new RecruitChatService().RecruitChatList();

		request.setAttribute("chlist", chlist);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
