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

import tbh.articlesix.member.service.MemberService;

@WebServlet("/showId")
public class ShowIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowIdServlet() {
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
		PrintWriter out = response.getWriter();
		String gobStr = "";
		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
		
		HttpSession saveKey = request.getSession();
		Object auth = saveKey.getAttribute("auth");
		if(auth == null) {
			out.append("이메일 인증이 필요합니다");
			return;
		}
		try {
			String m_name = request.getParameter("m_name");
			String m_email = request.getParameter("m_email");
			String verCode = request.getParameter("verCode");
			System.out.println("m_name: " + m_name);
			System.out.println("m_email: " + m_email);
			System.out.println("verCode: " + verCode);
			
			Map<String, String> map2 = new HashMap<String, String>();
		
			if (verCode.equals(auth.toString())) {
				String findId = mservice.findId(m_name, m_email);
				if (findId == null) {
					map2.put("result", "fail");
					map2.put("msg", "회원정보를 찾을 수 없습니다.");
					gobStr = gObject.toJson(map2);
				} else {
					map2.put("result", "ok");
					map2.put("m_id", findId);
					map2.put("msg", findId);
					System.out.println("찾은아이디 : " + findId);
					gobStr = gObject.toJson(map2);
					//
					HttpSession foundId = request.getSession();
			        foundId.setAttribute("id", findId);
			        //
				}
			} else {
				map2.put("result", "fail");
				map2.put("msg", "인증코드가 일치하지 않습니다.");
				
				gobStr = gObject.toJson(map2);
			}
		} catch(Exception e) {
			e.printStackTrace();
			Map<String, String> map2 = new HashMap<String, String>();

			map2.put("result", "fail");
			map2.put("msg", "서버오류");

			gobStr = gObject.toJson(map2);
		}
		
		out.print(gobStr);
		out.flush();
		out.close();
	}

}
