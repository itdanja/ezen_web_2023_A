package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

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
	
	// 6. info		: 로그인된 회원정보 페이지 
	public void info() {
		System.out.println("\n\n ===== info ===== ");
		// 1. 컨트롤에게 회원정보 요청해서 1명의 회원정보[DTO] 반환 받기 
		MemberDto result = MemberController.getInstance().info();
		// 2. 반환받은 회원정보객체[memberDto] 의 각 필드를 출력 
		// System.out.println(">ID : " + result.id ); // DTO 필드의 직접접근 불가능 
		System.out.println(">ID : " + result.getMid() ); // getter or setter
		System.out.println(">NAME : " + result.getMname() );
		System.out.println(">PHONE : " + result.getMphone() );
		// 2. 서브메뉴 
		System.out.print("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 선택 : ");
		int ch = sc.nextInt();
		if( ch == 1 ) { infoUpdate(); }
		if( ch == 2 ) { infoDelete(); }
		if( ch == 3 ) { return; } // 생략가능 
	}
	
	// 7. infoUpdate : 비밀번호수정 페이지 
	public void infoUpdate() {
		System.out.println("\n\n ===== password Update ===== ");
		System.out.print("새로운 비밀번호 : ");	
		String newPw = sc.next();
		
		boolean result 
			= MemberController.getInstance().infoUpdate(newPw);
		if( result ) { 
			System.out.println("안내]비밀번호수정완료 : 로그아웃됩니다."); 
			MemberController.getInstance().logOut();
		}
		else { System.out.println("경고]비밀번호수정실패 : 관리자에게문의");}
	} // f end 
	
	// 8. infoDelete : 회원탈퇴 페이지 
	public void infoDelete() {
		System.out.println("\n\n ===== member delete ===== ");
		System.out.print("정말 탈퇴하시겠습니까?? 1.예 2.아니요 : "); 
		int ch = sc.nextInt();
		if( ch == 1 ) { 
			boolean result 
				= MemberController.getInstance().infoDelete(); 
			if( result ) { 
				System.out.println("안내]회원탈퇴성공 : 로그아웃됩니다.");
				MemberController.getInstance().logOut();
			}else {
				System.out.println("경고]회원탈퇴실패 : 관리자에게문의");
			}
		}
	} // f end 
	
	// 9. boardWrite : 게시물쓰기 페이지 
	public void boardWrite() {
		
	}
	// 10. boardPrint : 모든 게시물 출력 
	public void boardPrint() {}
	// 11. boardView : 개별 게시물 출력 
	public void boardView() {}
	// 12. boardUpdate : 게시물 수정 
	public void boardUpdate() {}
	// 13. boardDelete : 게시물 삭제
	public void boardDelete() {}
	
}


























