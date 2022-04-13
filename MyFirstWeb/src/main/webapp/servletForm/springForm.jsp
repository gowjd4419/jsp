<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- http://localhost:8181/MyFirstWeb/spring 을 목적지로 하는 폼 만들기
         jsp, boot라는 이름으로 submit을 하는 폼 생성 -->
         
         <form action ="http://localhost:8181/MyFirstWeb/spring">
           <input type="text" name="jsp"><br>
           <input type="text" name="boot"><br>
           <input type="submit" value="제출하기">
         </form>
</body>
</html>