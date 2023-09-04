<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/board/list.css" rel="stylesheet"> 
</head>
<body>

	<%@include file = "../header.jsp" %>
	<div class="webcontainer">
		
			<div class="boardtop">
				<h2 class="cname"> 게시판 </h2>
				<p> 다양한 사람들과 정보를 공뷰 해보세요 </p>
			</div>
		
			<div class="boardtopetc">
				<button class="bbtn" onclick="onWrite()" type="button">글쓰기</button>
				
				<div>
					<span class="seachcount"> 게시물수 : 6 </span>
					<select class="bbtn listsize" onchange="setlistsize()">
						<option>10</option>
						<option>15</option>
						<option>20</option>
					</select>
				</div>
			</div>
			
			
			<button class="bbtn" onclick="onCategory(0)" >전체보기</button>
			<button class="bbtn" onclick="onCategory(1)" >공지사항</button>
			<button class="bbtn" onclick="onCategory(2)" >자유게시판</button>
			<button class="bbtn" onclick="onCategory(3)" >노하우</button>
			
			
			<table class="boardTable"> </table>
		
			<div class="boardbottom">
			
				<!-- 페이징처리 버튼들 -->
				<div class="pagebox"> </div>
			
				<!-- 검색 버튼들 -->
				<select class="key bbtn">	<!-- select 시 사용되는 조건의 필드명 -->
					<option value="b.btitle">제목</option>
					<option value="b.bcontent">내용</option>
					<option value="m.mid">작성자</option>
				</select>
				<input class="keyword" type="text">	<!-- select 시 사용되는 조건의 데이터 -->
				<button class="bbtn" onclick="getsearch()" type="button">검색</button>
				
			</div>
		
		
		
	</div>
	<script src="../js/board/list.js" type="text/javascript"></script>
	
</body>
</html>



