package tbh.articlesix.board.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.board.service.BoardService;
import tbh.articlesix.board.board.vo.Board;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet({"/boardlist", "/board"})
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ArrayList<Board> volist = new BoardService().selectBoardList();
		request.setAttribute("boardvolist", volist);
		
		ArrayList<Board> volist2 = new BoardService().selectBoardList2();
		request.setAttribute("boardvolist2", volist2);
		
		ArrayList<Board> volist3 = new BoardService().selectBoardList3();
		request.setAttribute("boardvolist3", volist3);
		
		ArrayList<Board> volist4 = new BoardService().selectBoardList4();
		request.setAttribute("boardvolist4", volist4);
		
		ArrayList<Board> volist5 = new BoardService().selectBoardList5();
		request.setAttribute("boardvolist5", volist5);
		
		ArrayList<Board> volist6 = new BoardService().selectBoardList6();
		request.setAttribute("boardvolist6", volist6);
		// Page 이동하면서 Data도 전달함.
		request.getRequestDispatcher("/WEB-INF/BoardList.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
