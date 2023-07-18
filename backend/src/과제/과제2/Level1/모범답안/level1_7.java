package 과제.과제2.Level1.모범답안;

import java.time.LocalDateTime;
import java.util.Scanner;

public class level1_7 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_7 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		String output = "";
		
		/* 문제풀이 위치 */
		
		System.out.print( " 회원명  String : "); String name = scanner.next();
		System.out.print( " 상태 boolean :  "); boolean state = scanner.nextBoolean();
		System.out.print( " 회원번호 byte : ");   byte number = scanner.nextByte();
		System.out.print( " 성별 char : ");   char gender = scanner.next().charAt(0);
		System.out.print( " 나이 short : ");   short age = scanner.nextShort();
		System.out.print( " 포인트 int  : ");  int point = scanner.nextInt();
		System.out.print( " 예금액 long : ");   long savings = scanner.nextLong();
		System.out.print( " 키 float : ");     float ki = scanner.nextFloat();
		System.out.print( " 몸무게 double : ");  double kgs = scanner.nextDouble();
		
        System.out.println();
		
		
         
		output = " ============회원  개인정보=========\r\n"
				+"|      회원명 :" +name+ "\t\t"+      "|\r\n"
				+"|      상태 :" +state+ "\t\t\t" +     "|\r\n"
				+"|      회원번호 :" +number+"\t\t"+   "|\r\n"
				+"|      성별 :"  +gender+"\t\t\t"+     "|\r\n"
				+"|      나이 :"   +age+ "\t\t\t"+      "|\r\n"
				+"|      포인트 :" +point+ "\t\t"+     "|\r\n"
				+"|      예금액 :" +savings+"\t\t"+   "|\r\n"
				+"|      평균 :"  + ki+ "\t\t\t" +      "|\r\n"
				+"|      평균 :"  + kgs+ "\t\t" +     "|\r\n"
				+ " ================================";
		System.out.println( output );
		
		
		/* ----------- */
		
		
	}
}

/* 
	[문제조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 기본 자료형8개 + 문자열클래스 변수 1개 를 이용한 9개변수를 입력 받습니다.
		3. 입력받은 9개 변수를 그림과 같이 출력합니다.
		4. 기존에 미리 작성된 변수를 최대한 활용합니다.
		
*/

