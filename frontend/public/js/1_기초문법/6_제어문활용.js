/*     조건 : 반복문X 입력:prompt 출력 : console 
       문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
       문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력 
       문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력 
       
       문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       
       문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
       문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
                            80점이상 B등급 출력 
                            70점이상 C등급 출력  
                            그외 재시험
       문제 8 : 아이디와 비밀번호 입력받기 
             회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 아니면 로그인실패 출력
 */
// 문제1 : 2개의 정수 를 입력받아서 가장 큰수를 출력  
	// 1. 2개 입력받아 각 변수에 저장
		// 1.첫번째 값을 입력받기						prompt('정수1 : ')
		// 2.입력받은 값을 변수에 저장 value1			let value1 =
		// 3.두번째 값을 입력받기						prompt('정수2 : ')
		// 4.입력받은 값을 변수에 저장 value2			let value2
		// 5. 가장큰수?? 비교/논리/조건/판단 => 연산자		
		// 6. >= <= > < 연산자 선택					value1 > value2
		// 7. if 이용한 출력							if( 조건 ){  }
		//											else{ }
let value1 = Number( prompt('정수1 : ') ) ;
let value2 = Number( prompt('정수2 : ') ) ;
	// 2. if 이용한 논리제어 
if( value1 > value2 ){ console.log( value1 ) }
else if( value1 < value2){ console.log(value2) }
else{ console.log( '같다') }

// 문제2 : 3개의 정수 를 입력받아서 가장 큰수를 출력 
let value3 = Number( prompt('정수1 : ') ) ;
let value4 = Number( prompt('정수2 : ') ) ;
let value5 = Number( prompt('정수2 : ') ) ;
let max1 = value3;
if( max1 < value4 ){ max1 = value4 }
if( max1 < value5 ){ max1 = value5 }
console.log( max1 )

// 문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력 
let value6 = Number( prompt('정수1 : ') ) ;
let value7 = Number( prompt('정수2 : ') ) ;
let value8 = Number( prompt('정수3 : ') ) ;
let value9 = Number( prompt('정수4 : ') ) ;
let max2 = value6;
if( max2 < value7 ){ max2 = value7; }
if( max2 < value8 ){ max2 = value8; }
if( max2 < value9 ){ max2 = value9; }
console.log( max2 )

// 문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
let int1 = Number( prompt('정수1 : ') ) ;	// 3
let int2 = Number( prompt('정수2 : ') ) ;	// 5
let int3 = Number( prompt('정수3 : ') ) ;	// 2
// 정렬 = 하나씩 비교 해서 자리 교체 
// 만약에 첫번째 값이 두번째 값보다 크면
if( int1 < int2 ){  // 조건1	:	> 오름차순  < 내림차순 
	// *스왑/교체
	let temp = int1; // 1.	임시변수에 3 저장 
	int1 = int2;	// 2.	3있던 변수에 5 저장 
	int2 = temp;	// 3. 	5있던 변수에 3 저장 
}
if( int1 < int3 ){  // 조건2
	let temp = int1;
	int1 = int3;
	int3 = temp;
}
if( int2 < int3 ){ // 조건3 
	let temp = int2;
	int2 = int3;
	int3 = temp;
}
console.log( int1 +'  '+int2 + '  ' + int3 )



 
 
 
 
 
 
 
 
 
 
 
 
 
 
 