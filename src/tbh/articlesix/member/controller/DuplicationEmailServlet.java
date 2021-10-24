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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tbh.articlesix.member.service.MemberService;

@WebServlet("/dupEmail")
public class DuplicationEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuplicationEmailServlet() {
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
		
		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
		PrintWriter out = response.getWriter();
		Map<String, Object> map2 = new HashMap<String, Object>();
		try {
			int result = mservice.duplicationEmail(request.getParameter("m_email"));
			if (result > 0) {
				map2.put("result", "fail");
				System.out.println("정보있음");
			} else {
				map2.put("result", "ok");
				System.out.println("정보없음");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map2.put("result", "error");
		}
		out.print(gObject.toJson(map2));
		out.flush();
		out.close();
	}

}
