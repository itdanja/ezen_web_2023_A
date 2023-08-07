package java1.day18.Ex1;

public class Audio implements RemoteControl {
	
	// 필드
	private int volume; // 인스턴스 필드
	
	@Override
	public void turnOn() {
		System.out.println("오디오 켭니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("오디오 끕니다.");
	}
	
	@Override
	public void setVolume(int volume) {
		if( volume > RemoteControl.MAX_VOLUME ) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if( volume < RemoteControl.MIN_VOLUME ) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else { this.volume = volume; }
		System.out.println("현재 오디오 소음 : "+ this.volume );
	}
}
