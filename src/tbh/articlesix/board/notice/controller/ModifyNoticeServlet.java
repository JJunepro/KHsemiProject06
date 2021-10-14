package tbh.articlesix.board.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.notice.dao.NoticeDao;
import tbh.articlesix.board.notice.service.NoticeService;
import tbh.articlesix.board.notice.vo.Notice;

/**
 * Servlet implementation class ModifyNoticeServlet
 */
@WebServlet("/noticemodify")
public class ModifyNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyNoticeServlet() {
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
//		Notice no = new NoticeService().updateNotice(bn_title, bn_content, bn_n)
		
		String no = request.getParameter("no");
		
		int bn_n = Integer.parseInt(no);
		Notice bnn = new NoticeService().getNotice(bn_n);
		
		request.setAttribute("noticeno", bnn);
		request.getRequestDispatcher("/WEB-INF/noticemodify.jsp").forward(request, response);
		//TODO 진행중
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
