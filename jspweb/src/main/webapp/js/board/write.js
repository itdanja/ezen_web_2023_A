
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

$(document).ready(function() {
  // $('#summernote').summernote( {설정객체} );
  $('#summernote').summernote( { 
	lang : 'ko-KR', // 한글 적용 [ 한글.JS CDN 필요]  
	height : 500 , 
	placeholder : '여기에 내용작성'
  });
});
