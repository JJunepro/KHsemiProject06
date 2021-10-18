package tbh.articlesix.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/sendEmail")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
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
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String gobStr = "";
		Gson gObject = new GsonBuilder().setPrettyPrinting().create();
		String m_email = request.getParameter("m_email");
		
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("result", "fail");
		map2.put("m_email", m_email);
		gobStr = gObject.toJson(map2);
		out.print(gobStr);
		//메일 서버
				String host = "smtp.naver.com";
				String user = "";
				String password = "";
				
				//메일받을 주소
				String to_email = m_email;
				
				//SMTP 서버 정보 설정
				Properties props = new Properties();
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.ssl.protocols", "TLSv1.2");
				
				//인증번호 생성기
				StringBuffer temp = new StringBuffer();
				Random rnd = new Random();
		        for(int i=0;i<6;i++)
		        {
		            int rIndex = rnd.nextInt(3);
		            switch (rIndex) {
		            case 0:
		                // a-z
		                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
		                break;
		            case 1:
		                // A-Z
		                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
		                break;
		            case 2:
		                // 0-9
		                temp.append((rnd.nextInt(10)));
		                break;
		            }
		        }
		        String authenticationKey = temp.toString();
		        System.out.println(authenticationKey);
		        
		        Session session = Session.getDefaultInstance(props, new Authenticator(){
		        	protected PasswordAuthentication getPasswordAuthentication() {
		        		return new PasswordAuthentication(user, password);
		        	}
		        });

		        try {
		        	MimeMessage msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress(user));
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
		            //메일 제목
		            msg.setSubject("안녕하세요 TBH 인증 메일입니다.","UTF-8");
		            //메일 내용
		            msg.setText("인증 번호는 : "+temp+"입니다.", "UTF-8");
		            
		            Transport.send(msg);
		            System.out.println("이메일 전송");
		            
		        }catch(AddressException e) {
		            e.printStackTrace();
		        }catch(MessagingException e) {
		        	e.printStackTrace();
		        }
		        HttpSession saveKey = request.getSession();
		        saveKey.setAttribute("auth", authenticationKey);
		        out.flush();
		        out.close();
	}

}
