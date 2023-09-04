

// 1. list.jsp에서 클릭된 제목의 bno를 전달받아 게시물 1개 가져오기
getBoard();
function getBoard(){
	// 1. URL에 있는 매개변수(쿼리스트링) 가져오기
		// 1. 현재 주소(url)상 매개변수 가져오기 
	let urlParams = new URL(location.href).searchParams
		console.log( urlParams );
	let bno = urlParams.get("bno"); // rul주소에서 bno의 데이터 가져오기 
		// new URL(location.href).searchParams.get("매개변수명")
		console.log( bno );
	
	// 2. AJAX 이용한 bno 전달해서 게시물의 상세 정보 모두 가져오기
	$.ajax({
		url : "/jspweb/BoardInfoController" ,
		method: "get" , 
		data : { type : 2 , bno : bno } , 
		success : r => {  console.log(r);
			// 1. 
			let boardBox = document.querySelector('.boardBox')
			
			// 2. HTML 구성 
			let html = `부가정보 : <div> 
									${ r.bcname } , 
									${ r.bview } , 
									${ r.bdate } 
								 </div>
						부가정보2 : <div>  
									${ r.mid }  , 
									<img src="/jspweb/member/img/${ r.mimg }" width="50px" /> 
								</div>
						제목 : <div> ${ r.btitle } </div>
						내용 : <div> ${ r.bcontent } </div>
						첨부파일 : <div> ${ r.bfile } </div>
						<button type="button">삭제</button>
						<button type="button">수정</button>
						<a href="list.jsp"><button type="button">목록보기</button></a>
						`
			// 3.
			boardBox.innerHTML = html;
		} , 
		error : e => { console.log(e) }
	})
	
} // f end 



















