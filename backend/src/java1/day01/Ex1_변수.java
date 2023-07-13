package java1.day01; // 현재 클래스가 위치한 폴더 경로

public class Ex1_변수 { // class s

	// main + 컨트롤 + 스페이바 => 엔터
	public static void main(String[] args) { // main s

		// [ p.37 1 ]
		/*
			int value;	// int 타입으로 value 이름으로 변수 선언 
			 
			int result = value + 10; // value 변수에 값이 없으므로 연산이 불가능 // 오류 O
			
			System.out.println( result );
		*/
		
		// [ p.37 2 ]
		int hour = 3 ;	// int 타입으로 hour 이름으로 변수 선언 
		int minute = 5 ;	// int 타입으로 minute 이름으로 변수 선언 
		System.out.println( hour + "시간 " + minute +"분");
		
		int totalMinute = (hour*60) + minute ;	// 변수에 값이 있으면 연산 가능 // 오류 X
		System.out.println("총 "+totalMinute+"분");
		
	} // main e

} // class e

/*
 	문자열 처리 : " "
  	문자열 연결 : +
  	-----------
	변수 : 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름 
	형태 :
		타입 변수명 ;			// 선언 
		타입 변수명 = 초기값;	// 선언과 동시에 처음값 저장
 	
	 	타입 : 미리 정해진 변수의 크기
	 	변수명 : 메모리 번지 대신에 식별용으로 사용되는 메모리 이름 [ 카멜 표기법 ] 
	 	= : 오른쪽에 데이터를 왼쪽에 대입 
	 	초기값 : 변수 선언시 저장할 데이터 
 	호출 
 		변수명 
 		
 	
 	
 */






