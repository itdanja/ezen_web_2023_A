import java.util.ArrayList;
import java.util.Arrays;

public class 배열리스트차이 {

	public static void main(String[] args) {
		// 배열 : 여러개의 데이터를 저장하는 공간  [ 저장할 개수가 딱 정해져 있을때 ]
		// - 선언 
		int[] intArray = new int[5];	// int 5개  => 고정길이 
			// -저장 [ ] 
			intArray[0] = 30; intArray[1] = 40; intArray[2] = 50; intArray[3] = 60; intArray[4] = 70;
			System.out.println( Arrays.toString( intArray ) );
			// -호출 [ ]
			System.out.println( intArray[0] );
			// -데이터개수체크 .length
			System.out.println( intArray.length );
			// - 배열내 데이터를 하나씩 순회
			for( int i = 0 ; i < intArray.length ; i++ ) { System.out.println( intArray[i] ); }
			
		// 리스트 : 여러개의 데이터를 저장하는 공간 	[ 저장할 개수가 정해져 있지 않을떄 ]
		// - 선언
		ArrayList<Integer> intList = new ArrayList<>();	 // 자동  => 가변길이  
			// - 저장 .add 
			intList.add( 30 ); intList.add( 40 ); intList.add( 50 ); intList.add( 60 ); intList.add( 70 );
			System.out.println( intList );
			// - 호출 .get
			System.out.println( intList.get(0) );
			// -데이터개수체크 .size()
			System.out.println( intList.size() );
			// - 리스트내 데이터를 하나씩 순회
			for( int i = 0 ; i < intList.size() ; i++ ) { System.out.println( intList.get(i)); }
	}
}





