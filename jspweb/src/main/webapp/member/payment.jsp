<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	
	<style type="text/css">
	
		.leftbox{ width:  50%; padding: 2%;  }
		.rightbox{ width:  50%; padding: 2%;  }
		.paybox{ display: flex; margin-bottom: 30px; }
		.paybox img{ width: 30%; margin: 2%; }
		
		
	</style>
	
</head> 
<body>

	<%@include file = "../header.jsp" %>

	<div class="container" style="display: flex;"> <!-- 회원가입 전체 구역  -->

		<div class="leftbox">
			<h3>포인트 충전하기</h3>
			<div class="paybox">
				<img src="/jspweb/img/1000.png" width="100%"/>
				<img src="/jspweb/img/5000.png" width="100%"/>
				<img src="/jspweb/img/10000.png" width="100%" />
			</div>
			<div class="text-center fs-5 mb-2">충전포인트 <span class=point></span> </div>
			<button class="form-control" type="button" onclick="payment()">결제하기</button>
		</div>
		
		<div class="rightbox">
			<h3>포인트 사용내역</h3>
			<h5 class="text-end"> 남은 포인트 : <span class="pay"></span> </h5>
			<table class="table pointTable">
			</table>
		</div>
	</div>
		<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script src="/jspweb/js/payment.js" type="text/javascript"> </script>
	

</body>
</html>




