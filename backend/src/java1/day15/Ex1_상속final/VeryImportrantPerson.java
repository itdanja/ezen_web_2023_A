package java1.day15.Ex1_상속final;

public class VeryImportrantPerson extends Member {
			// 자식클래스 extends 부모클래스	public class Member{} 		: 상속 가능 
			//							public final class Member{} : 상속 불가능 =
	@Override
	public void stop1() {	// stop1메소드는 final 키워드가 없으므로 오버라이딩 가능 
		// TODO Auto-generated method stub
		super.stop1();
	}
	@Override
	public void stop2() {	// stop2메소드는 final 키워드가 있으므로 오버라이딩 불가능 [ 오류발생 ]
		// TODO Auto-generated method stub
		super.stop2();
	}
	
	
			
}
