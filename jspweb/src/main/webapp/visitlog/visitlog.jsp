<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<link href="visitlog.css" rel="stylesheet" />
	
</head>
<body>

	<div class="visitwrap">
	
		<div class="visitwritebox">
			<div class="visitwriter_top">
				<input class="vwriter" type="text" placeholder="작성자">
				<input class="vpwd" type="password" placeholder="비밀번호">
			</div>
			<textarea class="vcontent" placeholder="내용 입력해주세요"></textarea>
			<button onclick="vwrite()" type="button">등록</button>
		</div>
	
		<div class="visitprintbox">

		</div>
		
		
	</div>


	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="visitlog.js" type="text/javascript"></script>

</body>
</html>