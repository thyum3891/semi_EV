<%@page import="com.kh.semi.vo.ReplyVO"%>
<%@page import="com.kh.semi.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="/view/common/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- Required Meta Tags Always Come First -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>게시글</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/board/assets/bootstrap-icons.css">

    <!-- CSS Front Template -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/board/assets/theme.min.css">

    <!-- JS Front -->
    <script src="<%=request.getContextPath()%>/view/board/assets/theme.min.js"></script>

 	<script src="<%= request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
 	
    <style>
        body {
            font-family: 'Noto Sans KR', sans-serif;
        }
        
        .content {
            height: 300px;
        }
        
        .col-form-label {
            font-size: 18px;
        }
        
        #replyText {
            resize: none;
            border-radius: 5px;
            border: 0.5px solid lightgray;
        }
        
        #replyText:focus {
            border: 1px solid #3bb44a;
        }
        
        .submit-btn {
            float: right;
            width: 140px;
            height: 121px;
            background-color: #3bb44a;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            letter-spacing: 5px;
        }
        
        .reply-list {
            margin-top: 50px;
        }
        
        .reply-table {
            width: 100%;
        }
        
        .reply-table tr {
            height: 65px;
        }
        
        .reply-table tr td {
            border-bottom: 1px solid lightgrey;
            border-top: 1px solid lightgrey;
            text-align: left;
        }
        
        .reply-table tr td sup {
            margin: 0;
        }
        
        .comment-writer {
            color: gray;
            font-size: 13px;
        }
        
        .comment-date {
            color: #3bb44a;
            font-size: 12px;
        }
        
        .btn-delete {
            float: right;
            display: none;
            background-color: #3bb44a;
            color: white;
            border: none;
            border-radius: 5px;
            letter-spacing: 5px;
            width: 90px;
            height: 30px;
            margin-right: 10px;
        }
        
        tr:hover button.btn-delete {
            display: inline;
        }
        
        tr:hover {
            background-color: #3bb44910;
        }
    </style>
    
    <%
    	BoardVO board = (BoardVO)request.getAttribute("board");
    
    %>
</head>

<body>

    <!-- START CONTENTS-->
    <!-- Form Card -->
    <div class="container content-space-2 content-space-lg-3">
        <div class="w-lg-75 mx-lg-auto">
            <!-- Heading -->
            <div class="text-center mb-7">
                <h2 class="card-title">게시글</h2>
                <p class="card-text">MoMoMo</p>
            </div>

            <div class="card card-bordered shadow-none">
                <div class="card-body">
                    <div class="row mb-3">
                        <label for="submitAppProjectName" class="col-sm-3 col-form-label">NO</label>
                        <div class="col-sm-9">
                            <div name="board_no" class="form-control form-control-lg" id="board_name"><%=board.getBoard_no()%></div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="submitAppProjectName" class="col-sm-3 col-form-label">제목</label>
                        <div class="col-sm-9">
                            <div name="title" class="form-control form-control-lg" id="board_name"><%=board.getTitle()%></div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="submitAppCategoryLabel" class="col-sm-3 col-form-label form-label">작성자</label>

                        <div class="col-sm-9">
                            <div name="writer" class="form-control form-control-lg"><%=board.getWriter_id()%></div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="submitAppCategoryLabel" class="col-sm-3 col-form-label form-label">작성일</label>

                        <div class="col-sm-9">
                            <div name="date" class="form-control form-control-lg"><%=board.getCreate_date() %></div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="submitAppCategoryLabel" class="col-sm-3 col-form-label form-label">조회수</label>

                        <div class="col-sm-9">
                            <div name="readCount" class="form-control form-control-lg"><%=board.getReadcount()%></div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="submitAppCategoryLabel" class="col-sm-3 col-form-label form-label">첨부파일</label>
						<%
							String origin = board.getFile_origin();
			                String rename = board.getFile_rename();
			                if(origin != null && origin.length() > 0) {
						%>
	                        <div class="col-sm-9">
	                        	<div name="file" class="form-control form-control-lg">
	                            	<a href="javascript:fileDownload('<%=origin%>', '<%=rename%>');">
	                             		<img src="<%=request.getContextPath()%>/resources/img/file.png"><%=origin%>
	                            	</a>
	                        	</div>
	                        </div>
                        <% } %>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-3 col-form-label form-label">내용</label>
                        <div class="col-sm-9">
                           	<div name="content" class="form-control form-control-lg content"><%=board.getContents()%></div>
                        </div>
                    </div>

                    <div class="text-center mt-5">
                    	<%if (loginMember != null) {
                    		if (loginMember.getId().equals(board.getWriter_id()) || loginMember.getRole().equals("ADMIN")) { %>
                        		<button type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/board/board_update?board_no=<%=board.getBoard_no()%>'">수정</button>
                        		<button type="button" id="btnDelete" name="btnDelete" class="btn btn-primary">삭제</button>
                    		<% } 
                    	} %>
                        <button type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/board/board_list'">목록으로</button>
                    </div>
                </div>
            </div>
            
            <!-- End Card -->
            
            <!-- 댓글 -->
            <br>
            <h3 style="margin-bottom: 20px; margin-top: 30px;">댓 글</h3>
            
            <div>
	            <!-- 댓글 등록 -->
                <div class="reply-write">
                    <form action="<%=request.getContextPath()%>/board/reply" method="post">
                    	<input type="hidden" name="board_no" value="<%=board.getBoard_no()%>">
                    	<input type="hidden" name="replyWriter" value="<%=loginMember != null ? loginMember.getId() : ""%>">
                    	<input type="hidden" name="replyWriter_no" value="<%=loginMember != null ? loginMember.getId() : ""%>">
                        <textarea name="replyContent" id="replyContent" cols="89" rows="13"></textarea>
                        <input type="submit" value="등록" class="submit-btn">
                    </form>
                </div>
            	<!-- 댓글 등록 -->
                
                <!-- 댓글 리스트 -->
                <div class="reply-list">
                    <table class="reply-table">
                    <%if(board.getReply()!=null){ 
                    for(ReplyVO reply : board.getReply()) {%>
                        <tr>
                            <td style="width: 83%;">
                                <sup class="comment-writer"><%=reply.getWriter_id()%></sup>
                                <sup class="comment-date"><%=reply.getCreate_date()%></sup>
                                <br>
                                <%=reply.getContents()%>
                            </td>
                            <td>
                            	<% if(loginMember != null && loginMember.getId().equals(reply.getWriter_id())) { %>
                                	<button class="btn-delete" onclick="deleteReply(<%=reply.getReply_no()%>);">삭제</button>
                            	<% } %>
                            </td>
                        </tr>
                    <% }} %>
                    </table>
                </div>
                <!-- 댓글 리스트 -->
            </div>

        </div>
    </div>
    <script type="text/javascript">
    
        function fileDownload(origin, rename) {
            var url = "<%= request.getContextPath()%>/board/fileDown";
            var oName = encodeURIComponent(origin);
            var rName = encodeURIComponent(rename);
            var requestURL = url + "?oriname=" + oName + "&" + "rename=" + rName;
            console.log(requestURL);
            location.assign(requestURL);
        }
        
        function deleteReply(reply_no) {
            var url = "<%=request.getContextPath()%>/board/replyDelete?reply_no=";
            var requestURL = url + reply_no;
            location.replace(requestURL);
        }
        
        $(document).ready(() => {
    		$("#btnDelete").on("click", (e) => {
    			if(confirm("정말로 게시글을 삭제 하시겠습니까?")) {
    				location.replace("<%=request.getContextPath() %>/board/delete?board_no=<%=board.getBoard_no()%>");
    			}
    		});
    		
    		$("#replyText").on("focus", (e) => {
    			if(<%= loginMember == null %>) {
    				alert("로그인 후 이용해주세요!");
    			}
    		});
    	});
    </script>

</body>


</html>
