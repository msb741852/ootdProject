<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>myCloset</title>
    <link rel="stylesheet" href="/style/reset.css" />
    <link rel="stylesheet" href="/style/common.css" />
    <link rel="stylesheet" href="/style/login.css" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  </head>
  <body>
    <div id="wrap">
      <div class="container">
        <div class="logo_box">
          <div class="logo_box">오늘 뭐 입지?</div>
        </div>
        <div class="login_box">
          <div class="box_title">
            <span class="title">LOGIN</span>
            <c:if test="${not empty msg_fail}">
              <span class="msg_fail">${msg_fail}</span>
            </c:if>
          </div>
          <form action="/login" method="post" class="login_form">
            <input type="text" placeholder="ID" name="memberId" class="input_id" value="admin" required/>
            <input type="password" placeholder="PW" name="memberPw" class="input_pw" value="123123" required/>
            <div class="btn_box">
              <button
                type="button"
                class="btn_register btn_style1"
                onclick="location.href='/register/view'"
              >
                회원가입
              </button>
              <button type="submit" class="btn_login btn_style1">로그인</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
