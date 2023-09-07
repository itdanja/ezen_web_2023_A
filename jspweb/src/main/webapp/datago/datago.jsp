<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "../header.jsp" %>

	<div class="webcontainer">
	
		<div>
			<h2> - 카카오지도  - </h2>
			<div class="detailbox">
			
			</div>
			<div id="map" style="width:100%;height:500px;"></div>
		</div>
		
		<div>
			<h2> - 안산시 착한가격업소 현황 - </h2>
			<table class="apiTable1" style="width: 100%; text-align: center;">
				
			</table>
		</div>
			
	</div>
	
	<!-- 카카오js -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd&libraries=clusterer"></script>
	
	<script src="/jspweb/js/datago/datago.js" type="text/javascript"></script>

</body>
</html>








