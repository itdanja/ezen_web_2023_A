package java1.day04;

import java.util.Scanner;

public class Ex2_확인문제7_5 { // class s 
	
	public static void main(String[] args) { // main s 
		
		// step5 : 각 기능별 구현 => 공통 변수 생각 => 예금액
			// 1:예금액  	: 예금할 금액 입력받아 예금액 변수에 더하기 	+=
			// 2:출금액	: 출금할 금액 입력받아 예금액 변수에 빼기 	-=
			// 3:잔고		: 예금액 변수 출력 
			// 4:종료		: 무한루프[while] 종료[break]
		
		Scanner scanner = new Scanner( System.in );
		// 1. int 예금액 = 0;  // main 실행될때 // // 1번 [ o ]
		int 예금액 = 0;
		
		while( true ) { 
			// 2. int 예금액 = 0; // while 실행될때 / 반복될때마다  [ x ]
			System.out.println("\n-----------------------------");
			System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료");  
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			int ch = scanner.nextInt(); 
			
			if( ch == 1 ) { 
				// 3. int 예금액 = 0; // 1 입력 했을때 / 1 입력할때마다 [x]
				System.out.print("예금액>");
				예금액 += scanner.nextInt(); // 입력받은 정수를 예금액 변수에 누적 더하기 
			}
			else if( ch == 2 ) { 
				System.out.println("출금액>"); 
				예금액 -= scanner.nextInt(); // 입력받은 정수를 예금액 변수에서 누적 빼기 
			}
			else if( ch == 3 ) { 
				System.out.println("잔고> " + 예금액 );  // 예금액 변수 호출해서 출력 
			}
			else if( ch == 4 ) { 
				System.out.println("\n프로그램 종료"); 
				break; // 가장 가까운 while 탈출
			}
			
		}
		
		
	} // main e 
	
} // class e 
