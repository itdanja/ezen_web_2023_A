console.log( 'write.js 실행' )

// 1. 썸머노트 실행할때 사용되는 코드 
$(document).ready(function() {
  // $('#summernote').summernote( {설정객체} );
  $('#summernote').summernote( { 
	lang : 'ko-KR', // 한글 적용 [ 한글.JS CDN 필요]  
	height : 500 , 
	placeholder : '여기에 내용작성'
  });
});
//---------------------------------------//
// 로그인제 게시판 [ 로그인 했다는 가정하에 로그인된 아이디를 가정하에 변수에 저장 ]
let loginId = 'blue1234';

/*
	JS는 HTML 에서 포함된 문서
		- HTML 새로고침[F4] / 페이지전환[ a ] 되면 JS도 재호출 => 메모리 휘발성/초기화
		- 영구적인저장[ 백엔드 담당 = DB ]
		- 브라우저 저장소 : 1.세션 2.쿠키 
			세션 : 모든 브라우저 꺼지면 초기화
			쿠키 : 모든 브라우저/OS 꺼져도 유지	/ 직접 쿠키 삭제 하기전까지 유지 / 보안이 필요한 데이터 사용X
			
		- 사용방법 = JS에서 객체 제공 = 키와 값으로 이루어진 객체 
			- 문자 타입으로 저장!!!!!!!!!!!!! , 숫자x , 배열x , 객체x
			sessionStorage : 세션
				 sessionStorage.setItem( '키' , 값 )		: 해당 값을 '키'라는 이름으로 저장 
				 sessionStorage.getItem( '키' )			: 해당 키를 호출하면 저장된 값 호출 
				 sessionStorage.clear()					: 삭제
			localStorage : 쿠키 
				localStorage.setItem( '키' , 값 )
				localStorage.getItem( '키' )
				localStorage.clear()
		
		- JSON : JS 객체 문법으로 구조화된 데이터를 표현하기 위한 문자 기반의 포멧[형식/자료형/타입]
			- 구조(모양)는 객체/배열 인데 포멧[형식/자료형/타입]은 문자
			- 
				JS	:   { id : 'qwe' , pwd : '1234' }
				JSON : "{ id : 'qwe' , pwd : '1234' }"
			- 사용방법
				1. JSON.parse( )		: 문자타입을 객체/배열 타입 로 변환 
				2. JSON.stringify()		: 객체/배열 타입을 문자타입 로 변환  
			
*/

// 1. 등록 함수 [ 실행조건 : 등록 버튼을 클릭했을떄]
function onWrite(){
	// 1. 입력받은 값을 가져온다.
	let title = document.querySelector('.title').value;
	let content = document.querySelector('#summernote').value;
	
	// 3. 해당 객체/변수 를 배열에 저장한다.
		// 1. 기존에 쿠키에서 게시물들이 저장된 boardList 배열 호출한다. * 호출할때 배열/객체포멧으로 변환
	let boardList = JSON.parse( localStorage.getItem('boardList') );
		// 2. 만약에 쿠키가 존재하지 않으면 [ 숫자없다는걸 0 / 문자없다는걸 공백 / 객체없다는걸 null 표기 ] 
	if( boardList == null ) boardList = [ ] // 쿠키가 없으면 빈배열 생성 
	
	
		// * 마지막 인덱스의 게시물에 해당하는 게시물번호에 +1 더한 수
	let no = boardList.length == 0 ? 1 : boardList[boardList.length-1].no + 1
			// 조건 ? 참 : 거짓 
			/*
				if( boardList.length == 0 ){ // 만약에 배열의 길이가 0 이면 // 게시물 0개 
					no = 1  // 첫 게시물에 게시물번호 1 설정 
				}else{
					no = boardList[boardList.length-1].no + 1 // 마지막 게시물번호 +1
				}
			*/
		// * 유효성검사한다.
		
		// 2. 입력받은 값이 여러개 이면 객체화 
		let board = {
			title : title ,			// 입력받은 값 넣기 
			content : content ,		// 입력받은 값 넣기 
			no : no ,				// 게시물 번호 [ 마지막게시물 +1 ]
			date : `${new Date().getFullYear()}-${new Date().getMonth()+1 }-${new Date().getDate() }` , // 게시물 작성일 [ 연도 , 월+1 , 일 ]
			view : 0 ,				// 게시물 조회수 기본값이 0 부터 시작 
			like : 0 , 				// 게시물 추천수는 기본값이 0 부터 시작 
			writer : loginId // 게시물 작성자 [ 로그인된 아이디 ]
		}
		console.log( board )
		
		// 3. 위에서 생성된 board을 boardList 저장 
	boardList.push( board )
		// 4. boardList를 다시 쿠키에 저장한다. * 저장할때 문자포멧으로 변환
	localStorage.setItem( 'boardList' , JSON.stringify( boardList )  )
		// 5. 글쓰기 성공 했으면 페이지 전환
	alert('글쓰기 성공');
			// HTML : <a href="경로"> </a>
			// JS : location.href="경로"
		location.href = 'list.jsp'
		
	//////////////////// --- 예 /////////////////////////////
		// 함수{ }안에 선언된 배열 : 지역변수
		// 함수{ }밖에 선언된 배열 : 전역변수 
		// 세션(서버PC) / 쿠키(사용자PC) : JS외 저장 가능하다. -> JS 새로고침/페이지전환 해도 유지
	sessionStorage.setItem( '세션' , 1 );
	localStorage.setItem('쿠키' , 2 );
	
	console.log( 1 )								// 숫자 1 
	console.log( sessionStorage.getItem('세션') )	// 숫자 1 저장했지만 문자 1 로 출력됨
	console.log( localStorage.getItem('쿠키') )		// 숫자 2 저장했지만 문자 2 로 출력됨 
	
}
















