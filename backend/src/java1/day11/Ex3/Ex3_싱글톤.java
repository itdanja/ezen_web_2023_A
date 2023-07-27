package java1.day11.Ex3;

public class Ex3_싱글톤 {
	public static void main(String[] args) {
		
		// 1. Member 객체 생성
			// 오류 : 생성자를 private 되어 있는 클래스는 외부에서 객체생성 불가능 
		// Member member = new Member();
		
		// [ 두 객체는 다르다 ]
		// Member member3 = new Member();
		// Member member4 = new Member();
		
		// 2. Member 객체 호출 [ 두 객체는 같다. ]
		Member member1 = Member.getInstance();
		Member member2 = Member.getInstance();
		
		System.out.println( member1 == member2 );
		
	}
}
