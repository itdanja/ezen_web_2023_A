<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

	<style type="text/css">
	
		.cart_t{
			    text-align: center;
    			vertical-align: middle;
		}
		.checkbtn{ zoom: 1.3; }
		
		.buybtnbox button {
			width: 20%;
			margin: 10px;
			border: none;
			background-color: black;
			color: white;
		}
		.buybtnbox{
			display: flex;
			height: 60px;
			justify-content: center;
		}
	
		.selectbtnbox button{
			width: 100px;
			margin-right: 5px;
		}
	
	</style>

</head>
<body>

	<%@include file="../header.jsp"%>
	<div class="container">

		<table class="table cart_t">
			<tr>
				<th width="5%"><input type="checkbox" class="checkbtn"></th>
				<th width="5%">이미지</th>
				<th width="40%">상품정보</th>
				<th width="15%">가격</th>
				<th width="15%">비고</th>
			</tr>

			<tr>
				<td ><input type="checkbox" class="checkbtn"></td>
				<td ><img width="100%" alt="" src="/jspweb/product/img/1667290461000_태블릿_삼성.png" /></td>
				<td >상품정보</td>
				<td >가격</td>
				<td >비고</td>
			</tr>
			
			<tr>
				<td ><input type="checkbox" class="checkbtn"></td>
				<td ><img width="100%" alt="" src="/jspweb/product/img/1667290461000_태블릿_삼성.png" /></td>
				<td >상품정보</td>
				<td >가격</td>
				<td >비고</td>
			</tr>
			
		</table>
		
		<div class="selectbtnbox">
			<button type="button">선택삭제</button>
			<button type="button">전체삭제</button>
		</div>
		<div class="buybtnbox">
			<button type="button">전체구매</button>
			<button onclick="payload()" type="button">선택구매</button>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src="/jspweb/js/product/likelist.js" type="text/javascript"></script>

</body>
</html>