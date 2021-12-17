<%@page import="java.util.List"%>
<%@page import="com.kh.semi.vo.Buy_Counseling"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/view/common/header.jsp"%>   
    
    <%
    List<Buy_Counseling> list = (List<Buy_Counseling>)request.getAttribute("bcList");
    
    	int count = (int)request.getAttribute("count");
    	
    	int p = (int)request.getAttribute("page");
    	
    	int prePage = p-1;
    	int nextPage = p+1;
    	
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구매 상담신청 관리</title>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <style>
        .board-table {
            width: 75%;
            height: 700px;
            margin: auto;
            margin-top: 100px;
        }
        
        .board {
            width: 100%;
            border-collapse: collapse;
        }
        
        th {
            height: 45px;
            text-align: left;
            border-bottom: 1px solid rgb(174, 173, 173);
            border-top: 1px solid rgb(174, 173, 173);
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 16px;
        }
        
        td {
            height: 55px;
            text-align: left;
            border-bottom: 1px solid lightgray;
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 16px;
            /* color: rgb(94, 93, 93); */
            color: black;
        }
        
        #board-name {
            display: block;
            margin: 0;
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 30px;
            float: left;
            margin-left: 15px;
            margin-bottom: 20px;
        }
        
        .icon-wrap {
            display: block;
            height: 30px;
            width: 30px;
            margin-right: 15px;
            margin-bottom: 20px;
            float: right;
        }
        
        .btn-arrow {
            background-color: rgba(255, 255, 255, 0);
            border: none;
        }
        
        .btn-arrow:hover {
            color: #3bb44a;
        }
        
        #pageBar {
            margin-top: 30px;
            height: 40px;
            text-align: center;
        }
    </style>
</head>

<body>

    <div id="board-table" class="board-table">
        <p id="board-name" class="board-name">상담신청 관리</p>
        <p class="icon-wrap">
            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill=" currentColor " class="bi bi-person-check-fill " viewBox="0 0 16 16 ">
            <path fill-rule="evenodd " d="M15.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L12.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z "/>
            <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z "/>
          </svg>
        </p>

        <table class="board " id="board ">
            <tr>
                <th style="width: 8%; ">이름</th>
                <th style="width: 12%; ">연락처</th>
                <th style="width: 28%; ">전기차 모델명</th>
                <th style="width: 12%; ">상담 날짜/시간</th>
                <th style="width: 12%; ">유입 경로</th>
                <th style="width: 16%; ">기타 문의사항</th>
                <th style="width: 12%; ">상태</th>
            </tr>
	<%for(Buy_Counseling bc : list){ %>
            <tr>
                <td style="padding-left: 5px;"><%=bc.getU_name() %></td>
                <td><%=bc.getPhone()%></td>
                <td><%=bc.getModelname()%></td>
                <td><%=bc.getCounseling_date()%><br><%=bc.getTime() %></td>
                <td><%=bc.getInflow_path() %></td>
                <% String info = bc.getAdditional_information();
                if(info==null||info.equals("null")){info = "없음";}%>
                <td><%=info%></td>
                <% String check = bc.getCheck_counseling();
                if(check.equals("미확인")){%>
                <td style="color: red;">
                	<b><a onclick="check(<%="'"+check+"',"+bc.getBc_no()%>)" style="cursor: pointer;"><%=check%></a></b>
                </td>
                	
                <%}else{%>
                <td style="color: green;">
                	<b><a onclick="check(<%="'"+check+"',"+bc.getBc_no()%>)" style="cursor: pointer;"><%=check%></a></b>
                </td>
                <%} %>
               
            </tr>
<%}%>
        </table>
    </div>



    <div id="pageBar">

		<%if(prePage>0){%>
        <button class="btn-arrow " onclick="location.href='<%=request.getContextPath()%>/counseling/list/inner?page=<%=prePage%>' ; "><svg xmlns="http://www.w3.org/2000/svg " width="25 " height="25 " fill="currentColor " class="bi bi-chevron-left " viewBox="0 0 16 16 ">
            <path fill-rule="evenodd " d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z "/>
          </svg></button>
		<%}if(nextPage <= Math.ceil((double)count/10)){ %>
        <button class="btn-arrow " onclick="location.href='<%=request.getContextPath()%>/counseling/list/inner?page=<%=nextPage%>' ; "><svg xmlns="http://www.w3.org/2000/svg " width="25 " height="25 " fill="currentColor " class="bi bi-chevron-right " viewBox="0 0 16 16 ">
            <path fill-rule="evenodd " d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z "/>
          </svg></button>
		<%} %>

    </div>
<script type="text/javascript">
	function check(value,bc_no){
		
		 $.ajax({ 
				type : "POST",
				url : "<%=request.getContextPath()%>/counseling/check",
				data : {
					value, bc_no
				},
				success : function (result) {
					window.location.reload();
				},
				error : function (e) {
					window.location.reload();
				},
			});
		
		
	}
</script>

<%@ include file="/view/common/footer.jsp"%>