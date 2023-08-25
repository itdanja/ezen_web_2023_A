package java2.day26_컬렉션프레임워크.Ex3_LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex3_예제 {

	public static void main(String[] args) {
		
		// ArrayList 객체 
		List<String> list1 = new ArrayList<>();
			// ArrayList vs LinkedList 
			// 사용방법 동일 , 내부구조 설계 다르다.
			// 배열에 객체저장	, 객체를 체인처럼 연결
			// .add( 객체 ) : 마지막 인덱스에 객체 추가 
			// .add( 인덱스 , 객체 ) : 해당 인덱스에 객체 추가
				// 속도 차이 
				/*
				 					추가		중간삽입	중간삭제
				 	ArrayList		빠름		느림		느림			[ 0 ] [ 1 ] [ 2 ] [ 3 ] [ 4 ] [ 5 ]
				 	[ p.647 ]							
				 												[ 0 ] [ 1 ] [ 2 ] [ 3 ] [ 4 ] [ 5 ]
				 												x031  x032  x033   x034	 x035  x036
				 												
				 									데이터			값		값	  값	 	값	  값		값 
				 												[ 0 ] [ 1 ] [ x ] [ 3 ] [ 4 ] [ 5 ]
				 												[ 0 ] [ 1 ] [ 3 ] [ 3 ] [ 4 ] [ 5 ]
				 												[ 0 ] [ 1 ] [ 3 ] [ 4 ] [ 4 ] [ 5 ]
				 												[ 0 ] [ 1 ] [ 3 ] [ 4 ] [ 5 ] [ 5 ]
				 												[ 0 ] [ 1 ] [ 3 ] [ 4 ] [ 5 ]
				 												 
				  	LinkedList		느림		빠름		빠름			[ 0 ]-[ 1 ]-[ 2 ]-[ 3 ]-[ 4 ]-[ 5 ]
				  	[ p.642 ]
				  												[ 0 ]---[ 1 ]---[ 2 ]---[ 3 ]---[ 4 ]---[ 5 ]
				  												x031 	 x032  	 x033    x034	 x035    x036
				  												
				 									데이터		값		   값	  값	 	 값	  	  값		  값 
				 									앞주소				 x031	  x032	 x033 	 x034	 x035
				 									뒤주소		 x032 	 x033 	  x034 	 x035	 x036 
				  												[ 0 ]---[ 1 ]---[ x ]---[ 3 ]---[ 4 ]---[ 5 ]
				  												
				  									데이터		값		   값	  	 	   값	  	  값		  값 
				 									앞주소				 x031	  	 	   x032 	 x034	 x035
				 									뒤주소		 x032 	 x034 	   		   x035	 x036 			
				  														
				  													삭제된 객체의 앞주소를 뒤 객체의 앞주소로 변경 
				  													삭제된 객체의 뒤주소를 앞 객체의 뒤주소로 변경
				  														
				  												[ 0 ]---[ 1 ]---     ---[ 3 ]---[ 4 ]---[ 5 ]
				  	
				  	--- 리스트내 중간 데이터를 삽입/삭제 하는게 많으면 ArrayList 비효율적이다. [ p.642 ]
				  	--- 리스트내 중간 데이터를 삽입/삭제 하는게 많으면 LinkedList 효율적이다. 
				  	
				 */
		// LinkedList 객체
		List<String> list2 = new LinkedList<>();
		
		// 두 객체의 저장 속도 체크 
		long startTime; // 시작시간 
		long endTime;	// 끝시간 
		
		// 밀리초( 1/1000 초 )  나노초( 1/1000000000 초 )
		startTime = System.nanoTime(); // 현재시간을 나노시간 으로 호출/반환받기
		for( int i = 0 ; i<100000 ; i++ ) { list1.add( i+"" ); }
		endTime = System.nanoTime(); // 현재시간을 나노시간 으로 호출/반환받기
		
		System.out.println(" ArrayList 10000개를 저장하는데 걸리는 시간 : " + (endTime-startTime) );
		
		startTime = System.nanoTime(); // 현재시간을 나노시간 으로 호출/반환받기
		for( int i = 0 ; i<100000 ; i++ ) { list2.add(  i+"" ); }
		endTime = System.nanoTime(); // 현재시간을 나노시간 으로 호출/반환받기
		
		System.out.println(" LinkedList 10000개를 저장하는데 걸리는 시간: " + (endTime-startTime) );
		
		
		
		
		
		
	}
	
}

/*

LIST 컬렉션 
	- List 인터페이스
		구현체
		1. ArrayList 	: 
		2. Vector 		: 멀티스레드 사용하는 환경에서 권장 
		3. LinkedList 	: 리스트내 많은 데이터를 중간 삽입/삭제 빈번할때 권장 
			ArrayList  vs  Vector
			 - 사용방법동일, 내부구도 동일 [ 차이점 : 비동기 vs 동기 ]
			ArrayList vs LinkedList 
			 - 사용방법동일, 비동기 동일 [ 차이점 : 배열구조 , 링크구조 ] 

	- 리스트 객체 선언하는 방법 [ 인터페이스 사용여부 선택 ]
		List<Board> list = new ArrayList<>();		또는 	ArrayList<Board> list = new ArrayList<>();	
		List<Board> list = new Vector<>();			또는 	Vector<Board> list = new Vector<>();	
		List<Board> list = new LinkedList<>();		또는 	LinkedList<Board> list = new LinkedList<>();

	- 사용방법(함수) 동일 
		리스트객체명.add( 객체 ) 			: 해당 객체를 리스트에 끝에 추가 
		리스트객체명.add( 인덱스 , 객체 ) 	: 해당 객체를 리스트내 인덱스 위치에 추가 
		리스트객체명.set( 인덱스 , 객체 ) 	: 해당 객체를 리스트내 인덱스 위치에 바꿈
		리스트객체명.get( 인덱스 ) 		: 리스트내 해당 인덱스 위치에 객체 반환 
		리스트객체명.contains( 객체 )		: 리스트내 해당 객체가 있으면 true / 없으면 false
		리스트객체명.isEmpty()			: 리스트내 객체가 모두 비어 있는지 true / 아니면 false
		리스트객체명.size()				: 리스트내 저장된 객체 수 
		리스트객체명.remove( 인덱스 ) 	: 리스트내 해당 인덱스 위치에 객체 삭제 / 1칸씩 당겨짐 
		리스트객체명.remove( 객체 ) 		: 리스트내 해당 객체가 존재하면 삭제 
		리스트객체명.clear()			: 리스트내 모든 객체 삭제 / 초기화

 */







