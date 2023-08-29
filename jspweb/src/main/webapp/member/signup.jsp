<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/member.css" rel="stylesheet">

</head> 
<body>

	<%@include file = "../header.jsp" %>

	<div class="container"> <!-- 회원가입 전체 구역  -->
	
		<form class="signupForm"> <!-- 폼 전송시 각 input에 name속성 -->
		
			<h2> 이젠 개발자 커뮤니티 </h2>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다 </p>
				
			<div class="title">아이디</div>
			<input onkeyup="idcheck() " name="mid" class="mid"  type="text" /> 
			<div class="idcheckbox"></div>
			
			<div class="title">비밀번호</div>
			<input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password" />
			
			<div class="title">비밀번호 확인 </div>
			<input onkeyup="pwcheck()"  class="mpwdconfirm" type="password" />
			<div class="pwcheckbox"></div>
			
			
			<div class="title">이메일 </div>
			<div class="emailbox">
				<input onkeyup="emailcheck()" name="memail" class="memail" type="text" /> 
				<!-- 이메일 인증요청 버튼 -> 유효성검사 통과시 사용가능 -->
				<button disabled class="authReqBtn" onclick="authReq()"  type="button">인증요청</button> <br/>
			</div>
			
			<div class="authbox">
				<!-- 인증요청 버튼 클릭시 보이는 구역  -->
			</div>
			
			<div class="emailcheckbox"></div>
			
			<div class="title"> 프로필 </div>
			<input onchange="preimg( this )" name="mimg" class="mimg" type="file" /> <br/>
				<!-- <태그명 이벤트명="함수명( this )" /> : 함수에 이벤트실행한 태그객체 매개변수로 전달  -->
			<img class="preimg" alt="" src="img/default.webp" > <!-- 등록 사진을 미리보기 할 사진 태그  -->
		
			<button class="signupbtn" onclick="signup()" type="button">회원가입</button>
		</form>
	</div>
	
	<script src="../js/signup.js" type="text/javascript"> </script>
	

</body>
</html>