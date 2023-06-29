
// * 배열  = 여러개 객체(게시물)을 저장하는 배열  
let boardlist = [ ]

// * JS 열렸을때 최초 1번 함수 실행 
onPrint()

// 1. 등록 이벤트 함수 [ 실행조건 : 등록 버튼을 클릭했을때 ]
function onWrite(){ console.log('onWrite()함수')

	// 1. 입력받은 데이터 호출 
		// 1. document.querySelector(식별자).value
	let writerValue = document.querySelector('#writer').value;
	let passwordValue = document.querySelector('#password').value;
	let titleValue = document.querySelector('#title').value;
	let contentValue = document.querySelector('#content').value;
	
	// 2. 게시물1개당 = 객체1개 선언/만들기  = 각 input로 입력받은 값들을 각 속성명별로 대입해서 객체 생성 
	let board = { 
					writer : writerValue ,
				 	password : passwordValue ,
				  	title : titleValue ,
				   	content : contentValue  ,
				   	date : new Date() ,
				   	view : 0 
   				}
	console.log( board ) ;	// board 생성 확인 
	// --------- 등록전에 유효성검사 --------------------//
		
	// ---------------------------------------------//
	
	// 3. 현재 { } 안에서 선언된 board 는 } 끝나면 사라짐[지역변수] --> 전역변수/배열에 저장하자.
	boardlist.push( board );	console.log( boardlist ) ;	// 배열  확인 
	
	// * 새로운 게시물이 등록 되었으니까 게시물 출력 화면 업데이트
	onPrint()

} // F END 

// 2. 출력 함수 [ 실행조건 : 1.JS열렸을때 2.등록했을때 3.삭제했을때 4.수정했을때 5.조회수증가했을때]
function onPrint(){ console.log('onPrint()함수');
	
	// 1. 어디에 출력할껀지 ????  테이블 
	let boardTable = document.querySelector('#boardTable')
	
	// 2. 테이블 무엇을 대입/출력 할껀지 ??? 객체에 정보들을 객체 1개당 한줄씩<tr> 출력
	let html = `<tr> <th> 번호 </th> <th>제목</th> <th>작성일 </th> <th>조회수</th> </tr>`
	
		// 배열내 순차적으로 하나씩 열어보자 
		for( let i = 0 ; i<boardlist.length ; i++ ){
			
			let board = boardlist[i];	// i번째 배열 인덱스의 객체 호출 
			// 로그인=비교=if		// HTML출력 => HTML 구성 
			
			html += `<tr>
						<td> ${ i+1 } </td> 
						<th> ${ board.title } </th> 
						<th> ${ board.date } </th> 
						<th> ${ board.view } </th>
					</tr>`
		} // for end 
		
	// 3. 대입 
	boardTable.innerHTML = html 
}


























