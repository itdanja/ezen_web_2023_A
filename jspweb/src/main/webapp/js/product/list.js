/* 
	https://apis.map.kakao.com/web/sample/
*/
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
    level : 12 // 지도의 확대 레벨
});

var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10, // 클러스터 할 최소 지도 레벨
    disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
});

kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
    var level = map.getLevel()-1;
    map.setLevel(level, {anchor: cluster.getCenter()});
});

// 1. 현재 보고 있는 지도의 동서남북 좌표 얻기 
getInfo();
function getInfo() {
    let 동 = map.getBounds().pa; console.log( "동:"+동 ) // 동
    let 서 = map.getBounds().qa; console.log( "서:"+서 )// 서
    let 남 = map.getBounds().ha; console.log( "남:"+남 )// 남 
    let 북 = map.getBounds().oa; console.log( "북:"+북 )// 북 
 	findByLatLng( 동 , 서 , 남 , 북 ); // 2번 실행 
}
// 2. 현재카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수 
function findByLatLng( east , west  ,  south  , north  ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" ,
		async : false , /* ajax 동기화설정 [비동기통신 async : true] / [동기통신 async : false] */
		data : { type : "findByLatLng"  , east : east , west : west , south : south , north : north },
		success : jsonArray => { console.log( jsonArray ); 
			var markers = jsonArray.map( (p) => {
		        return new kakao.maps.Marker({
		            position : new kakao.maps.LatLng( p.plat, p.plng )
		        });
		    });
			clusterer.addMarkers(markers);
		}
	})
} // f end 
// 3. 카카오지도에서 드래그를 하고 끝났을때. 1번함수 재실행 
kakao.maps.event.addListener(map, 'dragend', function() {  getInfo(); });











