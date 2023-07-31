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
		// 2. 객체를 리스트에 저장
		BoardDao.getInstance().boardDtoList.add(boardDto);
		// 3. 성공[true] 또는 실패[false]
		return true;
	}
	// 글출력 처리 기능함수 [ R ] - 07/30 강호동 작업완료
	public void printLogic() { 
		System.out.println("검토용) 출력 컨트롤러 까지 도착");
	}
	// 글수정 처리 기능함수 [ U ]
	public void updateLogic() { 
		System.out.println("검토용) 수정 컨트롤러 까지 도착");
	}
	// 글삭제 처리 기능함수 [ D ]
	public void deleteLogic() { 
		System.out.println("검토용) 삭제 컨트롤러 까지 도착");
	}

}
