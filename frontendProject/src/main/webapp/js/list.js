console.log('list.js');
	/* 쿠키/세션에 저장된 객체/배열 호출시  JSON.parse( )
	   쿠키/세션에 저장된 객체/배열 저장시 JSON.stringify( ) */
// 0. 쿠키에 있는 배열 호출 [ 페이지[JS] 열리면 ]
let boardList = JSON.parse( localStorage.getItem('boardList') );
if( boardList == null ) boardList = [ ] // 만약에 쿠키가 비어 있으면 비어 있는 배열 대입
boardPrint();
// 1. 게시물 출력 함수 [ 페이지[JS] 열리면 ]
function boardPrint(){
	// 1. 어디에 
	let tcontent = document.querySelector('.tcontent')
	// 2. 무엇을 
	let html =``
		// HTML 구성 : 쿠키에서 꺼내온 배열을 반복문 해서 HTML 누적 더하기 
		for( let i = 0 ; i<boardList.length ; i++ ){
			let board = boardList[i];	// i번째 게시물 호출
			html += `<tr>
						<td> ${ board.no } </td> 
						<td onclick="onViewLoad( ${ board.no } )" > ${ board.title } </td> 
						<td> ${board.writer} </td>
						<td> ${ board.date } </td> <td> ${ board.view } </td> <td> ${ board.like } </td>
					</tr>`
		}
	// 3. 대입
	tcontent.innerHTML = html;
} // f end 

// 2. 상세 페이지로 이동 [ 실행조건 : 클릭한 게시물 제목 ]
function onViewLoad( no ){ // 인수 : 클릭한 제목(게시물)의 번호 
	console.log( ' 현재 클릭된 제목(게시물)의 번호 : ' + no);
	// 클릭된 결과를 다른페이지로 옮기는방법
		// JS는 페이지가 전환/새로고침 초기화 -> // 세션/쿠키
	// 1. 클릭된 게시물번호 세션에 저장 
	sessionStorage.setItem( 'no' , no )
	// 2. 페이지 이동 
	location.href="view.jsp"
}





















	