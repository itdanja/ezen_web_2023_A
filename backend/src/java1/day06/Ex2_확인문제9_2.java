package java1.day06;

public class Ex2_확인문제9_2 { // class s

	public static void main(String[] args) { // main s 
		
		// [p.199] 확인문제 9
		
		// step2 : 반복[되풀이]할 출력문으로 하나로 만들기 [ 종료조건 : 종료선택[4] 입력하면 ]
		while(true) { // while s // 무한루프 
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
			System.out.println("-----------------------------------------------");
			System.out.println("선택> 1");
		} // while end 
		
	} // main e 
} // class e 

/*
 	공통 출력 
 		System.out.println("-----------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
		System.out.println("-----------------------------------------------");
		System.out.println("선택> 1");
 	
 	개별 출력 
		// 1.
		System.out.println("학생수> 3");
		// 2.
		System.out.println("scores[0]> 85");
		System.out.println("scores[1]> 95");
		System.out.println("scores[2]> 93");
		// 3.
		System.out.println("scores[0]: 85");
		System.out.println("scores[1]: 95");
		System.out.println("scores[2]: 93");
		// 4.
		System.out.println("최고 점수: 95");
		System.out.println("평균 점수: 91.0");
		// 5.
		System.out.println("프로그램 종료");
		
*/