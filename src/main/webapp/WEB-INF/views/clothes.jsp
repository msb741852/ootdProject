<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>myCloset</title>
    <link rel="stylesheet" href="/style/reset.css" />
    <link rel="stylesheet" href="/style/common.css" />
    <link rel="stylesheet" href="/style/clothes.css" />
    <script
      src="https://kit.fontawesome.com/57b67e461c.js"
      crossorigin="anonymous"
    ></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  </head>
  <body>
    <div id="wrap">
      <header class="header">
        <div class="logo_box">
          <a href="/home">오늘 뭐 입지?</a>
        </div>
        <div class="logout_box" onclick="location.href='/logout'">LOGOUT</div>
      </header>
      <div class="container">
        <div class="container_content">
          <div class="section_title">${sessionScope.omemonicktnadme}님의 옷장</div>
          <div class="tab_menu_box">
            <input type="radio" name="clothes" id="clothes_top" checked>
            <label for="clothes_top" class="tab_btn tab_btn_active">상의</label>
            <input type="radio" name="clothes" id="clothes_bottom">
            <label for="clothes_bottom" class="tab_btn">하의</label>
            <input type="radio" name="clothes" id="clothes_outer">
            <label for="clothes_outer" class="tab_btn">아우터</label>
          </div>
          <div class="clothes_list_box">
            <ul class="clothes_list">
            </ul>
          </div>
          <div class="btn_clothesAdd">+ 추가하기</div>
        </div>
      </div>
      <footer class="footer">
        <div class="today_temp_info_box">
          <div class="low_temp">최저 기온: ${cookie.pmeTwoLevas.value}°C</div>
          <div class="high_temp">최고 기온: ${cookie.pmeThgiHevas.value}°C</div>
        </div>
        <nav class="nav_box">
          <ul class="nav_list">
            <li><a href="/home" class="nav_item">HOME</a></li>
            <li>
              <a href="/clothes" class="nav_item nav_active">CLOTHES</a>
            </li>
            <li><a href="/today" class="nav_item">TODAY</a></li>
            <li><a href="/past" class="nav_item">PAST</a></li>
          </ul>
        </nav>
      </footer>
    </div>
  <script src="/js/clothes.js"></script>
  </body>
</html>
