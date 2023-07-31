package java1.day13.Ex2.controller;

import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {
	// ---------------------- 싱글톤 ----------------------------- //
	// 싱글톤(공유)O : 게시물마다 가 아닌 모든 게시물이 하나의 객체을 통해 동일한 기능 수행
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() { return boardController; }
	private BoardController() {}
	// --------------------------------------------------------- //
	
	// 글등록 처리 기능함수 [ C ] - 07/31 김현수 작업중
	public boolean writeLogic( String content , String writer) { 
		// 1. 매개변수로 부터 전달 받은 content , writer 를 하나의 객체로 선언
		BoardDto boardDto = new BoardDto(content, writer);
		// 2. 객체를 리스트에 저장   .add( 저장할객체명 );
		BoardDao.getInstance().boardDtoList.add(boardDto);
		// 3. 성공[true] 또는 실패[false]
		return true;
	}
	// 글출력 처리 기능함수 [ R ] - 07/30 강호동 작업완료
	public BoardDto printLogic( int index ) { 
		// 1. 리스트 안에 있는 객체 호출 .get( 인덱스 ) : 해당 인덱스의 객체 호출
		BoardDto boardDto = BoardDao.getInstance().boardDtoList.get(index);
		// 2. 호출된 dto를 리턴하기 
		return boardDto;
	}
	
	// 글수정 처리 기능함수 [ U ] : 수정할 게시물 인덱스 , 수정할 내용 , 수정할 작성자
	public boolean updateLogic( int index , String content , String writer ) { 
		// 1. 입력받은 인덱스의 게시물을 호출해서 새로운 입력받은 값으로 대입/저장/수정 = set , 호출/불러오기 = get
		BoardDao.getInstance().boardDtoList.get(index).setContent( content );
			// BoardDao.getInstance().boardDtoList.get(index).content = content    // * DTO 필드의 직접접근X -> set , get 간접접근O
		BoardDao.getInstance().boardDtoList.get(index).setWriter( writer );
		return true;
	}
	
	// 글삭제 처리 기능함수 [ D ] : 삭제할 게시물 인덱스 
	public boolean deleteLogic( int index ) { 
		// 1. 리스트 안에 있는 객체 삭제 .get( 인덱스 ) : 해당 인덱스의 객체 호출
		BoardDao.getInstance().boardDtoList.remove(index);
		// 2. 삭제 여부 반환
		return true;
	}

}













