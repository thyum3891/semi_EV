<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/common/header.jsp"%>
<head>
    <!-- Required Meta Tags Always Come First -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>Events</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/bootstrap-icons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/hs-mega-menu.min.css">

    <!-- CSS Front Template -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/theme.min.css">
</head>
<style>
    .row {
        display: flex;
        justify-content: center;
        text-align: center;
    }
    
    @media (min-width: 992px) {
        .content-space-b-lg-3 {
            padding-bottom: 4.5rem!important;
        }
    }
    
    @media (min-width: 992px) {
        .content-space-t-lg-5 {
            padding-top: 2.5rem!important;
        }
    }
    
    .mb-5 {
        margin-left: 40px;
        margin-right: 40px;
    }
</style>

<body>

    <!-- ========== MAIN CONTENT ========== -->
    <main id="content" role="main">
        <div class="container content-space-t-3 content-space-t-lg-5 content-space-b-2 content-space-b-lg-3">
            <!-- Hero -->
            <div class="text-center">
                <p class="lead">모두의, 모두에 의한, 모두를 위한</p>
                <h1 class="display-4 mb-0">이벤트
                    <span class="text-highlight-warning">
            <span class="js-typedjs"
                  data-hs-typed-options='{
                    "strings": ["create a portfolio", "publicize my band", "sell my products", "promote my business", "display my photographs", "promote my business", "publish my videos"],
                    "typeSpeed": 100,
                    "loop": true,
                    "backSpeed": 50,
                    "backDelay": 1500
                  }'></span>
                    </span>
                </h1>
            </div>
        </div>
        <!-- End Hero -->

        <!-- Card Grid -->
        <div class="container content-space-b-2 content-space-b-lg-3">
            <!-- Nav Scroller -->
            <div class="js-nav-scroller hs-nav-scroller-horizontal mb-7">
                <span class="hs-nav-scroller-arrow-prev" style="display: none;">
             <a class="hs-nav-scroller-arrow-link" href="javascript:;">
             <i class="bi-chevron-left"></i>
             </a>
                </span>

                <span class="hs-nav-scroller-arrow-next" style="display: none;">
             <a class="hs-nav-scroller-arrow-link" href="javascript:;">
             <i class="bi-chevron-right"></i>
              </a>
                 </span>
            </div>
            <!-- End Nav Scroller -->

            <div class="js-shuffle row row-cols-1 row-cols-sm-2 row-cols-md-3">
                <div class="js-shuffle-item col mb-5" data-groups='["product"]'>
                    <!-- Card -->
                    <a class="card card-flush card-transition" href="<%=request.getContextPath()%>/view/events/eventTestDrive.jsp">
                        <img class="card-img-top" src="<%=request.getContextPath()%>/view/resources/img/event_car1.jpg" alt="Image Description">
                        <div class="card-body">

                            <h3 class="card-title">오토플러스 인천 시승권 응모하기</h3>
                        </div>
                    </a>
                    <!-- End Card -->
                </div>
                <!-- End Col -->

                <div class="js-shuffle-item col mb-5" data-groups='["branding"]'>
                    <!-- Card -->
                    <a class="card card-flush card-transition" href="<%=request.getContextPath()%>/view/events/eventResort.jsp">
                        <img class="card-img-top" src="<%=request.getContextPath()%>/view/resources/img/event_img.jpg" alt="Image Description">
                        <div class="card-body">

                            <h3 class="card-title">대명리조트 숙박권 응모하기</h3>
                        </div>
                    </a>
                    <!-- End Card -->
                </div>
                <!-- End Col -->
            </div>
            <!-- End Row -->
        </div>
        <!-- End Card Grid -->
    </main>
    <!-- ========== END MAIN CONTENT ========== -->


</body>
<%@ include file="/view/common/footer.jsp"%>