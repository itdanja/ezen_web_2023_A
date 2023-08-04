package 과제.과제11.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class MainPage {
	// 0. 싱글톤 객체 
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() { return mainPage; }
	private MainPage() {}
	
	// 0.입력객체 
	private Scanner sc = new Scanner(System.in);
	// 1. 메인메뉴 
	public void mainView() {
		while(true) {
			System.out.println("\n\n ===== 회원제 커뮤니티 ===== ");
			System.out.print("1.회원가입 2.로그인 선택 : ");
			try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if( ch == 1 ) { signupView(); }
				if( ch == 2 ) { loginView(); }
			}catch( Exception e ) {
				System.out.println("경고] 잘못된 입력입니다. ");
				sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기 
				// 왜? 초기화 안하면 입력된 값이 객체내 계속있기때문에 오류 계속 발생 // 객체내 입력값 지우기 => 객체 새로 만들기 
			} // c end
		} // w end 
	} // f end 
	// 2. 회원가입 화면
	public void signupView() {
		// 1. 출력에 따른 입력값 받는다 .
		System.out.println(" ----- 회원가입 페이지 ----- ");
		System.out.print("아이디 > "); 		String id = sc.next();
		System.out.print("비밀번호 > "); 		String pw = sc.next();
		System.out.print("이름 > "); 			String name = sc.next();
		System.out.print("전화번호[-포함] > ");String phone = sc.next();
		// 2. 입력받은 값을 컨트롤에게 전달 
 		MemberController.getInstance()
 					.signupLogic(id, pw, name, phone);
	}
	// 3. 로그인 화면
	public void loginView() {
		System.out.println(" ----- 로그인 페이지 ----- ");
		System.out.print("아이디 > "); 		String id = sc.next();
		System.out.print("비밀번호 > "); 		String pw = sc.next();
		
		MemberController.getInstance().loginLogic(id, pw);
		
	}
	
}










