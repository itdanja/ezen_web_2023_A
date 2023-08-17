console.log('1_AJAX통신.js Open');

// 1. 예제1
function 예제1(){ // ajax 메소드 이용한 서블릿과 통신 
	$.ajax({
		url : "http://localhost/jspweb/Test02" ,
		//url : "/jspweb/Test02" , // 학원 카톡 제출용
		method : "get" ,
		success : function 함수명(result){ console.log(result); }
	});
} // f end 
function 예제2(){
	$.ajax({
		url : "/jspweb/Test03" ,
		method : "get" ,
		success : function 함수명(result){ console.log(result); }
	});
} // f end 

function 예제3(){
	$.ajax({
		url : "/jspweb/Test04" ,
		method : "get" ,
		success : function 함수명(result){  console.log(result);  
			console.log( result.title ); console.log( result.content );
		}
	});
} // f end 
function 예제4(){
	$.ajax({
		url : "/jspweb/Test05" ,
		method : "get" ,
		success : function 함수명(result){  console.log(result);  
			console.log( result.title ); console.log( result.content );
		}
	});
} // f end 










/*
	$.ajax({
		url : "통신할경로/서블릿주소" , 
		method : "통신방법:get,post,put,delete 선택" ,
		success : function 함수명( 통신반환변수 ){ 통신성공했을때 실행코드 } , 
		error :  function 함수명( 통신반환변수 ){ 통신실패했을때 실행코드 } , 
	})
	
	- 1. success/error 속성에서 통신 결과의 반환값 받는 함수 작성시 
		1. success : function 함수명( 통신반환변수 ){ 통신성공했을때 실행코드 }
		2. success : function ( 통신반환변수 ){ 통신성공했을때 실행코드 }
		3. success : ( 통신반환변수 ) => { 통신성공했을때 실행코드 }
	
	------------------------------------------
	서블릿 내장객체
		- request : 요청 객체
		- response : 응답 객체 
			- response.getWriter().print(데이터)  	
				웹 출력=응답 데이터 
			- response.setContentType("전송할데이터타입명;인코딩타입") 			
				출력할 데이터의 타입 혹은 인코딩
				- 1. 문자전송[default]
					response.setContentType("text/html;charset=UTF-8");
				- 2. JSON전송 
					response.setContentType("application/json;charset=UTF-8");
	------------------------------------------
	JACKSON : JAVA객체를 JSON 형식에 대한 다양한 클래스 제공 라이브러리
		jackson-annotations-2.14.2 , jackson-core-2.14.2 , jackson-databind-2.14.2
		1. ObjectMapper 클래스 : JAVA객체를 JSON형식으로 변환해주는 함수들을 제공하는 클래스  
			1. .writeValueAsString( JAVA객체 ) : 해당객체를 JSON형식의 문자열로 반환 
*/




