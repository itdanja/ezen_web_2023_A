package java1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 
		 for( int i = 0 ; i<n ; i++ ) {
			 int m = sc.nextInt();
			 int[] arr = new int[m];
			 for( int j = 0 ; j<arr.length ; j++ ) {
				 arr[j] = sc.nextInt();
			 }
			 int sum = arr[0];
			 int plusMinus = sum >= 0 ? 1 :  -1 ;
			 
			 for( int j = 1 ; j<arr.length ; j++ ) {
				 sum+=arr[j];
				 plusMinus += sum >= 0 ? 1 :  -1 ;
			 }
			System.out.println( plusMinus >= 0 ? "yes" : "no" );
		 }
	}
}
