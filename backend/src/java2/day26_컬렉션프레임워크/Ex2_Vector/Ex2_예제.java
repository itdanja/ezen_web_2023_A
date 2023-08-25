package java2.day26_컬렉션프레임워크.Ex2_Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import java2.day26_컬렉션프레임워크.Board;

public class Ex2_예제 {
	public static void main(String[] args) {
		
		// 1. Vector 리스트 객체 생성 
			// ArrayList vs Vector
				// 내부구조 동일하고 함수도 동일 
				// 동기화x vs 동기화o
		List<Board> list = new Vector<>();			// 두 스레드가 안전하게 2000개 모두 저장  [ synchronized ]
		// List<Board> list = new ArrayList<>();	// 두 스레드가 2000개 모두 저장 못함..	
		
		// 2. 작업 스레드A 추가 
		// Thread threadA = new Thread() {  };
		Thread threadA = new Thread() { 
			public void run() { for( int i = 1 ; i<=1000 ; i++ ) { list.add( new Board("제목", "내용", "글쓴이") ); } }
		}; // t end 
		
		// 2. 작업 스레드B 추가 
		// Thread threadB = new Thread() { };
		Thread threadB = new Thread() { 
			public void run() { for( int i = 1001 ; i<=2000 ; i++ ) { list.add( new Board("제목", "내용", "글쓴이") ); } }
		}; // t end 
		
		// 3. 스레드 실행 
		threadA.start();
		threadB.start();
		
		// 4. main 스레드 대기상태 만들기. [ 두 스레드의 작업이 모두 끝날떄까지 main 스레드 기다림 => 작업 결과를 확인 할려고 ]
		try { threadA.join(); threadB.join(); } catch (Exception e) { }
		// 5.
		System.out.println("두 스레드가 추가한 리스트에 추가한 객체수 : " + list.size() );
		
		
	} // m end 
} // c end 
















