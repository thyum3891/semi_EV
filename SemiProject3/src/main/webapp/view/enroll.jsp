<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
 <style>
   body {
            background-color: white;
            font-family: 'Noto Sans KR', sans-serif;
        }
        /*가로 800px 이상일때*/
        
        @media(min-width: 800px) {
            .main {
                width: 460px;
                margin: auto;
            }
            /* 로고설정*/
            /* .image {
                margin-top: 20px;
                height: 44px;
                padding: 30px;
            } */
        }
        
        .image {
            width: 300px;
            height: 200px;
            margin-top: 30px;
            margin-right: 75px;
        }
        
        #signup-text {
            margin-top: 10px;
        }
        
        #signup-text h1 {
            font-size: 30px;
            letter-spacing: 4px;
        }
        /*회원가입 부분*/
        
        .main-signup {
            text-align: center;
            width: 460px;
            margin: auto;
        }
        
        h3 {
            margin: 19px 0px 8px;
            text-align: left;
            font-size: 14px;
            color: #5a5a5a;
        }
        
        .signup-input {
            display: flex;
            border-top-right-radius: 15px;
            padding: 10px;
            border: solid 3px #dadada;
            background: white;
            cursor: pointer;
        }
        
        .signup-input:hover {
            border: solid 3px #3bb44a;
        }
        
        #signup-id,
        #pass1,
        #pass2 {
            height: 29px;
            border: none;
            outline: none;
            width: 100%;
        }
        
        .signup-at {
            color: rgb(150, 150, 150);
            font-size: 15px;
            margin-top: 8px;
        }
        
        .signup-at input {
            background-color: rgb(150, 150, 150);
        }
        
        .pw-lock {
            top: 50%;
            right: 13px;
            width: 24px;
            height: 24px;
            margin-top: 5px;
            background-image: url(https://static.nid.naver.com/images/ui/join/m_icon_pw_step.png);
            background-size: 125px 75px;
            cursor: pointer;
        }
        
        .pww-lock {
            top: 50%;
            right: 13px;
            width: 24px;
            height: 24px;
            margin-top: 5px;
            background-image: url(https://static.nid.naver.com/images/ui/join/m_icon_pw_step.png);
            background-size: 125px 75px;
            cursor: pointer;
        }
        
        #signup-name,
        #signup-email,
        #signup-phone {
            width: 100%;
            height: 29px;
            border: none;
            outline: none;
        }
        /*회원가입버튼박스*/
        
        .signup-btn-wrap {
            border-radius: 15px;
            height: 52px;
            line-height: 55px;
            margin: 50px 0px 50px 0px;
            border: solid 1px rgba(0, 0, 0, .1);
            background-color: #3bb44a;
            color: #fff;
            cursor: pointer;
        }
        /*회원가입버튼*/
        
        #signupSubmit {
            width: 100px;
            background-color: #3bb44a;
            border: none;
            color: #fff;
            font-size: 18px;
            outline: none;
            cursor: pointer;
        }
        
        #emailCheck {
            width: 200px;
            background-color: #3bb44a;
            border-radius: 10px;
            border: none;
            color: #fff;
            font-size: 14px;
            outline: none;
            cursor: pointer;
        }
        
        input:hover {
            border-color: blue;
        }
    </style>
</head>
<body>
<div class="main-signup">
        <header>
            <!--로고-->
            <div class="logo">
                <a href="index.html" title="네이버 홈페이지"><img src="<%=request.getContextPath()%>/view/resources/img/logo_last.png"  class="image" alt="로고사진"></a>
            </div>
            <div id="signup-text">
                <p>회 원 가 입</p>
            </div>
        </header>

        <!--회원가입 부분-->
        <section class="signup-wrap">
            <form name="memberEnrollForm" action="<%= request.getContextPath() %>/member/enroll" method="post">

                <div>
                    <!--아이디,비번,비번확인-->
                    <h3>> 이메일(아이디)</h3>
                    <span class="signup-input">
                     <input id="signup-id" type="email" name="userId" placeholder="example@email.com"  required></input>
                     <input type="button" id="emailCheck" name="emailCheck" value="이메일 중복 확인" onclick="idChecked()">
                    <span class="signup-at"></span>
                    </span>

                    <h3>> 비밀번호</h3>
                    <span class="signup-input">
                    <input id="pass1" type="password" name="pass1" placeholder="비밀번호" required></input>
                    <span class="pw-lock"></span>
                    </span>

                    <h3>> 비밀번호 확인</h3>
                    <span class="signup-input">
                    <input id="pass2" type="password" name="pass2" placeholder="비밀번호 확인" onblur="checkPw()" required></input>
                    <span class="pww-lock"></span>
                    </span>

                </div>

                <div style="margin-top: 20px;">
                    <!--이름,-->
                    <h3>> 이름</h3>
                    <span class="signup-input">
                    <input id="signup-name" name="name" type="text" placeholder="이름을 입력하세요"required></input>
                </span>


                </div>

                <div style="margin-top: 20px;">
                    <!--휴대폰 번호-->
                    <h3>> 휴대폰 번호</h3>
                    <div style="display: flex;">
                        <span class="signup-input" style="width:100%; margin: 10px 0px 0px 0px">
                        <input id="signup-phone" name="phone" type="tel" maxlength="11" placeholder="(-없이)번호 입력  ex)01012345678"></input>
                    </span>
                    </div>
                </div>
                <div>
                    <!--회원가입 하기 : 회원가입 되면 메인으로 돌아가기-->
                    <div class="signup-btn-wrap">
                        <input type="submit" id="signupSubmit" value="회원가입">
                    </div>
                </div>
            </form>
        </section>

        <script>
            // 아이디 중복확인
           
           function idChecked() {
                var userid = $("#signup-id").val().trim();

                $.ajax({ 
        			type : "GET",
        			url : "<%=request.getContextPath()%>/member/checkId2",
        			data : {
        				userid
        			},
        			success : function (result) {
        				alert(result);
        			},
        			error : function (e) {
        				alert("실패");
        			},
        		});
                
            };

            //비밀번호 일치 확인
            function checkPw() {
                var pw1 = document.getElementById("pass1").value;
                var pw2 = document.getElementById("pass2").value;

                if (pw1 != pw2) {
                    alert("비밀번호가 일치하지 않습니다.");
                    pw2.focus();
                }
            }
        </script>
        </div>
</body>
</html>