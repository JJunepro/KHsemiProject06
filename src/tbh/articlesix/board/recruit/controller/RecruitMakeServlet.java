package tbh.articlesix.board.recruit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tbh.articlesix.board.recruit.model.dao.RecruitDao;
import tbh.articlesix.board.recruit.model.vo.Recruit;

/**
 * Servlet implementation class RecruitWriteServlet
 */
@WebServlet("/RecruitMake")
public class RecruitMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecruitMakeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response, Object m_id, Object recruitDao) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		Recruit recruit = new Recruit;
		
		PrintWriter out = response.getWriter();
				// 세션 상태를 체크
//				String userID = null;
//				if(session.getAttribute("userID") != null){
//					userID = (String)getsession().getAttribute("userID");
//				}
//				// 로그인을 한 사용자 모집방 생성
//				if(userID == null){
//					out.println("<script>");
//					out.println("alert('로그인을 하세요')");
//					out.println("location.href='login.jsp'");
//					out.println("</script>");
//				}else{
//					// 입력이 안 된 부분이 있는지 체크한다
//					if(recruitMake.getb_Title() == null || bbs.getBbsContent() == null){
//						out.println("<script>");
//						out.println("alert('입력이 안 된 사항이 있습니다')");
//						out.println("history.back()");
//						out.println("</script>");
//					}else{
//						// 정상적으로 입력이 되었다면 글쓰기 로직을 수행한다
//						BbsDAO bbsDAO = new BbsDAO();
//						int result = bbsDAO.write(bbs.getBbsTitle(), userID, bbs.getBbsContent());
//						// 데이터베이스 오류인 경우
//						if(result == -1){
//							out.println("<script>");
//							out.println("alert('글쓰기에 실패했습니다')");
//							out.println("history.back()");
//							out.println("</script>");
//						// 글쓰기가 정상적으로 실행되면 알림창을 띄우고 게시판 메인으로 이동한다
//						}else {
//							out.println("<script>");
//							out.println("alert('글쓰기 성공')");
//							out.println("location.href='MainPage.jsp'");
//							out.println("</script>");
//						}
//					}
//				}
			
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
