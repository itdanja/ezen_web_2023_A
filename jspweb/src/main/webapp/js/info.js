
function mupdate(){
	let signupForm = document.querySelectorAll('.signupForm')[0];
	let signupData = new FormData( signupForm );
	$.ajax({
		url : "/jspweb/MemberInfoController" , 
		method: "put" ,			
		data : signupData ,		
		contentType : false ,		
		processData : false ,
		success : r => { 
			if( r ){ // 회원가입성공 [ 1.알린다 2.페이지전환]
				alert('회원수정완료');
				location.href = '/jspweb/member/info.jsp';
			}
			else{ // 회원가입실패
				alert('회원수정실패[관리자문의]');
			}
		} ,
		error : e => { console.log(e) } ,
	})
}

function mdelete(){
	
	let dconfirm = confirm('정말 탈퇴하시겠습니까?');
	if( dconfirm == true ){
		let mpwdconfirm = prompt('비밀번호 확인');	
	}
}


getInfo()
function getInfo(){
	
	$.ajax({
		url : "/jspweb/MemberInfoController" ,
		data : { type : "info" },
		method : "get", 
		success : r => { 
			console.log( r );
			
			document.querySelector('.mid').innerHTML = `${ r.mid }`;
			document.querySelector('.preimg').src = `img/${ r.mimg }`;
			document.querySelector('.memail').innerHTML = `${ r.memail }`;
			
		} ,
		error : e => { console.log(e); } 
	});
}; 

// 2. 비밀번호 유효성검사 [ 1.정규표현식 검사 2. 비밀번호 와 비밀번호 확인 일치여부 ]
function pwcheck(){	
	let pwcheckbox = document.querySelector('.pwcheckbox')
	
	let mpwd = document.querySelector('.mpwd').value; 					console.log('mpwd : ' + mpwd);	
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;		console.log('mpwdconfirm : ' + mpwdconfirm);	
	
		let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
		
		if( mpwdj.test( mpwd ) ){  
			if( mpwdj.test( mpwdconfirm) ){
					pwcheckbox.innerHTML = `사용가능한 비밀번호`;
			}else{
				pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`; 
			}
		}else{
			pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`;
		}
} // f end 

// 7. 첨부파일에 등록된 사진을 HTML 표시하기 < 등록 사진을 미리보기 기능 >
function preimg( o ){ console.log('사진 선택 변경');
	console.log( o ); // 이벤트 발생시킨 태그의 DOM객체를 인수로 받음
	// 1. input태그의 속성 [ type,class,onchange,name,value 등등 ] type="file" 이면 추가적인 속성 
		// .files : input type="file" 에 선택한 파일 정보를 리스트로 받음 
	console.log( o.files );		console.log( o.files[0] ); // 리스트중에서 하나의 파일만 가져오기 
	// --- 해당 파일을 바이트코드 변환 
	// 2. JS 파일읽기 클래스 선언 
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일읽기객체 선언 
	// 3. 파일 읽어오기 함수 제공 
	file.readAsDataURL( o.files[0] ); // input 에 등록된 파일리스트(o.files) 중 1개를 파일객체로 읽어오기 
		console.log( file );
	// document.querySelector('.preimg').src = file.result; // img src속성에 대입 // 오류 
	// 4. 읽어온 파일을 해당 html img태그에 load 
	file.onload = e => { // onload() : 읽어온 파일의 바이트코드를 불러오는 함수 구현 
		console.log( e ); 				// e : 이벤트 정보
		console.log( e.target );	 	// onload() 실행한 FileReader 객체
		console.log( e.target.result ); // 읽어온 파일의 바이트코드 
		document.querySelector('.preimg').src = e.target.result; // img src속성에 대입 
	} 
	
} // f end 






