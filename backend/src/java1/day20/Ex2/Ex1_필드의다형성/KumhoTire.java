package java1.day20.Ex2.Ex1_필드의다형성;

public class KumhoTire implements Tire { // 상속받으면 자식클래스에서 부모클래스의 멤버(필드,생성자,메소드) 사용할수 있다.
	@Override
	public void roll() { 
		System.out.println("금호 Tire 회전 "); 
	}
}
