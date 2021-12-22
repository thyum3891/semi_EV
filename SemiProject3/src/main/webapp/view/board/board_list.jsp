<%@page import="java.net.URLEncoder"%>
<%@page import="com.kh.common.util.PageInfo"%>
<%@page import="com.kh.semi.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/view/common/header.jsp"%>
    
<!DOCTYPE html>
<html lang="en">

<% 
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <style>
        .board {
            width: 100%;
            border-collapse: collapse;
        }
        
        .board-table {
            width: 75%;
            height: 600px;
            margin: auto;
            margin-top: 100px;
        }
        
        th {
            height: 45px;
            text-align: left;
            border-bottom: 1px solid lightgrey;
            border-top: 1px solid lightgrey;
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: bold;
            font-size: 18px;
        }
        
        td {
            height: 45px;
            text-align: left;
            border-bottom: 1px solid lightgrey;
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 16px;
        }
        
        td a {
            text-decoration: none;
            
	        td a:visited {
	            color: black;
	        }
            
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
        
        .icon {
            text-decoration: none;
        }
        
        .icon:visited {
            color: black;
        }
        
        td:hover,
        .icon:hover,
        .btn-arrow:hover {
            color: #3bb44a;
        }
        
        .icon-wrap {
            display: block;
            height: 25px;
            width: 25px;
            margin: 15px;
            margin-bottom: 20px;
            float: right;
        }
        
        .search-wrap {
            display: block;
            float: right;
        }
        
        .search-wrap select {
            width: 100px;
            height: 30px;
        }
        
        .search-wrap input {
            width: 200px;
            height: 25px;
            margin-left: 5px;
        }
        
        #search-btn {
            background-color: white;
            border: none;
        }
        
        .btn-arrow {
            background-color: rgba(255, 255, 255, 0);
            border: none;
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
        <p id="board-name" class="board-name">자유 게시판</p>
		<% if(loginMember != null) { %>
	        <!-- 연필 아이콘  : 누르면 글쓰기 페이지로 넘어감-->
	        <p class="icon-wrap">
	            <a href="<%=request.getContextPath()%>/board/board_write" class="icon"> <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
	                <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
	              </svg>
	            </a>
	        </p>
	    <% } %>
        <!-- 검색 아이콘  -->
        <form name="searchForm" action="<%=request.getContextPath()%>/board/board_list" method="post">

        	
            <p class="icon-wrap">
                <button type="submit" name="search-btn" id="search-btn">
                <a class="icon"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
              </svg>
            </a>
        </button>
            </p>
            <!-- 검색창 -->
            <p id="search-wrap" class="search-wrap">
                <select name="category" id="category" class="" required="required">
                   <option ${(param.category == "title")? "selected" : "" } value="title">제목</option>
                   <option ${(param.category == "id")? "selected" : ""} value="id">작성자</option>
            	</select>
                <input type="text" id="search-text" name="searchKeyword"  value="${param.searchKeyword}"placeholder="검색어를 입력하세요..">
	        	<input type="hidden" name="seachCategory" value="<%=request.getParameter("category")%>">
	        	<input type="hidden" name="searchKeyword" value="<%=request.getParameter("searchKeyword")%>">
            </p>
        </form>

        <table class="board" id="board">
            <tr>
                <th style="width: 7%;">NO</th>
                <th style="width: 40%;">제목</th>
                <th style="width: 18%;">작성자</th>
                <th style="width: 15%;">작성일</th>
                <th style="width: 10%;">첨부파일</th>
                <th style="width: 10%;">조회수</th>
            </tr>
			
			<% if(list == null || list.isEmpty()) { %>
				<tr>
					<td colspan="6">조회된 게시글이 없습니다.</td>
				</tr>
			<% } else {%>
				<%for(BoardVO board : list) {%>
					<tr>
		                <td><%=board.getBoard_no()%></td>
		                <td>
			                <%String path = request.getContextPath() + "/board/board_view?board_no=" + board.getBoard_no();%>
			                <a href="<%=path%>"><%=board.getTitle()%></a>
		                </td>
		                <td><%=board.getWriter_id() %></td>
		                <td><%=board.getCreate_date() %></td>
		                <td>
		                	<% if(board.getFile_origin() != null) {%>
		                		<img src="<%=request.getContextPath()%>/resources/img/file.png">
		                	<% } else {%>
		                		-
		                	<% } %>
		                </td>
		                <td><%=board.getReadcount()%></td>
		            </tr>
				<% } %>
			<% } %>
        </table>
    </div>

    <div id="pageBar">
        <button class="btn-arrow" onclick="location.href='<%=request.getContextPath()%>/board/board_list?page=1'"><svg xmlns="http://www.w3.org/2000/svg" width="25px" height="25px" fill="currentColor" class="bi bi-chevron-double-left" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M8.354 1.646a.5.5 0 0 1 0 .708L2.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
            <path fill-rule="evenodd" d="M12.354 1.646a.5.5 0 0 1 0 .708L6.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
          </svg></button>

        <button class="btn-arrow" onclick="location.href='<%=request.getContextPath()%>/board/board_list?page=<%=pageInfo.getPrvePage()%>'"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
          </svg></button>

		<% for (int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++) { %>
			<% if(i == pageInfo.getCurrentPage()) { %>
				<button class="btn-arrow" disabled><%=i%></button>
			<% } else { %>
				<button class="btn-arrow" onclick="location.href='<%=request.getContextPath()%>/board/board_list?page=<%=i%>'"><%=i%></button>
			<% } %>
		<% } %>

        <button class="btn-arrow" onclick="location.href='<%=request.getContextPath()%>/board/board_list?page=<%=pageInfo.getNextPage()%>'"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
          </svg></button>

        <button class="btn-arrow" onclick="location.href='<%=request.getContextPath()%>/board/board_list?page=<%=pageInfo.getMaxPage()%>'">
            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-chevron-double-right" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z"/>
            <path fill-rule="evenodd" d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z"/>
          </svg>
        </button>
    </div>
</body>

</html>

<script>


</script>