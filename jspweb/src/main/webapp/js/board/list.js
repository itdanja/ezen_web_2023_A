
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
		metdod : "get" ,
		data : { type : 1 } , 
		success : r => { console.log( r ); 
			// 1. 출력할 위치 
			let boardTable = document.querySelector('.boardTable');
			// 2. 출력할 내용 구성
			let html = `<tr> <th> 번호 </th> <th> 카테고리 </th>
						<th> 제목 </th> <th> 작성자 </th> <th> 조회수 </th>
						<th> 작성일 </th> </tr>` 
				// * 서블릿으로부터 전달받은 내용[배열] 반복해서 html 구성
				// 배열명.forEach( 반복변수명 => { 실행코드 } )			 // java ->  ,  js =>
				r.forEach( b => {
					console.log( b );
					html += `<tr> 
								<td> ${ b.bno } </td> 
								<td> ${ b.bcname } </td>
								<td> <a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle } </a> </td> 
								<td> 
									${ b.mid }  
									<img src="/jspweb/member/img/${ b.mimg }"/>
								</td> 
								<td> ${ b.bview } </td>
								<td> ${ b.bdate } </td> 
							</tr>`
				} ); // for end 
			// 3. 구성된 html내용을 출력 
			boardTable.innerHTML = html;
		}, 
		error : e => {}
	})
}

/*
	
	HTTP URL에 매개변수(파라미터) 전달 ( 쿼리[질의]스트링 방식 )
		- 정의 : 페이지 전환시 매개변수(PK,식별) 전달 
		- 형태 
			URL?변수명=데이터
			URL?변수명=데이터&변수명=데이터
			http://localhost:80/jspweb/board/view.jsp?bno=3
			href="/jspweb/board/view.jsp?bno=${ b.bno }
		
		- URL에서 매개변수 호출 
			new URL(location.href).searchParams.get("변수명")			
*/









