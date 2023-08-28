package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

/**
 * Servlet implementation class Email
 */
@WebServlet("/EmailController")
public class EmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 받을 회원 이메일 요청 
		String memail = request.getParameter("memail");	System.out.println( "memail : "+ memail );
		// 2. 인증코드 만들기 
		String auth = "";
		
		for( int i = 0 ; i<6 ; i++ ) {	// 6자리 난수 생성 
			Random random = new Random(); // 랜덤 객체 
			auth += random.nextInt(10);	// 0~9 사이의 정수 생성 
		};System.out.println( "auth : " + auth );
		
		// 3. 인증코드를 받는사람의이메일 에게 보내기 
	 	boolean result = MemberService.sendEmail(memail, auth);
	 	if( result ) { // 메일 전송 성공시 인증코드 보내기
	 		response.getWriter().print( auth ); 
	 	}else { // 4. 메일 전송 실패시 false;
	 		response.getWriter().print( result );
	 	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	

}
