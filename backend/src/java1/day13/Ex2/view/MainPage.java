package java1.day13.Ex2.view;

import java.util.Scanner;

import java1.day13.Ex2.controller.BoardController;

public class MainPage {
	// ---------------------- 싱글톤 ----------------------------- //
	// 싱글톤(공유)O : 게시물마다 가 아닌 모든 게시물이 하나의 객체을 통해 동일한 기능 수행
	// 1. 현재클래스안에 현재클래스로 싱글톤 객체 선언[ private static ]
	private static MainPage mainPage = new MainPage();
	// 2. 외부로부터 간접적으로 싱글톤이 호출되도록 하는 함수 
	public static MainPage getInstance( ) { return mainPage; }
	// 3. 외부로부터 객체 생성 차단하는 생성자 선언 
	private MainPage() {}
	// --------------------------------------------------------- //
	
	// 입력객체 필드
	private Scanner sc = new Scanner(System.in);
	
	// 메인페이지 입출력 함수 
	public void mainView() {
		while(true) {
			System.out.println("\n\n >>>>> 방문록 프로그램 >>>>>");
			System.out.print("1.글등록 2.글보기 3.글수정 4.글삭제 선택> ");
			int ch = sc.nextInt();
			if( ch == 1 ) { writeView(); } // 각 번호별 페이지 함수 호출 
			if( ch == 2 ) { printView(); }
			if( ch == 3 ) { updateView(); }
			if( ch == 4 ) { deleteView(); }
		} // while end 
	} // f end 
	
	// 글등록 페이지 입출력 함수
	public void writeView() { 
		System.out.println("안내] 방문록 등록 페이지 ");
		// 1. 내용(띄어쓰기o) 과 작성자(띄어쓰기x)을 입력받아 변수 저장
		sc.nextLine(); // nextLine() 함수 실행전 nextInt() 실행되므로 오류 발생 방지!!!!
		System.out.print("방문록 : "); String content = sc.nextLine(); // nextLine()함수 앞뒤로 다른 next()가 있을때 하나의 입력으로 인식[오류]
		System.out.print("작성자 : "); String writer = sc.next();
		// 2. 입력받은 변수를 컨트롤에게 전달보내기 
		// 현재위치도 java 컨트롤도 java 이므로 메소드 이용한다. // 전달보내기 = 매개변수  / 전달받기 = 리턴 	// View 에서 Controller 함수 호출하기
		boolean result =  BoardController.getInstance().writeLogic( content , writer ); // 문자열 2개 매개변수로 전달하고 종료 후 boolean 값 1개 리턴받음
		// 3. 컨트롤에게 전달 받은 내용 제어하기
		if( result ) { System.out.println("안내] 글 등록 성공 ");}
		else { System.out.println("안내] 글 등록 실패 ");}
	}
	// 글출력 페이지 입출력 함수
	public void printView() { 
		// View 에서 Controller 함수 호출하기
		BoardController.getInstance().printLogic();
	}
	// 글수정 페이지 입출력 함수
	public void updateView() { 
		// View 에서 Controller 함수 호출하기
		BoardController.getInstance().updateLogic();
	}
	// 글삭제 페이지 입출력 함수
	public void deleteView() { 
		// View 에서 Controller 함수 호출하기
		BoardController.getInstance().deleteLogic();
	}

	
}












