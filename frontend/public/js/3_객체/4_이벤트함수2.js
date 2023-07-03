/*

	이벤트함수 
	HTML 이벤트 적용하는방법
	1.
		<태그 이벤트속성명="함수명()"> </태그명>
	2.
		1. DOM객체.addEventListener('이벤트명' , 함수명 )								// 기존 함수명 적용 
		2. DOM객체.addEventListener('이벤트명' , (  )=>{ 실행코드정의 } )			// 익명 화살표 함수 정의해서 적용  
		3. DOM객체.addEventListener('이벤트명' , function (  ){ 실행코드정의 } )		// 익명 함수 정의해서 적용 
		
		* document.addEventListener('이벤트명' , ( e )=>{ } )
		
 	3. 이벤트
 		이벤트명
		1. DOMContentLoaded : HTML이 완전히 열렸을때[모두 로드되었을때] 실행되는 이벤트
		2. window.onload	: 해당 객체가 호출 되었을때
		3. click			: 해당 객체를 클릭했을때
		4. keyup			: 해당 객체에서 키보드를 누르고 떼어있을때
		5. keydown			: 해당 겍체에서 키보드를 눌렀을때
			- e.keyCode		: 입력된 키코드번호 
		
 
 */
// 1. 
let text = document.querySelector('.textbox')
text.addEventListener( 'keyup' , ( event )=>{		console.log('키보드 입력하고 떼어있을때');
	let h3 = document.querySelector('.h3box')
	console.log( text.value.length );
	h3.innerHTML = `입력된 문자 길이 : ${ text.value.length }`
	// 1. 키 상태 확인 => 키보드 제어 
	console.log( event );
	console.log( event.altKey );		// alt 눌렀는지??
	console.log( event.ctrlKey );		// ctrl 눌렀는지??
	console.log( event.shiftKey );		// ctrl 눌렀는지??
	console.log( event.code );			// 입력된 키보드의 코드네임
	console.log( event.key );			//
	console.log( event.keyCode )		// 입력된 키보드의 코드번호	[ C : 대문자 ] 
	// 만약에 키보드에서 엔터를 쳤을때
	if( event.keyCode == 13 ){ alert('엔터입력했습니다.'); }
})

// 2. 
let moving = document.querySelector('.moving');	// 1. 버튼의 태그 호출 
moving.style.position = `absolute`;	// 2. style 속성 이용한 css 추가 
	// 1. DOM객체명.style = `속성명 : 값 , 속성명 : 값 `;
	// 2. DOM객체명.style.css속성명 = `값`;		주의할점 : css속성명 작성시 카멜표기법 사용
		// DOM객체명.style = `backgorund-color = blue`';
		// DOM객체명.style.backgorundColor = `blue`	// JS는 속성명에 - 사용금지.. 
	// * 버튼 위치의 초기값 x=가로축  y=세로축  block = 이동단위[30px씩 이동]
	let x = 7;	let y = 0;  let block = 30;		
	// 1. 버튼 위치 출력 함수 
movingPrint(); // JS 열렸을때 최초 1번 실행 
function movingPrint(){
	moving.style.left = `${ x * block }px`
	moving.style.top = `${ y * block }px`
}
	// 2. 이동 이벤트 함수 [ 만약에 본문에서 키다운을 누르면 ]
document.body.addEventListener( 'keydown' , (e)=>{
		// e : keydown 이벤트 결과 정보 담고있는 객체 
		// * 만약에 이동상태가 true인 경우에만 가능 
		if( control == true ){
			// 1. 만약에 key 상태에 따른 제어 
			let key = e.keyCode;		// 눌린 키보드 키의 코드넘버 C[대문자]
				console.log( key );
				//왼쪽방향키 = 37 위방향키 = 38 오른쪽방향키 = 39 	아래방향키 = 40
			if( key == 37 ){ x--;  }	// 왼쪽방향키를 눌렀을때 왼쪽 으로 이동
			else if( key == 38 ){ y--; }	// 위로 이동 
			else if( key == 39 ){ x++; }	// 오른쪽 이동 
			else if( key == 40 ){ y++; } 	// 아래로 이동
			
			movingPrint(); // 해당 버튼의 위치 새로고침/재랜더링
		}
} ) // f end 

let control = true ; // 버튼 이동상태 저장 변수 [ true = 이동 , false = 이동불가 ]
	// 3. 버튼 클릭시 control 변수 상태 변경해주는 함수 
moving.addEventListener( 'click' , ( e )=>{ 
	control = !control // 현태 상태를 반대로 변경 [ true => false / false => true ]
	if( control ) moving.innerHTML='배치하기';
	else moving.innerHTML='이동하기';
}) 




























 