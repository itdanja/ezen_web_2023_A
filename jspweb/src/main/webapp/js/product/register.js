
// 1. 제품 등록 
function onRegister(){
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














