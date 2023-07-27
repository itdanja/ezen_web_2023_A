package java1.day11.Ex5디자인패턴2;

import java1.day11.Ex5디자인패턴2.view.MainPage;

public class AppStart { // 프로그램 전원
	public static void main(String[] args) {
		// 다른 클래스에 있는 메소드를 호출 하는 방법 
		// 1. 메소드가 인스턴스멤버이면					=> 객체를 이용한 메소드 호출 		=> 멤버 각각
			//MainPage mainPage = new MainPage();
			//mainPage.mainPage();
		// 2. 메소드가 정적(static)멤버이면 				=> 클래스를 이용한 메소드 호출 	=> 멤버 공용
			//MainPage.mainPage();
		// 3. 싱글톤 객체( 정적 객체 ) 이면 				=> 싱글톤객체 호출해서 메소드 호출  => 공용 , 프로그램 내 1개 객체( 멤버 모두 공용 )
			MainPage.getInstance().mainPage();
	}
}
