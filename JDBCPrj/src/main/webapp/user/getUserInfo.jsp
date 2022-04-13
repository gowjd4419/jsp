<%@page import="com.ict.domain.UserVO"%>
<%@page import="com.ict.domain.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Driver"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   // 1. userId 라는 이름으로 전달되는 데이터를 받으면(request.get?????)
    
	String userId = request.getParameter("userId"); // 오른쪽에 있는 변수는 http변수 왼쪽은 자바 변수 둘은 다르다

   // - DAO생성(MySQL을 쓴다고 지정)
    UserDAO dao = UserDAO.getInstance();
   // - DAO 내부 메서드인 .getUserInfo(유저명) 호출
    UserVO user = dao.getUserInfo(userId);
   System.out.println("유저 정보 확인 : " + user);
   out.println(user + "<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 유저 정보 입력 -->
		 아이디 : <%= user.getUserId() %><br>
		 비밀번호 : <%= user.getUserPw() %><br>
		 이름 : <%= user.getUserName() %><br>
		 이메일 : <%= user.getEmail() %><br>

    	 
</body>
</html>

