package 과제.과제5.Level3.ex6;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_6 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_6 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		String quiz = "동해물과 백두산이"; 
		System.out.println( quiz );
		/* 문제풀이 위치 */
		
		String input = scanner.nextLine();
		int 맞은개수 = 0;
		for( int i = 0 ; i<quiz.length() ; i++ ) {
			if ( quiz.charAt(i) == input.charAt(i) ) { 맞은개수++;}
		}
		System.out.println();
		
		/* ----------- */

	}
}
/* 
	[문제] 띄어쓰기가 포함된 1개 문자열이 존재합니다. 문자열을 입력받아 quiz 변수내 문자열과 동일한 글자수가 몇개인지 출력하시오. 
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. .charAt() : 함수를 활용합니다.
*/
