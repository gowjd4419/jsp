<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8181/MyFirstWeb/boardUpdate" method="post">
   <input type="hidden" name="board_num" value="${board.boardNum }">
   글제목 : <input type="text" name="title" value="${board.title }">
   글쓴이 : <input type="text" name="writer" value="${board.writer}" readonly><br>
   본문 : <textarea cols="50" rows="15" name="content">${board.content}</textarea><br>
      <!-- textarea는 value값이 안들어감 괄호 사이에 넣어주기 -->
   <input type="reset" value="초기화">
   <input type="submit" value="수정하기">
</form>
</body>
</html>