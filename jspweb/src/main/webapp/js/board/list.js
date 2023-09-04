
let pageObject = {
	page : 1 , // page : 표시할 페이징번호
	type : 1 , // 1:전체출력 2:개별출력
	key : "" , 
	keyword : "",
	bcno : 0 , // 카테고리 번호
	listsize : 10
}



function onCategory( bcno ){
	pageObject.bcno = bcno; 
	pageObject.key = '';	// 검색 없애기
	pageObject.keyword ='';	// 검색 없애기
	getList( 1 );
}

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
getList( 1 );
function getList( page ){
	pageObject.page = page; // 인수로 받은 현재페이지를 객체에 대입
	
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		method : "get" ,
		data : pageObject , 
		success : r => { console.log( r ); 
			// 1. 출력할 위치 
			let boardTable = document.querySelector('.boardTable');
			// 2. 출력할 내용 구성
			let html = `<tr> <th> 번호 </th> <th> 카테고리 </th>
						<th> 제목 </th> <th> 작성자 </th> <th> 조회수 </th>
						<th> 작성일 </th> </tr>` 
				// * 서블릿으로부터 전달받은 내용[배열] 반복해서 html 구성
				// 배열명.forEach( 반복변수명 => { 실행코드 } )			 // java ->  ,  js =>
				r.boardList.forEach( b => {
					console.log( b );
					html += `<tr> 
								<td> ${ b.bno } </td> 
								<td> ${ b.bcname } </td>
								<td> <a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle } </a> </td> 
								<td> ${ b.mid } <img src="/jspweb/member/img/${ b.mimg }" width="20px"; style="vertical-align:middle"; />  </td> 
								<td> ${ b.bview } </td>
								<td> ${ b.bdate } </td> 
							</tr>`
				} ); // for end 
			// 3. 구성된 html내용을 출력 
			boardTable.innerHTML = html;
			
			// ---------------------------------------------------- //
			// -------------------- 페이징 버튼 출력 --------------------- //
			html = ''; // 기존에 들어있던 내용 제거 
			// 이전 [ 만약에 현재 페이지가 1 이하 이면 이전페이지 없음 ]
			html += page <= 1 ?
					`<button onclick="getList(${ page })" type="button" class="pagebtn"> < </button>`
					:
					` <button onclick="getList(${ page-1 })" type="button" class="pagebtn"> < </button> `
			// 페이징 번호 버튼 들 
			for( let i = r.startbtn ; i<=r.endbtn ; i++ ){ // 시작버튼번호 부터 마지막버튼번호 까지 버튼 생성 
				html += `
					<button onclick="getList(${i})" type="button" class="pagebtn"> ${i} </button>
					`
			}
			// 다음 [ 만약에 현재 페이지가 총페이지수 이상이면 다음페이지 없음 ]
			html += page >= r.totalpage ?
					`<button onclick="getList(${ page })" type="button" class="pagebtn"> > </button>`
					:
					`<button onclick="getList(${ page+1 })" type="button" class="pagebtn" > > </button>`
			document.querySelector('.pagebox').innerHTML = html;
			
			
			if( pageObject.key == '' ){
				document.querySelector('.seachcount').innerHTML = `게시물 수 : ${ r.totalsize } `
			}else{
				document.querySelector('.seachcount').innerHTML = `검색된 게시물 수 : ${ r.totalsize } `
			}
			
			

		}, 
		error : e => {}
	})
}



// 2. 검색 
function getsearch(){
	console.log('onsearch()함수');
	// * 입력받은 데이터를 전역객체내 필드에 대입 
	pageObject.key = document.querySelector('.key').value
	pageObject.keyword = document.querySelector('.keyword').value
	// * 게시물리스트 재호출 
	getList(1);
}

// 4. 화면에 표시할 게시물 수 변경 함수 
function setlistsize(){
	// 1. select 에서 선택된 값 가져오기 
	let listsize 
		= document.querySelector('.listsize').value;
	// 2. pageObject 필드에 대입 
	pageObject.listsize = listsize;
	// 3.  
	getList(1);		// 재호출
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









