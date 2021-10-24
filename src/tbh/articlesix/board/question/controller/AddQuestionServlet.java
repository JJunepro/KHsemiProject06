package tbh.articlesix.board.question.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.question.service.QuestionService;
import tbh.articlesix.board.question.vo.Question;


@WebServlet("/questionwrite.do")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.getRequestDispatcher("/WEB-INF/QuestionWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String bq_title = request.getParameter("bq_title");
		String m_id = request.getParameter("m_id");
		String bq_content = request.getParameter("bq_content");
		
		out.println("입력된 title: "+ bq_title);
		out.println("<br>입력된 content: "+ bq_content);
		
//		String m_id = (String)request.getSession().getAttribute("memberLoginInfo");
		if (m_id == null) {
			m_id = "Manager";
		}
		
		Question no = new Question(bq_title, m_id, bq_content);
		
		int result = new QuestionService().insertQuestion(no);
		response.sendRedirect("questionlist");
	}

}
