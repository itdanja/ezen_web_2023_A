package java2.day23_멀티스레드2.Ex3;

public class Calculator { // 계산기 
	private int memory; 	// 필드 
	// 메소드 
	public int getMomory() { return memory; }
	
	// 1. 메소드 동기화 하는 방법 : 메소드 선언부 키워드 synchronized
	//public void setMomory1( int memory ) { // 메소드
	public synchronized void setMemory1( int memory ) { 
		// 동기화메소드 : 해당 메소드를 여럿 스레드가 호출시 대기상태
		// 1. 매개변수를 들어온 값을 필드에  저장 [ setter ]
		this.memory = memory; 
		// 2. 현재 스레드를 2초간 일시정지
		try { Thread.sleep(2000); }catch (Exception e) { }
		// 3. 2초 후 필드 값 확인 
		System.out.println( Thread.currentThread().getName()  +"요청한 2초 후 저장된 메모리 : " + this.memory ); 
	}
	// 2. 메소드내 특정 블록에서만 동기화 하는 방법  : synchronized(this){ }
	public void setMemory2( int memory ) {
		System.out.println( Thread.currentThread().getName()  + " : 비동기화 구역");
		synchronized(this) { // 현재 객체 잠금 
			System.out.println(Thread.currentThread().getName()  + " : 동기화 구역");
			this.memory = memory;
			try { Thread.sleep(2000); }catch (Exception e) { }
			System.out.println( Thread.currentThread().getName() 	+"요청한 2초 후 저장된 메모리 : " + this.memory ); 
		}
	}
}








