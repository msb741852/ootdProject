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
      <div class="btn_back" onclick="location.href='/'">< back</div>
      <div class="container">
        <div class="logo_box">오늘 뭐 입지?</div>
        <div class="register_box">
          <div class="box_title">REGISTER</div>
          <form action="/register/add" method="post" class="login_form">
            <c:if test="${not empty fail_msg}">
              <span class="msg_fail">${fail_msg}</span>
            </c:if>
            <input type="text" placeholder="ID - 4~12자, 영문(+숫자)" name="memberId" minlength="4" maxlength="12" required autofocus/>
            <input type="password" class="password" placeholder="PW - 8~16자, 영문+숫자" name="memberPw" minlength="8" maxlength="16" required  />
            <input type="password" class="password_chk" placeholder="PW-CHECK" minlength="8" maxlength="16" required  />
            <c:choose>
              <c:when test="${not empty nickname}">
                <input type="text" placeholder="NICKNAME" name="memberNickname" value="${nickname}" minlength="2" maxlength="16" required />
              </c:when>
              <c:otherwise>
                <input type="text" placeholder="NICKNAME - 2~16자, 영문/숫자/한글 " name="memberNickname" minlength="2" maxlength="16" required />
              </c:otherwise>
            </c:choose>
              <button type="submit"
                class="btn_register btn_style1"
              >
                가입하기
              </button>
          </form>
        </div>
      </div>
    </div>
  <script src="/js/register.js"></script>
  </body>
</html>
