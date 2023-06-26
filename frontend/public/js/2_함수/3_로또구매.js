console.log('js 실행')
// * 선택된 번호를 저장하는 배열 
let 선택번호목록 = [ ] 

// 1. 로또 구매 함수 정의 
function 로또구매(){
	console.log('로또구매() 실행 ');
	// 1. 1~45개의 button 생성해서 변수에 담기 
	let buttonHTML = ``;
	for( let i = 1 ; i<=45 ; i++ ){ // for s 
		// i는 1부터 45까지 1씩증가 반복
		// 버튼 하나씩 변수에 추가
		buttonHTML += `<button 
							onclick="숫자버튼( ${ i } )" > 
							${ i } 
						</button>` // i번째 버튼생성
						// 인수 = i번째 출력된 버튼 클릭시 i번째 출력된 숫자를 숫자버튼() 함수에게 전달 
						// JS -> HTML생성 -> 클릭이벤트 실행 
		// 만약에 i가 5의 배수이면 
		if( i % 5 == 0 ) buttonHTML+= `<br/>`
	} // for end 
	// 2. for에서 생성된 45개 버튼을 해당 div에 대입	
	document.querySelector('.버튼목록구역').innerHTML = buttonHTML;
} // F END 
// 2. 숫자 (선택) 버튼 함수 정의
function 숫자버튼( 선택된번호 ){
	console.log( 선택된번호 + ' 숫자버튼을 클릭했군요. ')
	// < push > 배열에 저장하기전에 유효성검사
	// 1. 중복검사 = 배열명.indexOf
	if( 선택번호목록.indexOf( 선택된번호 ) != -1 ){ // -1 : 동일한 데이터가 배열내 없음 뜻  // != -1 : 배열내 존재하면 
		alert('이미 선택된 번호 입니다.'); // 안내문구 
		return; // 함수 강제 종료 
	} // if end
	 
	// 2. 6개 초과인지 검사 = 배열명.length	: 배열내 데이터 총개수/길이 
	if( 선택번호목록.length == 6 ){
		alert('이미 6개 번호 모두 선택하셨습니다.');
		return; // 함수 강제 종료 // return 안했을경우 아래보드 실행!!!!
	} // if  end 
	
	// * 배열에 저장 ( 2개의 유효성검사를 모두 통과했을때 배열에 저장 ) 
	선택번호목록.push( 선택된번호 ); console.log( 선택번호목록 )
}











