<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    세션값 : ${sessionScope.s_id }<br>
<c:if test="${sessionScope.s_id eq null}">
      <% response.sendRedirect("http://localhost:8181/MyFirstWeb/"); %>
</c:if>
   
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
<form action="http://localhost:8181/MyFirstWeb/boardInsert.do" method="post">
   글제목 : <input type="text" name="title" >
   글쓴이 : <input type="text" name="writer" value="${sessionScope.s_id }" readonly><br>
   본문 : <textarea cols="50" rows="15" name="content"></textarea><br>
   <input type="submit" value="글쓰기">
   <input type="reset" value="초기화">
</form>

</body>
</html>