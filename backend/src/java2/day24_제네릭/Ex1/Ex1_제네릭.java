package java2.day24_제네릭.Ex1;

import 과제.과제11.model.dto.MemberDto;

public class Ex1_제네릭 {
	public static void main(String[] args) {
		
		/* 목적 : 하나의 필드에 여러 타입의 데이터를 저장하고 싶을때. */
		
		// 1. [ 570p.] 제네릭 을 사용하지 않을때. => Object
		Box2 box2 = new Box2();
		// 1. 자식객체는 부모객체로 대입 [ 자동타입변환 ] : 무조건 가능 
			//box2.content = 1;	// 1[int] --> Object[최상위클래스]
			//box2.content = "안녕"; // "안녕"[String] --> Object[최상위클래스]
		box2.content = new MemberDto(); // Dto[객체] --> Object[최상위클래스]
		// --------------------------------- //
			// box2.content.getMpw();
		// 2. 부모는 자식의 멤버를 사용할수 없다. [ 형변환 ] : 부모 -> 자식 [ 강제타입변환 ]
			// 강제타입변환 하는방법 2가지
				// 1. 타입 알고 있을떄 (형변환할타입)
		MemberDto dto = (MemberDto)box2.content;
		dto.getMpw();
				// 2. instanceof 타입 조사후 사용
		if ( box2.content instanceof MemberDto ) { }
		
			// 권장하지 않는 방법!!! 
		
		// 2. [ 572p.] 제네릭을 사용할때. 
		Box<String> box1 = new Box<>();
			// 1. Box 클래스에 넣을 타입 선정 < > 
				// String content;
		box1.content = "안녕하세요.";
		String str = box1.content;
		System.out.println( str );
		
		Box<Integer> box3 = new Box<>();
			// 1. Box 클래스에 넣을 타입 선정 < > 
				// Integer content;
		box3.content = 100;
		int value = box3.content;
		System.out.println( value );
		
		// --------------------------- //
		
		Box<MemberDto> box4 = new Box<>();
				// MemberDto content;
		box4.content = new MemberDto();
		MemberDto dto2 = box4.content;
		System.out.println( dto2 );
		
		
		
	}
}













