

// 3. 선택된 제품번호에 해당하는 제품 출력 함수 
findByPno( new URL(location.href).searchParams.get("pno") )
function findByPno( pno ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" , 
		data : { type: "findByPno" 	, pno : pno  } ,
		success : jsonObject => { console.log( jsonObject ) 
			
				let imgbox = document.querySelector('.imgbox');
				
				let html =``;
					
				Object.values(jsonObject.imgList).forEach( (img , i) => { 
				
						html += `<div class="carousel-item ${ i == 0 ? 'active' : '' }">
						      <img src="/jspweb/product/img/${ img }" class="d-block w-100" alt="...">
						    </div>`;
				})
				imgbox.innerHTML = html;
				
				document.querySelector('.mid').innerHTML = `${ jsonObject.mid }`;
				document.querySelector('.pcname').innerHTML = `${ jsonObject.pcname }`;
				document.querySelector('.pdate').innerHTML = `${ jsonObject.pdate }`;
				document.querySelector('.pname').innerHTML = `${ jsonObject.pname }`;
				document.querySelector('.pprice').innerHTML = `${ jsonObject.pprice.toLocaleString() }원`;
				document.querySelector('.pcontent').innerHTML = `${ jsonObject.pcontent }`;
				
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = { 
				        center: new kakao.maps.LatLng( jsonObject.plat , jsonObject.plng ), // 지도의 중심좌표
				        level: 6 // 지도의 확대 레벨
				    };
				var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
				// 지도를 클릭한 위치에 표출할 마커입니다
				var marker = new kakao.maps.Marker({ 
				    // 지도 중심좌표에 마커를 생성합니다 
				    position: map.getCenter() 
				}); 
				// 지도에 마커를 표시합니다
				marker.setMap(map);
	
		}
	})
}

