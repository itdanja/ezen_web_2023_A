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

$.ajax({
	url : "/jspweb/ProductInfoController" , method : "get" ,
	data : { type : "findByAll" },
	success : jsonArray => { console.log( jsonArray ); 
		var markers = jsonArray.map( (p) => {
	        return new kakao.maps.Marker({
	            position : new kakao.maps.LatLng( p.plat, p.plng )
	        });
	    });
		clusterer.addMarkers(markers);
	}
})
kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
    var level = map.getLevel()-1;
    map.setLevel(level, {anchor: cluster.getCenter()});
});






