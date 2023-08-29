
package java2.day28_컬렉션프레임워크3.Ex2_TreeMap;

import java.util.TreeMap;

public class Ex2_예제 {

	public static void main(String[] args) {
		
		// 1. TreeMap 객체 생성
		TreeMap< String , Integer > treeMap = new TreeMap<>();
		
		// 2. 무작위 엔트리<키,값> 저장 
		treeMap.put( "apple", 100);
		treeMap.put( "forever", 60);
		treeMap.put( "description", 40);
		treeMap.put( "ever", 50);
		treeMap.put( "zoo", 80);
		treeMap.put( "base", 20);
		treeMap.put( "guess", 70);
		treeMap.put( "cherry", 30);
		System.out.println( "이진트리 map 상태 : " + treeMap );  // 자동으로 오름차순 (key) 정렬
		// 오름차순 : 낮은것->끝것 ( 1 2 3  , a b c , ㄱ ㄴ ㄷ )
		
		// 3. 
		System.out.println("가장 왼쪽 노드/엔트리 : " + treeMap.firstEntry() );
		System.out.println("가장 오른쪽 노드/엔트리 : " + treeMap.lastEntry() );
		System.out.println("ever 노드 왼쪽 노드/엔트리 : " + treeMap.lowerEntry("ever") );
		System.out.println("ever 노드 오른쪽 노드/엔트리 : " + treeMap.higherEntry("ever") );
		System.out.println("ever 노드 이거나 왼쪽 노드/엔트리 : " + treeMap.floorEntry("ever") );
		System.out.println("ever 노드 이거나 오른쪽 노드/엔트리 : " + treeMap.ceilingEntry("ever") );
		
		// 4. 내림차순 
		System.out.println("이진트리 map 내림차순 : " + treeMap.descendingMap() );
		
		System.out.println("시작(a)~c 단어 검색 : " + treeMap.headMap("c", true));
		System.out.println("c~끝(z)까지 단어 검색 : " + treeMap.tailMap("c", true));
		System.out.println("c~h 사이의 단어 검색 : " + treeMap.subMap("c", true, "h", false));
		
		
		
	}
	
}
