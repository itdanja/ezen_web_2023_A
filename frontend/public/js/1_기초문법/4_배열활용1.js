
// 1. 배열선언 : '학생리스트' 배열명으로 비어 있는 배열 선언
let 학생리스트 = [ ]	// * 초기에는 배열에 아무것도 없다.

// 2. 이벤트 : 무엇인가가 실행/일어 났음
	// onclick : 온클릭 이벤트 [ 클릭했을때 이벤트 실행 ]
	// 이벤트 함수[ 코드들이 모여있는 주머니/공간/집합 ]
		// 함수 형태 : function 함수명( 매개변수 ){  }
		// 함:상자	수:숫자	=> 숫자들이 들어있는 상자 => 미리 정의된 수 => 미리 정의된 코드
function 추가함수(){ // f start
	alert('함수 실행했네...')
	// 1. input 객체 호출 
	let snameInput = document.querySelector(".sname")
		// document : HTML문서( DOM객체 ) 
		// query : 쿼리(질의)
		// Selector : 선택자 ( id , class , 마크업 등 )
			// 1. document.querySelector(".sname") : sname 이라는 class명 가진 input 객체 호출 
			// 2. 호출된 input객체를 'sname' 변수에 담았다.
	// 2. 입력받은 데이터 가져오기 
	let name = snameInput.value
			// 3. 변수명.value	: 입력된 값 호출 
	// 3. 입력받은 데이터를 배열에 추가 
	학생리스트.push( name )
			// 4. 배열명.push(데이터)	: 해당 데이터를 배열에 추가 
	// 4. 배열 출력 
		// document.write( 학생리스트 )		// 문서에 해당 데이터를 쓰기[ 기존데이터 사라짐 ]
		// 1. ul 객체 호출 
	let slistUl = document.querySelector(".slist")
		// 2. 해당 ul 객체에 쓰기
	slistUl.innerHTML = '<li>'+학생리스트+'</li>'
		// innerHTML : <> (inner) </>
} // f end 













		
