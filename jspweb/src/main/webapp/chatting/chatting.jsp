<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="/jspweb/css/chatting/chatting.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>

<%@include file ="/header.jsp" %>
	<div class="webcontainer">
	
		<div class="chatbox">	<!--  채팅 구역 -->
			<div class="contentbox"> <!-- 채팅창  -->
					
					<div class="rcont">
						<div class="subcont">
							<div class="date"> 오전 10:07 </div>
							<div class="content"> 안녕하세요 </div>
						</div>
					</div>
					
					<div class="alarm"> 강호동님이 입장 하셨습니다. </div>
					
					<div class="lcont">
						<img src="/jspweb/member/img/default.webp" class="pimg">
						<div class="tocont">
							<div class="name"> 강호동 </div>
							<div class="subcont">
								<div class="content"> 그래 안녕 </div>
								<div class="date"> 오전 10:10 </div>
							</div>
						</div>
					</div>
			</div>
			<div class="chatbottom">
				<textarea onkeyup="enterkey()" class="msgbox" rows="" cols=""></textarea>
				<button onclick="보내기()" class="sendbtn" type="button">전송</button>
			</div>
		</div>
	</div>
	
	
	<script src="/jspweb/js/chatting/chatting.js" type="text/javascript"></script>

</body>
</html>