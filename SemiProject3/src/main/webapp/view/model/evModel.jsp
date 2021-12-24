<%@page import="com.kh.semi.vo.EvModelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		List<EvModelVO> list = (List<EvModelVO>)request.getAttribute("list");
	%>
	<h2>EvModel Output Test</h2>
	<%for(EvModelVO model : list){ %>
		<div>
			<p>
				모델명 : <%= model.getModelName() %> <br>
				상세모델명 : <%= model.getModelSub() %> <br>
				가격 : <%= model.getPrice() %> <br>
				연비 : <%= model.getFuel() %> <br>
				탑승인원 : <%= model.getPerson() %> <br>
				변속기어 : <%= model.getTransM() %> <br>
				1회 충전시 이동가능거리 : <%= model.getDistance() %> <br>
				출력 : <%= model.getEnergy() %> <br>
				모터 : <%= model.getMotor() %> <br>
				회사 : <%= model.getCompany() %> <br>
				구분 : <%= model.getNation() %> <br>
				이미지 경로 : <%= request.getContextPath() %>/image/<%= model.getImage_1()%> <br>
				이미지 : <img src="<%= request.getContextPath() %>/resources/image/<%= model.getImage_1()%>" width="150" height="150"> <br>
				<hr>
			</p>
		</div>	
	<%}%>

</body>
</html>