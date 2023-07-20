
package java1.day06;

import java.util.Arrays;

public class Ex1_배열 { // class s 

	public static void main(String[] args) { // main s 
		
		// [ p.168 ]
		// 1. 선언 
		String[] season = { "spring" , "summer" , "fall", "winter" };
			// String[]  : String 클래스(타입) 으로 배열 선언 = string데이터만 저장 가능!! 
			// { 값1 , 값2 , 값3 } : 배열에 저장할 데이터 순서대로 작성 
		// 2. 호출 
		System.out.println( season ); 	// season변수는 배열주소값을 가지고 있는 스택영역 
		System.out.println( Arrays.toString( season ) ); 
		//Arrays.toString( 배열변수명 )	// 주소를 찾아서 배열의 정보 호출 
		
		System.out.println( season[0] ); // 인덱스 0 데이터 호출 
		System.out.println( season[1] ); // 인덱스 1 데이터 호출 
		System.out.println( season[2] ); // 인덱스 2 데이터 호출 
		System.out.println( season[3] ); // 인덱스 3 데이터 호출
		
		// 3. 변경 ( 새로운값 대입 : = )			* 해당 인덱스에 새로운값 대입
		season[1] = "여름";	// season[0] "summer"  =  "여름"
		System.out.println( season[1] ); 
		
		// 4. 삭제 ( 없음 : 배열은 선언될떄 고정!! ) 	* 해당 인덱스의 데이터를 null 대입
		season[1] = null;
		System.out.println( Arrays.toString( season ) );
		
		// 5. 추가 ( 없음 : 배열은 선언될때 고정!! ) 	* 배열내 인덱스중 null 있으면 해당위치에 데이터 대입
		if( season[1] == null ) season[1] = "초여름";
		else System.out.println("공간이 부족합니다.");
		System.out.println( Arrays.toString( season ) );
		
		// int형 배열 선언 
		int[] scores = { 83 , 90 , 87 };	// int형 배열 선언하고 3개의 정수를 초기화 
		
		// 배열내 데이터들의 총합 / 평균 구하기  
		int sum = 0 ;
		for( int i = 0 ; i<=2 ; i++ ) { // i는 0부터 3미만까지 1씩증가 [ 0~2 ] // scores배열은 [ 인덱스: 0~2 ]
			sum += scores[i];
			// 1회전 : sum += 83	// // 2회전 : sum += 90 // 3회전 : sum += 87
		} // for end 
		
		System.out.println("총합 : " + sum); 
		System.out.println("평균 : " + sum/3.0 ); 
		
		
	} // main e 
	
} // class e 

/*
 	변수 : 하나의 데이터를 저장  
	배열 : 여러개의 데이터를 저장 
		1. 연속적인 공간에 데이터 저장하고 나열
		2. 각 데이터공간 에 인덱스를 부여 [ 인덱스 : 0~ ]
		3. 특징
			1. 배열은 선언된 타입의 값만 저장할수 있다.
				int[] intArray = { 1 , "dd" } 	[x]
				* int로 선언된 배열은 int형 데이터 저장가능
				int[] intArray = { 1 , 3 } 		[o] 
			2. 배열의 길이는 선언될때 고정되므로 늘리거나 줄일 수 없다.
				int[] intArray = new int[길이];
				int[] intArray = new int[3];
				intArray[0] , intArray[1] , intArray[2]
				* 추가하거나 줄일수 없다.. [ 고정길이 ]
		4. 선언
			1. 타입[] 변수명;		int[] intArray;
			2. 선언과 동시에 값 대입 해서 생성
				타입[] 변수명 = {  값1 , 값2 , 값3 , 값4 }
				
			3. new 연산로 배열 생성 (기본값) 으로 생성 
				타입[] 변수명 = new 타입[길이];		* 길이 : 배열에 저장할 데이터 개수
			
			
*/





