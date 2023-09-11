
let 헤더변수 = "헤더변수데이터";
// 1. 현재 로그인된 회원정보 요청 
let loginState = false; /* 로그인 상태 저장하는 변수  true:로그인중 false 비로그인*/ 
let loginMid = ''; /* 로그인 성공된 아이디를 가지고 있는 변수 */ 
getMemberInfo(); 
function getMemberInfo(){
	$.ajax({ // 1. ajax 이용한 서블릿세션 정보 가져오기
		url : "/jspweb/MemberInfoController" ,
		method : "get" ,
		async : false , /* 비동기화(기본값=true) , 동기화(false) 설정하는 속성 ( 우선적인 ajax실행 응답이 필요할때. )*/
		data : { type : "info" } , 
		success : r => { console.log( r ); 
			let submenu = document.querySelector('.submenu')
			let html = ``; // - 로그인 상태에 따른 서로다른 html 구성  
			if( r == null ){ // 비로그인 
				loginState = false; loginMid = '';
				html += ` <li> <a href="/jspweb/member/signup.jsp">회원가입</a> </li>
						<li> <a href="/jspweb/member/login.jsp">로그인</a> </li> `;
			}else{ // 로그인 
				loginState = true; loginMid = r.mid;
				html += ` <li> ${ r.mid } 님 </li>
						<li> <img class="hmimg" src="/jspweb/member/img/${ r.mimg }" /> </li>
						<li> <a href="/jspweb/member/info.jsp">마이페이지</a> </li>
						<li> <a onclick="logout()" href="#">로그아웃</a> </li> `
				if( r.mid == "admin"){ } // 로그인 했는데 관리자메뉴
			}
			// - 구성된 html 대입
			submenu.innerHTML = html;
		} ,error : e => {} 
	})
} // f end 
// 2. 로그아웃 함수 [ 서블릿에 세션을 삭제.. 그리고 로그아웃 성공시 메인페이지로 이동 ]
function logout(){
	$.ajax({
		url : "/jspweb/MemberInfoController" ,
		method : "get",
		data : { type : "logout"} , 
		success : r => { 
			alert('로그아웃 되었습니다.');
			location.href="/jspweb/index.jsp"; 
		} , error : e => {} 
	})
} // f end 

/*
	응답받은 r 상태 확인 
	let r = { 
		loginDatetime: "2023-08-31T11:51:16.933258300"
		memail: "zxczxc1@zxczxc1.com"
		mid: "zxczxc1"
		mimg: "사진22.jpg"
		mno: 12
		mpwd : null
	}
*/
