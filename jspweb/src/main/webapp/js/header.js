
// 1. 로그인 함수 
getInfo()
function getInfo(){
	
	$.ajax({
		url : "/jspweb/MemberInfoController" ,
		data : { type : "info" },
		method : "get", 
		success : r => { 
			console.log( r );
			
			let submenu = document.querySelector('.submenu');
			let html = ``;
			if( r == null ){ // 비로그인 상태 
				html += `
				<li> <a href="/jspweb/member/signup.jsp">회원가입</a> </li>
				<li> <a href="/jspweb/member/login.jsp">로그인</a> </li>
				`;
			}else{ // 로그인 상태
				html += `
				<li> ${ r.mid } 님 </li>
				<li> <img class="hmimg" src="/jspweb/member/img/${r.mimg}" /> </li>
				<li> <a href="/jspweb/member/info.jsp">마이페이지</a> </li>
				<li> <a href="#" onclick="logout()">로그아웃</a> </li>
				`;
			}
			submenu.innerHTML = html;
			
		} ,
		error : e => { console.log(e); } 
	});
}; 

function logout(){

	$.ajax({
		url : "/jspweb/MemberInfoController" ,
		method : "get", 
		data : { type : "logout" },
		success : r => { 
			alert('로그아웃이 되었습니다.');
			location.href="/jspweb/index.jsp";
		} ,
		error : e => { console.log(e); } 
	});
	
}
















