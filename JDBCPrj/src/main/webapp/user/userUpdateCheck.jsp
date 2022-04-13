<%@page import="com.ict.domain.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%      // 한글깨짐 방지는 항상 가장 위쪽에 해야함
        request.setCharacterEncoding("utf-8");
		String fId = request.getParameter("fId");
		String fPw = request.getParameter("fPw");
		String fName = request.getParameter("fName");
		String fEmail = request.getParameter("fEmail");
		
		UserDAO dao = UserDAO.getInstance();
		dao.userUpdateCheck(fId, fPw, fName, fEmail);
		response.sendRedirect("userLoginForm.jsp");
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>