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

/**
 * Servlet implementation class ReplyQuestionServlet
 */
@WebServlet("/questionreply")
public class ReplyQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyQuestionServlet() {
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
		
		request.getRequestDispatcher("/WEB-INF/QuestionReply.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Question oVo = null;
		String viewBno = request.getParameter("no");
		
		System.out.println(viewBno);
		if(viewBno == null || viewBno.equals("")) {   // 기존 읽고 있던 글이 없다면 원본 새글쓰기로 인식
			oVo= new Question();
		} else {
			int bq_n = Integer.parseInt(viewBno);
			// 알아와야함. bref, bre_level, bre_step
			oVo = new QuestionService().getQuestion(bq_n);  
		}
		String bq_title = request.getParameter("bq_title");  //내용부분입력된값이지요
		String bq_content = request.getParameter("bq_content");  //뭐라해야할지모를제목
		String m_nick = (String)request.getSession().getAttribute("memberLoginInfo");
		if(m_nick == null) {
			m_nick = "test_manager";   // TODO: 임시 user 설정
		}

		Question vo = new Question(oVo.getBq_n(), bq_title, bq_content, m_nick, oVo.getBref(), oVo.getBreLevel(), oVo.getBreStep());		
		
		int result = new QuestionService().insertQuestion(vo);
//		if(result == 0) {
//			out.println("<br>게시글 되지 않았습니다. <br>작성된 글에 비속어가 포함되어 있습니다. <br>다시 작성해 주세요.");
//		} else {
//			out.println("<br>게시글 입력되었습니다.");
//		}
		
		response.sendRedirect("questionlist");
	}

}
