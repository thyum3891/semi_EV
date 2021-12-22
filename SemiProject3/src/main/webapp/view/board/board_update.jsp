<%@page import="com.kh.semi.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/view/common/header.jsp"%>
    
    <%
    	BoardVO board = (BoardVO)request.getAttribute("board");
    %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- Required Meta Tags Always Come First -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>게시글 수정</title>

    <!-- CSS Implementing Plugins -->

    <!-- CSS Front Template -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/board/assets/theme.min.css">
    <!-- <link rel="stylesheet" href="assets/vendor/quill/dist/quill.snow.css"> -->

    <!-- JS Front -->
    <script src="assets/theme.min.js"></script>

    <style>
        .content {
            resize: none;
            border: 0.5px solid lightgray;
            width: 100%;
            height: 300px;
        }
        
        img {
            width: 20px;
            height: 20px;
        }
    </style>
</head>

<body>
    <!-- START CONTENTS-->
    <!-- Form Card -->
    <div class="container content-space-2 content-space-lg-3">
        <div class="w-lg-75 mx-lg-auto">
            <!-- Heading -->
            <div class="text-center mb-7">
                <h2 class="card-title">게시글 수정</h2>
                <p class="card-text">MoMoMo</p>
            </div>
            <!-- End Heading -->

            <!-- Card -->
            <div class="card card-bordered shadow-none">
                <div class="card-body">
                    <!-- Form -->
                    <form name="boardWriteForm" id="boardWriteForm" action="<%=request.getContextPath()%>/board/board_update" method="post" enctype="multipart/form-data">
                    <%if(board.getFile_origin()!=null){ %>
                    <input type="hidden" name="file_origin" value="<%=board.getFile_origin()%>">
                    <%}
                    if(board.getFile_rename()!=null){ %>
					<input type="hidden" name="file_rename" value="<%=board.getFile_rename()%>">
					<%} %>
					<input type="hidden" name="board_no" value="<%=board.getBoard_no()%>">
                        <!-- Form -->
                        <div class="row mb-3">
                            <label for="submitAppProjectName" class="col-sm-3 col-form-label">NO</label>
                            <div class="col-sm-9">
                            
                                <div name="board_no" class="form-control form-control-lg" id="board_no"><%=board.getBoard_no()%>번</div>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="submitAppProjectName" class="col-sm-3 col-form-label">제목</label>
                            <div class="col-sm-9">
                                <input type="text" name="title" class="form-control form-control-lg" id="board_name" aria-label="board_name" value="<%=board.getTitle()%>">
                            </div>
                        </div>
                        <!-- End Form -->

                        <!-- Form -->
                        <div class="row mb-3">
                            <label for="submitAppCategoryLabel" class="col-sm-3 col-form-label form-label">작성자</label>

                            <div class="col-sm-9">
                                <input type="text" name="writer" class="form-control form-control-lg" value="<%=board.getWriter_id()%>" readonly>
                                <input type="hidden" name="writer_no" class="form-control form-control-lg" value="<%=loginMember.getId()%>" readonly>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="submitAppCategoryLabel" class="col-sm-3 col-form-label form-label">작성일</label>

                            <div class="col-sm-9">
                                <input type="text" name="date" class="form-control form-control-lg" value="<%=board.getCreate_date()%>" readonly>
                            </div>
                        </div>
                        <!-- End Form -->

                        <div class="row mb-3">
                            <label for="submitAppCategoryLabel" class="col-sm-3 col-form-label form-label">첨부파일</label>

                            <div class="col-sm-9">
                                <input type="file" name="reloadFile" class="form-control form-control-lg" onchange="checkSize(this)">
                                <%if(board.getFile_origin() != null) { %>
	                                <div class="row mb-3">
	                                    <div class="col-sm-9">
	                                    <%-- 파일 이미지!! --%>
	                                        <img src="<%=request.getContextPath()%>"><%=board.getFile_origin()%>
	                                    <%-- 파일 이미지!! --%>
	                                    </div>
	                                </div>
                                <% } %>
                            </div>
                        </div>


                        <div class="row mb-3">
                            <label class="col-sm-3 col-form-label form-label">내용</label>

                            <div class="col-sm-9">
                                <textarea class="content" name="content"><%=board.getContents()%></textarea>
                            </div>
                        </div>

                        <div class="text-center mt-5">
                            <button type="submit" class="btn btn-primary btn-lg">게시글 수정</button>
                            <button type="button" class="btn btn-primary btn-lg" onclick="location.href='<%=request.getContextPath()%>/board/board_list">목록으로</button>
                        </div>
                    </form>
                    <!-- End Form -->
                </div>
            </div>
        </div>
    </div>

</body>

<script type="text/javascript">

	function checkSize(input) {
		if(input.files && input.files[0].size > (2 * 1024 * 1024)) {
	        alert("파일 사이즈가 2MB 를 넘습니다.");
	        input.value = null;
	    }
	}


</script>

</html>

