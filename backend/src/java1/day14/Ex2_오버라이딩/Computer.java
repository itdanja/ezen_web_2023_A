package java1.day14.Ex2_오버라이딩;

public class Computer extends Calculator {
			// 자식클래스 extends 부모클래스
			// - 자식클래스에서 부모클래스의 멤버(필드,생성자,메소드) 를 사용할수 있다.
	// 1. 필드
	// 2. 생성자
	// 3. 메소드
		// 부모클래스[Calculator]에게 상속받은 메소드를 재정의
		// - 컨트롤 스페이바
		// 오버라이딩 : 자식클래스는 부모클래스로부터 메소드를 물려 받았기 때문에..
			// 자식클래스에서 부모클래스와 동일한 이름으로 메소드를 선언 불가능.
			// 동일한 이름으로 선언하고 매개변수[개수,타입,순서] 다르면 => 오버로딩	[ 새로운 선언 ]
			// 동일한 이름으로 선언하고 매개변수[개수,타입,순서] 모두 동일하면 => 오버라이딩[ 재정의 ]
	@Override
	public double areaCircle(double r) {
		// 선언부는 동일하되 { } 안에 있는 코드를 재정의[리모델링]
		System.out.println("Computer areaCircle 메소드 실행 ");
		return Math.PI * r * r;
	}
}












