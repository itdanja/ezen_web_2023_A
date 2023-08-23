package java2.day24_제네릭.Ex2;

public class Ex2_제네릭 {
	public static void main(String[] args) {
		
		// 1. Proudct 객체 만드는데.. tv 객체를 가지고 
			// 1. product객체 만들때. 필드에 사용할 타입 구체적으로 대입 
		Product< Tv, String> product1 = new Product<>( );
			// 2. product객체[ Tv kind = null ; String model = null ; ] * 필드의 초기값 = 정수0실수0.0boolean false 클래스null
		product1.setKind( new Tv() );
		product1.setModel( "스마트Tv");
			// 3. product객체[ Tv kind = new Tv() ; String model = "스마트Tv" ; ]
		Tv tv = product1.getKind();	
		String tvModel = product1.getModel();
		
			// ---------------------- product객체<Tv,String>  --->  product객체<Car , String>
		// 다른 제네릭 타입의 객체 생성하고 싶을때는 -> 객체 생성 
		// 2. Proudct 객체 만드는데.. Car 객체를 가지고 
			// 1. product객체 만들때. 필드에 사용할 타입 구체적으로 대입 
		Product< Car, String > product2 = new Product<>(); // 2. product객체[ Car kind = null ; String model = null ; ]
		product2.setKind( new Car() );
		product2.setModel( "SUV자동차" );	// 3. product객체[ Car kind = new Car() ; String model = "SUV자동차"; ]
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
		
	}
}
