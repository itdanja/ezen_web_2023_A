package java1.day18.Ex1;

/*
 	JVM 실행 메모리 
 
 	1. 메소드영역			2. 스택영역				3. 힙영역
 	 - 클래스정보			 - 함수{ }내 변수들		 	 - 객체(인스턴스) 
 	 - 메소드											- 필드
 	 - static정적
 	 - 인터페이스정보		 						
 	 	
	class 사람{				사람 유재석 = 102번지		유재석객체( 나이 = 30 )		유재석.밥먹기() => 30
		int 나이;				사람 강호동 = 103번지		강호동객체( 나이 = 40 )		강호동.밥먹기() => 40
		void 밥먹기(){
			print( this.나이 )
		}
	}
	
 
 */

public interface RemoteControl {
	// 1. 상수[ public static final ] 필드 : 프로그램내 수정 불가능한 데이터
		// [ public static final ] int MAX_VOLUME ;
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	// 2. 추상 메소드 : 메소드 선언부 , 메소드 호출하는 방법
		// [ public abstract ] 리턴타입 메소드명(매개변수1, 매개변수2);
	
	// 1. 선언만하는 전원켜기 함수
	public abstract void turnOn();
	// 2. 선언만하는 전원끄기 함수 
	void turnOff();
	// 3. 선언만하는 볼륨조절 함수 
	void setVolume( int volume );
	
}











