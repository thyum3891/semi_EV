<%@page import="com.kh.common.util.PageInfo"%>
<%@page import="com.kh.semi.vo.news"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
 String newsSearchText = request.getAttribute("newsSearchText").toString(); 
 PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
 %>
 <%@ include file="/view/common/header.jsp"%>
<head>
<meta charset="utf-8">
<title>NEWS</title>
<script src="jquery-3.6.0.min.js"></script>


<style>
* {
	box-sizing: border-box;
}

body {
	box-sizing: border-box;
	font-family: 'Noto Sans KR', sans-serif;
	padding: 10px;
	margin: 0 auto;
	background: white;
	margin: 0 auto;
	width: 100%;
}

.row {
	padding: 10px;
	margin: 0 auto;
	width: 1200px;
}

.search {
	text-align: center;
	margin: 100px 0px 30px 0px;
}

#search-button {
	width: 50px;
	height: 50px;
	vertical-align: bottom;
	color: white;
	background-color: black;
	border: none;
	cursor: pointer;
	border-radius: 5px;
}

#search-text {
	width: 400px;
	height: 50px;
	border: 1px solid black;
	cursor: pointer;
	border-radius: 5px;
}
/* Left column */
.leftcolumn {
	float: left;
	width: 75%;
}

.news-name {
	margin: 0px 0px 20px 20px;
	letter-spacing: 3px;
	font-size: 30px;
}
/* Right column */
.rightcolumn {
	float: left;
	width: 25%;
	margin-top: 55px;
	padding-left: 20px;
}

.fakeimg {
	width: 100%;
}

.news a, .event a {
	text-decoration: none;
}

.news a:visited, .event a:visited {
	color: black;
}

.news a:hover, .event a:hover, .btn-arrow:hover {
	color: #3bb44a;
}

.event {
	margin-top: 10px;
	/* background-color: #1ebcdf1c; */
	border: 1px solid lightgray;
	border-radius: 10px;
	padding: 10px;
}

.news {
	padding: 10px 20px;
	border-top: 1px solid lightgrey;
	width: 870px;
	height: 130px;
	text-align: left;
}

.news_event_img {
	width: 100%;
	height: 150px;
}

#pageBar {
	margin-top: 10px;
	padding-top: 40px;
	border-top: 1px solid lightgrey;
	text-align: center;
}

.btn-arrow {
	background-color: rgba(255, 255, 255, 0);
	border: none;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
<body>
	<div id="row" class="row">

		<!-- 검색창 영역 -->
		<div class="search">
			<form name="newsSearchForm"
				action="<%=request.getContextPath()%>/view/news" method="get">
				<input type="text" id="search-text" name="search_text"
					placeholder="  Search...">
				<button type="submit" id="search-button">
					<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22"
						fill="currentColor" class="bi bi-search" viewBox="0 0 16 16"
						id="icon">
                		<path
							d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
              		</svg>
				</button>
			</form>
		</div>


		<!-- 메인 뉴스 영역 -->
		<div id="leftcolumn" class="leftcolumn">
			<h2 class="news-name">뉴스</h2>
			<table>
				<%	List<news>  list =  (List<news>)request.getAttribute("list"); %>
				<%for(news item : list){ %>


				<tr>
					<td>
						<div class="news">
							<h3>
								<a href="<%=item.getOriginallink()%>"><%=item.getTitle()%></a>
							</h3>
							<p><%=item.getDescription()%></p>
						</div>
					</td>
				</tr>
				<%}%>
			</table>
			<div id="pageBar">
				<button class="btn-arrow" onclick="pageMove(1)">
					<svg xmlns="http://www.w3.org/2000/svg" width="25px" height="25px"
						fill="currentColor" class="bi bi-chevron-double-left"
						viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
							d="M8.354 1.646a.5.5 0 0 1 0 .708L2.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
                    <path fill-rule="evenodd"
							d="M12.354 1.646a.5.5 0 0 1 0 .708L6.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
                  </svg>
				</button>

				<button class="btn-arrow" onclick="pageMove(<%=pageInfo.getPrvePage()%>)">
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
						fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
							d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
                  </svg>
				</button>
				<% for (int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++) { %>
			<% if(i == pageInfo.getCurrentPage()) { %>
				<button class="btn-arrow" disabled><%=i%></button>
			<% } else { %>
				<button class="btn-arrow" onclick="pageMove(<%=i%>)"><%=i%></button>
			<% } %>
			<% } %>

				<button class="btn-arrow" onclick="pageMove(<%=pageInfo.getNextPage()%>)">
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
						fill="currentColor" class="bi bi-chevron-right"
						viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
							d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z" />
                  </svg>
				</button>

				<button class="btn-arrow" onclick="pageMove(<%=pageInfo.getMaxPage()%>)">
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
						fill="currentColor" class="bi bi-chevron-double-right"
						viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
							d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z" />
                    <path fill-rule="evenodd"
							d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z" />
                  </svg>
				</button>

				<script>
                  	function pageMove(page){
                  		var link = '<%=request.getContextPath()%>/view/news?page='+page;
                  		
                  		if(<%=newsSearchText != null && newsSearchText.length() > 0 %>){
                  			link += "&newsSearchText=<%=newsSearchText%>"
                  		}
                  		
                  		location.href(link)
                  	}
                  </script>
			</div>
		</div>

		<!--이벤트 영역  -->
		<div class="rightcolumn" id="rightcolumn">
			<div class="event">
				Event 1
				<div class="fakeimg" style="height: 150px;">
					<img class="news_event_img" src="./resources/img/news_img2.jpg">
				</div>
				<p>
					<a href="<%=request.getContextPath()%>/view/events/eventTestDrive.jsp">오토플러스 인천 시승권 응모하기</a>
				</p>
			</div>
		</div>
		<div class="rightcolumn" id="rightcolumn">
			<div class="event">
				Event 2
				<div class="fakeimg" style="height: 150px;">
					<img class="news_event_img" src="./resources/img/news_img1.jpg">
				</div>
				<p>
					<a href="<%=request.getContextPath()%>/view/events/eventResort.jsp">대명리조트 숙박권 응모하기</a>
				</p>
			</div>
		</div>
	</div>



</body>
 <%@ include file="/view/common/footer.jsp"%>