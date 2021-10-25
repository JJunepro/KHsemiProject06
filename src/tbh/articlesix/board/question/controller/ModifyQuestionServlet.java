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


@WebServlet("/questionmodify")
public class ModifyQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		
		int bq_n = Integer.parseInt(no);
		Question bqn = new QuestionService().getQuestion(bq_n);
		
		request.setAttribute("questionno", bqn);
		request.getRequestDispatcher("/WEB-INF/QuestionModify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String no = request.getParameter("no");
		int bq_n = Integer.parseInt(no);
		
		String bq_title = request.getParameter("bq_title");
		String m_id = request.getParameter("m_id");
		String bq_content = request.getParameter("bq_content");
		
		out.println("입력된 title: "+ bq_title);
		out.println("<br>입력된 content: "+ bq_content);
		
//		String m_id = (String)request.getSession().getAttribute("memberLoginInfo");
		if (m_id == null) {
			m_id = "Manager";
		}
		
		Question bqn = new Question(bq_title, bq_content, bq_n);
		
		int result = new QuestionService().updateQuestion(bq_title, bq_content, bq_n);
		
		if(result > 0) {
			request.setAttribute("questionno", bqn);
//			request.getRequestDispatcher("WEB-INF/BranchModiPage.jsp").forward(request, response);
			response.sendRedirect("questionlist");
		} else {
			System.out.println("오류입니다.");
//			request.setAttribute("msg", "수정되지 않았습니다");
//			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
