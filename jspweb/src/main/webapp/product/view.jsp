<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/product/view.css" rel="stylesheet">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="webcontainer"> <!-- 지도와 사이드바 포함된 구역 -->
		<div class="productBox">
			
			<div id="carouselExample" class="carousel slide">
			  <div class="imgbox carousel-inner">

			  </div>
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
			
			<div> 판매자: <span class="mid"> </span> </div>
			<div> 
				카테고리 : <span class="pcname"> </span> / 
				등록일 : 	<span class="pdate"> </span> </div>
			<div> <span class="pname"> </span> </div>
			<div> <span class="pprice"> </span> </div>
			<div> <span class="pcontent"> </span> </div>
			<div class="etcbtnbox">
				<button type="button">찜하기</button>
				<button type="button">바로구매</button>
			</div>
			
			
			<nav class="mt-5 ">
			  <div class="nav nav-pills flex-column flex-sm-row " id="nav-tab" role="tablist">
			    <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#navtab1" type="button" role="tab" aria-controls="nav-home" aria-selected="true">제품위치</button>
			    <button class="nav-link" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#navtab2" type="button" role="tab" aria-controls="nav-home" aria-selected="false">가격제안</button>
			    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#navtab3" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">후기목록</button>
			    <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#navtab4" type="button" role="tab" aria-controls="nav-contact" aria-selected="false">QnA</button>
			    <button class="nav-link" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#navtab5" type="button" role="tab" aria-controls="nav-home" aria-selected="false">주의사항</button>
			  </div>
			</nav>
			<div class=" my-3 tab-content" id="nav-tabContent">
			  <div class="tab-pane fade show active" id="navtab1" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
			  	<div>제품위치</div>
			  	<div id="map" style="margin: 0 auto; width:60%;height:250px;"></div>
			  </div>
			  <div class="tab-pane fade" id="navtab2" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0">
			  	<div>가격제안</div>
			  </div>
			  <div class="tab-pane fade" id="navtab3" role="tabpanel" aria-labelledby="nav-contact-tab" tabindex="0">
			  	<div>후기목록</div>
			  </div>
			  <div class="tab-pane fade" id="navtab4" role="tabpanel" aria-labelledby="nav-contact-tab" tabindex="0">
			  	<div>QnA</div>
			  </div>
			  <div class="tab-pane fade" id="navtab5" role="tabpanel" aria-labelledby="nav-contact-tab" tabindex="0">
			  	<div>주의사항</div>
			  </div>
			</div>
		</div>
	</div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd&libraries=clusterer"></script>
	<script src="/jspweb/js/product/view.js" type="text/javascript"></script>
	

</body>
</html>


