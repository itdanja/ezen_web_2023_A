package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

import java.util.TreeSet;

public class Ex3_예제 {
	
	public static void main(String[] args) {
	
		// - Integer , String , Double 정렬 기준이 명확( 숫자 ,문자 이므르 )
		// - 사용자정의 클래스인 MemberDto( 여러개 필드 ) 정렬 기준이 ???????? 명확하지 않음
		
		// - compareTo메소드[ Comparable 인터페이스 로부터 구현] 이용한 정렬 기준 만들기.
		
		// 1. Tree
		TreeSet<Person> treeSet = new TreeSet<>();
			// TreeSet<> 제네릭에는 Comparable 로 부터 구현된 클래스의 객체만 저장 가능 
		
		// 2. 무작위 person 객체 대입 
		treeSet.add( new Person("홍길동", 45) );
		treeSet.add( new Person("감자바", 25) );
		treeSet.add( new Person("박지원", 31) );
		treeSet.add( new Person("유재석", 15) );
		System.out.println(" 이진트리 상태 : " + treeSet  );
	}
}

