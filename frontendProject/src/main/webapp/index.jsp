<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 다른 JSP 파일 호출 -->
	
	<%@include file ="header.jsp" %>
	<p>
		대문입니다.
		ctrl+f11 실행 [ 톰캣서버 ]
		코드변경되면 저장후에 [ 크롬에서 ctrl+f5 : 강력새로고침 ]
	</p>
	
	<!-- 다른 JSP 파일 호출 -->
	<%@include file ="footer.jsp" %>
	
	
</body>
</html>