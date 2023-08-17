<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> AJAX [ JS ---- 자바[서블릿] 통신 ] </h3>
	<h6> 1.[응답:문자타입]JS 에서 servlet[자바웹클래스] 에게 통신하고 데이터 반환 받기  </h6>
	<button onclick="예제1()" type="button">예제1</button>
	
	<h6> 2.[응답:문자타입/한글인코딩] JS 에서 servlet[자바웹클래스] 에게 통신하고 데이터 반환 받기  </h6>
	<button onclick="예제2()" type="button">예제2</button>
	
	<h6> 3.[응답:JSON타입[직접변환]/한글인코딩] JS 에서 servlet[자바웹클래스] 에게 통신하고 데이터 반환 받기  </h6>
	<button onclick="예제3()" type="button">예제3</button>
	
	<h6> 4.[응답:JSON타입[JACKSON라이브러사용]/한글인코딩] JS 에서 servlet[자바웹클래스] 에게 통신하고 데이터 반환 받기  </h6>
	<button onclick="예제4()" type="button">예제4</button>
	
	<!-- 최신 JQUERY 라이브러리 호출 * AJAX 메소드 사용할려고 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="1_AJAX통신.js" type="text/javascript"></script>

</body>
</html>