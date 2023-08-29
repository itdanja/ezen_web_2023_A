package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmailService;


@WebServlet("/AuthSendEmailController")
public class AuthSendEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AuthSendEmailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 요청하기
		String memail = request.getParameter("memail"); 	System.out.println("memail : " + memail);
		
		// 2. 인증번호 생성 [ 난수 6자리 ]
		String auth = ""; // 인증번호를 저장할 문자열 
		for( int i = 0 ; i<6 ;i++ ) {
			Random random = new Random(); 		// 랜덤객체 
			// random.nextInt();				// 랜덤객체.nextInt() : int타입 범위내 난수생성 
			auth += random.nextInt(10);			// 0~9 random.nextInt( 끝수 ) : 0~끝수 범위내 난수생성 
		}; System.out.println("생성된 6자리 난수 : " + auth );
		
		// 3. 인증번호를 해당 이메일에게 전송
			// 메일전송서비스 객체 선언 
		EmailService emailService = new EmailService();
			// 객체를 통한 메일전송 함수 호출( 받는사람이메일 , 인증코드 );
		emailService.authsend( memail, auth);
		
		// 4. 인증번호 반환 
		response.getWriter().print( auth );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}
}









