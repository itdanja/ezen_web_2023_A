/*
	변수
		지역변수 : 지역{ }에서 태어났으면 지역 밖으로 못나감
			{안산} 태어났으면 안산{} 밖으로 못나감
			- { } 안에서 선언된 변수는 { } 밖에서 사용 불가능 / 안 으로는 가능
			
		전역변수 : 지역{ }밖에서 태어났으면 자유롭게 이동 가능 
			대한민국 태어났으면 안산{} 성남{} 이동 가능 
			- { } 밖에서 선언된 변수는 { } 안으로 이동 가능 
*/


console.log('JS실행');

// 4. 배열 선언 
let 방문록배열 = []; // 1. 여럿 함수{ }에서 사용하기 때문에 함수 밖에서 선언

// 1. 이벤트 함수 만들기 
function 등록( ){ // s end 
	// let 방문록배열 = []; // 2. 
	// 1. 함수가 잘 작동하는지 체크~
	console.log(' 등록함수 실행 ');	

	// 2. <input> 태그 호출 
	let contentInput = document.querySelector('.content')
	console.log( contentInput ); // 호출 잘 되었는지 체크~~
	
	// 3. 입력받은 값 호출 
	let value = contentInput.value;
	console.log( value );		// 입력값 들어왔는지 체크~~
	
	// 4. 배열 등록
	방문록배열.push( value );
	console.log( 방문록배열 );		
	
} // f end 


