
// 1. 회원가입 메소드
function signup(){
	
	// 1. HTML에 가져올 데이터의 tag객체 호출 [ DOM객체 : html 태그를 객체화 ]
	let midInput = document.querySelector('.mid'); 
	let mpwdInput = document.querySelector('.mpwd'); 
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm'); 
	let memailInput = document.querySelector('.memail'); 
	let mimgInput = document.querySelector('.mimg'); 
	
	// 2. (객체화)
	let info = { // 인증코드(유효성검사 위한) , 패스워드확인(유효성검사 위한) : DB 넣을 필요가 없는 데이터 
		mid : midInput.value , 
		mpwd : mpwdInput.value , 
		memail : memailInput.value , 
		mimg : mimgInput.value 
	}
	// 3. 유효성검사
	
	// 4. AJAX메소드를 이용한 Servlet 와 통신 
	$.ajax({ 
		url : "/jspweb/MemberInfoController" , 
		method:"post" , 
		data : info , 
		success : r => { console.log('통신성공'); } ,
		error : e => { console.log('통신실패'); }
	})
		// 5. Servlet 의 응답에 따른 제어 
	
}






