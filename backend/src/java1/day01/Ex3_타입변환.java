package java1.day01;

public class Ex3_타입변환 { // class s 
	
	public static void main(String[] args) { // main s
		
		// 1.[p.53] 자동 타입 변환 : byte->short->int->long->float->double
		byte b1 = 10;	// -128 ~ 127 까지 저장 가능 한 변수에 10 저장 
		int i1 = b1;	// byte변수를 int변수에 대입 [ 자동 ]
		
		char c1 = '가';	// 0~65000 까지 저장 가능 한 변수에 '가' 저장 
		i1 = c1;		// char변수를 int변수에 대입 [ 자동 ]
		
		int i2 = 50;	long l1 = i2;	// int --> long [ 자동 ]
		long l2=100;	float f1 = l2;	// long --> float [ 자동 ]
		float f2=10.5f;	double d1 = f2;	// float --> double [ 자동 ]
		
		// 2.[p.55] 강제 타입 변환 : byte<-short<-int<-long<-float<-double
		int i3 = 10;		byte b2 = (byte)i3;			// (byte) int -> byte 	[ 강제 ]
		long l3 = 300;		int i4 = (int)l3;			// (int) long -> int 	[ 강제 ]
		int i5 = 65;		char c2 = (char)i5;			// (char) int -> char	[ 강제 ] 
		double d2 = 3.14;	int i6 = (int)d2;			// (int) double -> int 	[ 강제 ]
		
	} // main e 

} // class e 

/*
 		타입/자료형 변환 
 			- 허용 범위 순서 
 				byte->short,short->int->long->float->double
 		1. 자동 타입 변환 
 			작은 타입 --> 큰 타입   [ 자동 ]
 			- 큰 허용범위 타입 = 작은 허용범위 타입 
 		
 		2. 강제 타입 변환 
 			큰 타입 --> 작은 타입 [ 수동 ]
 			* 주의 : 데이터 손실 발생 할수 있음 !!! double 31.5 -> int 31
 			- 작은 허용범위 타입 = ( 작은 허용범위타입 )큰 허용범위 타입 
 								 	캐스팅 
 		3. 연산시 자동 타입 변환 
 			- 피연산자 중 큰 타입를 결과타입 반환 
 			정수
 				1. int 보다 작은 byte,short 연산시 무조건 int 결과 
 					byte + byte -> int
 					short + int -> int 
				2. int 보다 큰 허용범위 long 연산시 
					int + long -> long 
					byte + long -> long 
			실수
				float + float -> float 
				float + double -> double 
				
		4. 
			문자열 --> 기본타입 
				- 외부[java외] 에서 데이터가 문자[String]로 들어오는 경우 다수 [ JS->JAVA ]
				"10" : 문자 10		vs 		10 : 정수 10
				
				기본타입 : int 
					int 정수 = 10;		정수.????
				기본타입클래스명 : Integer 	
					Integer 정수 = 10	정수.메소드명() 
					
				* Integer.parseInt( "10" ) ----> 10
				
			기본타입 --> 문자열	
				1. String.valueOf()
					10 ----> "10"		String.valueOf(10)
				2. +""
					10 ----> "10"		10+""			정수+문자열 => 문자열 
									
				
				
				
 								 	
 								 	
 								 	
 								 	
 								 	
 								 	
 								 	
 								 	
 								 	
 								 	
 								 	
 								 	
			 	
  
 */
