<%@page import="java.text.DecimalFormat"%>
<%@page import="com.kh.common.util.PageInfo"%>
<%@page import="com.kh.semi.vo.EvModelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전기차 조회</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"> ​
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css" />

    <style>
        body {
            font-family: 'Nanum Gothic', sans-serif;
        }
        /* 메인 페이지 시작 */
        
        .wrap {
            position: relative;
            padding-top: 10px;
            width: 100%;
            min-width: 1200px;
            height: 100%;
        }
        
        .background {
            background-color: rgb(245, 245, 245);
        }
        
        .main_page {
            display: flex;
            flex-wrap: nowrap;
            justify-content: space-around;
            margin: -10px auto;
            width: 1200px;
            background-color: rgb(245, 245, 245);
        }
        /* 왼쪽 div.box 시작 */
        
        .form {
            display: block;
        }
        
        .main_left_box {
            width: 270px;
            height: 100%;
            background-color: white;
        }
        
        .main_left_top {
            position: relative;
            padding: 25px 20px;
            border-bottom: 1px solid #3bb44a
        }
        
        .main_left_box .main_left_top>em {
            display: block;
            margin-bottom: 18px;
            font-weight: bold;
            font-size: 20px;
            color: #000;
        }
        
        ul,
        ol,
        li {
            list-style: none;
            margin: 0;
            padding: 0;
        }
        
        .main_left_box>ul {
            list-style: none;
        }
        
        .main_left_box>ul>li>span {
            position: relative;
            display: block;
            padding: 0 20px;
            line-height: 55px;
            font-size: 14px;
            font-weight: bold;
            color: #000;
            cursor: pointer;
            border-bottom: 1px solid #3bb44a
        }
        
        .main_left_box>ul>li>span:after {
            content: "";
            position: absolute;
            top: 24px;
            right: 25px;
            z-index: 1;
            width: 12px;
            height: 6px;
            text-indent: -9999px;
            background: url();
            transition: all .3s ease-out;
        }
        
        .main_left_box>form {
            display: block;
            margin-top: 0em;
        }
        /* .input-card {
            display: flex;
            background-color: whitesmoke;
            padding: 0.3rem 0.3rem;
            box-shadow: 0 0.375rem 1.5rem 0 rgb(140 152 164 / 13%);
            border-radius: 0.2rem;
        }

        .border {
            border: 0.0625rem solid rgba(33,50,91,.1)!important;
            margin-top: 10px;
        } */
        /* 왼쪽 div.box 종료 */
        /* 오른쪽 div.box 시작 */
        
        .main_right_box {
            position: relative;
            padding: 40px 0 200px;
            width: 850px;
            background-color: rgbrgb(245, 245, 245);
        }
        
        .main_right_top {
            display: flex;
            flex-wrap: wrap;
            margin-bottom: 25px;
        }
        
        .main_right_top label {
            display: block;
            padding: 0 20px;
            font-size: 13px;
            color: #000;
            line-height: 32px;
            border: 1px solid #ddd;
            background-color: #fff;
            border-radius: 15px;
            margin-left: 20px;
        }
        
        .main_right_top input[id="main_right_top1"] {
            display: none;
        }
        
        .main_right_array {
            display: flex;
            flex-wrap: nowrap;
            margin-bottom: 20px;
        }
        
        .main_right_array a {
            position: relative;
            margin-right: 25px;
            font-size: 14px;
            color: #000;
        }
        
        .main_right_typeView {
            display: block;
        }
        
        .carList-grid {
            display: flex;
            flex-wrap: wrap;
            margin: 0 -10px 20px;
        }
        
        .carList-grid li {
            margin-bottom: 20px;
            padding: 0 10px;
            width: 31%;
        }
        
        .carList-grid li a {
            position: relative;
            display: block;
            background-color: #fff;
            transition: all .15s;
        }
        
        .carList-grid li a p {
            position: relative;
            z-index: 1;
            display: block;
            height: 150px;
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
        }
        
        .carList-grid li a dl {
            padding: 25px;
            list-style: none;
            margin: 0;
        }
        
        .carList-grid li a dl dt {
            margin-bottom: 10px;
            font-size: 15px;
            color: #000;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            text-decoration: none;
        }
        
        .carList-grid li a dl dd {
            display: block;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            float: right;
            text-decoration: none;
        }
        /* 오른쪽 div.box 종료 */
        /* 상세조회 버튼 부분 시작 */
        
        .container {
            width: 100%;
            padding-right: var(--bs-gutter-x, .75rem);
            padding-left: var(--bs-gutter-x, .75rem);
            margin-right: auto;
            margin-left: auto;
            /* border: 1px solid black; */
        }
        
        .content-space-1 {
            padding-top: 3rem !important;
            padding-bottom: 3rem !important;
        }
        
        @media (min-width:576px) {
            .container {
                max-width: 540px
            }
        }
        
        @media (min-width:768px) {
            .container {
                max-width: 720px
            }
        }
        
        @media (min-width:992px) {
            .container {
                max-width: 960px
            }
        }
        
        @media (min-width:1200px) {
            .container {
                max-width: 1140px
            }
        }
        
        .row {
            --bs-gutter-x: 1.5rem;
            --bs-gutter-y: 0;
            display: -ms-flexbox;
            display: flex;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
            /* margin-top: calc(-1 * var(--bs-gutter-y)); */
            margin-top: 50px;
            margin-right: calc(-.5 * var(--bs-gutter-x));
            margin-left: calc(-.5 * var(--bs-gutter-x));
            height: 500px;
            width: 1000px;
            margin: 0 auto;
        }
        
        .col-md-7 {
            -ms-flex: 0 0 auto;
            flex: 0 0 auto;
            /* width: 55%; */
            /* width: 41.66667%; */
            width: 45%;
            height: 400px;
            margin-top: 30px;
        }
        
        .mb-7 {
            margin-bottom: 3rem !important;
        }
        
        .mb-md-0 {
            margin-bottom: 0 !important;
        }
        
        .pe-md-4 {
            padding-right: 1.8rem !important;
        }
        
        .card-pinned {
            position: relative;
            display: none;
        }
        
        .col-md-5 {
            -ms-flex: 0 0 auto;
            flex: 0 0 auto;
            width: 55%;
            /* width: 41.66667%; */
            height: 400px;
            margin-top: 30px;
        }
        
        .mb-5 {
            margin-bottom: 1.2rem !important;
            margin-left: 20px;
            background-color: rgb(248, 248, 248);
            border-radius: .4375rem;
        }
        
        .mb-4 {
            margin-bottom: 1.5rem !important;
            margin-left: 20px;
        }
        
        .d-grid {
            display: grid !important;
        }
        
        .btn {
            display: inline-block;
            font-weight: 500;
            line-height: 1.5;
            color: #677788;
            text-align: center;
            vertical-align: middle;
            cursor: pointer;
            background-color: transparent;
            border: .0625rem solid transparent;
            padding: 0rem 1rem;
            margin-right: auto;
            font-size: 12px;
            border-radius: .4375rem;
            transition: all .2s ease-in-out;
        }
        
        .btn-primary {
            color: #fff;
            font-family: 'Nanum Gothic', sans-serif;
            height: 20px;
            background-color: #3bb44a;
        }
        
        .form-btn {
            font-size: 20px;
        }
        
        .btntransition:hover,
        .btntransition:focus {
            background-color: #2bd13f;
            color: rgb(255, 255, 255);
        }
        
        .card-img {
            width: 100%;
            height: 450px;
        }
        
        .card-img {
            border-top-left-radius: .4375rem;
            border-top-right-radius: .4375rem;
            border-bottom-right-radius: .4375rem;
            border-bottom-left-radius: .4375rem;
        }
        
        .car-table {
            height: 310px;
            width: 100%;
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 18px;
        }
        
        .car-table th {
            width: 50%;
            text-align: left;
            font-weight: bold;
            padding-left: 20px;
        }
        
        .car-table td {
            width: 50%;
            text-align: left;
            padding-left: 20px;
        }
        
        .car-manu {
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 16px;
            margin-left: 20px;
            margin-top: 0px;
            text-align: left;
            margin-bottom: 5px;
        }
        
        .car-name {
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 25px;
            margin-left: 20px;
            margin-bottom: 10px;
            margin-top: 0px;
            text-align: left;
        }
        /* 모달 */
        /* The Modal (background) */
        
        .modal {
            display: none;
            /* Hidden by default */
            position: fixed;
            /* Stay in place */
            z-index: 1;
            /* Sit on top */
            padding-top: 100px;
            padding-bottom: 100px;
            /* Location of the box */
            left: 0;
            top: 0;
            width: 100%;
            /* Full width */
            height: 100%;
            /* Full height */
            overflow: auto;
            /* Enable scroll if needed */
            background-color: rgb(0, 0, 0);
            /* Fallback color */
            background-color: rgba(0, 0, 0, 0.4);
            /* Black w/ opacity */
        }
        /* Modal Content */
        
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 10px;
            border: 2px solid #3bb44a;
            border-radius: 30px;
            width: 70%;
            height: 600px;
            margin-bottom: 200px;
            -webkit-animation-name: animatetop;
            -webkit-animation-duration: 0.7s;
            animation-name: animatetop;
            animation-duration: 0.7s
        }
        /* Add Animation */
        
        @-webkit-keyframes animatetop {
            from {
                top: -300px;
                opacity: 0
            }
            to {
                top: 0;
                opacity: 1
            }
        }
        
        @keyframes animatetop {
            from {
                top: -300px;
                opacity: 0
            }
            to {
                top: 0;
                opacity: 1
            }
        }
        /* The Close Button */
        
        .close {
            color: #3bb44a;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        
        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
        /* 상세조회 버튼 부분 시작 */
        /* paging 시작 */
        
        .paging {
            text-align: center;
        }
        /* paging 시작 */
    </style>
</head>


<body>

	<%
		List<EvModelVO> list = (List<EvModelVO>)request.getAttribute("list");
		PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
		DecimalFormat format = new DecimalFormat("###,###");
	%>
	
    <!-- 메인 페이지 시작-->
    <div class="wrap background">
        <div class="main_page">
            <form>
                <div class="main_left_box">
                    <div class="main_left_top">
                        <em id="topCountry">전기차</em>
                        <span>총 차량 대수는 OOO 입니다.</span>
                        <a onclick="box.SearchReset();"></a>
                    </div>
                    <ul>
                        <li class>
                            <span>제조사
                                <!-- ::after -->
                            </span>
                        </li>
                        <li class>
                            <span>모델이름
                                <!-- ::after -->
                            </span>
                        </li>
                        <li class>
                            <span>
                                <!-- Search -->
                                <form>
                                    <!-- Input Card -->
                                    <div class="input-card border">
                                        <div class="input-card-form">
                                            <div class="input-group input-group-merge">
                                                <span class="input-group-prepend input-group-text">
                                                    <span>차량검색</span>
                            </span>
                            <input type="text" class="form-control" id="searchAppsForm" placeholder="제조사/모델명 검색해주세요." aria-label="Search for apps">
                            <button type="button" class="btn btn-primary myBtn">
                                                    <i class="bi-arrow-right"></i>
                                                </button>
                </div>
        </div>
    </div>
    <!-- End Input Card -->
    </form>
    <!-- End Search -->
    </span>
    </li>

    <li class=""></li>
    <li class=""></li>
    <li class=""></li>
    <li class=""></li>
    <li class=""></li>
    </ul>
    </div>
    </form>
    
    <div class="main_right_box">
        <div class="main_right_top">
            <span>
                        <input type="checkbox" name="main_right_top" id="main_right_top1">
                        <label for="main_right_top1">전기차차량</label>
                    </span>
        </div>
        <div class="main_right_sort">
            <div class="main_right_array">
            	
            	<% String path1 = request.getContextPath()+"/model/view/modelListreadCount"; %>
            	<% String path2 = request.getContextPath()+"/model/view/modelListhPrice"; %>
            	<% String path3 = request.getContextPath()+"/model/view/modelListrPrice"; %>
            	
                <a class="on" href=<%=path1 %> onclick="win.GoOrderType(this, '조회순')">조회순</a>
                <a class="on" href=<%=path2 %> onclick="win.GoOrderType(this, '최고가순')">가격높은순</a>
                <a class="on" href=<%=path3 %> onclick="win.GoOrderType(this, '최저가순')">가격낮은순</a>
                
            </div>
        </div>
        
<section id="content">
        <div class="main_right_typeView" id="pagination">
            <ul id="SearchList" class="carList-grid">
            <%int i = 1;
            for(EvModelVO model : list){ %>
            
                <li name="data1">
                    <a data-ch="N" data-ce="N" data-in="N">
                        <p style="background-image:url('<%= request.getContextPath() %>/resources/image/<%= model.getImage_1()%>');"></p>
                        <dl>
                            <dt>
                            	<strong>
                            		<%= model.getModelName() %> / <%=model.getModelSub() %> <br>
                            		<%= model.getCompany() %> <br>
                            		<%= format.format(model.getPrice())%>원 <br>
                            	</strong>
                            </dt>
                            <dd>
                                <button id="<%=model.getModelName()%>" class="btn btn-primary btntransition" onclick="modalOpen('<%=model.getModelName().hashCode()%>')">상세보기</button>
                            </dd>
                        </dl>
                    </a>
                </li>
            <%}%>
                
            </ul>
        </div>

        <div class="paging">
        	<button onclick="location.href='<%= request.getContextPath() %>/model/view?page=1'">&lt;&lt;</button>
			
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/model/view?page=<%= pageInfo.getPrvePage() %>'">&lt;</button>

			<!--  10개 페이지 목록 -->
			<% for (int p = pageInfo.getStartPage(); p <= pageInfo.getEndPage(); p++) { %>
				<% if(p == pageInfo.getCurrentPage()) { %>
					<button disabled><%= p %></button>
				<% } else { %>
					<button onclick="location.href='<%= request.getContextPath() %>/model/view?page=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			
			<!-- 다음 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/model/view?page=<%= pageInfo.getNextPage()%>'">&gt;</button>
			
			<!-- 맨 끝으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/model/view?page=<%= pageInfo.getMaxPage() %>'">&gt;&gt;</button>
        </div>
</section>
    </div>
    </div>
    </div>

	
 <% int j = 1;
 for(EvModelVO model : list){ %>
    <!-- The Modal -->
    <div id="<%=model.getModelName().hashCode()%>" class="modal">

        <!-- Modal content -->
        <div class="modal-content">

            <span class="close">x</span>

            <!-- Hero -->
            <div class="container content-space-1">
                <div class="row">
                    <div class="col-md-7 mb-7 mb-md-0">
                        <div class="pe-md-4">
                            <div class="card-pinned">
                                <img class="card-img <%= model.getModelName().hashCode()%>" src="<%= request.getContextPath() %>/resources/image/<%= model.getImage_1()%>" alt="전기차 사진1">
                            </div>
                            <div class="card-pinned">
                                <img class="card-img <%= model.getModelName().hashCode()%>" src="<%= request.getContextPath() %>/resources/image/<%= model.getImage_2()%>" alt="전기차 사진2">
                            </div>
                            <div class="card-pinned">
                                <img class="card-img <%= model.getModelName().hashCode()%>" src="<%= request.getContextPath() %>/resources/image/<%= model.getImage_3()%>" alt="전기차 사진3">
                            </div>
                            <div class="card-pinned">
                                <img class="card-img <%= model.getModelName().hashCode()%>" src="<%= request.getContextPath() %>/resources/image/<%= model.getImage_4()%>" alt="전기차 사진4">
                            </div>
                            <div class="card-pinned">
                                <img class="card-img <%= model.getModelName().hashCode()%>" src="<%= request.getContextPath() %>/resources/image/<%= model.getImage_5()%>" alt="전기차 사진5">
                            </div>
                        </div>
                    </div>

                    <!-- End Col -->

                    <div class="col-md-5">
                        <!-- Heading -->
                        <!-- 구분/제조사 -->
                        <h4 id="car-manu" class="car-manu">[외제] > [테슬라]</h4>
                            <!-- 모델명 -->
                            <h2 id="car-name" class="car-name"><%=model.getModelName() %></h2>
                            <div class="mb-5">
                                <table class="car-table">
                                    <tr>
                                        <th>상세모델명</th>
                                        <td><%=model.getModelName() %></td>
                                    </tr>
                                    <tr>
                                        <th>출시가</th>
                                        <td><%= format.format(model.getPrice()) %>원</td>                                        
                                    </tr>
                                    <tr>
                                        <th>연비</th>
                                        <td>자동 6.1 km/kWh</td>
                                    </tr>
                                    <tr>
                                        <th>1회 충전 주행가능 거리</th>
                                        <td> 383Km </td>
                                    </tr>
                                    <tr>
                                        <th>에너지 용량</th>
                                        <td>50.0kWh</td>
                                    </tr>
                                    <tr>
                                        <th>모터최대출력</th>
                                        <td>211.0Kw</td>
                                    </tr>
                                    <tr>
                                        <th>변속기</th>
                                        <td>자동</td>
                                    </tr>
                                    <tr>
                                        <th>구동방식</th>
                                        <td> 후륜구동</td>
                                    </tr>
                                    <tr>
                                        <th>승차인원</th>
                                        <td> 5인승</td>
                                    </tr>
                                </table>
                            </div>
                            <!-- End Heading -->
                            <div class="d-grid mb-4">
                                <button type="button" class="btn btn-primary btntransition form-btn" style="height: 50px; width: 100%;" onclick="location.href='CounselingForm.html';">구매
                                    상담 신청</button>
                            </div>


                    </div>
                    <!-- End Col -->
                </div>
                <!-- End Row -->
            </div>
            <!-- End Hero -->

        </div>

    </div>
<%}%>

    <script>
        function modalOpen(modelName) {
            var modal = document.getElementById(''+modelName);
            modal.style.display = "block";

            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
                showSlides();
                setInterval(   	  showSlides(modelName)
                , 200);
            }

            $(".close").click(function() {
                modal.style.display = "none";
            })
        }
        
        var slideIndex = 0;
        showSlides = function(modelName) {
            var slides = document.getElementsByClassName(modelName);
            
            for (let i = 0; i < slides.length; i++) {
                slides[i].style.display = "none ";
            }
            slideIndex++;
            if (slideIndex > slides.length) {
                slideIndex = 1
            }
            slides[slideIndex - 1].style.display = "block";
        }
    </script>
</body>
</html>