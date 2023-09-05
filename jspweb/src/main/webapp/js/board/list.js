

// 1. 글쓰기 버튼을 클릭하면 
function onWrite(){
	if( loginState ){ 	// - 만약에 비 로그인이면 로그인 페이지로 이동
		location.href="/jspweb/board/write.jsp";
	}else{ // - 로그인이면 쓰기 페이지로 이동 
		alert('로그인후 글쓰기 가능합니다.');
		location.href="/jspweb/member/login.jsp";
	}
}

/* 게시물 조회 조건 객체 */
let pageOject = { type : 1 , bcno : 0  , listsize : 10 }
	// * type : 1:전체조회 , 2:개별조회
	// * bcno : 조회할 카테고리 번호 [ 기본값은 전체보기 ]
	// * listsize : 하나의 페이지에 최대표시할 게시물수 [ 기본값은 10개 ]
// 3. 카테고리 버튼을 클릭했을때.
function onCategory( bcno ){ 	console.log('클릭된 카테고리 : ' + bcno );
	pageOject.bcno = bcno; // 조회 조건객체내 카테고리번호를 선택한 카테고리로 변경
	getList(); // 조건이  변경되었기 때문에 다시 출력[ 재렌더링/새로고침 ]
} // f end 
// 4. 한페이지 최대 표시할 개수를 변경했을때.
function onListSize(){
	pageOject.listsize=document.querySelector('.listsize').value; // 선택된 게시물수를 조회조건객체 저장
	getList(); // 조건이  변경되었기 때문에 다시 출력[ 재렌더링/새로고침 ]
} 

// 2. 모든 글 조회 [ js열렸을때 1회 자동실행 ]
getList();
function getList(){
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		metdod : "get" ,
		data : pageOject , 
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
					html += `<tr> 
								<td> ${ b.bno } </td> 
								<td> ${ b.bcname } </td>
								<td> <a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle } </a> </td> 
								<td> 
									<img src="/jspweb/member/img/${ b.mimg }"/>
									${ b.mid } 
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









