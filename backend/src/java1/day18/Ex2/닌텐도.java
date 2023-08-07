package java1.day18.Ex2;

import java.util.Scanner;

public class 닌텐도 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 1. 게임패드 생성 
		게임패드 유재석패드 = null;
		
		while(true) {
			System.out.println("1.동물의숲 2.커비");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) {
				유재석패드 = new 동물의숲칩();
				System.out.println("동물의숲 시작");
			}else if( ch == 2 ) {
				유재석패드 = new 커비칩();
				System.out.println("커비 시작");
			}
			
			while( true ) {
				String btn = scanner.next();
				if( btn.equals("A") ) 유재석패드.A버튼(); 
				if( btn.equals("B") ) 유재석패드.B버튼(); 
				if( btn.equals("X") ) 유재석패드.X버튼(); 
				if( btn.equals("Y") ) 유재석패드.Y버튼();
				if( btn.equals("Q") ) break; 
			}
			
		} // while e 
	} // main e 
} // class e 
