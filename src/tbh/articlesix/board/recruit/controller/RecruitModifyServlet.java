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
import javax.servlet.http.HttpSession;

import tbh.articlesix.board.recruit.model.service.RecruitService;
import tbh.articlesix.board.recruit.model.vo.Recruit;

/**
 * Servlet implementation class RecruitModifyServlet
 */
@WebServlet("/RecruitModify")
public class RecruitModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RecruitModifyServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		HttpSession session = request.getSession(false);
//		Recruit rc = (Recruit)session.getAttribute("rc");
//		RecruitService rcs = new RecruitService();
//		int b_n = Integer.parseInt(request.getParameter("b_n"));
//		String m_id = (String) request.getSession().getAttribute("memberLoginInfo");
//		if (id == null) {
//			id = "user01"; // TODO: 임시 user 설정
//		}
//		int ca_n = Integer.parseInt(request.getParameter("ca_n"));
//		char b_type = request.getParameter("b_type").charAt(0);
//		String b_title = request.getParameter("b_title");
//		String b_content = request.getParameter("b_content");
//		String b_start = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		String b_end = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		int b_total = Integer.parseInt(request.getParameter("b_total"));
//		int b_attend = Integer.parseInt(request.getParameter("b_attend"));
//		String b_place = request.getParameter("b_place");
//		int b_fee = Integer.parseInt(request.getParameter("b_fee"));
//		char b_match = request.getParameter("b_match").charAt(0);
//		char b_gender = request.getParameter("b_gender").charAt(0);
//		char b_age = request.getParameter("b_age").charAt(0);
//		char b_equip = request.getParameter("b_equip").charAt(0);
//		int b_minpeople = Integer.parseInt(request.getParameter("b_minpeople"));
//		String b_progress = request.getParameter("b_progress");
//		char b_shower = request.getParameter("b_shower").charAt(0);
//		char b_parking = request.getParameter("b_parking").charAt(0);
//		char b_rental = request.getParameter("b_rental").charAt(0);
//		char b_cloth = request.getParameter("b_cloth").charAt(0);
//		String b_facility = request.getParameter("b_facility");
//		String b_timestamp = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		int b_view = Integer.parseInt(request.getParameter("b_view"));
//		PrintWriter out = response.getWriter();
//		
//		if(rc !=null && rc.getM_id().equals(m_id)) {
//			rc.setM_pw();
//			member.setM_nick(nick);
//			member.setM_phone(phone);
//			member.setM_email(email);
//			member.setM_address(address);
//			member.setM_address_detail(addressDetail);
//			
//			if(mservice.updateMember(member) > 0) {
//				session.setAttribute("member", member);
//				response.sendRedirect("/WEB-INF/MainPage.jsp");
//			}else {
//				out.append("<script>alert('오료발생!')</script>");
//			}
//		}else {
//			RequestDispatcher view = request.getRequestDispatcher("?????.jsp");
//			request.setAttribute("???", "????????");
//			view.forward(request, response);
//		}
//		out.flush();
//		out.close();
//	}
	}

}
