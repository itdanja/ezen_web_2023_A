package 과제.과제11.view;

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
			} // c end 
		} // w end 
	} // f end 
	// 2. 회원가입 화면
	public void signupView() {
		MemberController.getInstance().signupLogic();
	}
	// 3. 로그인 화면
	public void loginView() {
		MemberController.getInstance().loginLogic();
	}
	
}










