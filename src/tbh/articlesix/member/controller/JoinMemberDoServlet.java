package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import javafx.scene.control.Alert;
import tbh.articlesix.member.model.vo.Member;
import tbh.articlesix.member.service.MemberService;

/**
 * Servlet implementation class JoinMemberDoServlet
 */
@WebServlet("/join.do")
public class JoinMemberDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinMemberDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("join.do진입");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		String id = request.getParameter("m_id");
		String pw = request.getParameter("m_pw");
		char auth = 'u'; // 기본유저값
		String name = request.getParameter("m_name");
		String nick = request.getParameter("m_nick");
		String birth = request.getParameter("m_birth");
		char gender = request.getParameter("m_gender").charAt(0);
		String phone = request.getParameter("m_phone");
		String email = request.getParameter("m_email");
		String address = request.getParameter("m_address");
		String addressDetail = request.getParameter("m_address_detail");
//		String degreeStr = request.getParameter("m_degree");
		double degree = 36.5;
		String createDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String deleteDate = "";
		
		Member member = new Member(id, pw, auth, name, nick, birth, gender, phone, email, address, addressDetail, degree, createDate, deleteDate);
		System.out.println(member.toString());
		
		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
		PrintWriter out = response.getWriter();
		
//		try {
//			degree = Double.parseDouble(degreeStr);
//			member.setM_degree(degree);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		try {
			int result = new MemberService().createMember(member);
			
			if (result == 1) {
				map2.put("result", "ok");
			} else {
				map2.put("result", "fail");
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
