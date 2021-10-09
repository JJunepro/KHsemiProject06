package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import tbh.articlesix.member.model.vo.Member;
import tbh.articlesix.member.service.MemberService;

/**
 * Servlet implementation class LoginMemberDoServlet
 */
@WebServlet("/login.do")
public class LoginMemberDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMemberDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("login.do진입");
		MemberService mservice = new MemberService();
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		PrintWriter out = response.getWriter();
		
		//TODO: gson 쓰세요~
//		JSONObject job = new JSONObject();
		JsonObject job = new JsonObject();
		Member result = mservice.loginMember(m_id, m_pw);
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", result);
//			job.put("result", "ok");
//			job.put("name", result.getM_name());
			out.write("성공!");
//			
		}else {
//			job.put("result", "fail");
		}
//		out.println(job.toJSONString());
		out.flush();
		out.close();
		System.out.println("로그인실패!");
	}


}
