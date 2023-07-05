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
	<!--  범위지정 ctrl+shift+F -->
	<div class="kioskwrap"> <!-- 키오스크 전체 -->
		<div class="kioskheader">   <!-- 헤더 : 광고이미지/카테고리출력 표시되는 구역 -->
			
			<img class="himg" src="../img/himg1.png" >
			
			<!-- 카테고리 -->
			<ul class="categorymenu">
				<!-- categoryPrint함수가 html 넣어주는 위치  -->
			</ul>
			
		</div>  <!-- 헤더 end  -->
		
		<div class="kioskcontent">   <!-- 본문 : 제품출력/카트출력 구역-->
		
			<div class="productbox">   <!-- 제품구역 -->
					<!-- productPrint 함수가 html 넣어주는 위치  -->
			</div> <!-- 제품구역 end  -->
			
			<div class="cartbox">   <!-- 카트구역 -->
				
				<div class="cartcontent">   <!-- 제품개수/총가격 , 제품정보 출력 -->
				
					<div class="carttop">  <!-- 제품개수/총가격 출력 구역 -->
						<div> 카트 <span class="ccount">0</span> </div>
						<div> 총 주문금액 <span class="ctotal">0</span> </div>
					</div>
					
					<div class="cartbottom">    <!-- 제품정보 출력 구역 -->
						
						<!--  -->
						
					</div> 
				</div>
				
				<div class="cartbtn">	<!-- 버튼 구역 --> 
					<button onclick="cartCancel()" class="cancelbtn">취소하기</button>
					<button class="orderbtn">주문하기</button>
				</div> 
				
			</div> <!-- 카트구역  end  -->
			
		</div>  <!-- 본문 end  -->
		
	</div>  <!-- 키오스크 end -->
	
	<%@include file="../footer.jsp" %>

	<script src="/frontendProject/js/kiosk.js" type="text/javascript"></script>

</body>
</html>






