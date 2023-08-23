package java2.day24_제네릭.Ex3;

public class Ex3_제네릭 {
	public static void main(String[] args) {
		
		// 1. 홈 렌탈 대리점 객체 생성 	[ 안산지점 집렌탈대리점 ]  
		HomeAgency 홈렌탈안산지점 = new HomeAgency();
		Home 유재석집 = 홈렌탈안산지점.rent(); 	// 2. 해당 대리점에서 새로운 Home객체를 생성
		유재석집.turnOnLight();				// 3. 렌탈한 home객체(유재석집)해서 메소드 실행 
		Home 강호동집 = 홈렌탈안산지점.rent();		// 2. 해당 대리점에서 새로운 Home객체를 생성 
		강호동집.turnOnLight();				// 3. 렌탈한 home객체(강호동집)해서 메소드 실행 
		
		// 1-2. 홈 렌탈 대리점 객체 생성 	[ 수원지점 집렌탈대리점 ]  
		HomeAgency 홈렌탈수원지점 = new HomeAgency();
		Home 신동엽집 = 홈렌탈수원지점.rent(); 
		신동엽집.turnOnLight();				
		Home 하하집 = 홈렌탈수원지점.rent();	
		하하집.turnOnLight();				
		
		
		
		// 2. 자동차 렌탈 구현체 		[ 안신지점 자동차렌탈대리점 ]
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
	}
}
