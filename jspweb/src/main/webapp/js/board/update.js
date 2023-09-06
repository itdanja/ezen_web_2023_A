	// 2. 쿼리스트링(URL주소상의변수) 의 변수 가져오기
	// 쿼리스트링 : URL?변수명=값&변수명=값&변수명=값
	// new URL(location.href).searchParams.get("변수명");
let bno = new URL(location.href).searchParams.get("bno"); console.log( bno );

// 1. 수정할 게시물의 기존 정보를 보여주기
getBoard()
function getBoard(){
	// 3. ajax에게 bno 전달해서 게시물정보 가져오기
	$.ajax({
		url : "/jspweb/BoardInfoController",
		method : "get" ,
		data : { type : 2 , bno : bno } , 
		success : r => {
			console.log(r);
			// 응답 결과를 html 대입
			document.querySelector('.bcno').value = `${r.bcno }`;
			document.querySelector('.btitle').value = `${r.btitle}`;
			document.querySelector('.bcontent').innerHTML = `${r.bcontent}`;
			document.querySelector('.oldfile').innerHTML = `${r.bfile}`;
			
					
			/* 썸머노트 실행 */
			$(document).ready(function() {
				let option = { // 썸머노트 옵션관련 객체 만들기 
					lang : 'ko-KR' , 
					height : 500 , 
					placeholder : '여기에 내용작성'
				}
				$('#summernote').summernote( option );
			});

		}
	})
} // f end 

// 2. 수정하기 
function onUpdate(  ){
	// 1. 입력된(수정된) form 정보 한번에 가져오기
		// 1. form 가져오기
	let writeForm = document.querySelectorAll('.writeForm')[0];
		// 2. form 객체화
	let formdata = new FormData( writeForm );
		// *3 form 객체에 데이터속성 추가 [ bno ]
			// .set( 속성명 , 값 ); // form에 데이터 속성 추가 
		formdata.set( "bno" , bno );
	// 2. ajax 대용량(첨부파일) multipart
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		method : "put" , 
		data :  formdata , 
		contentType : false , 
		processData : false , 
		success : r => {
			if( r ){ alert('수정성공'); 
				location.href=`/jspweb/board/view.jsp?bno=${bno}`;
			} else{ alert('수정실패');}
		} ,
		error : e =>{console.log(e); }
	})
}

























