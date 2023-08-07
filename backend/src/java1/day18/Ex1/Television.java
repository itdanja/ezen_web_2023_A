package java1.day18.Ex1;

public class Television implements RemoteControl {
	
	// 필드
	private int volume; // 인스턴스 필드
	
	// 추상메소드 구현 : implements 인터페이스명 를 하게 되면 해당 인터페이스의 추상메소드 모두 구현
	@Override
	public void turnOn() { 
		System.out.println("텔레비전 켭니다."); 
	}
	
	@Override
	public void turnOff() {
		System.out.println("텔레비전 끕니다.");
	}
	
	@Override
	public void setVolume(int volume) {
		if( volume > RemoteControl.MAX_VOLUME ) {
			// 만약에 볼륨이 최대볼륨보다 크면 해당 객체는 최대볼륨으로 대입 
			this.volume = RemoteControl.MAX_VOLUME; // this: 해당메소드를 호출한 객체 뜻 
		}else if( volume < RemoteControl.MIN_VOLUME ) {
			// 만약에 볼륨이 최소볼륨보다 작으면 해당 객체의 소음을 최소볼륨으로 대입/설정 
			this.volume = RemoteControl.MIN_VOLUME;
		}else { this.volume = volume; }
		System.out.println("현재 텔레비전 소음 : "+ this.volume );
	}
}







