package 과제.과제5.Level3.ex4;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_4 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_4 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
	
		/* 문제풀이 위치 */
		 //1.친구 수 입력만큼 배열크기 선언  
	while( true ) {
	      System.out.print("친구목록 수 : ");   int friendNum = scanner.nextInt(); //친구목록 수를 입력받고
	      String[] friendlist = new String[friendNum]; 							//그 입력받은 만큼 배열에 담아주고
	      
	      //2. 배열크기만큼 입력받기 
	      for( int i = 0 ; i<friendlist.length ; i++ ) { 						//int i는 0부터 friendlist의 길이까지 1씩증가
	         System.out.print( (i+1) +"번째 친구명 : "); 							//i+1 번째 친구명 출력받고
	         
	         String input = scanner.next();   									//친구명 받아서
	         																	//System.out.println("input"+input);
	         // 3.중복체크 
	         boolean check = false;
	         for( String same : friendlist ) { 									//for(배열타입 변수이름 : 배열이름){ } 		        	 
	            if( same != null && same.equals(input) ) { 						// 입력한 이름과 또 입력한 이름이 같으면?!
	            																//System.out.println("same이 뭐지"+same);
	               System.out.println("[안내] 이미 등록된 친구명입니다.");				//이미 등록된 친구라고 알려줌
	               i--; check = false; break; 									//이미 등록이 된 친구이기 때문에 i++를 해주면 친구목록수와 맞지 않기때문에 --를 해주고 break를 해준다
	               					//false 중복이다.
	            }
	         }
	         // 4. 중복이 없을경우만 저장
	         if( !check ) { friendlist[i] = input;}								//만약에 check가 flase가 아니면 다시말해 중복이 아니면
	         																	//입력받은 친구를 friendlist i번째에 담는다.		      
	      }//		      
	 
	      
	      while(true) {
	    	     System.out.println("[안내] 모두 등록이 되었습니다");
	   	      System.out.println("=======친구목록=======");
	   	      for(int i=0; i<friendlist.length; i++) {
	   	    	  if( friendlist[i] != null ) System.out.println("["+(i+1)+"]" + friendlist[i]);
	   	      }
	    	  System.out.println("1. 친구삭제  2. 친구추가  3. 재등록");
		      
			  int ch = scanner.nextInt();
			      if(ch==1) {
			    		System.out.println("삭제할 친구명"); String deletename = scanner.next(); // 삭제할 친구의 이름을 입력받는다
			    		
			    		
			    			int dindex = -1;
			    			for(int i=0; i<friendlist.length; i++) { 						//int i는 0 부터 friend의 길이까지 하나씩 증가하면서 삭제할 친구의 이름을 찾는다.
			    				if(deletename.equals(friendlist[i])) { 						//만약에 입력받은(삭제할)친구이름과 friendlist에 이름이 동일하면	
			    					friendlist[i] = null; dindex = i; break;
			    				}
			    			}
			    			if( dindex != -1) {
				    			for(int j = dindex ; j<friendlist.length ; j++ ) {
				    				if( j+1 == friendlist.length) { friendlist[j] = null; break; };
				    				friendlist[j] = friendlist[j+1];
				    			}
			    			}else {
			    				System.out.println("그런 친구 없습니다.");
			    			}
			    			
			    				
			    			
			    		
			    	  	//배열의 삭제
			    		//배열명[인덱스] = NULL혹은 0 혹은0,0 혹은 false [p.183]

			      }//ch1 end 1
			      
			      else if(ch==2) {
						/*
						 * System.out.println("추가할 친구명"); String newfriend = scanner.next(); for(int
						 * i=0; i<friendlist.length; i++) { if(friendlist[i]!=null ) {} }
						 * 
						 * //System.out.println((friendNum+1) + newfriend); //추가이니 입력받은 수 +1을 하여 번호출력받고
						 * 새로운친구와 함께 출력
						 */			  
			    	  
			    	  System.out.println("추가할 친구명"); String newfriend = scanner.next();
			    	 	  
			    	  boolean inputcheck = false;
			    	  // 1. 기존 배열에 빈자리가 있을경우
			    	  for( int i = 0 ; i<friendlist.length ;i++) {
			    		  if( friendlist[i] == null ) {friendlist[i] = newfriend; inputcheck=true; break;}
			    	  }
			
			    	  if( inputcheck == false ) {
				    	  // 2. 기존 배열에 빈자리가 없을경우 
				    	  friendNum++; // 친구수 증가  3 -> 4
				    	  String[] friendlist2 = new String[ friendNum ]; 
				    	  for( int i = 0 ; i<friendlist.length ; i++ ) {
				    		  friendlist2[i] = friendlist[i];
				    	  }
				    	  friendlist2[ friendNum-1 ] = newfriend;
				    	  friendlist = friendlist2;
			    	  }
			    	  
			      }
			      else if(ch==3) {  friendlist = null;  break; }
			      else {System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");}
		    
		      //글러먹었나..
	      }//while end
	}
		/* ----------- */

	}
}
/* 
	[문제] Level3_2 이어서 작성합니다. 중복체크를 진행합니다.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 만일 배열에 null 존재할경우 출력하지 않습니다.
		3. [ 중복체크 ] 입력한 데이터가 이미 배열에 존재할 경우 다시 입력받습니다.
		4. [ 친구삭제 ] 삭제할 친구 이름을 입력받아 삭제를 진행합니다. [ 삭제시 삭제된 인덱스뒤로 한칸씩 당겨줍니다 ]
		5. [ 친구추가 ] 추가할 친구 이름을 입력받아 배열에 비어 있는 자리가 있으면 추가합니다..
		 			  만일 빈자리가 없을경우 해당 배열의 길이를 +1 증가시켜 배열을 저장합니다.
		6. [ 재등록 ] 처음 코드로 돌아가서 친구 수를 다시 입력받습니다.
*/



/*
package Homework;

import java.time.LocalDateTime;
import java.util.Scanner;

public class day_11_Ex3_JAVA_Level3_ex_4 {
	public static void main(String[] args) {
		System.out.println(" >> Level3_4 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
	
		  //1.친구 수 입력만큼 배열크기 선언  
	      System.out.print("친구목록 수 : ");   int friendNum = scanner.nextInt(); //친구목록 수를 입력받고
	      String[] friendlist = new String[friendNum]; 							//그 입력받은 만큼 배열에 담아주고
	      
	      //2. 배열크기만큼 입력받기 
	      for( int i = 0 ; i<friendlist.length ; i++ ) { 						//int i는 0부터 friendlist의 길이까지 1씩증가
	         System.out.print( (i+1) +"번째 친구명 : "); 							//i+1 번째 친구명 출력받고
	         
	         String input = scanner.next();   									//친구명 받아서
	         																	//System.out.println("input"+input);
	         // 3.중복체크 
	         boolean check = false;
	         for( String same : friendlist ) { 									//for(배열타입 변수이름 : 배열이름){ } 		        	 
	            if( same != null && same.equals(input) ) { 						// 입력한 이름과 또 입력한 이름이 같으면?!
	            																//System.out.println("same이 뭐지"+same);
	               System.out.println("[안내] 이미 등록된 친구명입니다.");				//이미 등록된 친구라고 알려줌
	               i--; check = false; break; 									//이미 등록이 된 친구이기 때문에 i++를 해주면 친구목록수와 맞지 않기때문에 --를 해주고 break를 해준다
	               					//false 중복이다.
	            }
	         }
	         // 4. 중복이 없을경우만 저장
	         if( !check ) { friendlist[i] = input;}								//만약에 check가 flase가 아니면 다시말해 중복이 아니면
	         																	//입력받은 친구를 friendlist i번째에 담는다.		      
	      }//		      
	      System.out.println("[안내] 모두 등록이 되었습니다");
	      System.out.println("=======친구목록=======");
	      for(int i=0; i<friendlist.length; i++) {
	    	  System.out.println("["+(i+1)+"]" + friendlist[i]);
	      }
	      
	      while(true) {
	    	  System.out.println("1. 친구삭제  2. 친구추가  3. 재등록");
		      
			  int ch = scanner.nextInt();
			      if(ch==1) {
			    		System.out.println("삭제할 친구명"); String deletename = scanner.next(); // 삭제할 친구의 이름을 입력받는다
			    			for(int i=0; i<friendlist.length; i++) { 						//int i는 0 부터 friend의 길이까지 하나씩 증가하면서 삭제할 친구의 이름을 찾는다.
			    				if(deletename.equals(friendlist[i])) { 						//만약에 입력받은(삭제할)친구이름과 friendlist에 이름이 동일하면
			    					
			    					System.out.println("찾았다!");
			    			}
			    		
			    				else {System.out.println("리스트에 없는 친구입니다.");}break;
			    		}
			    		
			    	  	//배열의 삭제
			    		//배열명[인덱스] = NULL혹은 0 혹은0,0 혹은 false [p.183]

			      }//ch1 end 1
			      
			      else if(ch==2) {
			    	  System.out.println("추가할 친구명"); String newfriend = scanner.next();
			    	  		for(int i=0; i<friendlist.length; i++) {
			    	  			if(friendlist[i]!=null ) {}
			    	  		}
			    	  
			    		 //System.out.println((friendNum+1) + newfriend); //추가이니 입력받은 수 +1을 하여 번호출력받고 새로운친구와 함께 출력
			    		 		    	  
			      }
			      else if(ch==3) {
			    	  friendlist=null;
			    	  break;
			    	  
			      }
			      else {System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");}
		    
		      //글러먹었나..
	      }//while end
	      
/* 
[문제] Level3_2 이어서 작성합니다. 중복체크를 진행합니다.
[조건] 
	1. 문제풀이 위치 외 코드는 수정 불가 합니다.
	2. 만일 배열에 null 존재할경우 출력하지 않습니다.
	3. [ 중복체크 ] 입력한 데이터가 이미 배열에 존재할 경우 다시 입력받습니다.
	4. [ 친구삭제 ] 삭제할 친구 이름을 입력받아 삭제를 진행합니다. [ 삭제시 삭제된 인덱스뒤로 한칸씩 당겨줍니다 ]
	5. [ 친구추가 ] 추가할 친구 이름을 입력받아 배열에 비어 있는 자리가 있으면 추가합니다..
	 			  만일 빈자리가 없을경우 해당 배열의 길이를 +1 증가시켜 배열을 저장합니다.
	6. [ 재등록 ] 처음 코드로 돌아가서 친구 수를 다시 입력받습니다.
	
	특정 인덱스의 데이터를 변경하고 싶을 때[대입/수정]
		1)	배열명[인덱스번호] = 새로운 데이터

	배열의 삭제
			배열명[인덱스] = NULL혹은 0 혹은0,0 혹은 false [p.183]

	배열의 길이
		배열명.length:배열의 길이

	반복문 활용
		for(자료형 변수명 : 배열명){}
		
			모든 배열 내 항목 호출 //변수의 타입은 배열의 타입과 동일해야 한다.
		1)
				for(int i=0; i<배열.length; i++){
						배열[i]
				}
		*/