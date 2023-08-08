package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class LoginPage {
	// 0.싱글톤 
	private static LoginPage loginPage = new LoginPage();
	public static LoginPage getInstance() { return loginPage; }
	private LoginPage() {}
	// 0.입력객체 
	private Scanner sc = new Scanner(System.in);
	
	// 1. loginMenu	: 로그인했을때 메뉴 페이지 
	public void loginMenu() {
		while( MemberController.getInstance().getLoginSession() != 0 ) { // 로그인이 되어 있는 경우에만 메뉴 반복 
			
			System.out.println("\n\n ===== ===== ===== ===== ");
			System.out.print("1.로그아웃 2.회원정보 3.글쓰기 선택 : ");
			try {
				int ch = sc.nextInt();
				if( ch == 1 ) { MemberController.getInstance().logOut(); }
				if( ch == 2 ) { info(); }
				if( ch == 3 ) { boardWrite(); }
			}catch( Exception e ) {
				System.out.println("경고] 잘못된 입력입니다. ");
				sc = new Scanner(System.in); 
			}  // c end 
		} // w end 
	}// f end 
	
	// 2. info		: 회원정보 페이지 
	public void info() {}
	// 3. infoUpdate : 회원정보수정 페이지 
	public void infoUpdate() {}
	// 4. infoDelete : 회원탈퇴 페이지 
	public void infoDelete() {}
	// 5. boardWrite : 게시물쓰기 페이지 
	public void boardWrite() {}
	// 6. boardPrint : 모든 게시물 출력 
	public void boardPrint() {}
	// 7. boardView : 개별 게시물 출력 
	public void boardView() {}
	// 8. boardUpdate : 게시물 수정 
	public void boardUpdate() {}
	// 9. boardDelete : 게시물 삭제
	public void boardDelete() {}
}





