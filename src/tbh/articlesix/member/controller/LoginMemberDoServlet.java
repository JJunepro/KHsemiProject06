package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
		response.setContentType("application/json;charset=UTF-8");
		
		MemberService mservice = new MemberService();
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		System.out.println("m_id: " + m_id);
		System.out.println("m_passwd: " + m_pw);
		PrintWriter out = response.getWriter();
		
		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
		String gobStr = "";
		
		Member m = mservice.loginMember(m_id, m_pw);
		if(m != null) {
		
			Map<String, Object> map2 = new HashMap<String, Object>();
			if(m.getM_deleteDate() != null){
				System.out.println(m.getM_deleteDate());
				System.out.println("탈퇴 회원");
				map2.put("result", "fail");
				map2.put("msg", "탈퇴된 회원입니다.");
				gobStr = gObject.toJson(map2);
				out.print(gobStr);
			} else {
				System.out.println("로그인 성공");
				HttpSession seeSession = request.getSession();
				seeSession.setAttribute("memberId", m.getM_id());
				seeSession.setAttribute("nickName", m.getM_nick());
				seeSession.setAttribute("mName", m.getM_name());
				seeSession.setAttribute("mAuth", m.getM_auth());
				seeSession.setAttribute("mBirth", m.getM_birth());
				seeSession.setAttribute("mGender", m.getM_gender());
				seeSession.setAttribute("mPhone", m.getM_phone());
				seeSession.setAttribute("mEmail", m.getM_email());
				seeSession.setAttribute("mAddress", m.getM_address());
				seeSession.setAttribute("mAddressDetail", m.getM_address_detail());
				seeSession.setAttribute("mDegree", m.getM_degree());
				
				
				map2.put("result", "ok");
				map2.put("name", m.getM_name());
				map2.put("memberInfo", m);
				map2.put("msg", "로그인에 성공했습니다.");
				gobStr = gObject.toJson(map2);
				out.print(gobStr);
			}
			
			
		}else {
			System.out.println("로그인 실패");
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("result", "fail");
			map2.put("msg", "회원정보가 맞지 않습니다.");
			gobStr = gObject.toJson(map2);
			out.print(gobStr);
		}
		System.out.println("gobStr : " + gobStr);
		out.flush();
		out.close();
		
	}
		

}
