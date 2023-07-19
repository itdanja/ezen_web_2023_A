package 과제.과제5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class 과제5_키오스크3_배열버전 {
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		String 재고관리 = "";
		/* 재고관리 변수 샘플  */
		
		String filePath = "./src/과제/과제5/과제5.txt";
		
		File file = new File(filePath);
		if( file.exists() ) {
			
			FileInputStream fin = new FileInputStream(filePath);
			byte[] inbytes = new byte[ (int)new File(filePath).length() ]; // 영 1바이트 , 한 3바이트
			int bytecount = fin.read( inbytes );	
			String fStr = new String( inbytes , 0 , bytecount );
			재고관리 = fStr;
			
		}else {
			재고관리 = "10,0,300\n10,0,200\n10,0,100\n";
			FileOutputStream fout = new FileOutputStream(filePath);
			fout.write( 재고관리.getBytes() );
		}
		
		
		System.out.println( 재고관리 );
		
		
		/* ----------- */
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			
			String 콜라정보 = 재고관리.split("\n")[0];	System.out.println(콜라정보);
			String 환타정보 = 재고관리.split("\n")[1];	System.out.println(환타정보);
			String 사이다정보 = 재고관리.split("\n")[2];	System.out.println(사이다정보);
			
			
			int 콜라재고 = Integer.parseInt( 콜라정보.split(",")[0] ) ; 		
			int 콜라바구니 = Integer.parseInt( 콜라정보.split(",")[1] ) ;  	
			int 콜라가격 = Integer.parseInt( 콜라정보.split(",")[2] ) ; 		
			
			int 환타재고 = Integer.parseInt( 환타정보.split(",")[0] ) ; 		
			int 환타바구니 = Integer.parseInt( 환타정보.split(",")[1] ) ;  	
			int 환타가격 = Integer.parseInt( 환타정보.split(",")[2] ) ; 		
			
			int 사이다재고 = Integer.parseInt( 사이다정보.split(",")[0] ) ; 		
			int 사이다바구니 = Integer.parseInt( 사이다정보.split(",")[1] ) ;  	
			int 사이다가격 = Integer.parseInt( 사이다정보.split(",")[2] ) ; 		
			/* ----- 1~4 기능 들어가는 자리 ------- */
			
			
			// step1 : 메뉴 번호 선택/입력 에 따른 서로 다른 실행/코드 
			if( ch == 1 ) { // 1. 콜라 선택
				
				// step2 : 기능 구현 
				// 1. 콜라 재고가 있으면 바구니에 담아 없으면 재고없음출력 
				if( 콜라재고 > 0 ) { // 재고가 있어 
					콜라재고--;	// 콜라재고 변수에 콜라 1개 차감/감소
					콜라바구니++; 	// 콜라바구니 변수에 콜라 1개 추가/증가
					System.out.println("안내) 콜라 담았습니다.");
				} 
				else {  // 재고가 없어 
					System.out.println("안내) 콜라 재고가 없습니다. [ 관리자에게 문의 ]");
				}
				
			}
			else if( ch == 2 ) { // 2. 환타 선택 
				if( 환타재고 > 0 ) {  환타재고--;		환타바구니++;  System.out.println("안내) 환타 담았습니다."); } 
				else {   System.out.println("안내) 환타 재고가 없습니다. [ 관리자에게 문의 ]"); }
			} 
			
			else if( ch == 3 ) { // 3. 사이다 선택 
				if( 사이다재고 > 0 ) {  사이다재고--;		사이다바구니++;  System.out.println("안내) 사이다 담았습니다."); } 
				else {   System.out.println("안내) 사이다 재고가 없습니다. [ 관리자에게 문의 ]"); }
			} 
			
			else if( ch == 4 ) {  // 4. 결제 선택 
				// 1. 변수/장바구니 내 데이터/개수 출력 *장바구니에 담은 제품만 출력[경우의수 = 바구니가 0보다 크면  ]
				System.out.println("----------------------");
				System.out.printf("%3s %2s %3s\n" , "제품명" , "수량" , "가격" );
				if( 콜라바구니 > 0 ) 	System.out.printf("%3s %2d %5d\n" , "콜라" , 콜라바구니 , 콜라바구니*콜라가격 );
				if( 사이다바구니 > 0 ) 	System.out.printf("%3s %2d %5d\n" , "사이다" , 사이다바구니 , 사이다바구니*사이다가격 );
				if( 환타바구니 > 0 ) 	System.out.printf("%3s %2d %5d\n" , "환타" , 환타바구니 , 환타바구니*환타가격 );
				int 총가격 = 콜라바구니*콜라가격 + 사이다바구니*사이다가격  +  환타바구니*환타가격;
				System.out.println("총가격 : " + 총가격 );
				System.out.println("----------------------");
				System.out.print(" 1.결제 2.취소 : "); int ch2 = scanner.nextInt();
				
				if( ch2 == 1 ) { // 결제 선택 == 1 
					// 1. 금액 입력 
					System.out.println("안내 금액 투여 : "); int pay = scanner.nextInt();
					// 2. 만약에 총가격보다 입력받은 금액이 더 크거나같으면 성공  / 아니면 실패 
					if( pay >= 총가격 ) {
						System.out.println("잔액 : " + (pay-총가격) );
						// 구매성공 // 장바구니 초기화 = 다음 사람을 위해 
						콜라바구니 = 0 ; 사이다바구니 = 0; 환타바구니 = 0;
						System.out.println(" 주문 번호 : 1 ");
					}
					else {  // 구매실패 // 장바구니 초기화 / 재고 원상복귀
						콜라재고 += 콜라바구니; 콜라바구니 = 0; 사이다재고 += 사이다바구니; 사이다바구니 = 0; 환타재고 += 환타바구니; 환타바구니 = 0;
						System.out.println("안내) 투여 금액이 부족합니다. 초기메뉴로 돌아갑니다.");
					}
				} 
				else if( ch2 == 2 ) { // 취소 선택 == 2  
					// 구매 취소 했기때문에 원상복귀
					콜라재고 += 콜라바구니;		콜라바구니 = 0;
					사이다재고 += 사이다바구니;		사이다바구니 = 0;
					환타재고 += 환타바구니;		환타바구니 = 0;
					System.out.println("안내) 장바구니를 초기화 했습니다. 초기메뉴로 돌아갑니다.");
				} 
			} // if 4 end 
			
			
			
			
			재고관리 = 콜라재고+","+콜라바구니+","+콜라가격+"\n"
					+ 환타재고+","+환타바구니+","+환타가격+"\n"
					+ 사이다재고+","+사이다바구니+","+사이다가격+"\n";
			FileOutputStream fout = new FileOutputStream(filePath);
			fout.write( 재고관리.getBytes() );
			
			
			/* ----------- */
			
		} // while end 
	} // main end 
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					이름 : 콜라 , 환타 , 사이다
					재고 : 10 , 10 , 10
					가격 : 300 , 200 , 100
					바구니 : 0 , 0 , 0
			
		2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
			1. 콜라 2.사이다 3.환타 4.결제
			[ 1~3 선택시 ]
				- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
				 
			[ 4 선택시 ] 
				- 현재 장바구니 현황 표시 목록 
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타		2	1000
				총가격 : 1400
				- 결제메뉴 표시
					1. 결제 2.취소 
					[결제]
						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
					[취소]
						- [ 장바구니 초기화 / 재고 다시 되돌리기 ]
						
						
						
		FileInputStream fin = new FileInputStream("c:/java/lotto.csv");
		byte[] inbytes = new byte[ (int)new File("c:/java/lotto.csv").length() ]; // 영 1바이트 , 한 3바이트
		int bytecount = fin.read( inbytes );	
		String fStr = new String( inbytes , 0 , bytecount );
		System.out.println( fStr );
		
 
 */







