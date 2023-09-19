
// * 게시판상세페이지 , 제품상세페이지 등등에서는 클릭된 식별자[제품번호]
// URL(인터넷주소) 에서 매개변수(쿼리스트링) 가져오기 
let pno = new URL( location.href ).searchParams.get("pno")
//  new URL( location.href ).searchParams.get("키")
// <a href="/jspweb/product/view.jsp?키=값&키=값&=값" >
// 1. pno에 해당하는 제품1개 호출 
findByPno( pno );
function findByPno( pno ){
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method : "get",
		data : { type:"findByPno" , pno : pno } ,
		success:jsonObject=>{ console.log(jsonObject);
			// --------- 캐러셀에 이미지 여러개 대입 
			let imgbox = document.querySelector('.imgbox')
			let html = ``;
			Object.values( jsonObject.imgList ).forEach( (img,i)=>{
				// 첫번째 이미지에만 active클래스 삽입
				html += `<div class="carousel-item ${ i==0 ? 'active' : '' } ">	
						  <img src="/jspweb/product/img/${img}" class="d-block w-100" alt="...">
						</div>`;
			})
			imgbox.innerHTML = html;
			
			// ---------- 각 위치에 데이터 넣어주기 
			document.querySelector('.mid').innerHTML = `판매자 : ${ jsonObject.mid }`;
			document.querySelector('.pcname').innerHTML = `카테고리 : ${ jsonObject.pcname }`;
			document.querySelector('.pdate').innerHTML = `등록일 : ${ jsonObject.pdate }`;
			document.querySelector('.pname').innerHTML = `${ jsonObject.pname }`;
			document.querySelector('.pprice').innerHTML = `${ jsonObject.pprice.toLocaleString() }원`;
			document.querySelector('.pcontent').innerHTML = `${ jsonObject.pcontent }`;
			
			getplike( pno )
			
		}
	})
}


//7. 찜하기 버튼를 눌렀을때[ 첫 클릭시 찜하기등록 / 다음 클릭시 찜하기 취소 / 다음 클릭시 찜하기 등록 ]
function setplike( ){
	// alert(pno);
	if( loginMid == '' ){ alert('회원기능입니다. 로그인후 사용해주세요'); return; 	}
	
	// 1. pot 방식 전송 
	$.ajax({
		url : "/jspweb/ProductLike",
		method : "post" ,
		data : { "pno" : pno } , 
		success : (r)=>{ 
			if( r == 'true'){
				alert('찜하기 등록');
				document.querySelector('.plikebtn').innerHTML = '찜하기♥';
			}else{
				alert("찜하기 취소")
				document.querySelector('.plikebtn').innerHTML = '찜하기♡';
			}
		}
	})
}

// 8. 현재 회원이 해당 제품의 찜하기 상태 호출 
function getplike(  ){
	if( loginMid == '' ){ document.querySelector('.plikebtn').innerHTML = '찜하기♡'; }
	$.ajax({
		url : "/jspweb/ProductLike",
		method : "get",
		async : 'false',
		data : { "pno" : pno },
		success : (r)=>{ 
			console.log( r )
			if( JSON.parse(r) == true){ document.querySelector('.plikebtn').innerHTML = '찜하기♥'; }
			else{ document.querySelector('.plikebtn').innerHTML = '찜하기♡'; }
		 }
	})
}

















