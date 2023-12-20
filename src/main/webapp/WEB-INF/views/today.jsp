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
          <div class="section_title">오늘의 착장</div>
          <form class="ootd_form">
            <div class="input_box">
              <label for="input_top">상의</label>
              <select name="topIdx" id="input_top" required>
                <c:choose>
                  <c:when test="${empty cloth_top}">
                    <option value="" disabled selected>저장되어 있는 상의가 없습니다.</option>
                  </c:when>
                  <c:otherwise>
                    <option value="" disabled selected>상의를 선택해주세요.</option>
                    <c:forEach var="cloth_top_item" items="${cloth_top}">
                      <option value="${cloth_top_item.idx}">${cloth_top_item.clothName}</option>
                    </c:forEach>
                  </c:otherwise>
                </c:choose>
              </select>
            </div>
            <div class="input_box">
              <label for="input_bottom">하의</label>
              <select name="bottomIdx" id="input_bottom" required>
                <c:choose>
                  <c:when test="${empty cloth_bottom}">
                    <option value="" disabled selected>저장되어 있는 하의가 없습니다.</option>
                  </c:when>
                  <c:otherwise>
                    <option value="" disabled selected>하의를 선택해주세요.</option>
                    <c:forEach var="cloth_bottom_item" items="${cloth_bottom}">
                      <option value="${cloth_bottom_item.idx}">${cloth_bottom_item.clothName}</option>
                    </c:forEach>
                  </c:otherwise>
                </c:choose>
              </select>
            </div>
            <div class="input_box">
              <label for="input_outer">아우터</label>
              <select name="outerIdx" id="input_outer">
                <c:choose>
                  <c:when test="${empty cloth_outer}">
                    <option value="" disabled selected>저장되어 있는 외투가 없습니다.</option>
                  </c:when>
                  <c:otherwise>
                    <option value="" disabled selected>(선택) 외투를 선택해주세요.</option>
                    <c:forEach var="cloth_outer_item" items="${cloth_outer}">
                      <option value="${cloth_outer_item.idx}">${cloth_outer_item.clothName}</option>
                    </c:forEach>
                  </c:otherwise>
                </c:choose>
              </select>
            </div>
            <div class="input_box">
              <label for="input_feedback">피드백</label>
              <input type="text" name="pastFeedback" id="input_feedback" placeholder="피드백을 작성해주세요." required/>
            </div>
            <input type="text" name="pastLowTemp" class="dsnone" />
            <input type="text" name="pastHighTemp" class="dsnone" />
            <button type="button" class="btn_ootdAdd">오늘의 착장 등록</button>
          </form>
        </div>
      </div>
      <footer class="footer">
        <div class="today_temp_info_box">
          <div class="low_temp">최저 기온: <span class="low_temp_text">${cookie.pmeTwoLevas.value}</span>°C</div>
          <div class="high_temp">최고 기온: <span class="high_temp_text">${cookie.pmeThgiHevas.value}</span>°C</div>
        </div>
        <nav class="nav_box">
          <ul class="nav_list">
            <li><a href="/home" class="nav_item">HOME</a></li>
            <li>
              <a href="/clothes" class="nav_item">CLOTHES</a>
            </li>
            <li>
              <a href="/today" class="nav_item nav_active">TODAY</a>
            </li>
            <li><a href="/past" class="nav_item">PAST</a></li>
          </ul>
        </nav>
      </footer>
    </div>
  <script src="/js/today.js"></script>
  </body>
</html>
