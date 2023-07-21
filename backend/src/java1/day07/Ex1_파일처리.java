package java1.day07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex1_파일처리 { // class s
	public static void main(String[] args) throws IOException  { // main s 

		// 스택영역 : 함수는 호출'{'시 메모리할당 종료'}'시 메모리초기화	* 지역변수
		// 힙영역 : 객체/배열은 참조하는 스택이 없으면 자동으로 메모리가 초기화
			// ---> RAM 주기억장치 : 현재 처리된 명령어 저장 --> 전기X저장X -> 휘발성[ 타서 날라감 ]
		// 영구저장 
			// ---> c: , usb , cd 등등 보조기억장치 : 명령어 영구 저장 --> 전기X저장O			-> 비휘발성
				
		// Ex1_파일처리.java
			// 저장위치 : 내가 작성한 코드/문법  c:~~~  보조기억장치 
			// 실행[ctrl+f11] : 실행중에 필요한 메모리(변수,객체,배열 등) -> 주기억장치
			// 실행중인 메모리를 다음에 또 사용할려면 주기억장치 메모리를 보조기억장치 저장 / 불러오기 
			
			//	String a = scaner.next(); ---------------->  c: 저장 	[ 파일처리 , 데이터베이스 ]
			// 	컴퓨터 종료후 다음날
			// 	String b = 					<--------------  c: 불러오기 	[ 파일처리 , 데이터베이스 ]
		/*
		// 파일처리 라이브러리( 미리 만들어진 클래스/메소드 )
			// * 스트림 : 자바 외부와 통신할때 사용 통로 [ * 바이트단위 ]
				// * 통신하다가 갑자기 오류 발생할수도 있음 [ * 필수 : 미리 예외처리/오류처리 ]
			// 1. FileOutputStream : 파일 내보내기/저장 관련된 메소드 제공하는 클래스 
				// new FileOutputStream("파일경로");			: 해당파일과 연동/연결 
				 	만약에 파일경로에 해당 파일이 존재하지 않으면 해당 파일 생성 
				// new FileOutputStream("파일경로" , true );	: 해당파일과 연동/연결
				 	만약에 파일경로에 해당 파일이 존재하지 않으면 해당 파일 생성 , 이어쓰기
				 	
				// 파일경로 : 
					// 상대경로 : 프로젝트명생략 ->  ./src/패키지명/파일명
					// 절대경로 : C:\Users\504-t\git\ezen_web_2023_A\backend\src\java1\day07
					
			// 2. 제공하는 함수/메소드
			 	1. .write( 바이트배열 )	:	1바이트=영문		바이트배열 = 여러글자
			 	
			
			1. 문자열.getBytes() 	: 	해당 문자열을 바이트배열 반환 
			 
		*/
		
		Scanner scanner = new Scanner(System.in);	// 입력객체 = 입력한 값이 바이트로 들어옴 
		String instr = scanner.nextLine(); // 객체 입력받은 값의 바이트열을 문자열로 반환 
		
		// 1. 파일처리 [ 저장 ]
			// 1. 파일출력스트림 객체 선언 [ 파일경로 ]
		// FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex1_테스트.txt" );
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex2_테스트.txt" , true );
			// 2. 파일출력스트림 객체를 이용한 내보내기 메소드 사용 [ 바이트 단위 ]
		byte[] instrArray = instr.getBytes();	// 문자열을 바이트배열로 변환후
		fileOutputStream.write( instrArray );	// 바이트배열을 내보내기 
		
		
		
		
	}// main e 
} // class e 










