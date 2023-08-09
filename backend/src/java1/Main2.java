package java1;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 
		 for( int i = 0 ; i<n ; i++ ) {
			 int m = sc.nextInt();
			 int[] arr = new int[m]; System.out.println( Arrays.toString(arr) );
			 for( int j = 0 ; j<arr.length ; j++ ) {
				 arr[j] = sc.nextInt();
			 }
			 System.out.println( Arrays.toString(arr) );
			 
			 int sum = arr[0];
			 int plusMinus = sum >= 0 ? 1 :  -1 ;
			 
			 for( int j = 1 ; j<arr.length ; j++ ) {
				 sum+=arr[j];
				 System.out.println("구간의 합 : " + sum);
				 plusMinus += sum >= 0 ? 1 :  -1 ;
				 System.out.println("구간의 양음수 : " + plusMinus );
			 }
			System.out.println( plusMinus >= 0 ? "yes" : "no" );
		 }
	}
}
