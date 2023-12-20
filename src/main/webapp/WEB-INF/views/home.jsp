<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>myCloset</title>
    <link
      rel="stylesheet"
      href="https://unpkg.com/swiper/swiper-bundle.min.css"
    />
    <link rel="stylesheet" href="/style/reset.css" />
    <link rel="stylesheet" href="/style/common.css" />
    <link rel="stylesheet" href="/style/home.css" />
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
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
          <div class="section_title">과거의 나</div>
          <div class="swiper mySwiper">
            <div class="swiper-wrapper">
            </div>
          </div>
        </div>
      </div>
      <footer class="footer">
        <div class="today_temp_info_box">
          <div class="low_temp">최저 기온: ${cookie.pmeTwoLevas.value}°C</div>
          <div class="high_temp">최고 기온: ${cookie.pmeThgiHevas.value}°C</div>
        </div>
        <nav class="nav_box">
          <ul class="nav_list">
            <li><a href="/home" class="nav_item nav_active">HOME</a></li>
            <li><a href="/clothes" class="nav_item">CLOTHES</a></li>
            <li><a href="/today" class="nav_item">TODAY</a></li>
            <li><a href="/past" class="nav_item">PAST</a></li>
          </ul>
        </nav>
      </footer>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="/js/home.js"></script>
  </body>
</html>
