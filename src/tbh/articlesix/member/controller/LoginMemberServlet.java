package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

//import org.json.simple.JSONObject;

import tbh.articlesix.member.model.vo.Member;
import tbh.articlesix.member.service.MemberService;

@WebServlet("/login")
public class LoginMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginMemberServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/LoginMember.jsp").forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
