package java1.day11.Ex5디자인패턴2.view;

import java.util.Arrays;
import java.util.Scanner;

import java1.day11.Ex5디자인패턴2.controller.MemberController;
import 과제.과제10.Member;
import 과제.과제10.MemberSys;

public class MainPage { // 입출력 담당하는 클래스 // view -> HTML/JS
	// 0. 싱글톤 생성
		// 1. 현재 클래스로 에 static 객체 생성 , 필드는 무조건 잠금 
	private static MainPage mainPage = new MainPage();
		// 2. 외부 객체에서 해당 싱글톤 호출하기 위한 메소드 
	public static MainPage getInstance() { return mainPage; }
		// 3. 객체 외부에서 해당 클래스로 객체 생성 잠금 , 생성자를 private 
	private MainPage() { }
	
	// 1. 필드
	private Scanner sc = new Scanner(System.in); 
	
	// 2. 생성자
	
	// 3. 함수 
	public void mainPage() {
		while(true) { // 무한루프
			System.out.println("\n\n--------- 회원 시스템 ---------");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾    선택> ");
			int ch = sc.nextInt();
			if( ch == 1 ) { singupPage(); }
			if( ch == 2 ) { loginPage(); }
			if( ch == 3 ) { findIdPage(); }
			if( ch == 4 ) { findPwPage(); }
		} // whine e 
	} // f end 
	
	void singupPage() {
		// 입/출력 
		System.out.println("--------- 회원가입 ---------");
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("비밀번호 : ");	String pw = sc.next();
		System.out.print("이름 : ");		String name = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();
		System.out.print("나이 :");		int age = sc.nextInt();
		// ---> 컨트롤러/서빙 에게 전달 // 컨트롤 클래스내 메소드 호출 
		boolean result=  MemberController.getInstance().singupLogic( id , pw , name , phone , age );
		if( result ) System.out.println("안내)회원가입성공");
		else System.out.println("안내)회원가입실패");
	}
	void loginPage() {}
	void findIdPage() {}
	void findPwPage() {}
	
	
	
	
	
	
	
}



















