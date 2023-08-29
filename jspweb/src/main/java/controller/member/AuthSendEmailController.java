package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		
		// 3. 인증번호를 해당 이메일에게 전송 [ SMTP : 간이 우편 전송 프로토콜 ]
		
		
		// 4. 인증번호 반환 
		response.getWriter().print( auth );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}
}
/*

	- 자바에서 이메일 전송 보내기 
		1. 이메일을 전송할 도메인 필요 [ 네이버 , 다음 , 구글 등등 ]
			[ 강의 : 네이버 ( git : 패스워드 감추거나 private 저장소 ) , 2차 비밀번호 불가능 ]
			- 네이버 로그인 
				1. 메일 
				2. 메뉴 -> 환경설정 -> 메뉴 -> POP3/IMAP 설정 
					
					[ IMAP/SMTP ]
						- IMAP/SMTP 사용 : 사용함 
						[ 스마트폰 메일 애플리케이션 계정 설정 ] 확인 
							SMTP 서버명 : smtp.naver.com
							SMTP 포트 : 587, 보안 연결(TLS) 필요 (TLS가 없는 경우 SSL로 연결)
		
		2. SMTP 라이브러리 [ 이메일 전송에 관련된 클래스/라이브러리 제공 ]
			1. java-mail , java-activation 다운로드 -> build path add
		
		3. 메일 전송 함수 만들기 
		
 */



















