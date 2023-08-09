package java1.day20.Ex2.Ex1_필드의다형성;

public class HankookTire implements Tire { // 상속 : 자식클래스 extends 부모클래스
	// !오버라이딩 : 부모클래스의 메소드를 물려받았지만 재정의(리모델링)
	@Override
	public void roll() { // 메소드 선언부 그대로 사용
		// super.roll(); // super.메소드() : 부모클래스의 메소드 호출 
		System.out.println("한국 Tire 회전 "); // 새로운 코드 = 재정의
	}
}
