package java1.day20.Ex2.Ex1_필드의다형성;

public class Car {
	// 1.필드 
	public Tire tire;		// Tire 클래스 타입의 필드 선언 [ 객체x ]
	// 2.생성자
	// 3.메소드 
	public void run() { tire.roll(); }
}
