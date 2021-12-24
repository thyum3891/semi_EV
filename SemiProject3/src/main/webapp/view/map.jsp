
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="common.Distance"%>
<%@page import="com.kh.semi.DAO.EvChargerDAO"%>
<%@page import="java.util.Map"%>
<%@page import="com.kh.semi.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Map<String,String>> locationMapList = (ArrayList<Map<String,String>>)request.getAttribute("locationMapList");

String lat = (String)request.getAttribute("lat");
String lng = (String)request.getAttribute("lng");
String setLat = lat;
String setLng = lng;

if(request.getAttribute("setLat")!=null && request.getAttribute("setLng") != null){
 setLat = (String)request.getAttribute("setLat");
 setLng = (String)request.getAttribute("setLng");
}else{
	 setLat = lat;
	 setLng = lng;
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>지도 생성하기</title>

<script src="jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=88746c767ec969fd9dd8304966eb4179&libraries=clusterer"></script>
<style>
.wrap {
	position: absolute;
	left: 0;
	bottom: 40px;
	width: 288px;
	height: 132px;
	margin-left: -144px;
	text-align: left;
	overflow: hidden;
	font-size: 12px;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
	line-height: 1.5;
}

.wrap * {
	padding: 0;
	margin: 0;
}

.wrap .info {
	width: 300px;
	height: 170px;
	border-radius: 5px;
	border-bottom: 2px solid #ccc;
	border-right: 1px solid #ccc;
	overflow: hidden;
	background: #fff;
}

.wrap .info:nth-child(1) {
	border: 0;
	box-shadow: 0px 1px 2px #888;
}

.info .title {
	padding: 5px 0 0 10px;
	height: 30px;
	background: #eee;
	border-bottom: 1px solid #ddd;
	font-size: 18px;
	font-weight: bold;
}

.info .close {
	position: absolute;
	top: 10px;
	right: 10px;
	color: #888;
	width: 17px;
	height: 17px;
	background:
		url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');
}

.info .close:hover {
	cursor: pointer;
}

.info .body {
	position: relative;
	overflow: hidden;
}

.info .desc {
	position: relative;
	margin: 6px 0 0 90px;
	height: 75px;
}

.desc .ellipsis {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.desc .jibun {
	font-size: 11px;
	color: #888;
	margin-top: -2px;
}

.info .img {
	position: absolute;
	top: 6px;
	left: 5px;
	width: 73px;
	height: 71px;
	border: 1px solid #ddd;
	color: #888;
	overflow: hidden;
}

.info:after {
	content: '';
	position: absolute;
	margin-left: -12px;
	left: 50%;
	bottom: 0;
	width: 22px;
	height: 12px;
	background:
		url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
}

.info .link {
	color: #5085BB;
}

.td-border {
 margin: 10px;
 cursor: pointer;
 margin: 5px
}

.gps-btn {
            border-radius: 15px;
            height: 52px;
            line-height: 55px;
            margin: 10px 0px 5px 0px;
            border: solid 1px rgba(0, 0, 0, .1);
            background-color: #3bb44a;
            color: #fff;
            cursor: pointer;
        }
.gps-btn:hover {
            
            background-color: #fff;
            color: #3bb44a;
            
        }
.listSel{
            margin: 10px 8px 10px;
            display: flex;
            padding: 10px;
            border: solid 3px #dadada;
            background: white;
            cursor: pointer;
            height: auto;
            border-top-right-radius: 15px;
            border-bottom-left-radius: 15px;

}
.listSel:hover {
  border: 5px solid #3bb44a;
}
</style>
</head>
<body>
	<!-- 지도를 표시할 div 입니다 -->

	
	
	<table id = "chargerList" style="width: 100%;">
	<tr>
	<td style="width: 50%; height: 500px;" >
		<div id="map" style="width: 100%; height: 100%;"></div>
	</td>
	<td style="width: 50%; height: 600px;border: 1px solid black;">
	<div style="overflow:auto; ;height: 100%;">
	<table style="width: 100%;height: 100%">
	<tr>
	</tr>
	<%
	for(Map<String,String> locationMap : locationMapList){		
	%>
		<tr >
			<td class = "td-border"  onclick="listPosition(<%=locationMap.get("lat")%>,<%=locationMap.get("lng")%>)">
			<div class="listSel">
				<table>
					<tr>
						<td class ="col1">
						주소명
						</td>
						<td>
						 : 
						</td>
						<td>
						<%=locationMap.get("statNm")%>
						</td>
						<td rowspan="4" >
					
					</tr>
					<tr>
						<td class ="col1">
						주소
						</td>
						<td>
						 : 
						</td>
						<td>
						<a><%=locationMap.get("addr") %></a>
						</td>
					</tr>
					<tr>
						<td class ="col1">
						운영 시간
						</td>
						<td>
						 : 
						</td>
						<td>
						<a><%=locationMap.get("useTime")%></a>
						</td>
					</tr>
					<tr>
						<td class ="col1">
						거리
						</td>
						<td>
						 : 
						</td>
						<td>
						<a><%=locationMap.get("distance")%><b>M</b></a>
						</td>
					</tr>
					<tr>
						<td class ="col1">
						대기중
						</td>
						<td>
						 : 
						</td>
						<td>
						<a style ="color:<%=locationMap.get("stat_2").equals("0") ?"red":"#3bb44a"%>;"><b><%=locationMap.get("stat_2")%></b>  </a>대
						</td>
					</tr>
				</table>
				</div>
				</td>
				
		</tr>
		
		<%}%>
	
	</table>
	</div>
	</td>
		<tr>
		<td>
		<button onclick="gps()" class = "gps-btn"><b>내 위치</b></button>
		</td>
		</tr>
	</table>
	
<script>
var mapContainer = document.getElementById('map'), 
mapOption = { 
    center: new kakao.maps.LatLng(37.5640455,126.834003), 
    level: 4 
}; 

var map = new kakao.maps.Map(mapContainer, mapOption); 




    
    var setPosition = new kakao.maps.LatLng(<%=setLat%>, <%=setLng%>);
    var locPosition = new kakao.maps.LatLng(<%=lat%>, <%=lng%>);
    
    displayMarker(locPosition);
    map.setCenter(setPosition); 
    map.setLevel(4);
    


function displayMarker(locPosition, message) {

	var marker = new kakao.maps.Marker({  
	    map: map, 
	    position: locPosition
	}); 

	}

var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
var markers = [];
var overrays = new Map();
<%for(int i = 0; i<locationMapList.size();i++){
	if(i==500){
		break;
	}
	Map<String,String> locationMap = locationMapList.get(i);
	if(locationMap.get("stat_2").equals("0")){
		continue;
	}	
	String content = "'<div class=\"wrap\">" + "    <div class=\"info\">"
	+ "        <div class=\"title\">" + locationMap.get("statNm")
	+ "            <div class=\"close\" onclick=\"closeOverlay()\" title=\"닫기\"></div>" + "        </div>"
	+ "        <div class=\"body\">" + "            <div class=\"desc\">"
	+ "                <div class=\"jibun ellipsis\">" + locationMap.get("addr") + "</div>"
	+ "                <div style=\"color: yellowgreen;font-weight: bold;\">대기중 : "
	+ locationMap.get("stat_2") + "/" + locationMap.get("count") + "<div>거리 : "+locationMap.get("distance")+"m</div></div>" + "            </div>"
	+ "        </div>" + "    </div>" + "</div>'";
	
%>
	

	var count = 1;
	
    var imageSize = new kakao.maps.Size(24, 35); 
    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    
    var marker = new kakao.maps.Marker({
        map: map, 
        position: new kakao.maps.LatLng('<%=locationMap.get("lat")%>','<%=locationMap.get("lng")%>'),
        title : '<%=locationMap.get("statNm")%>', 
        image : markerImage        
    });
   
    var overlay = new kakao.maps.CustomOverlay({
        content: <%=content%>,
        map: map,
        position: new kakao.maps.LatLng('<%=locationMap.get("lat")%>','<%=locationMap.get("lng")%>')       
    });
    overlay.setMap(null);
    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, overlay));
    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(overlay));
    kakao.maps.event.addListener(marker, 'click', function() {
    	window.location.href = "	https://map.kakao.com/link/map/<%=locationMap.get("statNm")%>,<%=locationMap.get("lat")%>,<%=locationMap.get("lng")%>";
    			
    	});
    
    function makeOverListener(map, marker, overlay) {
        return function() {
        	overlay.setMap(map);
        };
    }
	
    function makeOutListener(overlay) {
        return function() {
        	 overlay.setMap(null);
        }
    }
    overrays.set("<%=locationMap.get("statId")%>", overlay);
       markers.push(marker);
<%}%>


var clusterer = new kakao.maps.MarkerClusterer({
    map: map, 
    averageCenter: true, 
    minLevel: 5 
});

clusterer.addMarkers(markers);





var mapTypeControl = new kakao.maps.MapTypeControl();
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

function gps(geoLocation){ 
	
	map.setCenter(locPosition); 
	map.setLevel(4);
	
};
function listPosition(lat, lon){    
    var Position = new kakao.maps.LatLng(lat, lon);
	 map.setCenter(Position); 
	 map.setLevel(4);
	
}

</script>
</body>
</html>