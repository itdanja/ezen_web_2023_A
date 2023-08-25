package java2.day26_컬렉션프레임워크.Ex1_ArrayList;

import java.util.ArrayList;
import java.util.List;

import java2.day26_컬렉션프레임워크.Board;

public class Ex1_예제 {
	
	public static void main(String[] args) {
		
		// 1. ArrayList 컬렉션 객체 생성
		List<Board> list = new ArrayList<>();
			// ArrayList<Board> list2 = new ArrayList<>();
		System.out.println("---------- 1 : " + list );
		// 2. ArrayList 객체 안에 객체 추가 
			// 리스트객체명.add( 객체 ) 		: 해당 객체를 리스트에 끝에 추가 
			// 리스트객체명.add( 인덱스 , 객체 ) 	: 해당 객체를 리스트내 인덱스 위치에 추가 
			// 리스트객체명.set( 인덱스 , 객체 ) 	: 해당 객체를 리스트내 인덱스 위치에 바꿈
		list.add( new Board("제목1", "내용1", "글쓴이1"));	list.add( new Board("제목2", "내용2", "글쓴이2"));
		list.add( new Board("제목3", "내용2", "글쓴이3"));	list.add( new Board("제목4", "내용3", "글쓴이4"));
		list.add( new Board("제목5", "내용4", "글쓴이5"));
		list.add( 0 , new Board("제목6" , "내용6" , "글쓴이6") ); // 인덱스 0번에 객체를 추가하고 한칸씩 뒤로 물려남
		list.set( 1 , new Board("제목7" , "내용7" , "글쓴이7") ); // 인덱스 1번에 객체 사라지고 해당객체를 추가 
		
		Board board = new Board("제목8", "내용8", "글쓴이8");	list.add(board);	// 보드 객체 생성후 리스트객체 에 추가O
		Board board2 = new Board("제목9", "내용9", "글쓴이9");						// 보드 객체 생성후 리스트객체 에 추가X 
		
		System.out.println("---------- 2 : " + list );
		
		// 3. ArrayList 객체 안에 총 개수 / 특정 객체 검색 
			// 리스트객체명.get( 인덱스 ) 	: 리스트내 해당 인덱스 위치에 객체 반환 
			// 리스트객체명.contains( 객체 )	: 리스트내 해당 객체가 있으면 true / 없으면 false
			// 리스트객체명.isEmpty()		: 리스트내 객체가 모두 비어 있는지 true / 아니면 false
			// 리스트객체명.size()			: 리스트내 저장된 객체 수 
		System.out.println("---------- 3 size() : " + list.size() +" 개" );	 	// 배열명.length
		System.out.println("---------- 3 get() : " + list.get( 2 ) ); 		// 배열명[ 인덱스 ]
		System.out.println("---------- 3 contains() : " + list.contains( board ) );	
		System.out.println("---------- 3 contains() : " + list.contains( board2 ) );
		System.out.println("---------- 3 isEmpty() : " + list.isEmpty() );
		
			// 리스트와 반복문 활용 : 여러개 데이터를 순차적으로 순회 하는 방법
			// 1. for문 [ i를 인덱스로 활용해서 사용 ] 
			System.out.println("\n =================== 1. for문  ====================== \n ");
			for( int i = 0 ; i<list.size() ; i++ ) {  				// for( int i = 0 ; i<배열명.length ; i++ ) {
				System.out.print(" 인덱스 : "+i+" " + list.get(i) );
			}
			System.out.println("\n ========================================= \n ");
				
			// 2. 향상된 for 
			System.out.println("\n =================== 2. 향상된 for 문  ====================== \n ");
			int index = 0; // 인덱스로 사용할 변수 선언 
			for( Board b : list ) { // 리스트내 객체를 자동으로 처음부터 끝까지 반복변수에 하나씩 대입하면 반복
				System.out.println(" 인덱스 : "+index+" " + b );
				index++; // 인덱스 증가.
			}
			System.out.println("\n ========================================= \n ");
			
			// 3. .forEach( 반복변수명 -> { 실행코드 } )  // 화살표함수 : java[ 매개변수 -> { 실행코드 } ] , js[ 매개변수 => { 실행코드 } ]
				// 리스트내 객체를 자동으로 처음부터 끝까지 매개변수 b에 하나씩 대입하고 { } 실행 
			System.out.println("\n =================== 3. .forEach( )  ====================== \n ");
			list.forEach( b -> { System.out.println( b );} );
			System.out.println("\n ========================================= \n ");
		
		// 4. ArrayList 객체 안에 특정 객체 삭제 
			// 리스트객체명.remove( 인덱스 ) 	: 리스트내 해당 인덱스 위치에 객체 삭제 / 1칸씩 당겨짐 
			// 리스트객체명.remove( 객체 ) 		: 리스트내 해당 객체가 존재하면 삭제 
			// 리스트객체명.clear()			: 리스트내 모든 객체 삭제 / 초기화
		list.remove(2); // 리스트객체내 2번인덱스 객체 삭제 
		list.remove( board ); // 리스트객체내 해당 객체가 존재하면 삭제 
		System.out.println("---------- 4 remove() : " + list );	 
		list.clear();
		System.out.println("---------- 4 clear() : " + list );	 
		
	}
}
















