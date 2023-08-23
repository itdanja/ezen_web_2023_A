package java2.day23_멀티스레드2.Ex3;

import java.util.Scanner;

public class Ex3_동기화 {
	public static void main(String[] args) {
		//1.계산기 객체 생성 
		Calculator calculator = new Calculator();
		
		//2.작업스레드[유저1] 객체 생성 
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		//2.작업스레드[유저2] 객체 생성 
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
	}
}
