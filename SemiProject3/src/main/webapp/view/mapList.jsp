
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



%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>리스트 생성하기</title>
<script src="jquery-3.6.0.min.js"></script>



<body>
<style>
.chargerList tr:hover {
  background-color: #0099ff;
  color: white;
}

</style>
	<table class = "chargerList">
	<tr style="width: 100%">
		<th style = "background-color: lightgray;">충전기 정보</th>
		
	</tr>
	
	<%
	for(Map<String,String> locationMap : locationMapList){
		if(Integer.parseInt(locationMap.get("distance"))>2000){
			break;
		}
	%>
		<tr>
			<td style="border: 1px solid black;">
				<p>충전기 명 : <%=locationMap.get("statNm")%></p>
				<p>충전기 주소 : <%=locationMap.get("addr") %></p>
				<p>충전기 운영 시간 : <%=locationMap.get("useTime")%></p>
				<p>거리 : <%=locationMap.get("distance")%><b>M</b></p>
				<p>
					<a class = "stat2">전체 충전기 : <%=locationMap.get("count")%>/</a>사용 가능한 충전기
					<a style ="color:<%=locationMap.get("stat_2").equals("0") ?"red":"green"%>;"><%=locationMap.get("stat_2")%></a>
				</p>
			</td>
		</tr>
		
		<%}%>
	</table>
<script>
   

	
</script>
</body>
</html>