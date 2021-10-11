package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.recruit.model.service.RecruitService;
import tbh.articlesix.board.recruit.model.vo.Recruit;

/**
 * Servlet implementation class RecruitWriteServlet
 */
@WebServlet("/RecruitWriteServlet")
public class RecruitWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 화면입력 전달되어 옴. request - parameter (==변수명) : t, c
		String title = request.getParameter("b_title");
		String content = request.getParameter("b_content");
		String writer = (String) request.getSession().getAttribute("memberLoginInfo");
		if (writer == null) {
			writer = "user01"; // TODO: 임시 user 설정
		}
		out.println("입력된 title: " + title);
		out.println("<br>입력된 content: " + content);

		Recruit vo = new Recruit();

//		int result = new RecruitService().insertBoard(vo);
		if (result == 0) {
			out.println("<br>게시글 되지 않았습니다. <br>작성된 글에 비속어가 포함되어 있습니다. <br>다시 작성해 주세요.");
		} else {
			out.println("<br>게시글 입력되었습니다.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
