package java1.day06;

import java.util.Scanner;

public class Ex2_확인문제9_4 { // class s

	public static void main(String[] args) { // main s 
		
		// [p.199] 확인문제 9
		while(true) { // while s // 무한루프 
			
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");
			
			Scanner scanner = new Scanner(System.in);
			String ch = scanner.nextLine();
		
			if( ch.equals("1") ) {
				System.out.println("학생수> 3");
			}
			if( ch.equals("2") ) { 
				System.out.println("scores[0]> 85");
				System.out.println("scores[1]> 95");
				System.out.println("scores[2]> 93");
			}
			if( ch.equals("3") ) {
				System.out.println("scores[0]: 85");
				System.out.println("scores[1]: 95");
				System.out.println("scores[2]: 93");
			}
			if( ch.equals("4") ) {
				System.out.println("최고 점수: 95");
				System.out.println("평균 점수: 91.0");
			}
			if( ch.equals("5") ) { 
				System.out.println("프로그램 종료");
			}
			
		} // while end 
	} // main e 
} // class e 

/*
 	step4
 	설계조건
 		- 학생수를 입력받아 입력받은 학생수 만큼 점수를 입력받아 저장 
 		- 현재 점수 출력 / 통계 
 		1.학생수
 			- 학생수를 입력받아 '학생수' 변수에 저장한다.
 			- 그 학생수 만큼 배열 선언한다.[ 메모리 할당 ]  : 타입[] 변수명 = new 타입[길이]
 		2.점수입력
 			- 몇개 점수 입력?????????? 정해져 있지 않는 상태 --> 변수로만 처리 비효울적으로 --> 배열 효율적
 			- 1번기능에서 할당된 배열만큼 점수를 입력받아 각 인덱스에 저장한다.
 				[ 만일 학생수를 입력받지 않고 점수입력을 하면 오류 발생!!! ]
 		3.점수리스트
 			- 2번기능에서 저장된 배열내 모든 인덱스 데이터 호출 한다. 
 		4.분석
 			- 2번기능에서 저장된 배열내 모든 인덱스 데이터를 모두 더한후 학생수 만큼 나눈다. = sum/학생수(1번기능)
 			- 2번기능에서 저장된 배열내 모든 인덱스 데이터를 호출해서 최고점수 찾는다 = max
 		5.종료 
 			무한루프 종료해서 출력그만!!! break;
*/
























