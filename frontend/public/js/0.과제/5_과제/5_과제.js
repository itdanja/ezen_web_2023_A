
// 누구를~~  : userbox 를 
// 1. 조작/제어할 HTML 태그 dom객체 호출
let userbox 
= document.querySelector('.userbox');

// 어떻게~~  : 페이지전체(body) 에서 키보드를 누를때
	// DOM객체명.addEventListener('이벤트명' , ()=>{ })
document.body.addEventListener('keydown' , ( e )=>{
	console.log('키 눌림');
	// 1. 눌린 키 상태 확인 e.keyCode
	console.log( e ); // keydown 이벤트 상태 객체
	// 2. 만약에 왼쪽/오른쪽 키를 눌렀을때 css left 변경  
	if( e.keyCode == 37 ){
		console.log("왼쪽으로 이동"); // css left 차감 
		userbox.style.left--;
	}else if( e.keyCode == 39 ){
		console.log('오른쪽으로 이동');	 // css left 증가 
		userbox.style.left++;
	}
	// 확인 
	console.log( userbox.style.left );
	
})


