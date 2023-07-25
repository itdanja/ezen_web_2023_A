package 과제.과제9;

// 목적 : 설계도, 객체의모델
public class Member {
	
	// 1. 필드 : 객체의 데이터 를 저장하는곳
	String id;	
	String password;
	String name;
	String phone;
	int age;
	
	// 2. 생성자
	public Member( String id , String password ,String name , String phone , int age ) {// 1. 매개변수 5개 정의한 생성자
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	/*
	public Member() {} // 0. 빈 [ 매개변수 없는 ] 생성자 
	public Member( String id , String password , String name , String phone  ) {}			// 2. 매개변수 4개 정의한 생성자
	public Member( String id , String password , String name  ) {}							// 3. 매개변수 3개 정의한 생성자
	public Member( String id , String password   ) {}										// 3. 매개변수 2개 정의한 생성자
	public Member( String id   ) {}															// 4. 매개변수 1개 정의한 생성자
	//public Member( String password   ) {}													// 4. 매개변수 1개 정의한 생성자
	public Member( int age   ) {}															// 4. 매개변수 1개 정의한 생성자
	*/
	
	// 3. 메소드 
}






