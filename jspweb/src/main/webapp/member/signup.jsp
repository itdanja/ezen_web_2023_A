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

	<div> <!-- 회원가입 전체 구역  -->
		아이디 : <input onkeyup="idcheck() " class="mid" type="text" /> 
		<span class="idcheckbox"></span>
		<br/>
		
		비밀번호 : <input onkeyup="pwcheck()" class="mpwd" type="password" /> <br/>
		비밀번호 확인 : <input onkeyup="pwcheck()"  class="mpwdconfirm" type="password" />
		
		<span class="pwcheckbox"></span>
		<br/>
		
		이메일 : <input class="memail" type="text" /> <br/>
		이메일 인증코드 : <input class="ecode" type="text" /> <br/>
		프로필 : 	<input class="mimg" type="file" /> <br/>
		<button onclick="signup()" type="button">회원가입</button>
	</div>
	
	<script src="../js/signup.js" type="text/javascript"> </script>
	

</body>
</html>