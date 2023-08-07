package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class LoginPage {
	
	private static LoginPage loginPage = new LoginPage();
	public static LoginPage getInstance() { return loginPage; }
	private LoginPage() {}
	// 0.입력객체 
	private Scanner sc = new Scanner(System.in);
	// 1. 메인메뉴 
	public void loginMenu() {
		while(true) {
			System.out.println("\n\n ===== ===== ===== ===== ");
			System.out.print("1.로그아웃 2.내정보 3.글쓰기 선택 : ");
			try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if( ch == 1 ) { MemberController.getInstance().logOut(); break; }
			}catch( Exception e ) {
				System.out.println("경고] 잘못된 입력입니다. ");
				sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기 
				// 왜? 초기화 안하면 입력된 값이 객체내 계속있기때문에 오류 계속 발생 // 객체내 입력값 지우기 => 객체 새로 만들기 
			} // c end
		} // w end 
	} // f end 
	
	
	

}
