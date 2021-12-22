<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="../assets/bootstrap-icons.css">
    <link rel="stylesheet" href="../assets/hs-mega-menu.min.css">

    <!-- CSS Front Template -->
    <link rel="stylesheet" href="../assets/theme.min.css">
    <link rel="stylesheet" href="../assets/snippets.min.css">
    
    <style>
        .btn-lg:hover,
        .btn-lg:focus {
            background-color: #2bd13f;
            border: none;
            color: rgb(255, 255, 255);
        }
        
        .btn-primary {
            color: #fff;
            font-family: 'Nanum Gothic', sans-serif;
            background-color: #3bb44a;
        }
        
    </style>

</head>

<body>
    <!-- START CONTENTS-->

    <!-- Post a Comment -->
    <div class="container content-space-2">
        <!-- Heading -->
        <div class="w-md-75 w-lg-50 text-center mx-md-auto mb-5 mb-md-9">
            <h2>신규 전기차 등록</h2>
        </div>
        <!-- End Heading -->

        <div class="row justify-content-lg-center">
            <div class="col-lg-8">
                <!-- Card -->
                <div class="card card-lg border shadow-none">
                    <div class="card-body">
                        <form action="<%= request.getContextPath()%>/model/write" method="POST" enctype="multipart/form-data">
                            <div class="d-grid gap-4">
                                <!-- Form -->
                                <div class="row">
                                    <div class="col-sm-6 mb-4 mb-sm-0">
                                        <label class="form-label" for="blogContactsFormModelName"><b>모델명</b></label>
                                        <input type="text" class="form-control form-control-lg" name="blogContactsModelName" id="blogContactsFormModelName" placeholder="Model Name" required>
                                    </div>

                                    <div class="col-sm-6">
                                        <label class="form-label" for="blogContactsFormModelSub"><b>상세모델명</b></label>
                                        <input type="text" class="form-control form-control-lg" name="blogContactsModelSub" id="blogContactsFormModelSub" placeholder="Model Sub" required>
                                    </div>
                                </div>
                                <!-- End Form -->

                                <!-- Form -->
                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormEmail"><b>가격</b></label>
                                    <input type="text" class="form-control form-control-lg" name="blogContactsPrice" id="blogContactsFormPrice" placeholder="Price" required>
                                </span>

                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormFuel"><b>연비</b></label>
                                    <input type="text" class="form-control form-control-lg" name="blogContactsFuel" id="blogContactsFormFuel" placeholder="Fuel" required>
                                </span>

                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormPerson"><b>승차정원</b></label>
                                    <input type="text" class="form-control form-control-lg" name="blogContactsPerson" id="blogContactsFormPerson" placeholder="Person" required>
                                </span>

                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormDrive"><b>구동방식</b></label><br>
                                    <input type="radio" name="blogContactsDrive" id="blogContactsFormDrive1" value="전륜구동" checked>
                                    <label for="blogContactsFormDrive">전륜구동</label> &nbsp &nbsp
                                    <input type="radio" name="blogContactsDrive" id="blogContactsFormDrive2" value="후륜구동">
                                    <label for="blogContactsFormDrive">후륜구동</label> &nbsp &nbsp
                                    <input type="radio" name="blogContactsDrive" id="blogContactsFormDrive3" value="4륜구동">
                                    <label for="blogContactsFormDrive">4륜구동</label>
                                </span>

                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormTransM"><b>변속기어</b></label><br>
                                    <input type="radio" name="blogContactsTransM" id="blogContactsFormTransM1" value="자동" checked>
                                    <label for="blogContactsFormDrive">자동</label> &nbsp &nbsp
                                    <input type="radio" name="blogContactsTransM" id="blogContactsFormTransM2" value="수동">
                                    <label for="blogContactsFormDrive">수동</label>
                                </span>

                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormDistance"><b>1회 충전 시 이동 가능 거리<b></label>
                                    <input type="text" class="form-control form-control-lg" name="blogContactsDistance" id="blogContactsFormDistance" placeholder="Distance" required>
                                </span>

                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormEnergy"><b>에너지 출력</b></label>
                                    <input type="text" class="form-control form-control-lg" name="blogContactsEnergy" id="blogContactsFormEnergy" placeholder="Energy" required>
                                    <br>
                                </span>

                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormMotor"><b>모터 출력</b></label>
                                    <input type="text" class="form-control form-control-lg" name="blogContactsMotor" id="blogContactsFormMotor" placeholder="Motor" required>
                                    <br>
                                </span>

                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormCompany"><b>생산 회사</b></label>
                                    <input type="text" class="form-control form-control-lg" name="blogContactsCompany" id="blogContactsFormCompany" placeholder="Company" required>
                                    <br>
                                </span>
                                <br>


                                <span class="d-block">
                                    <label class="form-label" for="blogContactsFormNation"><b>구분</b></label><br>
                                    <input type="radio" name="blogContactsNation" id="blogContactsFormNation1" value="국산" checked>
                                    <label for="blogContactsFormDrive">국산</label> &nbsp &nbsp
                                    <input type="radio" name="blogContactsNation" id="blogContactsFormNation" value="외제">
                                    <label for="blogContactsFormDrive">외제</label>
                                </span>
                                <br>

                                <span class="d-block">
                                    <label for="image1">이미지1 : </label>
                                    <input type="file" name="image1" id="image1" required><br>
                                    <br>
                                    <label for="image2">이미지2 : </label>
                                    <input type="file" name="image2" id="image2" required><br>
                                    <br>
                                    <label for="image3">이미지3 : </label>
                                    <input type="file" name="image3" id="image3" required><br>
                                    <br>
                                    <label for="image4">이미지4 : </label>
                                    <input type="file" name="image4" id="image4" required><br>
                                    <br>
                                    <label for="image5">이미지5 : </label>
                                    <input type="file" name="image5" id="image5" required><br>
                                    <br>
                                </span>

                                <!-- End Form -->


                                <div class="d-grid">
                                    <br>
                                    <button type="submit" class="btn btn-primary btn-lg">신규 전기차 등록</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- End Card -->
            </div>
            <!-- End Col -->
        </div>
        <!-- End Row -->
    </div>
    <!-- End Post a Comment -->


    <!-- END CONTENTS-->

</body>

</html>