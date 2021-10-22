package tbh.articlesix.market.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import tbh.articlesix.market.service.MarketService;
import tbh.articlesix.market.vo.Market;

/**
 * Servlet implementation class DoAddMarketServlet
 */
@WebServlet("/doAddMarket")
public class DoAddMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoAddMarketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		String nickName = (String)session.getAttribute("nickName");
		
		int countList = new MarketService().CountList();
		countList++;
		int countImg = new MarketService().CountImg();

		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		String fileSavePath = "img";
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";

		
		try {
			ServletContext context = getServletContext();
			String uploadPath = context.getRealPath(fileSavePath);
			MultipartRequest multi = new MultipartRequest(request, // request 객체
					uploadPath, // 서버 상 업로드 될 디렉토리
					uploadSizeLimit, // 업로드 파일 크기 제한
					encType, // 인코딩 방법
					new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
			);
			
			Enumeration files = multi.getFileNames();
			while (files.hasMoreElements()) {
				countImg++;
				
				// 업로드 된 파일 이름 얻어오기
				String file = (String) files.nextElement();
				String fileName = multi.getFilesystemName(file);
				if(fileName == null) {
					continue;
				}else {
					String title = multi.getParameter("title");
					String imgPath = fileSavePath+"/"+fileName;
					String content = multi.getParameter("content");
					String price = multi.getParameter("price");
					
					int priceInt = Integer.parseInt(price);
					Market mk = new Market(memberId,countList, title, imgPath, priceInt, content);
					int result = new MarketService().AddMarket(mk);
					int imgResult = new MarketService().AddImg(mk,countImg);
					if (result == 0) {
						System.out.println("success");
					} else {
						System.out.println("fail");
					}}
				}
			} catch (Exception e) {
				e.printStackTrace();
				}
			

		response.sendRedirect("marketMain");
	
	}
}
