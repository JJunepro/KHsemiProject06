package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		response.setContentType("application/json;charset=UTF-8");
		
		MemberService mservice = new MemberService();
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		System.out.println("m_id: " + m_id);
		System.out.println("m_passwd: " + m_pw);
		PrintWriter out = response.getWriter();
		
		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
		String gobStr = "";
		
		List<Member> voList = new ArrayList<Member>();
		Member m = mservice.loginMember(m_id, m_pw);
		if(m != null) {
			System.out.println("로그인 성공");
			HttpSession seeSession = request.getSession();
			seeSession.setAttribute("member", m.getM_id());
			
			voList.add(m);
			voList.add(m);
			
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("result", "ok");
			map2.put("name", m.getM_name());
			map2.put("memberInfo", m);
			gobStr = gObject.toJson(map2);
			out.println(gobStr);
			
		}else {
			System.out.println("로그인 실패");
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("result", "fail");
			gobStr = gObject.toJson(map2);
			out.println(gobStr);
		}
		System.out.println("gobStr : " + gobStr);
		out.flush();
		out.close();
		
	}
		

}
