
/* 썸머노트 실행 */
$(document).ready(function() {

	let option = { // 썸머노트 옵션관련 객체 만들기 
		lang : 'ko-KR' , 
		height : 500 , 
		placeholder : '여기에 내용작성'
	}
	
	$('#summernote').summernote( option );
  
});

// write , update , delete : js 내장함수들 존재하기 때문에  함수명으로 사용불가 
function bwrite(){
	// 1. form 가져오기 
		// querySelectorAll() : 배열타입으로 여러 dom객체 
		// querySelector() : 객체타입으로 한개 dom객체
	let form = document.querySelectorAll('.writeForm')[0];
	// 2. form 객체화 하기 
	let formData = new FormData( form );
	// 3. ajax로 대용량 form 전송하기 
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		method: "post" , 
		data : formData ,
		contentType : false , 
		processData : false ,
		success : r => {
			
			if( r ){
				alert('글등록 성공');
				location.href="/jspweb/board/list.jsp";
			}else{
				alert('글등록 실패 ');
			}
			
		} , 
		error : e => { } 
	})
}
