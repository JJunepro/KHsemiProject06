package tbh.articlesix.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    //1 m_id : String
    //2 m_pw : String
    //3 m_auth : Char
    //4 m_name : String
    //5 m_nick : String
    //6 m_birth : Date
    //7 m_gender : Char
    //8 m_phone : String
    //9 m_email : String
    //10 m_address : String
    //11 m_address_detail : String
    //12 m_degree : int
    //12 m_createDate : Date
    //13 m_deleteDate : Date
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("join.do진입");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		String id = request.getParameter("m_id");
//		String pw = request.getParameter("m_pw");
//		char auth = request.getParameter("m_auth").charAt(0);
//		String name = request.getParameter("m_name");
//		String nick = request.getParameter("m_nick");
//		String birth = request.getParameter("m_birth");
//		char gender = request.getParameter("m_gender").charAt(0);
//		String phone = request.getParameter("m_phone");
//		String email = request.getParameter("m_email");
//		String address = request.getParameter("m_address");
//		String addressDetail = request.getParameter("m_adress_detail");
//		String degreeStr = request.getParameter("m_degree");
//		double degree = 36.5;
//		String createDate = request.getParameter("m_createDate");
//		String deleteDate = request.getParameter("m_deleteDate");
//		
		String id = "user11";
		String pw = "pass11";
		char auth = "U".charAt(0);
		String name = "사용자1";
		String nick = "닉";
		String birth = "2000/05/04";
		char gender = "M".charAt(0);
		String phone = "01011112222";
		String email = "user11@aaa.com";
		String address = "우편번호에 의한 주소지임";
		String addressDetail = "01-11";
		String degreeStr = "36.5";
		double degree = 36.5;
		String createDate = "2020/06/07";
		String deleteDate = "";
		
		try {
			degree = Double.parseDouble(degreeStr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//TODO 		
		new MemberService().createMember(null);
		
		//TODO 
		//Main 페이지/ 로그인 페이지
		response.sendRedirect("/");
	}

}
