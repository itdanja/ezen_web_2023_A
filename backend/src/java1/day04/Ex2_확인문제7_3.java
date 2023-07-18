package java1.day04;

import java.util.Scanner;

public class Ex2_확인문제7_3 { // class s 
	
	public static void main(String[] args) { // main s 
		
		// step3 : Scanner 클래스를 이용한 입력된 데이터로 [1,2,3,4]기능 제공 
			// 입력
			// 1. 입력객체 
		Scanner scanner = new Scanner( System.in );
			// 2. 입력객체를 이용한 next~~~() 메소드로 입력객체내 입력받은 데이터 형변환 해서 호출 
		
		while( true ) { // 무한루프 // 종료할떄까지 4입력할때까지 프로그램 실행 계속 되어야한다 = 무한루프 // 종료조건 : 4입력시
			// 1. 무한출력 
			System.out.println("\n-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			// 2. 무한입력 
			int ch = scanner.nextInt(); // 입력받고 변수에 저장 필수!!! 입력받은 값으로 추후 행동 하기 위해서 
		}
		
		/*
		
		System.out.println("예금액> 10000 ");
		
		
		System.out.println("출금액> 2000 ");
		
		
		System.out.println("예금액> 8000 ");
		
		
		System.out.println("\n프로그램 종료");
		*/
		
	} // main e 
	
} // class e 
