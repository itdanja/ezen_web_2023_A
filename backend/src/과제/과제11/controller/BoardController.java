package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.view.LoginPage;

public class BoardController {
	
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() { return boardController; }
	private BoardController() {}
	
	
	// 9. boardWrite : 게시물쓰기 페이지 
	public boolean boardWrite( String title , String content) {
		
		BoardDto boardDto = new BoardDto(title, content, MemberController.getInstance().getLoginSession() );
		
		return BoardDao.getInstance().boardWrite( boardDto );
		
	}
	// 10. boardPrint : 모든 게시물 출력 
	public ArrayList<BoardDto> boardPrint() {
		return BoardDao.getInstance().boardPrint(  );
	}
	
	// 11. boardView : 개별 게시물 출력 
	public void boardView() { }
	// 12. boardUpdate : 게시물 수정 
	public void boardUpdate() {}
	// 13. boardDelete : 게시물 삭제
	public void boardDelete() {}
	

}
