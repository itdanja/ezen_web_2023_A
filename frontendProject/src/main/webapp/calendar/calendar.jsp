<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/calendar.css" rel="stylesheet">
</head>
<body>

	<%@include file="../header.jsp" %>
	<div class="calwrap"> <!-- 캘린더 전체구역 -->
	
		<div class="caltop"> <!-- 상단 메뉴  -->
			<button onclick="onNext( 0 )" type="button"> < </button>  <!-- 이전 달 버튼 -->
			<h3 class="caldate"> 2023년 07월 </h3>				<!-- 현재 연도/월 표시 구역 -->
			<button onclick="onNext( 1 )"type="button"> > </button>  <!-- 다음 달 버튼 -->
		</div>
		
		<div class="calendar"> <!-- 날짜 표시 구역  -->
			<!-- 상단 요일 표기 일~토 -->
			
			<!-- 일 표기 1 ~ 31/30/29 -->
			
		</div>
		
	</div> <!--  ----------------------------------  -->
	<%@include file="../footer.jsp" %>
	<script src="../js/calendar.js" type="text/javascript"></script>

</body>
</html>