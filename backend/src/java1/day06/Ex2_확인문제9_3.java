package java1.day06;

import java.util.Scanner;

public class Ex2_확인문제9_3 { // class s

	public static void main(String[] args) { // main s 
		
		// [p.199] 확인문제 9
		

	
		
		while(true) { // while s // 무한루프 
			
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");
			
			// step3 : 경우의수가 있을때 경우의수 에 따른 서로 다른 실행/코드 * 경우의수 5가지 중에 선택(입력)
			// 입력 
			// 1. Scanner 객체 생성 [ import ]
			Scanner scanner = new Scanner(System.in);
			// 2. 객체.nextLine();  : 입력받은 데이터를 문자열로 반환 함수 //  // 3. 변수 저장
			String ch = scanner.nextLine();
			
			// 경우의수 판단 
			if( ch.equals("1") ) { // 1. 입력한 값(ch) 가 1일때
				System.out.println("학생수> 3");
			}
			if( ch.equals("2") ) { // 2. 입력한 값(ch) 가 2일때
				System.out.println("scores[0]> 85");
				System.out.println("scores[1]> 95");
				System.out.println("scores[2]> 93");
			}
			if( ch.equals("3") ) { // 3. 입력한 값(ch) 가 3일때
				System.out.println("scores[0]: 85");
				System.out.println("scores[1]: 95");
				System.out.println("scores[2]: 93");
			}
			if( ch.equals("4") ) { // 4. 입력한 값(ch) 가 4일때
				System.out.println("최고 점수: 95");
				System.out.println("평균 점수: 91.0");
			}
			if( ch.equals("5") ) { // 5. 입력한 값(ch) 가 5일때
				System.out.println("프로그램 종료");
			}
			
		} // while end 
	} // main e 
} // class e 

/*
 
*/