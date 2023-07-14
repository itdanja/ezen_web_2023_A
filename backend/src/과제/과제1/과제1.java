package 과제.과제1;

import javax.sql.rowset.CachedRowSet;

public class 과제1 {

	public static void main(String[] args) {
		
		// 캡처2 확인문제 
		// 1 : 4 
			// 1 : 변수는 하나의 값만 저장o vs 배열은 여러개 값 저장 
			// 2 : int 타입으로 선언했으면 int 허용범위내 데이터만 저장
			// 3 :  { } 안에서 선언된 변수는 밖으로 나올수 없다.
			// 4 : x
		/*
		int 문제1;	System.out.println( 문제1 ); // 4번 오류 
		
		// 2 : 2,3,6,7
		int modelName;	int class;	int 6hour;	int $value;
		int _age;		int	#name;	int int;
			// 미리 정해진 단어 : 문법적으로 사용되는 단어 = 키워드 
		
		// 3 : 
		
		 	정수타입		byte	short	int		long
		 						char
			실수타입						float	double
			논리타입		boolean
		
		
		// 4. 
			// 타입 : int , double
			// 변수명 : age , price
			// 리터럴 : 10 , 3.14;
		
		// 5. : 3 	short : +-3만정도 / char 6만정도 : 0~6만정도
		byte bytevalue = 10;		int intvalue = bytevalue;
		char charvalue = 10;		intvalue = charvalue;
									short shortvalue = charvalue;	// 3 : char에는 음수가 없기때문에
									double doublevalue = bytevalue;
		// 6. : 4
		int intValue = 10;				double var1 = (double)intValue; // 자동
		char charValue = 'A';			byte var2 = (byte)intValue; // 강제 
		double doubleValue = 5.7;		int var3 = (int)doubleValue; // 강제 
		String strValue = "A";			char var4 = (char)strValue;	// 4 : 오류 객체는 기본타입으로 캐스팅 불가 
		// 해결 방안 
		char var5 = strValue.charAt(0); // 문자열.charAt(인덱스) : 문자열내 인덱스 번째 문자 1개 추출
		
		// 7. : 3	'' 문자로 표현불가능  ' ' 공백 가능 
		int value1 = 10;	long value2 = 100000000000000L;
		char value3 = '';	float value4 = 10;
		String value5 = "abc\ndef";	
		String value6 = ;// [ p51 ] JDK13 버전 이상만 가능 
		
		// 8. : 3 	출력한다
		System.out.print();
		System.out.println();
		System.out.printf();
		nextLine() 메소드
		
		
		// 9 : 1  피연산자중에 더 큰 허용범위내로 결과 반환 [ * byte, short 는 int 반환 ]
		byte bvalue = 10;		float fvalue = 2.5f;		double dvalue = 2.5;
		
		byte result1 = bvalue + bvalue;
		int result2 = 5 + bvalue;	
		float result3 = 5 + fvalue; 
		double ressult4 = 5 + dvalue; 
		
		// 10 : 2 
		int.parseInt()	 	[x]
		Integer.parseInt() 	[o]	
		
		*/
		// 11 : 13,16  	* 변수의 허용범위 : { } 안에서 선언된 변수는 밖으로 호출/사용 불가
		int v1 = 1;
		System.out.println( v1 );
		if( true ) {
			int v2 = 2;
			if( true ) {
				int v3 = 2;
				System.out.println( v1 ); 	// o
				System.out.println( v2 ); 	// o
				System.out.println( v3 );	// o
			} // 두번째 if end 
			System.out.println( v1 );// o
			System.out.println( v2 );// o
			System.out.println( v3 );// 두번째 if {} 선언 X 
		} // 첫번째 if 
		System.out.println( v1 );// o
		System.out.println( v2 );// 첫번째 if {} 선언 x	
	}
}
/*
 	1. (2인1조) 연산자 암기 확인 
	 	1. 산술 
			+ 더하기		- 빼기		* 곱하기		/ 나누기=>몫		% 나누기=>나머지
		2. 비교
			> 초과   		< 미만
			>= 이상		<=이하
			== 같다		!=같지않다[다르다]
		3. 논리
			&& 	이면서 면서 이고 모두 그리고 	and
			|| 	이거나 거나 또는 하나라도  	or 	
			! 	부정[반대] true -> false  / false -> true
		4. 대입
			=  	 오른쪽값이 왼쪽으로 대입 [ 기존 데이터는 사라짐 ]
			+= 	 오른쪽값이 왼쪽값과 더하기 후에 왼쪽값에 대입
			-= *= /= %=
		5. 증감
			변수++	후위1증가		++변수	선위1증가
			변수--	후위1감소		--변수	선위1감소
		6. 삼항연산자[조건연산자]
			조건식 ? 참 : 거짓 
			(조건이 다수일경우) 조건식1 ? 조건식2 ? 참2 : 거짓2 : 거짓1
		7. 연결연산자 
			+ 연결연산자 
 	
 	2. (1인) p.73 ~ p.76 풀이 => 카톡방 과제1 git 주소
 	
		// 문제1 풀이 답 : 3
		// 문제2 풀이 답 : 1
		~~~~~
 	
 */
