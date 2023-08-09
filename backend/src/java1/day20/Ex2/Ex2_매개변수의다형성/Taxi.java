package java1.day20.Ex2.Ex2_매개변수의다형성;

public class Taxi implements Vehicle {
	@Override public void run() { 
		System.out.println("택시가 달립니다."); 
	}
}
