<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    // 이미 로그인한 사람이 로그인 페이지를 들어올 수도 없게 하기
    // 로그인한 사람이 들어오는 경우, session_login_ok.jsp로 보내주기
    
    String userId = (String)session.getAttribute("s_id");
    // ==의 반대 != (null이 아니라면~)
	 if(userId != null){
	 	response.sendRedirect("session_login_ok.jsp");
		    }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=http://localhost:8181/JSPBasic/jspobject/session/session_login_check.jsp>
   <input type = "text" name="id"><br>
   <input type = "password" name="pw"><br>
   <input type="submit" value="로그인">
</form>
</body>
</html>