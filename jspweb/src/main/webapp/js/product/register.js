
// 1. 제품 등록 
function onRegister(e){
	// 1. form dom객체 호출 
	let registerForm = document.querySelectorAll('.registerForm')[0]; console.log( registerForm );
	// 2. formData 객체 생성  [ ajax 전송타입 :  multipart/form-data  ]
	let formData = new FormData( registerForm ); console.log( formData );
	// 3. 
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method: "post",
		data : formData , 
		contentType : false ,  // ajax 전송타입 :  multipart/form-data 
		processData : false , 
		success : result => { console.log( result ); }
	})
} //f end 

// 2. 드래그 앤 드랍 
	// 1. 드래그 앤 드랍 할 구역 dom객체 호출 
let fileDropBox = document.querySelector('.fileDropBox');

	// 2. 해당 dom객체에 구역내 드래그가 들어왔을때.
fileDropBox.addEventListener( "dragenter" , (e)=>{
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
	console.log( '드래그가 들어왔어.' );
});
	// 3. 해당 dom객체에 구역내 드래그가 올라왔을때.
fileDropBox.addEventListener( "dragover" , (e) => {
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
	console.log( '현재구역에 드래그가 위치중.');
	fileDropBox.style.backgroundColor = '#e8e8e8';
});
	// 4. 해당 dom객체에 구역내 드래그가 나갔을때
fileDropBox.addEventListener( "dragleave" , (e)=>{ 
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
	console.log( '드래그가 나갔을때.')
	fileDropBox.style.backgroundColor = '#ffffff';
});
	// 5.해당 dom객체에 구역내 드래그가 드랍(마우스를 놓았을때)했을때.
fileDropBox.addEventListener( 'drop' , (e)=>{
	console.log( '해당 드래그가 드랍했어.' );
	console.log( e );
	
	// * 브라우저 자체적으로 'drop' 이벤트 우선적으로 실행되므로 해당 이벤트실행 불가능 
	// - 해결방안 : 기존 상위(브라우저) 이벤트 무시 
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
	
	// -------- 드랍된 파일의 정보??? ------------- //
		// 1. 드랍된 데이터 정보를 이벤트 결과에서 찾기 
		console.log( e.dataTransfer ) 
		console.log( e.dataTransfer.files )
		console.log( e.dataTransfer.files[0] )
		console.log( e.dataTransfer.files[0].name )
});

/*

	dom객체 이벤트 추가하는 방법 2가지 . 
		가정 : 특정 구역에 클릭(onclick) 이벤트 추가 
		1. HTML 속성 이벤트 사용하는 방법
			<button onclick="함수" type="button"></button>
			
		2. .addEventListener( '이벤트명' , 함수 )  : 사용하는 방법
			let button = document.querySelector('button');
			button.addEventListener( 'onclick' , 함수 );
			
		이벤트 
			종류 : click , keyup , keydown , drop 등등등 
			- 정의 : 특정 조건을 충족하면 발생하고 발생한 이벤ㅌ으 결과물 반환 해주는 구조 
			
			
		

	드래그 앤 드랍 관련 이벤트 
		1. dragenter	:
		2. dragover 	:
		3. dragleave	:
		4. drop			:
	
*/
	































/*
function register1(){
	
	$.ajax({ //  [ form 태그 없는경우 1 ]  
		url : "/jspweb/ProductInfoController",
		method : "post" ,
		data : {
			pname1 : document.querySelector('.pname1').value , 
			pcontent1 : document.querySelector('.pcontent1').value 
		} , 
		success : r => { console.log( r ) } , 
	})
	
}
function register2(){

	let registerForm1 = document.querySelectorAll('.registerForm1')[0];
	let formData = new FormData( registerForm1 );
	
	$.ajax({ //  [ form 태그 이용하는 경우 2 - form 전송시 ]
		url : "/jspweb/ProductInfoController",
		method : "post" ,
		data : formData , 
		// 전송타입 1. text/html , 2.application/json 3. multipart/form-data 
		contentType: false ,
 		processData: false ,
		success : r => { console.log( r ) } , 
	})
	
}
*/














