package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test02") // 해당 클래스의 URL 매핑[연결] 해주는 어노테이션
public class Test02 extends HttpServlet { 
// HttpServlet 클래스부터 상속 받으면 해당 웹 관련 기능 제공 [ 1.멀티 스레드 2.예외처리 3. HTTP get,post,put,delete 함수 제공 ]
	// * 자바서블릿 HTTP의 기반으로 만들어진 클래스 
	
	// HTTP : Hypertext Transfer Protocol : 문서 교환 규칙/약속/규약/방법
		// HTTP 메소드 :  get : 호출 / post : 저장 / put : 수정  / delete : 삭제 
		// HTTP Body : 주고받을 데이터 저장소 
			// 한글 지원X
	// 브라우저[크롬,엣지 등] 에서 주소 입력해서 웹사이트 접속하는 방식
		// 주소창 www.naver.com => get 방식 
	
	private static final long serialVersionUID = 1L;

    public Test02() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 콘솔 출력 
		System.out.println("Test02 Hello JS");
		// 2. 웹 출력 
		response.getWriter().print("Test02 Hello JS");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
