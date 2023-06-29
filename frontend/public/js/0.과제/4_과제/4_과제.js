
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
	
		// 날짜 모양으로 출력 
		let now = new Date(); // 1. 현재 시스템(pc)의 날짜/시간 호출 
		let year = now.getFullYear(); 	console.log('year : ' + year )		// 현재 연도 
		let month = now.getMonth()+1;	console.log('month : ' + month )	// 현재 월 0~11 [ 0:1월 / 1:2월 / 5:6월 / 11:12월 ]
		let week = now.getDay();		console.log('week : ' + week )		// 현재 요일 [ 0:일 1:월 ~~ 4:목요일 6:토요일 ]
		let day = now.getDate();		console.log('day : ' + day)			// 현재 일 
		let hour = now.getHours();	 	console.log('hour : ' + hour )		// 현재 시 
		let minute = now.getMinutes(); 	console.log('minute : ' + minute )	// 현재 분 
		let second = now.getSeconds(); 	console.log('second : ' + second )	// 현재 초
	
	// 2. 게시물1개당 = 객체1개 선언/만들기  = 각 input로 입력받은 값들을 각 속성명별로 대입해서 객체 생성 
	let board = { 
					writer : writerValue ,
				 	password : passwordValue ,
				  	title : titleValue ,
				   	content : contentValue  ,
				   	date : `${ now.getFullYear() }년 ${ now.getMonth()+1 }월 ${ now.getDate() }일 
				   			${ now.getHours() }:${ now.getMinutes() }:${ now.getSeconds()}
				   			` ,
				   	view : 0 
   				}
	console.log( board ) ;	// board 생성 확인 
	// --------- 등록전에 유효성검사 --------------------//
		// 생략~~~~
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
						<td onclick="onView( ${ i } )"> ${ board.title } </td> 
						<td> ${ board.date } </td> 
						<td> ${ board.view } </td>
					</tr>`
		} // for end 
	// 3. 대입 
	boardTable.innerHTML = html 
} // f end 

// 3. 
function onView( index ){ console.log('onView() 함수' + index); 
	// 1. 어디에 ~~~
	let viewbox = document.querySelector('#viewbox')
	// 2. 무엇을 ~~~ 
	let board = boardlist[index] // 인수로 전달받은 인덱스의 객체를 1개 꺼내기 
	
	let html = `<div> 제목 : ${ board.title } </div>
				<div> 내용 : ${ board.content } </div>
				<div> 작성자 : ${ board.writer } </div>
				<button onclick="onDelete( ${ index } )">삭제</button>
				<button>수정</button>`
	// 3. 대입
	viewbox.innerHTML = html 
	// 조회수 증가(JS변경) 하고 화면 새로고침(HTML변경)  
	board.view++; onPrint();
	
} // f end 

// 4. 삭제함수 
function onDelete( index ){ console.log('onDelete()함수' + index )
	
	// 1. 배열내 삭제할 인덱스의 해당하는 객체 호출 
	let board = boardlist[index];
	
	// 2. prompt() 함수로 입력받은 값을 password 변수 에 저장 
	let passowrd = prompt('비밀번호 : ')
	
	// 3. 비교 [ 삭제할 객체내 비밀번호와 입력받은 비밀번호와 일치하면 삭제 성공 ] 
	if( board.password == passowrd ){
		// 4. 배열내 해당 객체 삭제 
		boardlist.splice( index , 1 ); // 삭제할 인덱스번호부터 1개 삭제 
		// 5. 화면 새로고침 
		onPrint(); // 전체 게시물 출력 화면 새로고침 
		document.querySelector('#viewbox').innerHTML = `` // 현재 삭제된 개별 게시물 출력 화면 없애기 
		alert('[삭제성공] 게시물이 삭제 되었습니다.')
	}else{ // 일치하지 않으면 
		alert('[삭제실패] 비밀번호가 틀렸습니다. ')
	}
}



























