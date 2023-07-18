package java1.day04;

import java.util.Scanner;

public class Ex2_확인문제7_4 { // class s 
	
	public static void main(String[] args) { // main s 
		
		// step4 : 입력에 따른 서로 다른 코드 실행 
		
		Scanner scanner = new Scanner( System.in );
		
		while( true ) { 
			
			// 서로 같은 내용 출력  
			System.out.println("\n-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료"); // 경우의 수 4가지 
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			int ch = scanner.nextInt(); 
			
			// 3. 입력에 따른 서로 다른 내용 출력
			if( ch == 1 ) { System.out.println("예금액> 10000 "); }
			else if( ch == 2 ) { System.out.println("출금액> 2000 "); }
			else if( ch == 3 ) { System.out.println("잔고> 8000 "); }
			else if( ch == 4 ) { System.out.println("\n프로그램 종료"); }
			
		}
		
		
	} // main e 
	
} // class e 
