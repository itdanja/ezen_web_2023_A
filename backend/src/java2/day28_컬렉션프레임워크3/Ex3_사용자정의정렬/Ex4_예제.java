package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

import java.util.TreeSet;

public class Ex4_예제 {
	
	public static void main(String[] args) {

		// 1. (Fruit)정렬 구현객체 생성 
		FruitComparator fruitComparator = new FruitComparator();
		
		// 2. TreeSet 객체 생성 
		TreeSet<Fruit> treeSet = new TreeSet<>( fruitComparator );
		
		// 3. 무작위 Fruit 객체 대입 
		treeSet.add( new Fruit("포도", 3000) );
		treeSet.add( new Fruit("수박", 10000) );
		treeSet.add( new Fruit("딸기", 6000) );
		
		System.out.println("이진트리 상태 : " +  treeSet );
		
	}

}
