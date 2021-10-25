package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.recruit.model.service.RecruitService;
import tbh.articlesix.board.recruit.model.vo.Recruit;

@WebServlet("/RecruitMake")
public class RecruitMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecruitMakeServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.getRequestDispatcher("/WEB-INF/RecruitMake.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		
		// TODO 로그인 세션 가져오기 해야함

		String m_id = (String) request.getSession().getAttribute("memberLoginInfo");
//		if(writer == null) {
//			writer = "user01";   // TODO: 임시 user 설정
//		}
		int ca_n = Integer.parseInt(request.getParameter("ca_n"));
		char b_type = request.getParameter("b_type").charAt(0);
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String b_start = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String b_end = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int b_total = Integer.parseInt(request.getParameter("b_total"));
		int b_attend = Integer.parseInt(request.getParameter("b_attend"));
		String b_place = request.getParameter("b_place");
		int b_fee = Integer.parseInt(request.getParameter("b_fee"));
		char b_match = request.getParameter("b_match").charAt(0);
		char b_gender = request.getParameter("b_gender").charAt(0);
		char b_age = request.getParameter("b_age").charAt(0);
		char b_equip = request.getParameter("b_equip").charAt(0);
		int b_minpeople = Integer.parseInt(request.getParameter("b_minpeople"));
		String b_progress = request.getParameter("b_progress");
		char b_shower = request.getParameter("b_shower").charAt(0);
		char b_parking = request.getParameter("b_parking").charAt(0);
		char b_rental = request.getParameter("b_rental").charAt(0);
		char b_cloth = request.getParameter("b_cloth").charAt(0);
		String b_facility = request.getParameter("b_facility");
		String b_timestamp = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int b_view = 0;

		Recruit rc = new Recruit(m_id, ca_n, b_type, b_title, b_content, b_start, b_end, b_total, b_attend,
				b_place, b_fee, b_match, b_gender, b_age, b_equip, b_minpeople, b_progress, b_shower, b_parking,
				b_rental, b_cloth, b_facility, b_timestamp, b_view);

		int result = new RecruitService().recruitMake(rc);

		if (result == 0) {
			out.println("<br>내용이 입력되지 않았습니다.<br>다시 작성해 주세요.");
		} else {
			out.println("<br>모집방이 생성되었습니다.");
		}
		response.sendRedirect("rclist");
	}
}