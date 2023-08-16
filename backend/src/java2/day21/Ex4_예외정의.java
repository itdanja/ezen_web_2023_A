package java2.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex4_예외정의 {
	public static void main(String[] args)  {

		// 
		Account account = new Account();
		
		account.deposit( 10000 );
		System.out.println( account.getBalance() );
		
		try {
			account.withdraw( 5000 );
		}catch ( 잔고부족예외 e) {
			System.out.println( e );
		}
		
		try {
			account.withdraw( 20000 );
		}catch ( 잔고부족예외  e) {
			System.out.println( e );
		}
	}
}
