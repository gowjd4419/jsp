<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
   * 사용자의 입력값을 서버로 전송하는 방법.
   1. 사용자의 입력값을 서버로 전송하려면 form 태그를 사용한다.
   2. form태그에 action 속성에 데이터를 전송할 목적 페이지의 URL주소를 적는다.(현재는 #으로 두기)
   3. input태그에 name속성으로 보내는 이름을 전달하는데, BMI지수를 구하는 페이지를 만들 것이므로
      cm, kg이라는 두 개의 이름을 지정해서 input태그를 form 내부에 작성하면 된다.
   4. submit버튼도 만들어 주기
 --%>
 <form action = http://localhost:8181/JSPBasic/jspobject/request/req_bmi.jsp> <!-- #으로 두면 자신이 보낸 데이터를 그대로 다시 받음 -->
      키 : <input type = "number" name="cm">cm<br>
      체중 : <input type = "number" name="kg">kg<br>
      <input type="submit" value="확인">
  </form>
</body>
</html>