package java1.day20.Ex2.Ex2_매개변수의다형성;

public class Ex2_실행 {
	public static void main(String[] args) {
		// 0. 
		Driver driver = new Driver();
		// 1. 부모객체 
		//Vehicle vehicle = new Vehicle();
		//	System.out.println("------------> 1.차량대입 ");
		//	driver.drive( 3 , vehicle );  	// 객체의 타입[Vehicle] 매개변수 타입[Vehicle]	 타입이 일치해서 가능 
		// 2. 자식객체 
		Bus bus = new Bus();
			System.out.println("------------> 2.버스대입 ");
			driver.drive( 5  , bus );  		// 객체의 타입[Bus] 매개변수의 타입[Vehicle]		타입이 불일치인지 가능..
		// 2. 자식객체
		Taxi taxi = new Taxi();
			System.out.println("------------> 3.택시대입 ");
			// driver.drive( "안녕" , taxi );	// 매개변수의 타입 불일치 불가능 
			driver.drive( 3 , taxi );		// 매개변수의 타입 불일치 불가능 [ * 단 부모-자식 관계 일때 가능 ]
	}
}

