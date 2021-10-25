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

@WebServlet("/checkEmail")
public class checkEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkEmailServlet() {
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
		PrintWriter out = response.getWriter();
		String gobStr = "";
		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
		
		HttpSession saveKey = request.getSession();
		Object auth = saveKey.getAttribute("auth");
		
		if(auth == null) {
			System.out.println("인증코드 미입력");
			return;
		}
		try {
			String m_email = request.getParameter("m_email");
			String verCode = request.getParameter("verCode");
			System.out.println("m_email: " + m_email);
			System.out.println("verCode: " + verCode);
			
			Map<String, String> map2 = new HashMap<String, String>();
			if (verCode.equals(auth.toString())) {
				map2.put("result", "ok");
				//map2.put("msg", "인증성공");
				System.out.println("인증 성공");
				gobStr = gObject.toJson(map2);
				
			} else {
				map2.put("result", "fail");
				//map2.put("msg", "인증코드가 일치하지 않습니다.");
				System.out.println("인증코드 불일치");
				
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
