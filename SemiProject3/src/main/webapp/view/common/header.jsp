<%@page import="com.kh.semi.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<%
MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모모모 전기차</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"> 
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/footers/">

    <style>
      html,
        body {
            width: 100%;
            height: 100%;
            margin: -10px 0;
            padding: 0px;
            font-family: 'Noto Sans KR', sans-serif;
        }
        
        .header_section_01 {
            display: inline-block;
            
            height: 120px;
            width: auto;
            margin-right: 150px;
            vertical-align: middle;
            background-color: rgb(248, 248, 248);
            text-align: center;
        }
        
        .header_section_01 img {
        
            width: 135px;
            height: 80px;
            padding: 0px;
            margin-top: 25px;
            vertical-align: middle;
        }
        
        .header_section_02 {
            display: inline-block;
            vertical-align: middle;
            height: 120px;
            width: auto;
            margin-right: 70px;
            background-color: rgb(248, 248, 248);
        }
        
        .header_section_03 {
            display: inline-block;
            vertical-align: middle;
            height: 120px;
            width: auto;
            margin-left: 380px;
            line-height: 9;
            background-color: rgb(248, 248, 248);
        }
        
        .header {
            height: 120px;
            background: rgb(248, 248, 248);
            overflow: hidden;
            transition: 0.4s;
            line-height: 100px;
            text-align: center;
        }
        
        nav>ul>li {
            float: left;
            line-height: 80px;
            margin-right: 70px;
            position: relative;
            list-style: none;
        }
        
        nav>ul>li ul {
            width: 100%;
            position: relative;
            list-style: none;
            text-align: center;
            padding: 1px;
            font-size: 15px;
            color: rgba(0, 0, 0, 0.7);
        }
        
        nav>ul>li ul li a {
            white-space: nowrap;
            text-decoration-line: none;
        }
        
        nav>ul>li ul li a:link {
            color: #000;
            text-decoration: none;
        }
        
        nav>ul>li ul li a:visited {
            color: #000;
            text-decoration: none;
        }
        
        nav>ul>li ul li a:hover {
            color: green;
            text-decoration: none;
        }
        
        nav>ul>li ul li a:active {
            color: #000;
            text-decoration: none;
        }
        
        .menuB {
            display: inline-block;
            background: rgb(248, 248, 248);
            color: black;
            margin: 0 1rem;
            padding: 0 2rem;
            text-decoration: none;
            font-size: 18px;
            font-weight: bold;
            margin-top: 15px;
        }
        
        .menuB:hover {
            color: green;
            text-decoration: none;
        }
        
        .nav a {
            display: inline-block;
            background: rgb(248, 248, 248);
            color: black;
            margin: 0 1rem;
            padding: 0 2rem;
            font-size: 15px;
        }
        
        .header_span {
            float: right;
            background: rgb(248, 248, 248);
            color: black;
            margin-left: 10px;
            font-size: 15px;
            font-weight: bold;
            margin: 5px 5px;
        }
        
        .header_span a {
            text-decoration: none;
            color: inherit;
        }
        
        .header_span a:hover {
            color: green;
        }
    </style>
</head>
<body>
    <header class="header">
        <div class="header_section_01"><img src="<%=request.getContextPath()%>/view/resources/img/logo_last.png" alt="로고사진"></div>
        <div class="header_section_02">
            <nav>
                <ul class="mainmenu">
                    <li>
                        <a class="menuB" href="#">전기차</a>
                        <ul class="submenu">
                            <li><a href="<%=request.getContextPath()%>/view/model/view.jsp">전기차 조회</a></li>
                            <!-- 전기차 등록은 관리자로 로그인할 경우에만 보이게끔 하기 -->
                            <%if(loginMember!=null && loginMember.getRole().equals("ADMIN")) {%>
                            <li><a href="<%=request.getContextPath()%>/view/model/write.jsp">전기차 등록</a></li>
                            <li><a href="<%=request.getContextPath()%>/counseling/list/inner">상담신청자 관리</a></li>
                            <%}%>
                        </ul>
                    </li>
                    <li>
                    
                        <a class="menuB" href="<%=request.getContextPath()%>/view/mapSearch.jsp">충전소 찾기</a>
                        <ul class="submenu">
                            <li><a href="<%=request.getContextPath()%>/view/mapSearch.jsp">주소/검색으로 찾기</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="menuB" href="<%=request.getContextPath()%>/view/news">뉴스</a>
                        <ul class="submenu">
                            <li><a href="<%=request.getContextPath()%>/view/news">전기차뉴스</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="menuB" href="#">커뮤니티</a>
                        <ul class="submenu">
                            <li><a href="#">공지사항</a></li>
                            <li><a href="#">게시판</a></li>
                            <li><a href="<%=request.getContextPath()%>/view/events/eventList.jsp">이벤트</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>

        <!-- 로그인 전 -->
        <%if(loginMember==null){ %>
        <div class="header_section_03">
            <span class="header_span">
                <a href="<%=request.getContextPath()%>/view/enroll.jsp">회원가입</a>
                </span>
            <span class="header_span" style="cursor:default;">
                /
                </span>
            <span class="header_span">
                <a href="<%=request.getContextPath()%>/view/login.jsp" >로그인</a>
                </span>
        </div>
        <%}else{%>
        <!-- 로그인 후 -->
        <div class="header_section_03">
            <span class="header_span">
                <a href="#"> </a>
                </span>
            <span class="header_span">
                <a href="#"> </a>
                </span>
            <span class="header_span">
                <a href="<%=request.getContextPath()%>/logout" >로그아웃</a><!-- 바로 로그아웃 -->
                </span>
        </div>
		<%}%>

        <script>
            var header = document.querySelector('header'),
                nav = document.querySelector('nav');

            nav.addEventListener('mouseover', function() {
                header.style.height = '350px';
            });

            nav.addEventListener('mouseout', function() {
                header.style.height = '120px';
            });
        </script>
</header>