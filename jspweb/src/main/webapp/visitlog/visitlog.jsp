<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<!-- css import -->
	<link href="visitlog.css" rel="stylesheet" />
	
</head>
<body>

	<%@include file ="../header.jsp" %>
	
	<!-- CRUD 기반의 비회원 게시판/방문록 구현 -->
	<div class="visitwrap" > <!-- 전체구역 -->
	
		<div class="visit_Top"> <!-- 쓰기구역  -->
			<div class="visit_Inputs">
				<input class="vwriter" 	type="text" placeholder="작성자">
				<input class="vpwd" 	type="password" placeholder="비밀번호">
			</div>
			<textarea class="vcontent" placeholder="방문록내용"></textarea>
			<button onclick="vwrite()" type="button">등록</button>
		</div>
	
		<div class="visit_Bottom"> <!-- 출력 구역  -->
			<!-- JS가 출력해주는 구역 -->
		</div>
	</div>
	
	<!-- js import -->
	<script src="visitlog.js" type="text/javascript"></script>
	
	
</body>
</html>





