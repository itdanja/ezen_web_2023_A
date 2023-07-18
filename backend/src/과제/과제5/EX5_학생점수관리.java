package 과제.과제5;

import java.util.Scanner;

public class EX5_학생점수관리 { // class s
	public static void main(String[] args) { // class s 
		
		boolean run = true; 	// 무한루프 제어 변수
		int studentNum = 0;		// 학생수 저장할 변수 
		int[] scores = null;	// 여러개 점수를 저장할 배열 [ 메모리 할당 전 ]
		Scanner scanner = new Scanner(System.in); // 입력객체 
		while( run ) { // 무한루프 s [ 종료조건 : 5 입력했을때 ] 
			System.out.println("-------------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
			System.out.print("선택 : "); int selectNo = scanner.nextInt();
			if( selectNo == 1  )  // 1 입력했을때
				{ 
					System.out.print("학생수 : "); studentNum = scanner.nextInt(); 
					scores = new int[studentNum]; // **입력받은 학생수 만큼 배열에 메모리(길이) 할당
					System.out.println("-배열에 "+ studentNum +"명의 점수 입력 가능 ");
				} 
			else if( selectNo == 2 )  // 2 입력했을때 ( 학생수 입력전 실행 불가 )
				{ 
					for( int i = 0 ; i<scores.length ; i++ ) { // i는 0부터 배열의길이까지 1씩증가반복 
						System.out.print("scores["+i+"] : " ); 
						scores[i] = scanner.nextInt(); // i번째 인덱스의 입력값을 대입 
					}// for end 
				} 
			else if( selectNo == 3 )   // 3 입력했을때
				{
					for( int i = 0 ; i<scores.length ; i++ ) {
						// System.out.println("scores["+i+"]> "+scores[i]);
						System.out.printf("scores[%d]> %d \n", i , scores[i] );
					} // for end 
				}
			else if( selectNo == 4 )  // 4 입력했을때
				{
					int max = 0;	// 최고점수 
					int sum = 0;	// 평균 구하기전에 합계 구하기 
					for( int value : scores ) {
						if( value > max ){ max = value; }// 만약에 해당 값이 max 보다 크면 max 대입 
						sum += value;	// 해당 값을 sum 변수에 누적 더하기 
					} // for end 
					System.out.println("최고 점수 : " + max );
					double avg = (double)sum/scores.length;
								// * 강제형변환 int -> double
					System.out.println("평균 점수 : " + avg );  // 평균 : 합계/개수
					
					// * 순위별[ 내림차순 ] 출력 
					for( int i = 0 ; i<scores.length ; i++ ) {
						for( int j = i+1 ; j<scores.length ; j++ ) {
							if( scores[i] < scores[j] ) { // > : 오름차순 <:내림차순
								// 두 변수 교환
								int temp = scores[i];	
								scores[i] = scores[j];
								scores[j] = temp;
							} // if end 
						} // for end 
					} // for end 
					
					/*
					// 2. 클래스 이용한 정렬  [ 배열 관련 클래스 = Arrays ] 
					Arrays.sort( 학생점수목록 ); // 오름차순 / 오름차순 반대는 내림차순 
					Arrays.sort( 학생점수목록, Collections.reverseOrder() );
							// Collections.reverseOrder() : 순서 뒤집기 [ 기본 자료형은 불가 // 객체만 가능 ]
					*/
					
					// 확인 
					int rank = 0;
					for( int value : scores ) {
						System.out.println( (rank+1)+"순위 점수 : "+ value );
						rank++;
					}
				} 
			else if( selectNo == 5 ) 
				{ run=false; } // 5 입력했을때
			else 
				{ System.out.println("안내) 알수 없는 번호입니다."); } // 그외 입력했을때
		} // while e
		System.out.println("프로그램 종료");
	}// main e 
} // class e 







