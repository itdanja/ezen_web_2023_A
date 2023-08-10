package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 int n = Integer.parseInt( br.readLine( ) );

		 for( int i = 0 ; i<n ; i++ ) {
			
			 int m = Integer.parseInt( br.readLine( ) );
			 
			 String[] arr = br.readLine().split(" ");
			 
			 int sum = Integer.parseInt( arr[0] );
			 int plusMinus = sum >= 0 ? 1 :  -1 ;

			 for( int j = 1 ; j<m ; j++ ) {
				 sum+=Integer.parseInt(arr[j]);
				 plusMinus += sum >= 0 ? 1 :  -1 ;
			 }
			System.out.println( plusMinus >= 0 ? "YES" : "NO" );
			
		 }
	}

}