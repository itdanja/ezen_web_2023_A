/*
// 문제1) 입력받은 수 만큼 * 출력 
// 문제2) 입력받은 수 만큼 * 출력 [  - 3줄(3배수)마다 줄바꿈 ]
// 문제3) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
*
**			
***		
****	
*****
// 문제4) 입력받은 줄 수 만큼 * 출력 [ ex) 5 ]
*****
****
***
**
*
// 문제5) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
    *
   **
  ***
 ****
*****
// 문제6) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
*****
 ****
  ***
   **
    *
// 문제7) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
    *
   ***
  *****
 *******
*********
// 문제8) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
*********
 *******
  *****
   ***
    *
// 문제9) 입력받은 줄 수 만큼 * 출력  [ ex) 10 ]
    *
   ***
  *****
 *******
*********
*********
 *******
  *****
   ***
    *
// 문제10) 입력받은 줄 수 만큼 * 출력  [ ex) 7 ]
*     *
 *   *
  * *
   *
  * *
 *   *
*     *

*/

let output = ``;	//  출력용 변수 [ 모든 문제 에서 사용 ]
// 문제1) 입력받은 수 만큼 * 출력 
let value1 = prompt( '문제1:')
for( let i = 1 ; i<=value1 ; i++  ){ // i는 1부터 입력받은 수까지 1씩증가반복 
	output += `*`
} // for end 
console.log( output )
// ---------------------------------------------------------- // 
// 문제2) 입력받은 수 만큼 * 출력 [  - 3줄(3배수)마다 줄바꿈 ]
output = ``; // 공백으로 초기화
let value2 = prompt( '문제2:')
for( let i = 1 ; i<=value2 ; i++ ){
	output += `*`
	// 만약에 i의 값이 3배수( 값%3==0 ) 이면 
	if( i % 3 == 0 ){ output += `\n` }	
	// \ : 제어문자(이스케이프문자)	\t : 들여쓰기 \n : 줄바꿈
} // for end 
console.log( output )

// ---------------------------------------------------------- //
// 문제3) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
output = ``;
let line1 = prompt( '문제3:')
for( let i = 1 ; i<=line1 ; i++ ){
	// [별찍기]
	for( let s = 1 ; s <= i ; s++){ output += `*`}
	// [줄바꿈] i는 1부터 입력받은 줄수까지 1씩증가
	output +=`\n`;
}
console.log( output )




















