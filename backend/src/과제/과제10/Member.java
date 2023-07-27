package 과제.과제10;

public class Member {
	// 1. 필드/속성 : 객체의 데이터를 저장하는 곳 = 인스턴스 vs 정적멤버static
	String id; 
	String pw ;
	String name;
	String phone;
	int age ;
	// 2. 생성자 : 객체의 초기화를 담당 역할 = 인스턴스 vs 정적멤버static
		// 1. 빈생성자
	public Member() { } 
		// 2. 모든 필드를 저장하는 풀생성자
		// 클래스내 빈공간을 오른쪽클릭 -> Source -> Generate Constructor using Fields -> 모든 필드 체크후 생성
	public Member(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
		// 3. 특정 개수 필드를 저장하는 생성자 -> 추후에 필요하면 선언

	// 3. 메소드 : 객체의 행동을 담당 역할 = 인스턴스 vs 정적멤버static
		// 1. setter or getter
		// 2. toString : 객체호출시 객체의 주소가 아닌 필드의 값을 반환해주는 함수 [ * 개발자가 객체 상태 검사용 ]
		// 클래스내 빈공간을 오른쪽클릭 -> Source -> Generate ToString() -> 모든 필드 체크후 생성
	@Override
	public String toString() { // 객체의 주소값 대신 필드 문자형식으로 반환
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
}

/*

	JVM : 자바 가상(논리적으로 만들어낸) 메모리
		Member.java-----클래스로더----> Member.class ---------> 메소드영역						스택영역			힙영역
		자바 코드파일					바이트코드파일					클래스 코드,메소드 코드,			{ }				new
																정적(static)멤버								this
	
	- 키워드 
		this			: 인스턴스멤버 : new 힙 생성시 할당 되고 힙 초기화될때[ GC ] [ 공용X , 각각 ]
							- static 키워드 없으면
							- 객체를 통해 사용  
		static			: 정적멤버 : 프로그램 시작 할당 되고 프로그램이 종료될때 [ 전역 / 공통 / 공용 / 공유 ]
							- static 키워드 있으면
							- 클래스 통해 사용 
		final 			: 수정불가 : 초기화할때 대입만 가능하고 수정 불가능 
		static final 	: 상수 : 프로그램내에서 1개만저장(static) 수정불가능(final) 합친 키워드
*/









