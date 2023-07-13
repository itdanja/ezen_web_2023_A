package java1.day01; // 현재 클래스 패키지경로 

public class Ex2_타입 { // class s
	
	public static void main(String[] args) { // main s 
		
		// 1. [ p.41 ] 진수를 표현하는 방법 
		int var1 = 0b1011;	// (2진수) 데이터 앞에 0b 		1011[2] -> 11 [10]
			System.out.println( "var1 : " + var1);
		int var2 = 0206;	// (8진수) 데이터 앞에 0;		206[8]	-> 136 [10]
			System.out.println( "var2 : " + var2 );
		int var3 = 365;		// (10진수) x
			System.out.println( "var3 : " + var3 );
		int var4 = 0xB3;	// (16진수) 데이터 앞에 0x
			System.out.println( "var4 : " + var4 );
		
		// [p.42 ] byte 타입	[ -128 ~ 127 ]
		byte b1 = -128;			System.out.println( "b1 : " + b1 );
		byte b2 = 127;			System.out.println( "b2 : " + b2 );
		// byte b3 = 200;		System.out.println( "b3 : " + b3 ); // 오류 Type mismatch : 허용 범위 벗어남 
		
		// short 타입 [ -32,000 ~ 32,000 ]
		short s1 = 3200;		System.out.println( "s1 : " + s1 );
		//short s2 = -50000;	System.out.println( "s2 : " + s2 ); // 오류 Type mismatch : 허용 범위 벗어남 
		
		// int 타입 [ 대략 +-21억정도 ] * 정수 기본타입 : 1.우리 코드로 작성한 정수
		int i1 = 2000000000; 	System.out.println( "i1 : " + i1);
		// int i2 = 3000000000;	System.out.println( "i2 : " + i2);
		
		// long 타입 [ 대략 +- 21억이상 자동 ] 
		long l1 = 10;			System.out.println( "l1 : " + l1);
		// long l2 = 3000000000;	// 직접 작성한 정수 30억은 int 타입 -> 기본/자동 // 오류 : 입력한 정수는 int 이므로 21억까지만 입력가능
		long l3 = 3000000000L;	// 직접 작성한 정수를 long 타입 변경 -> 정수 뒤에 L 붙이기
			System.out.println("l3 : " + l3);
			
		// [p.43] char 타입 [ 문자 1개 저장 ] ' '
		char c1 = 'A';	// 문자 : ' '  VS 문자열 : " "
							System.out.println("c1 : " + c1);
		char c2 = 65;		System.out.println("c2 : " + c2);
		char c3 = '가';		System.out.println("c3 : " + c3);
		char c4 = 44032; 	System.out.println("c4 : " + c4);
		
		// [p.49] String 클래스 [ 문자열 저장 ] " "
		String str1 = "안녕하세요";			System.out.println("str1 : "+str1);
		
		// [p.45] float 타입 [ 소수 8자리 표현 ] // 데이터 뒤에 f 
		float f1 = 0.123456789123456789f; 	System.out.println("f1 : "+f1);
		
		// double [ 소수 17자리 표현 ] : *실수 기본타입 
		double d1 = 0.123456789123456789;	System.out.println("d1 : " + d1);
		
		// [p.48] boolean 타입 [ true or false ]
		boolean bool1 = true;				System.out.println("boo1 : " + bool1);
		
		// [p.50] 제어/이스케이프(기능) 문자 
			// \" : "출력   		\' : '출력    	\\ : \출력    
			// \t : 들여쓰기		\n : 줄바꿈		\r : 캐리지 리턴[커서 맨앞으로]
			// 엔터 : \n\r
		System.out.println(" \" ");
				// " : 문자열  , 
		System.out.println(" \' "); // ' : 문자
		System.out.println(" \\ ");
		System.out.println("\t");
		System.out.println("\n줄바꿈");
		System.out.println("\r캐리지 리턴");
	} // main e 
} // class e 

/*
	타입/자료형 : 데이터 저장할때 사용되는 메모리 크기
	 	1. 메모리 효율성 높일수 있다.
	 	2. 가독성 높음
	 	
	 				메모리크기			허용범위
		논리타입	
			boolean	1비트				false[0] / true[1] 
		문자타입		
			char	2바이트			[ 0 ~ 65535 ] 유니코드 
			*문자열 = 기본타입x
			String 	클래스[글자수다름]	제한없음.
		정수형타입		
			byte	1바이트 			[ -128 ~ 127 ]		대략 +-100정도
			short	2바이트			[ -32,768 ~ 32,767 ] 대략 +-3만정도
			*int	4바이트			[ 대략 +-21억 정도 ]
			long 	8바이트			[ 대략 +- 21억이상 정도 ]
		실수타입		
			float	4바이트			소수점 8자리 표현 
			*double	8바이트			소수점 17자리 표현
	
	ex) 
		- 선물상자 = 변수 / 사탕 = 데이터 
		500상자 엄마꺼 = 지갑선물
		500상자 아빠꺼 = 시계선물
		
		
	// 표현단위 : 진수 : 데이터 표현하는 수의 형식 // 기계어[2진수/이진코드] 표현하는데 한계 극복
	// 0,1 : 2진수  , 0~7 : 8진수 , 0~9 : 10진수 , 0~9ABCDEF : 16진수 
	
	// 용량단위 : 
	 	(처리최소단위)비트 : 0,1 -> 1bit		-> 01010101 -> 8자리 -> 8bit -> 1byte
	 	(저장최소단위)바이트 : 1byte -> 1024byte -> 1Kbyte
	 	킬로바이트 : 1kb -> 1024kb -> 1mb
	 	메가바이트 : 1mb -> 1024mb -> 1gb
	 	
 	// 인코딩 : 2진수를 문자로 표하는 방법 
 	 	컴퓨터 : 010101010101 --> 사람 : ??????????????
 	 	컴퓨터 : 10000001 --> 규칙/패턴/해독 (인코딩) ---> A
 	 	
 	 		미국 <----------- 전자기기 -----------> 한국 
 	 											Hello
 	 						1001000	H
 	 						1100101	e
 	 		He <-------------
 	 						
 	 	아스키코드 : 7비트(확장8비트) -> 128문자 표현	1바이트 = 특수문자/숫자/영문
 	 	유니코드 : 전세계 공용어 문자 표현				2바이트 = 특수문자/숫자/영문/한글
*/









