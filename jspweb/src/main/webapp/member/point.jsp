<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	
	<style type="text/css">
	
		.paybottom{
			display: flex;
		    justify-content: space-around;
		    height: 100px;
		    background-color: #e8e8e8;
		    align-items: center;
		    margin-top: 100px;
		    font-size: 20px;
		}
		
		.paybottom button{
			 border: none;
		    background-color: blue;
		    color: white;
		    height: 50px;
		    width: 300px;
		}
		.paymoney{
			display: flex; margin-top: 50px;     flex-wrap: wrap;
		}
		.paymoney div{
			width: 30%; margin:1%;  
		}
		
	</style>
</head>
<body>
	
	<!-- JSP파일안에 다른 JSP 파일 import 하기  -->
	<%@include file ="../header.jsp" %>

	<div class="container">
	
		<h3> 마이 포인트 </h3>
		
		<ul class="nav nav-tabs nav-pills nav-fill" id="myTab" role="tablist">
			<li class="nav-item" role="presentation">
				<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
					data-bs-target="#home-tab-pane" type="button" role="tab"
					aria-controls="home-tab-pane" aria-selected="true">포인트충전</button>
			</li>
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
					data-bs-target="#profile-tab-pane" type="button" role="tab"
					aria-controls="profile-tab-pane" aria-selected="false">포인트내역</button>
			</li>

		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
				<div class="paymoney" style="">
					<div onclick="selectpay(event,1000)" class="selectpay" style=""><img src="/jspweb/img/1000.png" width="100%"/></div>
					<div onclick="selectpay(event,5000)"class="selectpay" style=""><img src="/jspweb/img/5000.png" width="100%"/></div>
					<div onclick="selectpay(event,10000)"class="selectpay" style=""><img src="/jspweb/img/10000.png" width="100%"/></div>
					<div onclick="selectpay(event,50000)"class="selectpay" style=""><img src="/jspweb/img/1000.png" width="100%"/></div>
					<div onclick="selectpay(event,100000)"class="selectpay" style=""><img src="/jspweb/img/5000.png" width="100%"/></div>
				</div>
				<div class="paybottom" >
					<div> 결제금액 : <span class="pay"> 10,000원 </span> </div>
					<button type="button" onclick="payment()" >결제하기</button>
				</div>
			</div>
			<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
			
			</div>
		</div>
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	
	<script src="/jspweb/js/point.js" type="text/javascript"></script>
	
	
</body>
</html>