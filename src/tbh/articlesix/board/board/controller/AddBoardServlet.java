package tbh.articlesix.board.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.board.service.BoardService;
import tbh.articlesix.board.board.vo.Board;

/**
 * Servlet implementation class AddBoardServlet
 */
@WebServlet("/boardwrite.do")
public class AddBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("/WEB-INF/BoardWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String bf_title = request.getParameter("bf_title");
		String m_nick = request.getParameter("m_nick");
		String bf_content = request.getParameter("bf_content");
		String bf = request.getParameter("bf_category");
		int bf_category = Integer.parseInt(bf);
		System.out.println(bf_category);
		
		out.println("입력된 title: "+ bf_title);
		out.println("<br>입력된 content: "+ bf_content);
		
//		String m_id = (String)request.getSession().getAttribute("memberLoginInfo");
		if (m_nick == null) {
			m_nick = "Manager";
		}
		
		Board no = new Board(bf_title, m_nick, bf_content, bf_category);
		
		int result = new BoardService().insertBoard(no);
		response.sendRedirect("boardlist");
	}

}
