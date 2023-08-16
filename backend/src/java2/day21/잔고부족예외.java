package java2.day21;

// 예외 클래스 만들기 
	// 표준 라이브러리(미리 만들어서 제공된 클래스/인터페이스)에서 제공하지 않는 예외클래스를 만들기 가능 
	// 1. Exception 클래스 상속 
	// 2. 생성자에 예외가 발생한 이유/사유를 매개변수로 받아서 상속받은 Exception객체 에게 전달	
		// this : 현객체 . super : 현객체의 부모객체
	// 3. 예외발생 : throw new 예외클래스명( 예외사유 );
public class 잔고부족예외 extends Exception  { // 또는 extends RuntimeException
	
	// 기본생성자 
	public 잔고부족예외() { }
	// 매개변수1개 생성자 : 예외 정보를 받기 위함의 매개변수
	public 잔고부족예외( String message ) { super(message); }
}
