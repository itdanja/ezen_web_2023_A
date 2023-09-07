<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<style type="text/css">
	
		*{ 
			margin: 0px; padding: 0px; 
			box-sizing: border-box; 
			list-style-type: none; /* 글머리 제거 */
			font-family: 'omyu_pretty';
		}
		a{ color: black; text-decoration: none; }
	
		@font-face {
		    font-family: 'omyu_pretty';
		    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-01@1.0/omyu_pretty.woff2') format('woff2');
		    font-weight: normal;
		    font-style: normal;
		}
	
		.snscontainer{
			width: 350px; margin: 0px auto;
		}
		.snsheader{
			display: flex;
    		justify-content: space-between;
    		margin: 20px 5px;
		}
		.feed{
			padding: 10px; border: 1px solid #e8e8e8;
			border-radius: 20px;
			margin-bottom: 30px;
		}
		.feed .img img{
			width: 100%;
		    height: 300px;
		    object-fit: cover;
		    border-radius: 20px;
		}
		.feed .content{
			margin: 20px 0px; font-size: 16px;
		}
		.feed .replybox{
			font-size: 13px;
			margin: 20px 0px;
		}
		.btnbox button{
			background: none;
		    border-radius: 20px;
		    border: 1px #ae9a9a solid;
		    padding: 5px 3px;
		    width: 50px;
		    box-shadow: 1px 1px 1px #ae9a9a;
		    font-size: 11px;
		}
		.date{
			font-size: 11px; margin-bottom: 5px;
		}
		.replybox{
			border-top: 1px solid #e8e8e8;
    		padding-top: 10px;
		}
		.replybox button{
			border: none;
		    background-color: transparent;
		    margin-left: 5px;
		}
		.reply{
			display: flex;
		    align-items: center;
		    justify-content: space-between;
		}
		.searchbox{

		    margin: 20px 0px;
		}
		.searchbox input{
			border: 1px solid #ae9a9a;
		    box-shadow: 1px 1px 6px 0px #ae9a9a;
		    border-radius: 5px;
		    padding: 5px 10px;
		    width: 100%;
	    }
	    .searchbox .feedcount{
	    	font-size: 10px;
		    padding: 10px 5px;
		    text-align: right;
	    }
	    .btnbox{
	    	display: flex;
    		justify-content: space-between;
	    }
		
	</style>

</head>
<body>

	<div class="snscontainer">
		<div class="snsheader"> 
			<a href="sns.jsp"> SNS </a>
			<a href="#"> 등록 </a>
		</div>	
		
		<div class="searchbox">
			<div class="feedcount"> 총 피드 수 : 3 </div>
			<input type="text" placeholder=" search "> 
		</div>
		
		<div class="feedbox">
			
			<div class="feed"> 
				<div class="img"> <img src="여행2.webp" /> </div>
				<div class="content"> 
					<div class="date"> 1시간전 </div>
					방탄소년단이 'BTS 2019 SUMMER PACKAGE in KOREA' 촬영으로 다녀온✨ <br/>
					전라북도 완주에 위치한 이곳은 작은 비밀공간을 지나면 볼 수 있는 갤러리부터 주변에 특색 있는 산책길까지 한 편의 수채화 같은 곳이기도 합니다. 주말 데이트로 #아원고택 어때요?
				</div>
				
				<div class="btnbox">
					
					<div>
						<button type="button">수정</button>
						<button type="button">삭제</button>
						<button onclick="onreply()" type="button">답글</button>
						<button type="button">다운로드</button>
					</div>
					
					<span style="font-size: 15px;">
						<span> 👍 3 </span>
						<span> 👎 10 </span>
					</span>
					
				</div>
				
				<div class="replybox">
					<div class="reply"> 
						<span> 방탄소년단 너무 좋아요. </span>
						<div class="replyrignt">
							<span> 10분전 </span> 
							<span> <button type="button">x</button> </span> 
						</div>
					 </div>	
					 
					 <div class="reply"> 
						<span> 꼭 한번 놀러가보고 싶네요. </span>
						<div class="replyrignt">
							<span> 8분전 </span> 
							<span> <button type="button">x</button> </span> 
						</div>
					 </div>	
					 
				</div>
				
			</div>
			
	
			<div class="feed"> 
				<div class="img"> <img src="여행.jpg" /> </div>
				
				<div class="content"> 
					<div class="date"> 13시간전 </div>
					겸재 정선이 말아주는 국내 여행😎 <br /><br />
					우리나라 산천을 독자적인 화법으로 그려낸 겸재 정선! <br />
					생생하게 살아 움직이는듯한✨그림 속 여행지들로 떠나보세요. <br />
				</div>
				
				<div class="btnbox">
					
					<div>
						<button type="button">수정</button>
						<button type="button">삭제</button>
						<button onclick="onreply()" type="button">답글</button>
						<button type="button">다운로드</button>
					</div>
					
					<span style="font-size: 15px;">
						<span> 👍 25 </span>
						<span> 👎 7 </span>
					</span>
					
				</div>
				
				
				<div class="replybox">
					<div class="reply"> 
						<span> 사진 너무 잘 나왔네요. </span>
						<div class="replyrignt">
							<span> 1분전 </span> 
							<span> <button type="button">x</button> </span> 
						</div>
					 </div>	
					 
				</div>
				
			</div>
			
			
			<div class="feed"> 
				<div class="img"> <img src="여행3.png" /> </div>
				<div class="content"> 
					<div class="date"> 3일전 </div>
					RM 따라 서울을 즐기는 방법😎<br /><br />

					동에 번쩍 서에 번쩍 대한민국 구석구석을 여행하는 #방탄소년단 #RM 을 따라 서울에서 전시보고, 한강에서 따릉이도 타는 #서울여행 어떤가요?🚶‍♂️✨마음의 평화가 찾아오는 힐링 여행이 될 거예요.
				</div>
				
				<div class="btnbox">
					
					<div>
						<button type="button">수정</button>
						<button type="button">삭제</button>
						<button onclick="onreply()" type="button">답글</button>
						<button type="button">다운로드</button>
					</div>
					
					<span style="font-size: 15px;">
						<span> 👍 1 </span>
						<span> 👎 8 </span>
					</span>
					
				</div>
				
				<div class="replybox">
					<div class="reply"> 
						<span> 대한민국 구석구석 </span>
						<div class="replyrignt">
							<span> 10분전 </span> 
							<span> <button type="button">x</button> </span> 
						</div>
					 </div>	
					 
					 <div class="reply"> 
						<span> 서울여행 어떤가요? 마음의 평화가 찾아오는 힐링 여행 </span>
						<div class="replyrignt">
							<span> 1일전 </span> 
							<span> <button type="button">x</button> </span> 
						</div>
					 </div>	
					 
				</div>
				
				
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		
	</script>

	

</body>
</html>