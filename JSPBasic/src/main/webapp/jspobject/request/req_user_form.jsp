<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 현재 파일인 req_user_form.jsp에 폼 태그를 만들기
     목적지는 함께 req_user.jsp파일이고 post방식으로 데이터를 전달
     먼저 이름, 아이디, 비밀번호를 입력해 보낼 수 있는 input태그를 만들기
     각 태그의 name 속성은 uname,uid,upw 이다.
     데이터를 받아주는 req_user.jsp에서 한글이 깨지지 않도록 받아서 화면에 출력 --%>
 <form action = http://localhost:8181/JSPBasic/jspobject/request/req_user.jsp method="post">
      이름 : <input type = "text" name="uname" placeholder="이름"><br>
      아이디 : <input type = "text" name="uid" placeholder="아이디"><br><!-- placeholder적용시 회색으로 뭘 입력해야하는지 나옴 -->
      비밀번호 : <input type = "password" name="upw"placeholder="비밀번호"><br>
      <hr>
      
      취미 :
      <%--input 태그 내부에 value 값을 이용해 선택되었을때 전달될 데이터를 정할 수 있습니다. --%>
      <input type = "checkbox" name="hobby" value="요리">요리 &nbsp; <!-- name="hobby"까지만 적으면 취미:on / null 로만 뜸 value값을 주어야함 -->
      <input type = "checkbox" name="hobby" value="운동">운동 &nbsp;
      <input type = "checkbox" name="hobby" value="닌텐도">닌텐도 &nbsp;
      <input type = "checkbox" name="hobby" value="컴퓨터게임">컴퓨터게임 &nbsp;
      <input type = "checkbox" name="hobby" value="음악감상">음악감상 &nbsp;
      <hr>
      혈액형 :
      <input type="radio" name="blood" value="A">A형 &nbsp;
      <input type="radio" name="blood" value="B">B형 &nbsp;
      <input type="radio" name="blood" value="O">O형 &nbsp;
      <input type="radio" name="blood" value="AB">AB형 &nbsp;
      <hr>
      지역 :
      <select name="region">
          <option value="서울">서울</option>
          <option value="경기">경기</option>
          <option value="강원">강원</option>
          <option value="충청">충청</option>
          <option value="전라">전라</option>
          <option value="경상">경상</option>
          <option value="제주">제주</option>
          
      </select>
      
      
      <br>
      <input type="submit" value="제출">
</body>
</html>