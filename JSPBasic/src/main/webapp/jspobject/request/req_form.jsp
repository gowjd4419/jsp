<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <!--  form태그는 action="목적지" method="전달방식"(get,post)를 기입해 데이터를 전달하는 태그이다.
      여닫는 부분 사이에 input 태그를 이용해 보낼 데이터 양식을 지정할 수 있다. -->
      <!-- http데이터들을 스크립트로 변환해줌 -->
      <form action="http://localhost:8181/JSPBasic/jspobject/request/req_param.jsp" method="post">
          <!-- input태그는 text(단순문자), password(비밀번호), submit(전송버튼)등을 많이 사용한다. -->
          사과 : <input type = "text" name="apple"><br><!-- name목적지 어떤이름으로 보낼것인가 -->
          바나나 : <input type = "text" name="banana"><br>
          망고 : <input type = "text" name="mango"><br>
          물 : <input type = "text" name="water"><br>
          pw : <input type = "password" name="pw"><br><!-- type을 password로 주면 실제 비번입력같이나옴 -->
          <input type="submit"> <!-- form이 더 사용하기 편함-->
      </form>
</body>
</html>
