package java2.day25_제네릭2.Ex1;

public class Ex1_제한된타입파라미터 {
	// p. 582 
	// - 제네릭 메소드 정의 [ 제한된 타입 파라미터 ]
		// < T extends Number > : Number클래스 포함해서 Number 자손클래스의 객체들만 허용 
	public static < T extends Number > boolean compare( T t1 , T t2 ) {
		// - 매개변수 타입 확인 
		System.out.println( t1.getClass().getSimpleName() );
		System.out.println( t2.getClass().getSimpleName() );
		-
		double v1 = t1.doubleValue();	System.out.println( v1 );
		double v2 = t2.doubleValue();	System.out.println( v2 );
	
		return ( v1 == v2 );		
	
	} // f end 
	
	public static void main(String[] args) {
		// - 제네릭 메소드 사용 
		boolean result1 = compare( 10 , 20 ); System.out.println( result1 );
		boolean result2 = compare( 4.5 ,4.5); System.out.println( result2 );
		// String result3 = compare("안녕", "하세요"); // 오류발생 : Number 클래스 자손 아니므로 불가능 
		
		Integer i = 3; 		// Integer클래스는 Number 클래스의 자손 
		Double d = 3.0;		// Double클래스는 Number 클래스의 자손
		String s = "aa";	// String클래스는 Number 클래스의 자손 아니다.[X]
		
	} // f end 
}
/*
 	제네릭 : 결정되지 않은 타입을 파라미터로 처리하고 실제 사용할때 파라미터를 구체적인 타입으로 대체
 		1. < > : 파라미터 이름은 알파벳 대문자 A~Z 
 		2. 사용처
 			1. 클래스 : public class 클래스명 < T > { }
 					 
 					 -- 1. 클래스 정의시 
 					 public class 클래스명 < T > { 
 					 	T t;
 					 }
 					 
 					 -- 2. 객체 생성시 
 					 클래스명< Integer > 객체명 = new 생성자<>();
 					 
 			2. 메소드 : public < T > 리턴타입 메소드명( ) { } 
 			
 					-- 1. 메소드 정의
 					public < T > int 메소드명( T t ) { 
 						int value = t;
 						return value;
 					} 
 					
 					-- 2. 메소드 호출 
 					메소드명( 100 );
 					
 */






