<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- TIP: ctrl + space + T 누르면 전에 실수로끄던 탭 창 다시 살릴수있음 -->
<%
String Music = request.getParameter("music");

if(Music.equals("1번")){
	response.sendRedirect("https://www.youtube.com/watch?v=y6kacqPOZ7E");
}else if(Music.equals("2번")){
	response.sendRedirect("https://www.youtube.com/watch?v=AbZH7XWDW_k");
}else if(Music.equals("3번")){
	response.sendRedirect("https://www.youtube.com/watch?v=UOxkGD8qRB4");
}

%>

</body>
</html>