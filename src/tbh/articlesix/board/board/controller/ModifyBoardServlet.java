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
import tbh.articlesix.board.notice.service.NoticeService;
import tbh.articlesix.board.notice.vo.Notice;

/**
 * Servlet implementation class ModifyBoardServlet
 */
@WebServlet("/boardmodify")
public class ModifyBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyBoardServlet() {
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
		
		int bf_n = Integer.parseInt(no);
		Board bno = new BoardService().getBoard(bf_n);
		
		request.setAttribute("boardvo", bno);
		request.getRequestDispatcher("/WEB-INF/BoardModify.jsp").forward(request, response);
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
		int bf_n = Integer.parseInt(no);
		String cano = request.getParameter("bf_category");
		int bf_category = Integer.parseInt(cano);
		
		
		String bf_title = request.getParameter("bf_title");
		String m_nick = request.getParameter("m_nick");
		String bf_content = request.getParameter("bf_content");
		
		out.println("입력된 title: "+ bf_title);
		out.println("<br>입력된 content: "+ bf_content);
		
//				String m_id = (String)request.getSession().getAttribute("memberLoginInfo");
		if (m_nick == null) {
			m_nick = "Manager";
		}
		
		Board bno = new Board(bf_title, bf_content, bf_n);
		int result = new BoardService().updateBoard(bf_title, bf_content, bf_category, bf_n);
		
		if(result > 0) {
			request.setAttribute("noticeno", bno);
//					request.getRequestDispatcher("WEB-INF/BranchModiPage.jsp").forward(request, response);
			response.sendRedirect("noticelist");
		} else {
			System.out.println("오류입니다.");
//					request.setAttribute("msg", "수정되지 않았습니다");
//					request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}
}


