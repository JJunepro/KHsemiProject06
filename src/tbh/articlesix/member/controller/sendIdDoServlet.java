package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.member.model.vo.Member;
import tbh.articlesix.member.service.MemberService;

/**
 * Servlet implementation class FindIdDoServlet
 */
@WebServlet("/sendId.do")
public class sendIdDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendIdDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
	
		String m_name = request.getParameter("m_name");
		String m_email = request.getParameter("m_email");
		
		
		
		
		
		
//		System.out.println("m_name: " + name);
//		System.out.println("m_email: " + email);
//		PrintWriter out = response.getWriter();
		
		
		
		
		
	}

}
