package 과제.과제10;

import java.util.Arrays;
import java.util.Scanner;

public class MemberSys { // class s 
	
	static Scanner sc = new Scanner(System.in); 	// 프로그램내 전역구역에서 공유 사용되는 메모리 = 정적멤버
	// Member[] 객체배열 = new Member[100];			// 1. 인스턴스멤버 	= 힙영역		= new 마다 할당 => n개
	static Member[] memberList = new Member[100];	// 2. 정적멤버		= 메소드영역 	= 프로그램 전체 1개 
	static int loginIndex = -1; 					// 3. 정적멤버		= 메소드영역 	= 로그인을 성공한 인덱스(회원위치) 기억 = 웹 쿠키/세션
	
	public static void main(String[] args) {
		while(true) { // 무한루프
			// * 확인용 
			System.out.println("회원배열(리스트) 상태 : " + Arrays.toString( memberList ) );
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); // 1. 무한 출력
			System.out.print("1.회원가입 2.로그인    선택> ");
			
			// 입력객체의 사용 구역 범위 생각!!!!!! [ 프로그램내 전역구역 = static ]
			int ch = sc.nextInt();
			
			if( ch == 1 ) { MemberSys.회원가입(); } // main함수 밖에 있는 다른 함수 호출 
			// 1. 인스턴스멤버(static없는) 함수는 객체를 생성하고 호출한다.
			// 2. 정적멤버( static있는) 함수는 객체없이 클래스를 통한 호출한다.
			if( ch == 2 ) { MemberSys.로그인(); }
			if( ch == 3 ) { MemberSys.아이디찾기(); }
			if( ch == 4 ) { MemberSys.비밀번호찾기(); 회원가입();  }
			
		} // whine e 
	} // main e 
	
	// 1. 회원가입 함수 : 입력받아 저장 [ Create ]
	static void 회원가입() { 
		// 1. 입력받기 -> 각각 5개 입력받기
		System.out.println("--------- 회원가입 ---------");
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("비밀번호 : ");	String pw = sc.next();
		System.out.print("이름 : ");		String name = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();
		System.out.print("나이 :");		int age = sc.nextInt();
		// 2. 5개 변수를 하나의 객체로 묶음
		Member m = new Member(id, pw, name, phone, age);	// m변수에는 객체 힙 주소 가지고 있음
		// 3. 회원의 1개의 객체를 배열 저장
			// 1. 배열내 빈공간=null 을 찾는다
		for( int i = 0 ; i<memberList.length ; i++ ) {
			if( memberList[i] == null ) { memberList[i] = m; System.out.println("안내)회원가입 성공"); break; }
		} // for end
	} // m end 
	// 2. 로그인 함수 : 입력받아 기존에 데이터와 일치한지 비교 [ Reading ]
	static void 로그인() { 
		System.out.println("--------- 로그인 ---------");
		// 1. 입력받기 -> 각각 2개 입력받기
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("비밀번호 : ");	String pw = sc.next();
		// 2. 입력받은 값이 배열내 존재한지.. 하나씩 꺼내서 찾아내기
		for( int i = 0 ; i<memberList.length; i++ ) {
			if( memberList[i] != null && 				// 1. i번재 인덱스의 값이 null 아니면서 [ 회원이 있는곳만 비교 ]
					memberList[i].id.equals(id) &&		// 2. i번째 인덱스의 회원객체 의 id가 입력한 id와 같고
						memberList[i].pw.equals(pw) ) {	// 3. i번째 인덱스의 회원객체 의 pw가 입력한 pw와 같으면  
				loginIndex = i; // 정적 멤버 변수에 로그인 성공한 인덱스를 넣어두기 -> 추후에 사용할 목적
				break;
			} // if end  
		} // for end 
		// 3. 유효성검사
		if( loginIndex >= 0 ) { System.out.println("안내) 로그인 성공"); }
		else {System.out.println("안내) 로그인 실패 : 아이디 혹은 비밀번호가 일치 하지 않습니다.");}
	} // f end 
	// 3. 아이디찾기 함수 : 입력받아 기존에 데이터와 일치한지 비교 [ Reading ]
	static void 아이디찾기() { 
		System.out.println("--------- 아이디찾기 ---------");
		System.out.print("이름 : "); 		String name = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();
		
		for( int i = 0 ; i<memberList.length ; i++ ) {
			if( memberList[i] != null && memberList[i].name.equals(name) && memberList[i].phone.equals(phone) ) {
					System.out.println("안내) 회원님의 아이디 : " + memberList[i].id );
					return; // 일치한 회원이 존재하면 아이디 출력후 함수 강제 종료
			} // if end 
		} // for end 
		System.out.println("안내) 이름 혹은 전화번호가 일치하는 아이디가 없습니다.");
	} // f end 
	// 4. 비밀번호찾기 함수 : 입력받아 기존에 데이터와 일치한지 비교 [ Reading ]
	static void 비밀번호찾기() {
		System.out.println("--------- 비밀번호찾기 ---------");
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();
		
		for( int i = 0 ; i<memberList.length ; i++ ) {
			if( memberList[i] != null && memberList[i].id.equals(id) && memberList[i].phone.equals(phone) ) {
					System.out.println("안내) 회원님의 비밀번호 : " + memberList[i].pw );
					return; // 일치한 회원이 존재하면 아이디 출력후 함수 강제 종료
			} // if end 
		} // for end 
		System.out.println("안내) 아이디 혹은 전화번호가 일치하는 비밀번호가 없습니다.");
	} // f end 
} // class e 
/*
	주제 : 회원제 시스템 
		0. 회원클래스 설계 = Member
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
		0. Member 객체를 여러개 저장하는 배열 
			Member[] 객체배열 = new Member[100];
		
		1. 초기 메뉴 [ 24시간 ]
			1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
			
		2. 조건 기능 
			1. 회원가입 메소드 
				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
				 
			2. 로그인 메소드
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패
					 
			3. 아이디찾기 메소드
				1. 이름 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 아이디 출력 
					- 아니면 없다.
					 
			4. 비밀번호찾기 메소드 
				1. 아이디 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 비밀번호 출력
					- 아니면 없다.
					
					
					
			// 1. 1안
			Member m = new Member(); // 빈/깡통 생성자
				// 1. m = { id = null , pw = null , name = null , phone = null , age = 0 }
			m.id = id ; m.pw = pw; m.name = name; m.phone = phone; m.age = age;
				// 2. m = { id = "입력받은값" , pw = "입력받은값" , name = "입력받은값" , phone = "입력받은값" , age = "입력받은값" }
			// 2. 2안 
			Member m2 = new Member(id, pw, name, phone, age);
			
*/














