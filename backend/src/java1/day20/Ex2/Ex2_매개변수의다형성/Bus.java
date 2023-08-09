package java1.day20.Ex2.Ex2_매개변수의다형성;

public class Bus implements Vehicle {
	@Override public void run() { 
		System.out.println("버스가 달립니다."); 
	}
}
