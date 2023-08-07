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
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 선택 : ");
			try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if( ch == 1 ) { signupView(); }
				if( ch == 2 ) { loginView(); }
				if( ch == 3 ) { findIdView(); }
				if( ch == 4 ) { findPwView(); }
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
		// 2. 입력받은 값을 컨트롤에게 전달 하고 결과 받기 
		int result = 
				MemberController.getInstance().signupLogic(id, pw, name, phone);
		// 3. 결과에 출력 
		if( result == 1  ) { System.out.println("안내] 회원가입이 성공했습니다. 감사합니다.");}
		else if( result == 0 ) { System.out.println("경고] 회원가입시 실패. 관리자에게 문의");}
		else if( result == 3 ) { System.out.println("경고] 사용중인 아이디 입니다. ");}
		else if( result == 4 ) { System.out.println("경고] 사용중인 전화번호 입니다. ");}
	}
	// 3. 로그인 화면
	public void loginView() {
		System.out.println(" ----- 로그인 페이지 ----- ");
		System.out.print("아이디 > "); 		String id = sc.next();
		System.out.print("비밀번호 > "); 		String pw = sc.next();
		
		boolean result = 
				MemberController.getInstance().loginLogic(id, pw);
		if( result  ) { 
			System.out.println("안내] 로그인성공"); LoginPage.getInstance().loginMenu();
		}
		else { System.out.println("경고] 로그인실패");}
	}
	// 3. 아이디찾기 화면
	public void findIdView() {
		System.out.println(" ----- 아이디 찾기 페이지 ----- ");
		System.out.print("이름 > "); 		String name = sc.next();
		System.out.print("전화번호 > "); 		String phone = sc.next();
		
		String result = MemberController.getInstance().findIdLogic(name, phone);
		if( result != null ) { System.out.println("안내] 찾은 아이디 : " + result );}
		else { System.out.println("경고] 아이디 찾기 실패");}
	}
	// 3. 비밀번호찾기 화면
	public void findPwView() {
		System.out.println(" ----- 비밀번호 찾기 페이지 ----- ");
		System.out.print("아이디 > "); 		String id = sc.next();
		System.out.print("전화번호 > "); 		String phone = sc.next();
		
		String result = MemberController.getInstance().findPwLogic(id, phone);
		if( result != null ) { System.out.println("안내] 찾은 비밀번호 : " + result );}
		else { System.out.println("경고] 비밀번호 찾기 실패");}
	}
	
	
	
	
	
	
	
}
