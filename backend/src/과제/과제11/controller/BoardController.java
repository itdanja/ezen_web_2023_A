package 과제.과제11.controller;


import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.view.LoginPage;

public class BoardController {
	// 0.싱글톤 
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() { return boardController; }
	private BoardController() {}
	
	// 9. boardWrite : 게시물쓰기 페이지 
	public boolean boardWrite( String title , String content ) {
		// 1. 유효성검사 
		if( title.length() == 0 || title.length() > 50  ) { return false; }
		// 2. Dto [ 입력받은제목 , 입력받은내용 , 로그인된회원번호= MemberController 의 loginSession  ]
		BoardDto boardDto = new BoardDto( 
							title, content, 
							MemberController.getInstance().getLoginSession() );
		// 2. 글쓰기전용 생성자가 없을때
		// BoardDto boardDto2 = new BoardDto( 0, title, content, null , 0, MemberController.getInstance().getLoginSession(), null);
		// 3. DAO에게 전달후 결과 받아서 받은 결과 바로 반환
		return BoardDao.getInstance().boardWrite(boardDto);
	}
	// 10. boardPrint : 모든 게시물 출력 
	public ArrayList<BoardDto> boardPrint() {
		return BoardDao.getInstance().boardPrint();
	}
	// 11. boardView : 개별 게시물 출력 
	public BoardDto boardView( int bno ) {
		return BoardDao.getInstance().boardView(bno);
	}
	// 12. boardUpdate : 게시물 수정 [ 준비물 : bno = 수정할 게시물의 식별[누구를 수정할껀지] / mno(게시물의 작성자) =  수정요청한 회원과 게시물의 작성자 가 일치한 경우에만[유효성검사] / title : 수정할값 , content : 수정할값 ]
	public int boardUpdate( int bno , int mno , String title , String content ) {
		// 1. 유효성 검사 
			// 1. 게시물의 작성자회원번호 와 로그인된 회원번호 과 일치 하지 않으면 
		if( mno != MemberController.getInstance().getLoginSession() ) { return 3;}
			// 2. 제목 글자 수 체크 
		if( title.length() < 1 || title.length() > 50 ) { return 4; }
		// 2. 
		boolean result = 
				BoardDao.getInstance().boardUpdate( new BoardDto(bno, title, content) );
		if( result ) return 1;
		else return 2;
	}
	// 13. boardDelete : 게시물 삭제 [ 준비물 : bno = 삭제할 게시물의 식별[누구를 삭제할껀지] / mno(게시물의 작성자) = 삭제요청한 회원과 게시물의 작성자가 일치한 경우에만[유효성검사]
	public int boardDelete( int bno , int mno  ) {
		if( mno != MemberController.getInstance().getLoginSession() ) { return 3; }
		boolean result = BoardDao.getInstance().boardDelete( bno ) ;
		if( result ) return 1;
		else return 2;
	}

}




























