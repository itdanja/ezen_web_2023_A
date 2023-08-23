package java2.day21_예외처리;

public class Ex2_예외다중catch {
	
	public static void main(String[] args) {
		// p. 470 : 다중 catch : 다양한 예외에 따른 서로 다른 흐름제어
		String[] array = {"100", "1oo"};	
			// Integer.parseInt(문자열인숫자) : 문자열숫자 => 정수형숫자 정수로타입변환
			// System.out.println( Integer.parseInt( "7" ) ); // 문자 7 => 정수 7  형변환 가능 
			// System.out.println( Integer.parseInt( "ㄱ" ) ); // 문자 ㄱ => 정수 // NumberFormatException
			
		for( int i = 0 ; i<=array.length; i++ ) { // 인덱스:0~1 // 길이 : 2 // 인덱스 2는 없음 
			try {
				// System.out.println( array[i] ); // ArrayIndexOutOfBoundsException
				int value = Integer.parseInt( array[i] );	
					// NumberFormatException: For input string: "1oo"
			}
			// 예외클래스 catch 작성순서 : 하위 예외 클래스 블록 먼저 작성
			// catch ( Exception e  ) { System.out.println("예외발생 : " + e);} 
				// 예외 상위 예외클래스가 앞에 있으면 아래있는 하위 예외클래스들은 실행x
			catch ( NumberFormatException e) { System.out.println("숫자로 변환 할수 없는 데이터 : " + e); }
			catch ( ArrayIndexOutOfBoundsException e) { System.out.println("배열 인덱스 초과 : " + e ); }
			catch ( NullPointerException | ClassCastException e ){ System.out.println();}
			catch ( Exception e  ) { System.out.println("예외발생 : " + e); }
		
		}
		
	}
}
