
// 1. 글쓰기 버튼을 클릭하면 
function onWrite(){
	if( loginState ){ 	// - 만약에 비 로그인이면 로그인 페이지로 이동
		location.href="/jspweb/board/write.jsp";
	}else{ // - 로그인이면 쓰기 페이지로 이동 
		alert('로그인후 글쓰기 가능합니다.');
		location.href="/jspweb/member/login.jsp";
	}
}

// 2. 모든 글 조회 [ js열렸을때 1회 자동실행 ]
getList();
function getList(){
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		method : "get" ,
		data : {} , 
		success : r => {}, 
		error : e => {}
	})
}










