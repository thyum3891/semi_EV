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
    <title>Careers: Overview | Front - Multipurpose Responsive Template</title>

    <!-- Favicon
    <link rel="shortcut icon" href="./favicon.ico">

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/board/assets/bootstrap-icons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/board/assets/hs-mega-menu.min.css">

    <!-- CSS Front Template -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/board/assets/theme.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/board/assets/quill.snow.css">


    <!-- JS Front -->
    <script src="<%=request.getContextPath()%>/view/board/assets/theme.min.js"></script>


</head>

<body>

    <!-- START CONTENTS-->
    <!-- Form Card -->
    <div class="container content-space-2 content-space-lg-3">
        <div class="w-lg-75 mx-lg-auto">
            <!-- Heading -->
            <div class="text-center mb-7">
                <h2 class="card-title">게시글 작성</h2>
                <p class="card-text">MoMoMo</p>
            </div>
            <!-- End Heading -->

            <!-- Card -->
            <div class="card card-bordered shadow-none">
                <div class="card-body">
                    <!-- Form -->
                    <form name="boardWriteForm" id="boardWriteForm" action="<%=request.getContextPath()%>/board/board_write" method="post" enctype="multipart/form-data">
                        <!-- Form -->
                        <div class="row mb-3">
                            <label for="submitAppProjectName" class="col-sm-3 col-form-label">제목</label>
                            <div class="col-sm-9">
                                <input type="text" name="title" class="form-control form-control-lg" id="board_name" placeholder="게시글 제목을 입력하세요." aria-label="board_name">
                            </div>
                        </div>
                        <!-- End Form -->

                        <!-- Form -->
                        <div class="row mb-3">
                            <label for="submitAppCategoryLabel" class="col-sm-3 col-form-label form-label">작성자</label>

                            <div class="col-sm-9">
                                <input type="text" name="writer" class="form-control form-control-lg" value="<%=loginMember.getId()%>" readonly>
                                <input type="hidden" name="writer_no" class="form-control form-control-lg" value="<%=loginMember.getId()%>" readonly>
                            </div>
                        </div>
                        <!-- End Form -->

                        <!-- Form-->
                        <div class="row mb-3">
                            <label class="col-sm-3 col-form-label form-label">내용</label>

                            <div class="col-sm-9">

                                <!-- Quill -->
                                <div class="quill-custom">
                                <%--
                                    <div name="content" class="js-quill" style="height: 15rem;" data-hs-quill-options='{
                                            "placeholder": "내용을 입력하세요",
                                            "modules": {
                                            "toolbar": [
                                                ["bold", "italic", "underline", "strike", "link", "image", "blockquote", "code", {"list": "bullet"}]
                                            ]
                                            }
                                        }'>
                                    </div>
                                --%>
                                <textarea class="js-quill" name="content" rows="17" cols="61"></textarea>
                                    
                                </div>
                                <!-- End Quill -->
                            </div>
                        </div>
                        <!-- End Form-->
                        <!-- Form -->
                        <div class="row mb-3">
                            <label class="col-sm-3 col-form-label form-label">첨부파일</label>

                            <div class="col-sm-9">
                                <!-- File Attachment Input -->
                                <div id="dropzoneUpload" class="js-dropzone dz-dropzone dz-dropzone-card">
                                    <div class="dz-message">
                                        <input type="file" name="file" onchange="checkSize(this)">
                                        <%--<span class="d-block">업로드할 파일을 선택해주세요</span>--%>
                                        <span class="d-block text-muted small">파일 최대크기 2MB</span>
                                    </div>
                                </div>
                                <!-- End File Attachment Input -->
                            </div>
                        </div>
                        <!-- End Form -->
                        <div class="text-center mt-5">
                            <button type="submit" class="btn btn-primary btn-lg">게시글 등록</button>
                        </div>
                    </form>
                    <!-- End Form -->
                </div>
            </div>
            <!-- End Card -->
        </div>
    </div>

    <!-- JS Implementing Plugins -->
    <script src="assets/vendor/hs-file-attach/dist/hs-file-attach.min.js"></script>
    <script src="assets/vendor/hs-count-characters/dist/js/hs-count-characters.js"></script>
    <script src="assets/vendor/quill/dist/quill.min.js"></script>
    <script src="assets/vendor/dropzone/dist/min/dropzone.min.js"></script>

    <!-- JS Front -->

    <!-- JS Plugins Init. -->
    <script>
        
    function checkSize(input) {
		if(input.files && input.files[0].size > (2 * 1024 * 1024)) {
	        alert("파일 사이즈가 2MB 를 넘습니다.");
	        input.value = null;
	    }
	}

    </script>
</body>

</html>