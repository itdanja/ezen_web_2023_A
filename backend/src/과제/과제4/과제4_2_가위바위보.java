package 과제.과제4;

import java.util.Random;
import java.util.Scanner;

public class 과제4_2_가위바위보 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int 플레이어; // 플레이어 낸수 저장하는 변수 역할 
		int 컴퓨터; // 컴퓨터 낸수 저장하는 변수 역할 
		int 게임수 = 0;  // 게임 횟수 저장하는 변수 역할 
		int 플레이어승리수 = 0 ; int 컴퓨터승리수 = 0 ; // 승리할때마다 승리수를 저장하는 변수 역할 
		
		while(true) {
			System.out.println("\n\n--------------[[ 가위바위보 게임 ]] ----------- ");
			System.out.print(" >>>>>>>  가위[0] 바위[1] 보[2] 종료[3] 중 선택 : ");
			플레이어 = scanner.nextInt(); // 1. 플레이어에게 입력 받은 후
			
			/* 문제풀이 위치 */
			
			// step3 : 종료 코드를 넣어주는 시점 [ 난수x 승리자판단x ]
			if( 플레이어 == 3 ) {
				
				System.out.println(" 게임수 : " + 게임수 ); // 경우의수 없는 출력 
				
				if( 플레이어승리수 > 컴퓨터승리수 ) { System.out.println("플레이어 최종 승리 : " + 플레이어승리수  ); }
				else if( 플레이어승리수 < 컴퓨터승리수 ) { System.out.println("컴퓨터 최종 승리 : " + 컴퓨터승리수  ); }
				else { System.out.println("무승부"  ); }
				
				break; // while 종료
				
			}
			
			// step1
				// 컴퓨터수는 난수로 자동으로 생성 한다. [ Math.random() vs  new Random(); ]
				// 1. 랜덤 객체 생성 
			Random random = new Random();
				// 2. 랜덤 객체를 이용한 랜덤 함수 이용 [ 객체가 있으면 메소드/함수/행동 사용 가능 ]
			컴퓨터 = random.nextInt(3);	// 0~2 사이의 난수 생성
			System.out.println("컴퓨터가 낸수 : " + 컴퓨터 );
			
			// step2
				// 가위바위보 경우의수 = 3가지 [ 승리 패배 무승부 / 가위 바위 보 ]
				// 승리 : 가위&&보 || 바위&&가위 || 보&&바위
			if( 플레이어==0 && 컴퓨터==2 || 플레이어==1 && 컴퓨터==0 || 플레이어==2 && 컴퓨터==1  ) { 
				System.out.println("플레이어 승리");  플레이어승리수++;
			}
				// 무승부 : 가위&&가위 || 바위&&바위 || 보&&보
			else if( 플레이어 == 컴퓨터 ) {  System.out.println("무승부"); }	
				// 패배 : 그외 
			else{  System.out.println("컴퓨터 승리"); 컴퓨터승리수++; }
			
			게임수++; // 게임수/while 반복횟수 증가 
			
			/* ----------- */
			
		}
	}  
}  

/*
 	주제 : 가위바위보 만들기 
 		입력 조건 
 			1. 플레이어 값은 가위 대신 0 , 바위 대신 1 , 보 대신 2 , 종료 대신 3 입력받는다.
 			2. 컴퓨터 값은 난수 0~2 사이로 입력받는다.
 		실행 조건 
 			1. 플레이어에게 입력 받은 후 컴퓨터수는 난수로 자동으로 생성 한다.
 			2. 승리자 판단 한다.
 			3. 게임은 플레이어가 3을 입력할때까지 계속 진행 
 		출력 조건 
 			1. 매 게임 마다 승리자 출력 
 			2. 게임종료시 게임수 와 최종승리자 출력[ 가장 많이 이긴 플레이어 호출 ]
*/
























