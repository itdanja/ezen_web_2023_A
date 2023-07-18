package 과제.과제2.Level1.모범답안;

import java.time.LocalDateTime;
import java.util.Scanner;

public class level1_3 {
	
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
	
		/* 문제풀이 위치 */
         
		System.out.print("input boolean :" ); boolean a = scanner.nextBoolean();
		System.out.print("input byte :");  byte b = scanner.nextByte();
		System.out.print("input char : " ); String c = scanner.next();
		System.out.print("input short : "  ); short d = scanner.nextShort();
		System.out.print("input int : " ); int e = scanner.nextInt();
		System.out.print("input long : "  ); long f = scanner.nextLong();
		System.out.print("input float : "); float g = scanner.nextFloat();
		System.out.print("input double  : "); double i = scanner.nextDouble(); 
		
		
	    System.out.println("output boolean :"  + a); 
	    System.out.println("output byte :"  + b);
		System.out.println("output char : " + c );
		System.out.println("output short : " + d );
		System.out.println("output int : " + e );
		System.out.println("output long : "  + f );
		System.out.println("output float : " + g);
		System.out.println("output double  : " + i);
		
		
		
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. print() 메소드 사용
		3. scanner 객체 사용하여 입력받기
*/


