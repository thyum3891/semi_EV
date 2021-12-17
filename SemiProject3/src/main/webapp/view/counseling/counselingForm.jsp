<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Date sysDate = new Date();
    	int nowDate = sysDate.getDate();
    	String modelName = (String)request.getAttribute("modelName");
    	String name = (String)request.getAttribute("name");
    	String phone = (String)request.getAttribute("phone");
    %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required Meta Tags Always Come First -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>구매상담신청</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/bootstrap-icons.css">

    <!-- CSS Front Template -->
    <link rel="stylesheet" href="assets/theme.min.css">
      <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>

    <!-- ========== MAIN CONTENT ========== -->
    <main id="content" role="main" class="bg-light">
        <!-- Content -->
        <div class="container content-space-t-3 content-space-t-lg-5 content-space-b-2 content-space-b-lg-3">
            <div class="w-lg-75 mx-auto">
                <!-- Jobs Link -->
                <div class="mb-5">
                    <a class="link" href="carListPage.html">
                        <i class="bi-chevron-left small ms-1"></i> 전기차 상세 조회 페이지로
                    </a>
                </div>
                <!-- End Jobs Link -->

                <!-- Card -->
                <div class="card card-lg">
                    <div class="card-body">
                        <!-- Title -->
                        <div class="row justify-content-sm-between align-items-sm-center mb-5">
                            <div class="col-sm mb-3 mb-sm-0">
                                <h1 class="card-title h2">전기차 구매 상담 신청하기</h1>
                                <p class="card-text">구매 문의 외의 기타 문의는 카카오톡을 통해 문의하실 수 있습니다</p>
                            </div>
                        </div>
                        <!-- End Title -->
                        <hr class="my-5 my-sm-10">

                        <!-- Form -->
                        <h3> 개인정보 입력 </h3>
                        <br>
                        <form id="applyForJob" class="js-validate" action="<%=request.getContextPath()%>/counseling/save" method="post">
                            <!-- Form -->
                            <div class="row mb-3">
                                <label for="fullname" class="col-sm-4 col-form-label">이름</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="fullname" name="name" placeholder="홍길동" value="<%=name%>" aria-label="이름">
                                </div>
                            </div>
                            <!-- End Form -->

                            <!-- Form -->
                            <div class="row mb-3">
                                <label for="phoneNumber" class="col-sm-4 col-form-label">연락처</label>
                                <div class="col-sm-8">
                                    <input type="tel" class="form-control" id="phoneNumber" name="phone" maxlength="11" placeholder="010부터 (-) 없이 총 11자리를 입력하세요." value="<%=phone%>" aria-label="010-XXXX-XXXX">
                                </div>
                            </div>
                            <!-- End Form -->

                            <!-- Form -->
                            <div class="row mb-3">
                                <label for="carName" class="col-sm-4 col-form-label">상담할 전기차 모델명</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="carName" name="modelName" value="<%=modelName%>" disabled="disabled">
                                </div>
                            </div>
                            <!-- End Form -->

                            <hr class="my-5 my-sm-10">

                            <div class="mb-5">
                                <h3> 전기차 상담 예약 </h3>
                                <br>
                                <p>상담 가능한 시간은 평일 09:00~17:00 입니다. (12:00~13:00 점심시간)</p>
                                <p>상담 시간은 최소 10분~ 최대 30분입니다. </p>
                            </div>

                            <!-- Select -->

                            <div class="mb-4">

                                <label class="form-label" for="reservation_date"> 상담 가능한 시간 </label>
                                <select name="date" id="reservation_date" class="form-select form-select-lg" aria-label="상담 가능한 시간">
                                    
                                    
                                    <option selected>상담 예약 날짜를 골라주세요</option>
                                      <%for(int i = 1 ; i<=14 ; i++) {
                                    	  sysDate.setDate(nowDate+i);
                                      	String format1 = new SimpleDateFormat("yyyy/MM/dd").format(sysDate);
                                      	String format2 = new SimpleDateFormat("MM월 dd일 (EEE)").format(sysDate);
                                      	String week = new SimpleDateFormat("EEE").format(sysDate);
                                     if(week.equals("금")||week.equals("토")){
                                    	 continue;
                                     }
                                      if(week.equals("일")){
                                      %>
                                       <option>-------------</option>
                                    	  <%}else{%>
                                    <option value="<%=format1%>"><%=format2 %></option>
                                       <%}} %>
                                    
                                    </select>
                            </div>
                            <!-- End Select -->

                            <!-- Select -->
                            <div class="mb-4">
                                <label class="form-label" for="reservation_time"> 상담 가능한 시간 </label>
                                <select name="reservation" id="reservation_time" class="form-select form-select-lg" aria-label="상담 가능한 시간">
                                
                                
                                 <option selected>상담 예약 시간을 골라주세요</option>
                             

                                    <option value="10:00-11:00">10:00-11:00</option>
                                    <option value="11:00-12:00">11:00-12:00</option>
                                    <option value="13:00-14:00">13:00-14:00</option>
                                    <option value="14:00-15:00">14:00-15:00</option>
                                    <option value="15:00-16:00">15:00-16:00</option>
                                    <option value="16:00-17:00">16:00-17:00</option>
                                  </select>
                            </div>
                            <!-- End Select -->

                            <!-- Form -->

                            <span class="d-block" onchange="check()">
                                <label class="form-label" for="inflowPath"><b>유입 경로</b></label>
                                <br>
                                <br>
                                <input type="radio" name="inflowPath" id="inflowPath1" value="블로그" checked>
                                <label for="inflowPath">블로그</label>
                                <input type="radio" name="inflowPath" id="inflowPath2" value="인스타">
                                <label for="inflowPath">인스타</label>
                                <input type="radio" name="inflowPath" id="inflowPath3" value="지인 추천">
                                <label for="inflowPath">지인 추천</label>
                          
                                <input type="radio" name="inflowPath" id="inflowPath4" value="기타" >
                                <label for="inflowPath">기타</label>          
                                <input type="text" name="inflowPath" id="inflowPathblock" placeholder="기타 경로 입력" disabled>
                            </span>
                            <br>
							
                            <!-- End Form -->

                            <hr class="my-5 my-sm-10">

                            <div class="mb-5">
                                <h3>Additional information</h3>
                            </div>

                            <!-- Form -->
                            <div class="mb-3">
                                <label for="additionalInfoCareersForm" class="form-label visually-hidden">Additional information</label>
                                <textarea class="form-control" name="additionalInfoCareersFormName" id="additionalInfoCareersForm" placeholder="상담 하기 전에 상담원에게 미리 전하고 싶은 말을 적어주세요" aria-label="Add a cover letter or anything else you want to share." rows="5"></textarea>
                            </div>
                            <!-- End Form -->

                            <div class="w-lg-65 mx-lg-auto">
                                <!-- Accordion -->
                                <div class="accordion accordion-flush accordion-lg" id="accordionFAQ">
                                    <!-- Accordion Item -->
                                    <div class="accordion-item">
                                        <div class="accordion-header" id="headingBasicsOne">
                                            <a class="accordion-button" role="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                  개인정보 활용에 동의하십니까?
                                                </a>
                                        </div>
                                        <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingBasicsOne" data-bs-parent="#accordionFAQ">
                                            <div class="accordion-body">
                                                <p>이용자가 제공한 모든 정보는 다음의 목적을 위해 활용되며, 하기 목적 이외의 용도로 활용되지 않습니다. </p>
                                                <p> - 수집 항목 : 이름, 연락처 </p>
                                                <p> - 수집 이용 및 목적 : 전기차 구입 및 상담을 위하여 </p>
                                                <p> 전기차 구입을 위한 개인정보는 추가적으로 수집될 예정입니다. </p>
                                                <p> - 개인정보 보유 및 이용기간 : 수집 및 이용 동의일로부터 개인정보의 수집 및 이용 목적을 달성할 때까지</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- End Accordion Item -->
                            <hr>
                            <br>
                            <input type="radio" name="inflowPath2" id="inflowPath" value="네. 동의합니다." required="required">
                            <label for="inflowPath">이 양식을 제출함으로써 개인정보 활용에 동의합니다. </label> 
                            <div class="d-grid text-center mt-7">
                                <input type="submit" class="btn btn-primary" value="상담 예약 양식 제출하기" >
                            </div>


                        </form>
                        <!-- End Form -->
                    </div>
                </div>
                <!-- End Card -->
            </div>
        </div>
        <!-- End Content -->
    </main>
    <!-- ========== END MAIN CONTENT ========== -->


    <!-- JS Global Compulsory  -->
    <script src="<%=request.getContextPath()%>/view/assets/bootstrap.bundle.min.js"></script>

    

    <!-- JS Front -->
    <script src="<%=request.getContextPath()%>/view/assets/theme.min.js"></script>

    <!-- JS Plugins Init. -->
    <script>
    function check(){

        if($("#inflowPath4").is(':checked')){
            $("#inflowPathblock").prop("disabled", false);
            
        }else{
            $("#inflowPathblock").prop("disabled", true);
        }

        }
    </script>
</body>

</html>