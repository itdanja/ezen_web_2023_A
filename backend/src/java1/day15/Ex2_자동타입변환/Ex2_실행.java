package java1.day15.Ex2_자동타입변환;

public class Ex2_실행 {
	public static void main(String[] args) {
		
		// 1. 부모객체 생성 
		Parent parent = new Parent();	// --> 힙 : Parent객체1개
		
		// 2. 자식객체 생성 [ 자식객체는 힙생성시 부모객체 힙도 생성 ]
		Child child = new Child();		// --> 힙 : Parent,Child객체2개
		
		// 3. (자동타입변환)자식객체를 부모객체에 대입 ????
		Parent parent2 = child;	// 가능 : 자식객체는 부모객체가 될수 있다!!.
		// !! : 자식객체가 부모객체로 대입후에 변환된 부모객체는 자식객체의 멤버 사용할수 없다.
		parent2.method1();	// *단 : 오버라이딩 된 자식 메소드는 사용이 가능하다.
		parent2.method2();
		// parent2.method3();	// 부모객체가 자식객체의 오버라이딩 아닌 메소드는 사용 불가능하다.
		
		// 4. 부모객체를 자식객체에 대입 ????
		// Child child2 = parent;	// 불가능 : 부모객체는 자식객체가 될수 없다!!.
		
		// !! : (강제타입변환) : 캐스팅
		// Parent parent4 = new Parent(); 
		// Child child2 = (Child)parent4; // 실행 과정 오류 발생 
		
		Parent parent3 = new Child();	// 자동 타입 변환후에 강제 타입변환 가능하다.
		Child child3 = (Child)parent3;	// *단 : 강제 캐스팅을 이용한 형변환 가능 
		// !! : 부모객체가 자식객체로 대입후에 변환된 자식객체는 부모객체의 멤버 사용할수 있다.
		child3.method1();
		child3.method2();
		child3.method3();
	}
}
