<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/product/list.css" rel="stylesheet">
	
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="contentbox">
		<!-- 지도 -->
		<div id="map" style=""></div>
		<!-- 사이드바 -->
		<div class="produclistbox">
		
		</div>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd&libraries=clusterer"></script>

	<script src="/jspweb/js/product/list.js" type="text/javascript"></script>
	

</body>
</html>


	
		<!--  
		<h3> 제품 등록 페이지 [ form 태그 없는경우 1 ] </h3>
		<div>
			제품명 : <input class="pname1" type="text">   <br> 
			제품설명 : <textarea class="pcontent1" ></textarea> <br>
			<button onclick="register1()" type="button"> 등록1 </button>
		</div>
		
		<h3> 제품 등록 페이지 [ form 태그 이용하는 경우 2 ] </h3>
		<form class="registerForm1">
			제품명 : <input name="pname2" type="text">   <br> 
			제품설명 : <textarea name="pcontent2" ></textarea> <br>
			<button onclick="register2()" type="button"> 등록2 </button>
		</form>
		-->
		










