package java1.day13.Ex2.controller;

public class BoardController {
	// 싱글톤(공유)O : 게시물마다 가 아닌 모든 게시물이 하나의 객체을 통해 동일한 기능 수행
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() { return boardController; }
	private BoardController() {}
	
	// 글등록 처리 기능함수
	
	// 글출력 처리 기능함수
	
	// 글삭제 처리 기능함수 
	
	// 글수정 처리 기능함수 
	
}
