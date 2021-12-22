<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/common/header.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모모모 전기차</title>
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/checkout/">


    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Required Meta Tags Always Come First -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>Portfolio: Grid | Front - Multipurpose Responsive Template</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="assets/vendor/bootstrap-icons/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/vendor/hs-mega-menu/dist/hs-mega-menu.min.css">

    <!-- CSS Front Template -->
    <link rel="stylesheet" href="assets/css/theme.min.css">

    <style>
        .imgecen {
            text-align: center;
        }

        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        @media (min-width: 768px) {
            .col-12 {
                margin-bottom: 15px;
            }
        }

        .form-control {
            display: block;
            width: 100%;
            height: 34px;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.5;
            color: #555;
            background-color: #fff;
            background-image: none;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: 4px;
        }

        .container {
            width: 30%;
            height: auto;
        }

        .main-page {
            width: 100%;
            height: 100%;
            text-align: left;
        }

        .opopopop {
            width: 60%;
            height: auto;
        }

        .span,
        p {
            margin-left: 10px;
        }

        .element.style {
            margin-left: 50px;
        }

        .main-page {
            display: flex;
            flex-wrap: nowrap;
            justify-content: space-around;
            margin: -10px auto;
            width: 1200px;
            background-color: rgb(245, 245, 245);
        }

        @media (min-width: 992px) {
            .content-space-b-lg-3 {
                padding-bottom: 2.5rem !important;
            }
        }

        @media (min-width: 992px) {
            .content-space-t-lg-5 {
                padding-top: 2.5rem !important;
            }
        }

        @media (min-width: 992px) {
            .col-lg-8 {
            -ms-flex: 0 0 auto;
            flex: 0 0 auto;
            width: 100%;
            }
        }

        .main-page, .form-label, .form-check-label {
            font-family: var(--bs-body-font-family);
            font-size: 16px;
        }
    </style>

    <!-- Custom styles for this template -->
    <link href="form-validation.css" rel="stylesheet">
</head>


<body>
    <!-- ========== MAIN CONTENT ========== -->
    <main id="content" role="main">
        <div class="container content-space-t-3 content-space-t-lg-5 content-space-b-2 content-space-b-lg-3">
            <!-- Hero -->
            <div class="text-center">
                <p class="lead">모두의, 모두에 의한, 모두를 위한</p>
                <h1 class="display-4 mb-0">이벤트
                    <span class="text-highlight-warning">
                        <span class="js-typedjs" data-hs-typed-options='{
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

        <div class="imgecen">
            <img src="<%=request.getContextPath()%>/view/resources/img/event_img.jpg"
                alt="" title=""  style="width: 1200px; height: 600px;">
        </div>
        <section id="article_content" class="">
            <!-- <div class="container">
            <div class="left-column panel-panel">
                <div class="panel-pane pane-node-title">



                    <div class="pane-content">
                        <h2 class="page-title" style="margin-left: 40px; width: auto;">인천 시승 센터 시승 신청</h2>
                    </div>


                </div>
                <div class="panel-pane pane-entity-field pane-node-field-event-location">
 -->

            <div class="main-page">
                <br>
                <div class="opopopop">
                    <div class="pane-content">
                        <div class="field field-name-field-event-location field-type-location field-label-hidden">
                            <div class="field-items">
                                <div class="field-item even">
                                    <div class="location vcard" itemscope="" itemtype="http://schema.org/PostalAddress">
                                        <br>
                                        <br>
                                        <div class="adr">
                                            <span class="fn" itemprop="name" style="margin-left: 40px; font-size: 20px;"><strong>대명리조트 x 모모모전기차 Festa
                                            </strong></span>
                                        </div>
                                        <br>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="panel-pane pane-entity-field pane-node-field-event-time">
                        <div class="pane-content">
                            <div class="field field-name-field-event-time field-type-datetime field-label-hidden">
                                <div class="field-items">
                                    <div class="field-item even">
                                        <div class="date-display-range"><span class="date-display-start"
                                                style="margin-left: 40px;" property="dc:date" datatype="xsd:dateTime"
                                                content="2021-07-14T00:00:00-07:00">12월 1일</span> — <span
                                                class="date-display-end" property="dc:date" datatype="xsd:dateTime"
                                                content="2021-12-14T00:00:00-08:00">12월31일</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="panel-pane pane-entity-field pane-node-body">
                        <div class="pane-content">
                            <div class="field field-name-body field-type-text-with-summary field-label-hidden">
                                <div class="field-items">
                                    <div class="field-item even" property="content:encoded">
                                        <p style="text-align: center;"> </p>
                                        <p style="margin-left: 40px;">대명 리조트 & 모모모전기차의 리조트 숙박 응모권을 만나보세요!</p>
                                        <p style="margin-left: 40px;">대명 리조트에서 모모모전기차를 이용해주신 분에게 숙박 응모권을 증정합니다.</p>
                                        <p style="margin-left: 40px;">당첨이 될 시 대명리조트 어플을 통해 숙박권 등록 후 예약을 해주시기 바랍니다.</p>
                                        <p style="margin-left: 40px;">코로나 바이러스 확산 방지와 방문객 보호를 위하여 사전에 접종증명을 해주시기 바랍니다.
                                        </p>
                                        <p style="margin-left: 40px;"><span style="font-size:11px;">* 본 리조트는 방역 수칙을
                                                철저히
                                                준수하여 안전하게 운영됩니다.</span></p>
                                        <p style="margin-left: 40px;"> </p>
                                        <p style="margin-left: 40px;"></p>
                                        <p style="margin-left: 40px;"> </p>
                                        <ul>
                                            <li style="margin-left: 40px;">실시간 예약 시스템으로 인하여 원하시는 일정의 숙박이 조기 마감될 수 있습니다.
                                            </li>
                                            <li style="margin-left: 40px;">예약 1건 당 동반 1인까지 숙박이 허용되며, 이를 초과하는 경우 추가요금이 발생할 수 있습니다.</li>
                                            <li style="margin-left: 40px;">신청 후 예약 확정 문자가 발송되며, 해당 문자를 수신하지 못한 경우 대표전화
                                                (02-2186-5747)로 문의 주시기 바랍니다.</li>
                                            <li style="margin-left: 40px;">일정 변경은
                                                대표전화
                                                (02-2186-5747)로 문의 주시기 바랍니다.</li>
                                            <li style="margin-left: 40px;">숙박 가능한 연령은 20세이상 이며, 방문 시 유효한 신분증을 지참하시기 바랍니다.
                                            </li>
                                        </ul>
                                        <p style="margin-left: 40px;"> </p>
                                        <p style="margin-left: 40px;"> </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <main>
                        <div class="row g-5">
                            <h4 class="d-flex justify-content-between align-items-center mb-3"></h4>
                        </div>
                        <br>
                        <div class="col-md-7 col-lg-8">
                            <form class="needs-validation" novalidate action="<%=request.getContextPath()%>/event" method="post">
                                <div class="row g-3">
                                    <div class="col-12">
                                        <label for="firstName" class="form-label">이름</label>
                                        <input type="text" class="form-control" id="firstName" placeholder="" value=""
                                            required>
                                        <div class="invalid-feedback">
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label for="email" class="form-label">Email <span
                                                class="text-muted"></span></label>
                                        <input type="email" class="form-control" id="email"
                                            placeholder="you@example.com">
                                        <div class="invalid-feedback">
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label for="address" class="form-label">전화번호(하이폰 "-" 없이 숫자만 입력)</label>
                                        <input type="text" class="form-control" id="address" placeholder="0xxxxxxxxxx"
                                            required>
                                        <div class="invalid-feedback">
                                        </div>
                                    </div>

                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="same-address">
                                        <label class="form-check-label" for="same-address">&nbsp;당첨시 문자 수신에 동의하십니까?</label>
                                    </div>

                                    <hr class="my-4">

                                    <button class="w-100 btn btn-primary btn-lg" type="submit"
                                        style="width: 100%; font-family: var(--bs-body-font-family);
                                        font-size: 16px;">제출하기</button>

                                </div>
                            </form>
                        </div>
                </div>
            </div>
            </div>
    </main>


    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

    <script src="form-validation.js"></script>
    </div>
    <br><br><br>
    </div>
    </section>

</body>
<%@ include file="/view/common/footer.jsp"%>