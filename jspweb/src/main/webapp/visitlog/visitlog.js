
vprint();

function vwrite(){
	
	// 1. 
	let vwriter = document.querySelector('.vwriter');
	let vpwd = document.querySelector('.vpwd');
	let vcontent = document.querySelector('.vcontent');
	
	// 2. 
	let info = {
		vwriter : vwriter.value , 
		vpwd : vpwd.value , 
		vcontent : vcontent.value , 
	}; console.log( info );
	
	// 3. 유효성검사.
	
	// 4.
	$.ajax({
		url : "http://localhost/jspweb/VisitLog" ,
		method : "post" ,
		data : info , 
		success : function f(result){ console.log( result )
			if( result == true ){
				alert('글쓰기 성공.');
				vwriter.value = '';
				vpwd.value = '';
				vcontent.value = '';
				vprint();
			}else{
				alert('글쓰기 실패.');
			}
		} ,
		error : function f(result){ console.log( result )}
	});
	
} // f end 

function vprint(){
	
	// 1. 
	$.ajax({
		url : "http://localhost/jspweb/VisitLog" ,
		method : "get" ,
		data : "" , 
		success : function f(result){ console.log( result )
			
			let visitlogTable = document.querySelector('.visitprintbox');
			
			let html = ``
				
			for( let i = 0 ; i<result.length ; i++ ){
				
				let visit = result[i];
				
				html += `<div class="visitbox">
							<div >
								<div > ${ visit.vwriter } </div>
								<div > ${ visit.vdate } </div>
							</div>
							<div > ${ visit.vcontent } </div>
							<div>
								<button onclick="vupdate(${ visit.vno })" type="button">수정</button> 
								<button onclick="vdelete(${ visit.vno })" type="button">삭제</button>
							</div>
						</div>`
			}
			visitlogTable.innerHTML = html;
		} ,
		error : function f(result){ console.log( result )}
	});
} // 

function vupdate( vno ){ console.log('수정할 번호 : ' + vno );

	let vpwd = prompt('비밀번호 검증 : ');
	let vcontent = prompt('수정할 방문록내용 : ');
	

	$.ajax({
		url : "http://localhost/jspweb/VisitLog" ,
		method : "put" ,
		data : { vno : vno , vpwd : vpwd , vcontent : vcontent } , 
		success : function f(result){ console.log( result )
			
			if( result == 1 ){
				alert('수정완료'); vprint();
			}
			else if( result == 2 ){
				alert('비밀번호가 다릅니다.')
			}
			else if( result == 0 ){
				alert('수정실패')
			}
			
			
		} ,
		error : function f(result){ console.log( result )}
	});
	
}

function vdelete( vno ){ console.log('삭제할 번호 : ' + vno );
	
	// 1. 
	let vpwd = prompt('비밀번호 검증 : ');
	
	// 3. 
	$.ajax({
		url : "http://localhost/jspweb/VisitLog" ,
		method : "delete" ,
		data : { vno : vno , vpwd : vpwd } , 
		success : function f(result){ console.log( result )
			
			if( result == 1 ){
				alert('삭제완료'); vprint();
			}
			else if( result == 2 ){
				alert('비밀번호가 다릅니다.')
			}
			else if( result == 0 ){
				alert('삭제실패')
			}
			
		} ,
		error : function f(result){ console.log( result )}
	});
	
}












































