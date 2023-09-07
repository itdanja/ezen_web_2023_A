/*
	공공데이터 포털 
	https://www.data.go.kr/
		- 공공데이터 데이터 선택 -> 활용신청 -> Request URL 확인 
		
	$.ajax({
		url : "신청한공공데이터 Request URL" ,
		method : "GET" , 
		data: {} ,
		success : r => {} , 
		error : e => {} 
	})
	
 */

// 1. 안산시 착한가격업소 API 호출 
api1()
function api1(){
	$.ajax({
		url : "https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=45&serviceKey=z427Q0DLkQqM0SDOc1Lz8jPzk%2BKj0ng%2Bvz7h3I8CpVs3T90219bWi2o%2BmStIxJW%2B9lwayA%2FsAT6apxsxuvydQg%3D%3D" ,
		method : "get" , 
		data: {} ,
		success : response => { console.log( response );
			let data = response.data; console.log( data );
			console.log( data[0] ); console.log( data[0].업소명 );
			// 1. 출력할 dom객체 
			let apiTable1 = document.querySelector('.apiTable1');
			// 2. HTML 구성 
			let html = `<tr> <th> 번호 </th> <th> 상호명 </th>
							<th> 주소 </th> <th> 연락처 </th>
							<th> 대표메뉴1 </th> <th> 대표메뉴2 </th> <th> 대표메뉴3 </th>
						</tr>`;
				// 2-2 
				// 배열명.forEach( ( 반복변수명 ) => { 반복코드 } )
				// 배열명.forEach( ( 반복변수명 , 인덱스  ) => { 반복코드 } )
			data.forEach( ( d , i )=>{
				html += `<tr>
							<td> ${ i+1 }  </td>
							<td> ${ d.업소명 } </td>
							<td> ${ d.소재지도로명주소 } </td>
							<td> ${ d.연락처 } </td>
							<td> ${ d.품목1 } / ${ d.가격1 } </td>
							<td> ${ d.품목2 } / ${ d.가격2 } </td>
							<td> ${ d.품목3 } / ${ d.가격3 } </td>
						</tr>`
			});
			// 3. 출력할 위치에 HTML 대입 
			apiTable1.innerHTML = html;
		} , 
		error : e => {} 
	})
} // f end 

/*
	카카오 개발자 센터
		https://developers.kakao.com
		1. 애플리케이션 추가 
		2. 플랫폼 web -> 사이트 도메인 등록 
		
		https://apis.map.kakao.com/
		
*/

// 1. 접속한 브라우저의 GPS 좌표 얻기  [ geolocation ] - 엣지브라우저
navigator.geolocation.getCurrentPosition( pos => {  console.log( pos ); 
	let lat = pos.coords.latitude;
	let lng = pos.coords.longitude;
	// 카카오지도 출력 
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng( lat , lng ), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	
	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng( lat ,  lng); 
	
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);

}) // f end 


/*
	// 카카오지도 출력 
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	

*/























































