
// 1. list.js 에서 클릭된 게시물 번호 호출 [ 세션 ]
let no = sessionStorage.getItem( 'no' );
let boardList = JSON.parse( localStorage.getItem('boardList') ) ;
console.log( 'list.js 에서 저장된 세션정보: ' + no );
// 2. 클릭된 게시물번호의 게시물찾아서 출력 
onView()
function onView(){
	// 식별자 : 인덱스 , 게시물번호=인덱스찾기
	
	// 1. 어디에
	let title = document.querySelector('.title')
	let writerdate = document.querySelector('.writerdate')
	let content = document.querySelector('.content')
	
	// 2. 무엇을 ??? 
	// 1. 해당하는 게시물번호의 게시물찾기
	for( let i = 0 ; i<boardList.length; i++ ){
		let b = boardList[i] // i번째 게시물을 꺼내기 
		if( b.no == no ){
			console.log( b ); // 만약에 i번째 게시물번호와 클릭된 게시물 번호와 같으면
			// 3. 대입 
			title.innerHTML = b.title
			writerdate.innerHTML = ` 작성자 : ${ b.writer } 작성일 : ${ b.date } `;
			content.innerHTML = b.content
			break; // 가장 반복문 종료
		}
	} // end 
}



