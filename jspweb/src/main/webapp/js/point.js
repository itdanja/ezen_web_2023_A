

let imgAll = document.querySelectorAll('.paymoney img');


function selectpay( e , money ){
	document.querySelector('.pay').innerHTML = `${ money.toLocaleString() }원`
	console.log(e);
	
	imgAll.forEach( img =>{
		
		if( img == e.target ){
			e.target.style = "box-shadow: 0px 0px 35px blue;"
		}else{
			e.target.style = "box-shadow: 0px"
		}
		
	})
	
}





















function payment() {
	
	var IMP = window.IMP;
	IMP.init("imp35631338");

	IMP.request_pay(
		{
			pg: "kcp.INIpayTest",
			pay_method: "card",
			merchant_uid: "57008833-33004",
			name: "당근 10kg",
			amount: 1004,
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
		         alert('결제성공');
		      }
		}
	);
}

/*


*/