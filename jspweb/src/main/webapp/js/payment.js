// -- 포인트 지급 테스트
// setPoint( 1000 , "회원가입축하");
// setPoint( -500 , "이모티콘구매");
// getPoint();
// getPointList();

// 1. 포인트 사용 함수  [ mno는 서블릿이 (로그인 세션) 알고 있다. ]
function setPoint( mpamount , mpcomment ){
	if( loginState == false ){ return; }
	
	let returnData  = false;
	$.ajax({
		url : "/jspweb/PointController" , 
		method : "post" ,
		async : false,
		data : { mpamount : mpamount , mpcomment : mpcomment } , 
		success : result =>{ console.log(result); 
			returnData = result;
		} ,
		error : e => { console.log(e); }
	})
	return returnData;
	
}

// 2. 내 포인트 확인 함수 
getPoint();
function getPoint(){
	if( loginState == false ){ return; }
	$.ajax({
		url : "/jspweb/PointController" , 
		method : "get" ,
		async : false,
		data : { type : 1 } , 
		success : result =>{ console.log(result); 
			document.querySelector('.pay').innerHTML = `${ result.toLocaleString() }`
		} ,
		error : e => { 
			
		}
	})
}
// 3. 내 포인트 내역 전체 출력 함수 
getPointList()
function getPointList(){
	if( loginState == false ){ return; }
	$.ajax({
		url : "/jspweb/PointController" , 
		method : "get" ,
		async : false,
		data : { type : 2  } , 
		success : result =>{ console.log(result);
		
		let pointTable = document.querySelector(".pointTable")
		let html = `<tr><td>사용일자</td><td>지급내역</td><td>포인트</td></tr>`;
		result.forEach( (p)=>{
			html += `<tr><td>${ p.mpdate }</td>
						<td>${ p.mpcomment }</td>
						<td>${ p.mpamount}</td></tr>`
		})
		pointTable.innerHTML = html;
		
		 } ,
		error : e => { console.log(e); }
	})
}



let payImgList = document.querySelectorAll('.paybox img');

payImgList.forEach( (p , i )=>{
	
	p.addEventListener( 'click' , (e)=>{
		console.log(e);
		
		payImgList.forEach( (p)=>{
			p.style = `box-shadow:`;
		});
		e.currentTarget.style =  `box-shadow: 0px 0px 20px #4d07ff`;
		document.querySelector('.point')
			.innerHTML = `${ i == 0 ? '1000' : i == 1 ? '5000' : i == 2 ? '10000' : ''   }`;
	})
})



function payment() {

	var IMP = window.IMP;
	IMP.init("imp35631338");

	IMP.request_pay(
		{
			pg: "kcp.INIpayTest",
			pay_method: "card",
			merchant_uid: "57008833-33004",
			name: "포인트결제",
			amount: document.querySelector('.point').innerHTML,
			buyer_email: "Iamport@chai.finance",
			buyer_name: "포트원 기술지원팀",
			buyer_tel: "010-1234-5678",
			buyer_addr: "서울특별시 강남구 삼성동",
			buyer_postcode: "123-456",
		},
		function(rsp) {
			console.log( rsp )
			  if (rsp.success) {// 결제 성공 시 로직
			  	alert('결제실패');
		      } else { // 결제 실패 시 로직 [ 테스트 -> 실패(성공)]
		         
		        if( setPoint( document.querySelector('.point').innerHTML , "포인트결제") ) {
					alert('결제성공');
					location.reload();
					
				}else{
					
				}
		      }
		}
	);
}





