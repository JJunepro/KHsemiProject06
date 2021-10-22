package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		HttpSession session = request.getSession(false);
		String m_id = (String) session.getAttribute("memberId");
		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
		String gobStr = "";
		PrintWriter out = response.getWriter();
		MemberService mService = new MemberService();
		String pw = request.getParameter("m_pw");
		String nick = request.getParameter("m_nick");
		String phone = request.getParameter("m_phone");
		String email = request.getParameter("m_email");
		String address = request.getParameter("m_address");
		String addressDetail = request.getParameter("m_address_detail");
//		String m = mservice.updateMember(pw, nick, phone, email, address, addressDetail);

		Map<String, String> map2 = new HashMap<String, String>();
		try {
			int result = mService.updateMember(new Member(m_id, pw, nick, phone, email, address, addressDetail));
			if (result > 0) { // 성공
				map2.put("m_pw", pw);
				map2.put("m_nick", nick);
				map2.put("m_phone", phone);
				map2.put("m_email", email);
				map2.put("m_address", address);
				map2.put("m_address_detail", addressDetail);

				if (result == 1) {
					map2.put("result", "ok");
					gobStr = gObject.toJson(map2);
				} else {
					map2.put("result", "fail");
					gobStr = gObject.toJson(map2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map2.put("result", "error");
		}
		out.print(gObject.toJson(map2));
		out.flush();
		out.close();

//		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
//		PrintWriter out = response.getWriter();
//		
//		HttpSession session = request.getSession();
//		Member member = (Member)session.getAttribute("member");
//		MemberService mservice = new MemberService();
//		String id = request.getParameter("m_id");//request.getParameter("m_id");
//		String pw = request.getParameter("m_pw");
//		String nick = request.getParameter("m_nick");
//		String phone = request.getParameter("m_phone");
//		String email = request.getParameter("m_email");
//		String address = request.getParameter("m_address");
//		String addressDetail = request.getParameter("m_adress_detail");
//		
//		
//		Map<String, String> map2 = new HashMap<String, String>();
//		try {
//			if (member != null && member.getM_id().equals(id)) {
//				member.setM_pw(pw);
//				member.setM_nick(nick);
//				member.setM_phone(phone);
//				member.setM_email(email);
//				member.setM_address(address);
//				member.setM_address_detail(addressDetail);
//
//				
//				if (mservice.updateMember(member) > 0) {
//					map2.put("result", "ok");
//					session.setAttribute("member", member);
//					response.sendRedirect("main");
//				} else {
//					map2.put("result", "fail");
//					System.out.println("오류발발생생!");
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		out.print(gObject.toJson(map2));
//		out.flush();
//		out.close();
	}
}
