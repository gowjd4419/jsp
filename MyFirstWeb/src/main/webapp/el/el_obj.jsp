<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!-- 목적지가 el_obj_ok.jsp인 폼을 만들기
        이름(name)과 별명(nick)을 넘겨주기
        제출버튼을 눌러 넘어가게 하기 -->
        <form action = "el_obj_ok.jsp">
          <input type = "text" name="name"><br>
          <input type = "text" name="nick"><br>
          <input type = "submit" value = "제출">
        </form>
</body>
</html>