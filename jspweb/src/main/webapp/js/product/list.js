
let productList = null;	// getproductlist() 의 ajax 로부터 요청된 결과를 담는

// [2023-03-29 김현수] 1. 모든 제품 목록 html 출력 함수  
function produclistprint(  ){
    let html = `<p style="font-size:12px; text-align:right" > 제품목록수 : ${ productList.length } 개 </h6>`;
    productList.forEach( ( p , i) => {
		
		let firstImg = p.imgList[Object.keys(p.imgList)[0]];
		
		html += `
			<div onclick="productprint( ${ i } )" class="productbox">
				<div class="pimgbox">
					<img src="/jspweb/product/img/${ firstImg }">
				</div>
				<div class="pcontentbox">
					<div class="pdate"> ${ p.pdate } </div>
					<div class="pname"> ${ p.pname } </div>
					<div class="pprice"> ${ p.pprice.toLocaleString() } 원 </div>
					<div class="petc">
						<i class="far fa-thumbs-up"></i> 5
						<i class="far fa-comment-dots"></i> 2
					</div>
				</div>
			</div>
			`
	});
	document.querySelector('.produclistbox').innerHTML = html;
} // end 

// ------------------------------------ 지도 출력 --------------------------------------
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표 
    level : 6 // 지도의 확대 레벨 
});
// ------------------------------------- 마커 클러스터러를 생성합니다  -------------------
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 7 // 클러스터 할 최소 지도 레벨 
});
// $.ajax( { url:"/jspweb/product/info" , success : (r) => { } );

// ----------------------- 마커 이미지 변경 ------------------------------------ //
var imageSrc = '/jspweb/img/ezenlogo.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(10, 20)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다

// 5. 제품목록 호출 [ 1. 현재 보이는 지도좌표내 포함된 제품만 2. ]
function getproductlist( 동 , 서  , 남 , 북 ){
	clusterer.clear() // 클러스터 비우기 [ 기존 마커들 제거 ]
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method : "get",
		async : false ,
		data : { type: "fintByLatLng" , "동" : 동 , "서" : 서 ,"남" : 남 , "북":북 },
		success : (r)=>{ console.log(r)
		    // ------------ 사이드바 제품목록 --------------------------------
		    productList = r;	// 제품목록 결과를 전역변수 담아주기 
			produclistprint(  );
		   //------------ 마커 작업 ----------------------
		    var markers = r.map( ( p , i ) => {		console.log( p )
				// 마커에 추가코드 작성하기 위해 변수화
		        let marker = new kakao.maps.Marker({	
		            position : new kakao.maps.LatLng( p.plat, p.plng) ,
		            image: markerImage
		        });
		        // 마커에 클릭이벤트를 등록합니다
				kakao.maps.event.addListener(marker, 'click', function() {
				      productprint( i )
				}); // 클릭이벤트 end 
		        return marker;
		    }); // map end 
		    clusterer.addMarkers(markers);   // 클러스터러에 마커들을 추가합니다
		    //-------------------------------------------------
		} // success end 
	}); // ajax end  
} // getproductlist end 

// 6. 현재 지도의 좌표얻기
get동서남북();
function get동서남북(){
	var bounds = map.getBounds();  // 지도의 현재 영역을 얻어옵니다 
    var swLatLng = bounds.getSouthWest();   // 영역의 남서쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast();   // 영역의 북동쪽 좌표를 얻어옵니다 
    let 남 = swLatLng.getLat();
    let 서 = swLatLng.getLng();
    let 북 = neLatLng.getLat();
    let 동 = neLatLng.getLng();
    getproductlist( 동 , 서  , 남 , 북 );
}
// ------------  지도 중심좌표 이동 이벤트 //
// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener( map, 'dragend', ()=>{ get동서남북(); });
