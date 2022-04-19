<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- form만들기
form은 글쓴이, 글제목, 본문 정보를 전송한다.
목적지는 /boardInsert로 -->
<form action="http://localhost:8181/MyFirstWeb/boardInsert" method="post">
   글제목 : <input type="text" name="title" >
   글쓴이 : <input type="text" name="writer"><br>
   본문 : <textarea cols="50" rows="15" name="content"></textarea><br>
   <input type="submit" value="글쓰기">
   <input type="reset" value="초기화">
</form>

</body>
</html>