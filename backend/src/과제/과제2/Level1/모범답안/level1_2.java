package 과제.과제2.Level1.모범답안;

import java.time.LocalDateTime;

public class level1_2 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_2 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		System.out.printf("%-10s   %15s   %30s\n" , "type" , "value" , "range" );
		System.out.println("-------------------------------------------------------------");
		
		
		
		
		/* 문제풀이 위치 */
		
		boolean a = true;
        byte b = 100;
        char c = 'A';
        short d = 30000;
        int e =  2000000000;
        long f = 40000000000L;
        float g = 3.1231232f;
        double i = 3.123123123; 
        		
		
		System.out.printf( "%-10s   %15s   %30s\n" , "boolean" , a ,  "true or fasle");
		System.out.printf( "%-10s   %15s   %30s\n" , "byte" , b ,  "- 128 ~ 127");
		System.out.printf( "%-10s   %15s   %30s\n" , "char" , c ,  "0~65535 [ character1 ]");
		System.out.printf( "%-10s   %15s   %30s\n" , "short" , d ,  "-32768 ~ 32767");
		System.out.printf( "%-10s   %15s   %30s\n" , "int" , e ,  "-+2000 million");
		System.out.printf( "%-10s   %15s   %30s\n" , "long" , f ,  "-+2000 million Exess");
		System.out.printf( "%-10s   %15s   %30s\n" , "float" , g ,  "8 decimal palces");
		System.out.printf( "%-10s   %15s   %30s\n" , "double" , i ,  "17 decimal places");
		
		
		
		/* ----------- */
		
		
		
		
	}
}




/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개 선언하고 임의값을 대입하여 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. printf() 메소드 사용
*/

