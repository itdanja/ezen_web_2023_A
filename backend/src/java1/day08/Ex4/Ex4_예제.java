package java1.day08.Ex4;
// 실행 목적 
public class Ex4_예제 { // class s 
	
	public static void main(String[] args) { // main s 
		
		// 1. Car 객체 선언 : 클래스명 변수명 = new 생성자명();
		Car myCar = new Car();
		
		// 2. 객체를 이용한 객체내필드 호출 [ .접근연산자 ]
		System.out.println( myCar.company );
		System.out.println( myCar.model );
		System.out.println( myCar.model );
		System.out.println( myCar.maxSpeed );
		System.out.println( myCar.speed );
		
		// 3. 필드의 값 변경 
		myCar.speed = 60;
		System.out.println("수정된 속도 : "+myCar.speed);
		
		// --
		Car yourCar = new Car();
		System.out.println("수정된 속도 : "+yourCar.speed);
		
		
	} // main e 
} // class e 
