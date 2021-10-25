package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

@WebServlet("/delete.do")
public class DeleteMemberDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMemberDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
		String gobStr = "";
		PrintWriter out = response.getWriter();
		MemberService mService = new MemberService();
		HttpSession session = request.getSession(false);
		String m_deletedate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String m_id = (String) session.getAttribute("memberId");
		String m_pw = request.getParameter("m_pw");
		System.out.println(m_id);
		System.out.println(m_pw);
		Map<String, String> map2 = new HashMap<String, String>();
		try {
			int result = mService.deleteMember(m_id, m_pw, m_deletedate);
			System.out.println(result);
			if (result > 0) {
				map2.put("m_pw", m_pw);
				if (result == 1) {
					map2.put("result", "ok");
					gobStr = gObject.toJson(map2);
					System.out.println("탈퇴성공");
					session.invalidate();
					out.print(gobStr);
					out.flush();
					out.close();
				} else {
					System.out.println("탈퇴실패");
					map2.put("result", "fail");
					gobStr = gObject.toJson(map2);
				}
			}else {
				System.out.println("탈퇴실패");
				map2.put("result", "fail");
				gobStr = gObject.toJson(map2);
			}

		} catch (Exception e) {
			e.printStackTrace();
			map2.put("result", "error");
			gobStr = gObject.toJson(map2);
		}
		out.print(gobStr);
		out.flush();
		out.close();
	}

}
