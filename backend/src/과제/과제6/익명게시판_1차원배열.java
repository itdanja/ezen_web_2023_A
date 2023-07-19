package 과제.과제6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class 익명게시판_1차원배열 { // class s // step5 : 문자열 분리[split]해서 출력하기 
	public static void main(String[] args) throws Exception  { // main s  
		Scanner scanner = new Scanner(System.in); 
		
		String[] boards = new String[100];
		
		while( true ) {
			
			System.out.println("------------------ 게시물 목록 ---------------------");
			System.out.printf( "%2s %10s%5s\n" , "번호" , "제목"  , "작성자" );
			//*[행마다] 열 기준 자르기
			for( int i = 0 ; i<boards.length ; i++ ) {
				// * 게시물 마다 열 자르기 
				if( boards[i] != null ) {
					String[] cols =  boards[i].split(","); // 4조각 
					String title = cols[0];		String content = cols[1];
					String writer = cols[2];	String password = cols[3];
					System.out.printf( "%2d %10s%5s\n" , i , title  , writer );
				}
			}	
			System.out.println("-----------------------------------------------");
			
			System.out.print(" 메뉴> 쓰기[1]  삭제[2]  : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				System.out.print(" 제목 : ");	String title = scanner.next();
				System.out.print(" 내용 : ");	String content = scanner.next();
				System.out.print(" 작성자 : ");	String writer = scanner.next();
				System.out.print(" 비밀번호 : ");	String password = scanner.next();
				
				String outStr = title+","+content+","+writer+","+password+"\n";
					
				for( int i = 0 ; i<boards.length ; i++ ) {
					if( boards[i] == null ) {
						boards[i] = outStr; break;
					}
				}	

			} 
			else if( ch == 2 ) { break; }
		} // while e
	} // main e 
} // class e 






