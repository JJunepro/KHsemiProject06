package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.recruit.model.service.RecruitChatService;
import tbh.articlesix.board.recruit.model.service.RecruitService;
import tbh.articlesix.board.recruit.model.vo.RecruitChat;


@WebServlet("/RecruitChatInsert")
public class RecruitChatInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public RecruitChatInsertServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		int b_n = new RecruitService().recruitCountList();
		// TODO 로그인 세션 가져오기

		String m_id = (String) request.getSession().getAttribute("memberLoginInfo");
//		if(writer == null) {
//			writer = "user01";   // TODO: 임시 user 설정
//		}
		int ca_n = Integer.parseInt(request.getParameter("ca_n"));
		char b_type = request.getParameter("b_type").charAt(0);
		String chat_message = request.getParameter("chat_message");
		
		RecruitChat ch = new RecruitChat(b_n, m_id, chat_message);

		int result = new RecruitChatService().recruitChatInsert(ch);

		if (result == 0) {
			out.println("<br>내용이 입력되지 않았습니다.<br>다시 작성해 주세요.");
		} else {
			out.println("<br>모집방이 생성되었습니다.");
		}
		response.sendRedirect("/WEB-INF/RecruitMake.jsp");
	}

}
