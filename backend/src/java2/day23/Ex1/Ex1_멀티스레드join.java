package java2.day23.Ex1;

public class Ex1_멀티스레드join {
	
	public static void main(String[] args) {
		// main스레드가 main함수 호출
		System.out.println("현재스레드 : " + Thread.currentThread().getName() );
		
		// 1. [main스레드] 작업 스레드객체 생성 [ main 외 추가적으로 작업스레드 생성 ]
		SumThread sumThread = new SumThread();
		// 2. [main스레드] 작업 스레드 실행 => 대기상태 => CPU스케줄링 => 실행 => 대기상태 => 대기 => 실행 
		sumThread.start();
		
		// 3. [main스레드] 작업 스레드 객체 의 필드 확인 
		// - 작업스레드가 1~100까지 계산이 끝나기전에 main스레드가 결과 먼저!! 출력 
		System.out.println("[JOIN 하기전 ]1~ 100 합 : " + sumThread.getSum() );
		
		try { sumThread.join(); // 합친다.. [ 작업스레드르르 호출한 스레드는 일시정지 상태 ]
			// main스레드가 sumThread스레드의 join 메소드를 호출했기 때문에	main 스레드 일시정지
			// sumThread스레드가 종료되면 main스레드 일시정지 풀림.
		}catch (Exception e) {}
		System.out.println("[JOIN 했을때 ]1~ 100 합 : " + sumThread.getSum() );
		
	}
	
}
/*
 
 	함수를 호출하는 방법 [ 내부 객체에서 ]
 		메소드명()
 		this.메소드명()
 		super.메소드명()
 		
 	함수를 호출하는 방법 [ 외부 객체에서 ]
 		
 		1. 인스턴스 함수[static 아닌 함수 ]
 			클래스명 객체명 = new 생성자();
 			객체명.함수명();
		
		2. 정적 함수[static 함수]
			클래스명.함수명();
		
		3. 싱글톤
		 	클래스명.getInstance().메소드명()
		 	
	 	4. main함수??
	 		X -> 모든 자바 프로그램에서는 main스레드가 main함수 최초로 1번 호출
			
		
 
  
 */