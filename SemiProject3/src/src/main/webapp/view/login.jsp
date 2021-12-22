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
        }
        
        a {
            color: black;
            text-decoration: none;
        }
        
        .main {
            text-align: center;
            margin-top: 20px;
        }
        
        input {
            cursor: pointer
        }
        /* 로고설정*/
        
        .image {
            height: 32px;
            padding: 20px;
            margin-top: 30px;
            margin-bottom: 30px;
        }
        
        .login_gubun {
            margin-bottom: 20px;
        }
        /*input 아이디박스,  input 패스워드박스*/
        
        .login-id-wrap,
        .login-pw-wrap {
            margin: 10px 8px 10px;
            display: flex;
            padding: 10px;
            border: solid 3px #dadada;
            background: white;
            cursor: pointer;
            height: 30px;
            border-top-right-radius: 15px;
        }
        
        .login-pw-wrap {
            margin-bottom: 30px;
        }
        /*input 아이디 form*/
        /*input 패스워드 form*/
        
        #input-id,
        #input-pw {
            border: none;
            outline: none;
            width: 100%;
        }
        
        .login-id-wrap:hover,
        .login-pw-wrap:hover {
            border: solid 3px #3bb44a;
        }
        /*로그인버튼박스*/
        
        .login-btn-wrap,
        .enroll-btn-wrap {
            height: 52px;
            line-height: 55px;
            margin: 10px 8px 10px;
            border: solid 1px rgba(0, 0, 0, .1);
            background-color: #3bb44a;
            color: #fff;
            cursor: pointer;
            border-radius: 10px;
        }
        
        .enroll-btn-wrap {
            margin-top: 10px;
        }
        /*로그인버튼*/
        
        #login-btn,
        #enroll-btn {
            width: 100px;
            background-color: #3bb44a;
            border: none;
            color: #fff;
            font-size: 18px;
            outline: none;
            cursor: pointer;
        }
        /*가로 800px 이상일때*/
        
        @media(min-width: 800px) {
            .main {
                width: 460px;
                margin: auto;
            }
            /* 로고설정*/
            .image {
                margin-top: 40px;
                height: 44px;
                padding: 20px;
            }
        }
    </style>
</head>

<body>

    <div class="main">
        <!--웹페이지 상단-->
        <header>
            <!-- 로고 이미지-->
            <div class="logo">
                <a href="<%=request.getContextPath()%>" target="_blank" title="메인 홈페이지"><img src="<%=request.getContextPath()%>/view/resources/img/logo_last.png" style=" width: 135px;height: 80px;" class="image" alt="로고사진"></a>
            </div>
            <h1>로그인 </h1>
        </header>

        <!--로그인 부분-->
        <section class="login-wrap">
            <form id="loginForm" action="<%=request.getContextPath() %>/login" method="post">
                

                <div class="login-id-wrap">
                    <input id="input-id" name="userId" placeholder="이메일(아이디)를 입력하세요" type="text" required></input>
                </div>
                <div class="login-pw-wrap">
                    <input id="input-pw" name="userPwd" placeholder="비밀번호를 입력하세요" type="password" required></input>
                </div>
                <div class="login-btn-wrap">
                    <button type="submit" id="login-btn" >로그인</button>
                </div>
                
                <div class="enroll-btn-wrap">
                   <button type="button" id="enroll-btn" onclick="location.href='<%=request.getContextPath() %>/view/enroll.jsp'">회원가입</button>
                </div>
            </form>
        </section>
    </div>

</body>
</html>