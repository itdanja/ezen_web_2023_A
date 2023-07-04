<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<link href="/frontendProject/css/kiosk.css" rel="stylesheet">
	
</head>
<body>

	<%@include file="../header.jsp" %>
	
	<div class="kioskwrap">
	
		<div>   <!-- 헤더 : 광고이미지/카테고리출력 표시되는 구역 -->
			<img class="himg" src="../img/himg1.png" >
		</div>  <!-- 헤더 end  -->
		
		<div> </div> <!-- 본문 : 제품출력/카트출력 구역-->
		
	</div>
	
	<%@include file="../footer.jsp" %>

	<script src="/frontendProject/js/kiosk.js" type="text/javascript"></script>

</body>
</html>






