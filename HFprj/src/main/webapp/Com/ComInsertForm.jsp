<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/HFprj/ComInsert.do" method="post">
   작성자 : <input type="text" name="commentAuthor"><br>
   내용 : <textarea cols="30" rows="15" name="commentContent"></textarea><br>
   <input type="hidden" name = "postID" value="${param.postID}">
   <input type="submit" value="글쓰기">
   <input type="reset" value="초기화">
</form>
</body>
</html>