<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String Photo = request.getParameter("photo");

%>


<%= Photo %> 그림을 골랐습니다.<br>
<%
  if(Photo.equals("1번")){
	  out.println("1번 그림을 선택하셨네요!");
  }else{
	  out.println("2번 그림을 선택하셨네요!");
  }
%>

</body>
</html>