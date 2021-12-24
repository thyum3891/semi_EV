<%@page import="java.util.List"%>
<%@page import="com.kh.semi.vo.Faq"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/view/common/header.jsp"%>
<%
	List<Faq> list = (List<Faq>)request.getAttribute("list");
%>

<head>
    <!-- Required Meta Tags Always Come First -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>자주묻는질문</title>

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">


    <!-- CSS Front Template -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/view/assets/theme.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">

    <!-- End FAQ -->
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/view/assets/bootstrap.bundle.min.js"></script>

    <style>
        .accordion-button:not(.collapsed),
        .accordion-button:hover {
            color: #3bb44a;
            background-color: #fff;
            box-shadow: inset 0 -.0625rem 0 rgba(33, 50, 91, .1)
        }
        
        .accordion-body {
            line-height: 35px;
        }
        
        body {
            font-family: 'Noto Sans KR', sans-serif;
        }
        .text-center h2{
        	letter-spacing: 3px;
        }
    </style>

</head>

<body>
    <!-- FAQ -->
    <div class="container content-space-2 content-space-lg-3">
        <!-- Heading -->
        <div class="w-md-75 w-lg-50 text-center mx-md-auto mb-5 mb-md-9">
            <h2>자주 묻는 질문 </h2>
        </div>
        <!-- End Heading -->

        <div class="w-lg-65 mx-lg-auto">
            <!-- Accordion -->
            
            <div class="accordion accordion-flush accordion-lg" id="accordionFAQ">
                <!-- Accordion Item -->
                <%-- <%for(Faq faq : list){ %>  --%>
                <div class="accordion-item">
                    <div class="accordion-header" id="headingCuriousOne">
                        <a class="accordion-button" role="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
             				 	<%=list.get(0).getTitle()%>
           			 	</a>
                    </div>
                    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingCurious" data-bs-parent="#accordionFAQ">
                        <div class="accordion-body">
							<%=list.get(0).getContents()%>
                        </div>
                    </div>
                </div>
                <%-- <%} %> --%>
                <!-- End Accordion Item -->

                <!-- Accordion Item -->
                <div class="accordion-item">
                    <div class="accordion-header" id="headingCuriousTwo">
                        <a class="accordion-button collapsed" role="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
             				<%=list.get(1).getTitle()%>
            			</a>
                    </div>
                    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingCuriousTwo" data-bs-parent="#accordionFAQ">
                        <div class="accordion-body">
							<%=list.get(1).getContents()%>
                        </div>
                    </div>
                </div>
                <!-- End Accordion Item -->

                <!-- Accordion Item -->
                <div class="accordion-item">
                    <div class="accordion-header" id="headingCuriousThree">
                        <a class="accordion-button collapsed" role="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
              					<%=list.get(2).getTitle()%>
            			</a>
                    </div>
                    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingCuriousThree" data-bs-parent="#accordionFAQ">
                        <div class="accordion-body">
							<%=list.get(2).getContents()%>
                        </div>
                    </div>
                </div>
                <!-- End Accordion Item -->

                <!-- Accordion Item -->
                <div class="accordion-item">
                    <div class="accordion-header" id="headingCuriousFour">
                        <a class="accordion-button collapsed" role="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
            				<%=list.get(3).getTitle()%>
            			</a>
                    </div>
                    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingCuriousFour" data-bs-parent="#accordionFAQ">
                        <div class="accordion-body">
							<%=list.get(3).getContents()%>
                        </div>
                    </div>
                </div>
                <!-- End Accordion Item -->
            </div>
            <!-- End Accordion -->
        </div>
    </div>
    <%@ include file="/view/common/footer.jsp"%>
</body>

</html>