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
			
			<div class="logincheckbox"></div>
			
			<div class="subbtnbox">
				<a href="/jspweb/member/findid.jsp">아이디찾기</a>
				<a href="/jspweb/member/findpwd.jsp">비밀번호찾기</a>
			</div>
			
			
			<button class="signupbtn" onclick="signup()" type="button">로그인</button>
		</form>
	</div>
	
	<script src="../js/login.js" type="text/javascript"> </script>
	

</body>
</html>