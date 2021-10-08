package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tbh.articlesix.board.recruit.model.service.RecruitService;

/**
 * Servlet implementation class RecruitListServlet
 */
@WebServlet("/RecruitListServlet")
public class RecruitListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		final int PAGE_SIZE = 5; // �� ������ �� �ۼ�
		final int PAGE_BLOCK = 3; // �� ȭ�鿡 ��Ÿ�� ������ ��ũ ��
		int bCount = 0; // �� �ۼ�
		int pageCount = 0; // �� ��������
		int startPage = 1; // ȭ�鿡 ��Ÿ�� ����������
		int endPage = 1; // ȭ�鿡 ��Ÿ�� ������������
		int currentPage = 1;
		int startRnum = 1; // ȭ�鿡 ��
		int endRnum = 1; // ȭ�鿡 ��
		
		String pageNum = request.getParameter("pagenum");
		if (pageNum != null) { // ������ �������� ����.
			currentPage = Integer.parseInt(pageNum); // ������ ������
		}
		// �� �ۼ�
		bCount = new RecruitService().getBoardCount();
		// �� �������� = (�ѱ۰��� / ��������ۼ�) + (�ѱ۰������� ��������ۼ��� ���� �������� 0�� �ƴ϶�� ������������ 1 ����)
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
		// rownum ���� ���
		startRnum = (currentPage - 1) * PAGE_SIZE + 1; // 1//6//11/16//21
		endRnum = startRnum + PAGE_SIZE - 1;
		if (endRnum > bCount)
			endRnum = bCount;

		if (currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK - 1) * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK) * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK - 1;
		if (endPage > pageCount)
			endPage = pageCount;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
