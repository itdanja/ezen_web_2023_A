package 과제.과제2.Level1.모범답안;

public class level1_5 {

	
	public static void main(String[] args) {
		System.out.println(" >> Level1_5 answer >> \n");
		
		byte value1 = 100;				
		short value2 = 30000;			
		int value3 = 2000000000;		
		long value4 = 40000000000L;		
		float value5 = 3.123123123F;
		
		/* 문제풀이 위치 */
		
		short s_value = value1; // byte -> short 저장
		System.out.println( "byte -> short : " + s_value );
		
		int i_value = value2; // short -> int 저장
		System.out.println( "short -> int : " + i_value );
		
		long L_value = value3; // int -> long 저장
		System.out.println( "int -> long : " + L_value );
		
		float F_value = value4; //long -> float 저장
		System.out.println( "long -> float : " + F_value );
		
		double D_value = value5; // float -> double 저장
		System.out.println( "float -> double : " + D_value );
		
		
		
	
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 5개 선언되어 있습니다. 그림과 같이 자동 형변환을 하여 출력하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 자동 형변환 만 사용하여 그림과 같이 출력합니다.
		
*/
	
	
