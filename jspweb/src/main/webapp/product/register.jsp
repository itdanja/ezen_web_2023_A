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
		<form class="registerForm">
		
			카테고리 : <select name="pcno">
						<option value="1"> 노트북 </option>
						<option value="2"> 태블릿 </option>
						<option value="3"> 냉장고 </option>
					</select> <br/>
			제품명 : <input name="pname" type="text"> <br/>
			제품설명 : <textarea name="pcontent" rows="" cols=""></textarea> <br/>
			제품가격 : <input name="pprice" type="number">  <br/>
			
			<!-- 1. 첨부파일 1개일때.  -->
				<!--    제품이미지 : <input name="pimg" type="file"> <br/>  -->
				
			<!-- 2. 첨부파일 여러개일때.  input 속성에 multiple="multiple" -->
				<!-- 제품이미지 : <input name="pimg" type="file" multiple="multiple" >  -->
				<!-- multiple="multiple" 속성 사용시 cos.jar에서는 여러개 파일명 호출 불가능 [ 업로드 가능 ]    -->
				<!-- 해결방안 : 1. multiple="multiple" 사용하지 않고 input 여러개 사용 -->
				<!-- 해결방안 : 2. multiple="multiple" 사용하고 cos.jar 대신 commons.jar 사용 -->
			
			<!-- 3. 드래그앤드랍. cos.jar 와 commons.jar 가능 -->
			<div class="fileDropBox" style="width: 300px; height: 100px; border: 1px solid red;" >
				여기에 드래그 해서 파일을 올려주세요.
			</div>
				
			<button onclick="onRegister()" type="button">등록</button>
		</form>
	</div>
	
	<script src="/jspweb/js/product/register.js" type="text/javascript"></script>
	

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
		










