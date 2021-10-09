package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tbh.articlesix.member.model.vo.Member;
import tbh.articlesix.member.service.MemberService;

/**
 * Servlet implementation class UpdateMemberDoServlet
 */
@WebServlet("/update.do")
public class UpdateMemberDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession(false);
		Member member = (Member)session.getAttribute("member");
		MemberService mservice = new MemberService();
		String id = request.getParameter("m_id");
		String pw = request.getParameter("m_pw");
		String nick = request.getParameter("m_nick");
		String phone = request.getParameter("m_phone");
		String email = request.getParameter("m_email");
		String address = request.getParameter("m_address");
		String addressDetail = request.getParameter("m_adress_detail");
		PrintWriter out = response.getWriter();
		
		if(member !=null && member.getM_id().equals(id)) {
			member.setM_pw(pw);
			member.setM_nick(nick);
			member.setM_phone(phone);
			member.setM_email(email);
			member.setM_address(address);
			member.setM_address_detail(addressDetail);
			
			if(mservice.updateMember(member) > 0) {
				session.setAttribute("member", member);
				response.sendRedirect("/WEB-INF/MainPage.jsp");
			}else {
				out.append("<script>alert('오료발생!')</script>");
			}
		}else {
			RequestDispatcher view = request.getRequestDispatcher("?????.jsp");
			request.setAttribute("???", "????????");
			view.forward(request, response);
		}
		out.flush();
		out.close();
	}
}
