<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>myCloset</title>
    <link rel="stylesheet" href="/style/reset.css" />
    <link rel="stylesheet" href="/style/common.css" />
    <link rel="stylesheet" href="/style/today.css" />
    <link rel="stylesheet" href="/style/past.css" />
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
          <div class="section_title">
            <span>착장 기록</span>
            <select class="month_select">
              <option value="" selected disabled>월 선택</option>
              <option value="1">1월</option>
              <option value="2">2월</option>
              <option value="3">3월</option>
              <option value="4">4월</option>
              <option value="5">5월</option>
              <option value="6">6월</option>
              <option value="7">7월</option>
              <option value="8">8월</option>
              <option value="9">9월</option>
              <option value="10">10월</option>
              <option value="11">11월</option>
              <option value="12">12월</option>
            </select>
          </div>
          <div class="past_ootd_box">
            <ul class="past_ootd_list">
              <li class="introduce_text">원하시는 달을 선택해주세요.</li>
            </ul>
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
            <li><a href="/home" class="nav_item">HOME</a></li>
            <li>
              <a href="/clothes" class="nav_item">CLOTHES</a>
            </li>
            <li>
              <a href="/today" class="nav_item">TODAY</a>
            </li>
            <li><a href="/past" class="nav_item nav_active">PAST</a></li>
          </ul>
        </nav>
      </footer>
    </div>
  <script src="/js/past.js"></script>
  </body>
</html>
