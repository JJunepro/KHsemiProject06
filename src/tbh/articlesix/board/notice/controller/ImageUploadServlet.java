package tbh.articlesix.board.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/imageUpload")
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String fileSavePath = "./upload/notice";
		
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";

		if (ServletFileUpload.isMultipartContent(request))
			System.out.println("error");

		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);

		MultipartRequest multi = new MultipartRequest(request,
				uploadPath, 
				uploadSizeLimit,
				encType, 
				new DefaultFileRenamePolicy() 
		);

		String file = multi.getFilesystemName("upload");

		String img = fileSavePath +"/"+ file;
		if (file == null) {
			// 업로드 실패 시
			img = "썸네일 미등록";
			System.out.println("업로드 실패");
		} else {
			System.out.println("첨부파일명 : " + file);
			System.out.println("첨부파일명 : " + img);
			System.out.println("업로드 성공!!!");
		}
		
		PrintWriter out = response.getWriter();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("uploaded", 1);
		map1.put("fileName", file);
		map1.put("url", img);
		
		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(map1);
		out.print(result);
		out.flush();
		out.close();
		
		
	}

}
