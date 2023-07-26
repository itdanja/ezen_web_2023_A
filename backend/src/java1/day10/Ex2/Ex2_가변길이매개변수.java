package java1.day10.Ex2;

public class Ex2_가변길이매개변수 {
	
	public static void main(String[] args) {
		
		// 1. 다른 클래스에 있는 메소드를 호출하기 위한 객체 생성 
		Computer myCom = new Computer();
		
		// 2. 3개 인수로 전달
		System.out.println( myCom.sum( "유재석" , 1 , 2 , 3) );
		
		// 3. 5개 인수로 전달
		System.out.println( myCom.sum( "유재석" , 1 , 2 , 3 , 4 , 5) );
		
		// 4. 배열1 전달
		int[] values = { 1 , 2 , 3 , 4 , 5 };
		System.out.println( myCom.sum( "유재석" , values ) );
		
		// 5. 배열2 전달
		System.out.println( myCom.sum( "유재석" , new int[]{ 1 , 2 , 3 , 4 , 5 } ) );
		
		
		// 2. 3개 인수로 전달
			// System.out.println( myCom.sum2( "유재석" , 1 , 2 , 3) );
		
		// 3. 5개 인수로 전달
			// System.out.println( myCom.sum2( "유재석" , 1 , 2 , 3 , 4 , 5) );
		
		// 4. 배열1 전달
		int[] values2 = { 1 , 2 , 3 , 4 , 5 };
		System.out.println( myCom.sum2( "유재석" , values2 ) );
		
		// 5. 배열2 전달
		System.out.println( myCom.sum2( "유재석" , new int[]{ 1 , 2 , 3 , 4 , 5 } ) );
		
		
		
	} // m end 
} // c end 
