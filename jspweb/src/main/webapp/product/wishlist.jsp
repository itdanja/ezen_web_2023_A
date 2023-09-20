<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/product/wishlist.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="container"> <!-- bs : container 디바이스 크기에 따른 반응형 구역 -->
 		<h3> 찜 목록 현황 </h3>
 		<table class="table table-hover text-center align-middle"> <!-- bs : table 기본css 적용된 테이블 / text-center : 수평정렬  / align-middle : 수직정렬 -->
 			
 			<tr>
 				<th width="5%"> <input class="checkbox" type="checkbox"> </th>
 				<th width="5%"> 이미지 </th>
 				<th width="40%"> 제품 정보 </th>
 				<th width="10%"> 가격 </th>
 				<th width="10%"> 비고 </th>
 			</tr>
 			
 			<tr>
				<td><input class="checkbox" type="checkbox"></td>
				<td> <img src="/jspweb/product/img/1667290461000_태블릿_삼성.png" width="100%" /> </td>
				<td  style="text-align: left; padding-left: 20px;" > 노트북 팝니다. </td>
				<td> 373,354원</td>
				<td> <button type="button"> X </button> </td>
			</tr>
			
 		</table>
 		<div class="selectbtn">
 			<button type="button">선택 삭제</button>
 			<button type="button">전체 삭제</button>
 		</div>
 		
 		<div class="buybtn">
 			<button type="button">선택 구매</button>
 			<button type="button">전체 구매</button>
 		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src="/jspweb/js/product/wishlist.js" type="text/javascript"></script>
</body>
</html>















