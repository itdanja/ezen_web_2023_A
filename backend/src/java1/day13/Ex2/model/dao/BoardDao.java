package java1.day13.Ex2.model.dao;

import java.util.ArrayList;

import java1.day13.Ex2.model.dto.BoardDto;

public class BoardDao {
	// 싱글톤(공유)O : 게시물마다 가 아닌 모든 게시물이 하나의 객체을 통해 동일한 기능 수행
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() { return boardDao; }
	private BoardDao() {}
	// 게시물 여러개 저장하는곳 
		// 1.배열
	// public BoardDto[] boardDtoArray = new BoardDto[100];
		// 2.리스트 : 배열을 쉽게 사용할수 있도록 *다양한 함수 제공 
	public ArrayList<BoardDto> boardDtoList = new ArrayList<>();
		// ArrayList : 배열처럼 사용가능한 클래스 객체 선언 
			// <클래스> : 리스트객체 안에 여러개 객체를 저장할 저장 객체의타입
				// boardList : 리스트객체변수명 
}
/*
 	- 배열 : boardDtoArray
 	boardDtoArray =	[boardDto ]	[boardDto ] [ boardDto] [boardDto ] 
 					0			1			2			3	
 					
 		- 배열 선언하는 방법	
 			타입명[] 배열변수명 = new 타입명[길이]
 			- ( 고정길이 = 선언시 사용할 길이만큼 사용하고 중간에 변경불가능* )
 			
 		- 배열에 값 저장하는 방법
 			for( int i = 0 ; i<배열명.length ; i++ ) {
				if( 배열명[i] == null ) { 배열명[i] = 객체명; }
			} 
		- 배열에서 값 호출하는 방법
			배열명[인덱스]
		- 배열에서 값 삭제하는 방법 [ 삭제 못함 = 배열 고정길이 ]
			- 대신에 초기값 대입해서 삭제 처럼 표현
			배열명[인덱스] = null;
			[ dto ] [ dto ] [ null ] [ dto ] [ dto ]	: 이빨 빠진것처럼 구멍 발생 
				---> 한칸씩 당기기 해서 null 가장 뒤로 보내기
			[ dto ] [ dto ] [ dto ] [ dto ] [ null ]	: 이빨 채워서 구멍 없애기
		
 	- 리스트 : boardDtoList 
 		-----------------
 		|				|
 		|	boardDto	|
 		|	boardDto	|
 		|	boardDto	|
 		|	boardDto	|
 		|_______________|
 		- 리스트 선언하는 방법 
 			ArrayList<타입명> 리스트객체변수명 = new ArrayList<>();
 			(가변길이 = 저장하는 객체의 개수만큼 자동으로 저장개수 커졌다 작아졌다 함 )
 			
 		- 리스트에 값 저장하는 방법 
 			- 리스트객체명.add( 객체명 )		: 해당 객체를 리스트에 추가 [-마지막인덱스로 뒤로 객체 추가 ]
		- 리스트에 값 호출하는 방법
			- 리스트객체명.get( 인덱스 )		: 해당 인덱스의 객체를 호출 
		- 리스트에 값 삭제하는 방법
			- 리스트객체명.remove( 인덱스 )	: 해당 인덱스의 객체를 삭제 [-중간 객체 삭제해도 자동채움 ]
		 
 */
















