package java1.day10.Ex4;

public class Member {
	
	// 1.필드
	// 2.생성자
	// 3.메소드
	
	// ------------------ 메소드 선언 -------------------------//
		// 1. 리턴X매개변수X 함수 선언
	void signUp( ) {}
		// 2. 리턴x매개변수2개 함수  선언
	void login( String id , int pw ) {}
		// 3. 리턴O매개변수X 함수  선언
	String findId( ) { return "찾은아이디:"; }
		// 4. 리턴O매개변수O 함수 선언
	String[] findPw( String s1 , String s2 ) { 
		String[] array = {"qwe","asd"}; return array; 
	} 
		// 5. 매개변수가 가변길이일떄 함수 선언
		// [ ... : 여러 매개변수들을 하나의 힙에 저장해서 힙주소 반환 :  vs new : 클래스기반으로 힙에 객체 생성해서 힙의 객체주소 반환 
	void delete( String ...strArray ) { }
	void delete( int num , String ...strArray) { }
		// 6. 오버로딩 : 메소드명이 같되 매개변수의 이름[x]타입[o]순서[o]개수[o] 구분 식별 

}

/*
 	메소드 : 객체의 동작 , 객체의 상호작용 , 서로다른 객체 간의 데이터이동[MVC2패턴] 
  		선언 : 리턴타입 메소드명( 매개변수1, 매개변수2 ~ ){ 실행코드 return }
 */




