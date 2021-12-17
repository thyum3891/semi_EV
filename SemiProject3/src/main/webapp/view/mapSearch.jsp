<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/view/common/header.jsp"%>
  <script src="jquery-3.6.0.min.js"></script>
  <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=88746c767ec969fd9dd8304966eb4179&libraries=clusterer"></script>
  <style>
        .main_wrap {
            
            height: 100px;
            width: 100%;
        }
        
        .logo,
        .search_bar {
            display: inline-block;
        }
        
        .logo {
            margin-left: 20%;
            margin-right: 5%;
        }
        
        .search_bar select {
            width: 150px;
            height: 30px;
        }
        
        button {
            width: 80px;
            height: 30px;
        }
       
        .section{
        margin: 50px
        align="center";
        
		}
    </style>




<body>
   
<div class = "section">
    	<table style="width: 80%;" align="center";>
    	<tr>
    		<td>
    			 <div class="main_wrap">
        			<div class="">
			            <h2>전기차충전소찾기</h2>
			        </div>
			
			        <div class="search_bar">
			            <form name="chargingStationForm" action="#" method="post">
			                <div class="search_bar">
			                    <select class='select_seoul' name="option_first" id="option_first">
			                <option  value='서울특별시'>서울특별시</option>
			            </select>
			                </div>
			
			                <div class="search_bar">
			                    <select class='select_gu' id="option_second" name="option_second" onchange="mapQuery(this.value)">
			                        <option value="전체">전체 보기</option>
			                            <option value="강남구">강남구</option>
			                            <option value="강동구">강동구</option>
			                            <option value="강북구">강북구</option>
			                            <option value="강서구">강서구</option>
			                            <option value="관악구">관악구</option>
			                            <option value="광진구">광진구</option>
			                            <option value="구로구">구로구</option>
			                            <option value="금천구">금천구</option>
			                            <option value="노원구">노원구</option>
			                            <option value="도봉구">도봉구</option>
			                            <option value="동대문구">동대문구</option>
			                            <option value="동작구">동작구</option>
			                            <option value="마포구">마포구</option>
			                            <option value="서대문구">서대문구</option>
			                            <option value="서초구">서초구</option>
			                            <option value="성동구">성동구</option>
			                            <option value="성북구">성북구</option>
			                            <option value="송파구">송파구</option>
			                            <option value="양천구">양천구</option>
			                            <option value="영등포구">영등포구</option>
			                            <option value="용산구">용산구</option>
			                            <option value="은평구">은평구</option>
			                            <option value="중구">중구</option>
			                            <option value="종로구">종로구</option>
			                            <option value="중랑구">중랑구</option>
			                    </select>
			                </div>
			                
			            </form>
			        </div>
			
			    </div>
    		</td>
    	</tr>
    		<tr >
    		<td><div align="center" id="mapDiv" style="width: 100%;" ></div></td>
    		</tr>
    	</table>
    
	</div>
       
<%-- 
        <table class='datatable' style='width:100%;background:white;margin-top:10px'>
            <tr>
                <td style='color:#333333;font-size:15px;text-align:center'>ⓒ 전기차충전소찾기 전국 전기차충전소 정보 | 문의 : aptrank@naver.com | <a href='privacy.php' style='color:#333333;font-size:15px'>개인정보보호정책</a> | 데이터출처 : 한국환경공단
                </td>
            </tr>
        </table>
	--%>		

<script>
mapQuery("전체");
function mapQuery(value){
	navigator.geolocation.getCurrentPosition(function(position) {
	    var lat = position.coords.latitude,
	        lon = position.coords.longitude;
	    $.ajax({ 
			type : "GET",
			url : "<%=request.getContextPath()%>/mapQ",
			data : {
				lat, lon, value
			},
			success : function (result) {
				$("#mapDiv").html(result);
			},
			error : function (e) {
				$("#mapDiv").html("에러<br>" + e);
			},
		});
    
	<%--$.ajax({ 
		type : "GET",
		url : "mapList",
		data : {
			lat, lon
		},
		success : function (result) {
			$("#mapListDiv").html(result);
		},
		error : function (e) {
			$("#mapListDiv").html("에러<br>" + e);
		},
	});--%>
	
});
}
function mapGPS(){
	navigator.geolocation.getCurrentPosition(function(position) {
	    var lat = position.coords.latitude,
	        lon = position.coords.longitude;
	    var query = $("add2").val();
		
	    
	    $.ajax({ 
			type : "GET",
			url : "map",
			data : {
				lat, lon, value
			},
			success : function (result) {
				$("#mapDiv").html(result);
			},
			error : function (e) {
				$("#mapDiv").html("에러<br>" + e);
			},
		});
    
	<%--$.ajax({ 
		type : "GET",
		url : "mapList",
		data : {
			lat, lon
		},
		success : function (result) {
			$("#mapListDiv").html(result);
		},
		error : function (e) {
			$("#mapListDiv").html("에러<br>" + e);
		},
	});--%>
	
});
}
	

	</script>


<%@ include file="/view/common/footer.jsp"%>