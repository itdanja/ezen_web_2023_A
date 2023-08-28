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

	<form class="signupForm"> <!-- 회원가입 전체 구역  -->
		아이디 : <input onkeyup="idcheck() " name="mid" class="mid" type="text" /> 
		<span class="idcheckbox"></span>
		<br/>
		
		비밀번호 : <input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password" /> <br/>
		비밀번호 확인 : <input onkeyup="pwcheck()"  class="mpwdconfirm" type="password" />
		
		<span class="pwcheckbox"></span>
		<br/>
		
		이메일 : <input onkeyup="emailcheck()" name="memail" class="memail" type="text" /> 
		<!-- 이메일 인증요청 버튼 -> 유효성검사 통과시 사용가능 -->
		<button disabled class="authReqBtn" onclick="authReq()"  type="button">인증요청</button> <br/>
		
		<div class="authbox">
			<!-- 인증요청 버튼 클릭시 보이는 구역  -->
		</div>
		
		<span class="emailcheckbox"></span> <br/>
		
		<div class="pimgbox">
			<input onchange="premimg(this)" type="file" name="mimg"	 		class="mimg">		
			<img class="premimg" alt="" src="/jspweb/img/member/default.webp">
		</div>
		
		<div class="signupbox">
		
		</div>
		
		<button onclick="signup()" type="button">회원가입</button>
	</form>
	
	<script src="../js/signup.js" type="text/javascript"> </script>
	

</body>
</html>