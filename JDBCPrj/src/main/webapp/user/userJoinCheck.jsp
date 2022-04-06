<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
     // 한글 깨짐 방지
     request.setCharacterEncoding("utf-8");
	 String formId = request.getParameter("fId");
	 String formPw = request.getParameter("fPw");
	 String formName = request.getParameter("fName");
	 String formEmail = request.getParameter("fEmail");
	 
	 // 회원가입을 처리하는 로직
	 // 쿼리문은 INSERT INTO userinfo VALUES
	 //                   (아이디, 비번, 이름,이메일);


	 String dbType = "com.mysql.cj.jdbc.Driver";
		String connectUrl = "jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC";
		String connectId = "root";
		String connectPw = "5613";
		
		ResultSet rs = null;
		try {
			
			Class.forName(dbType);
			
			Connection con = DriverManager.getConnection(connectUrl,connectId,connectPw);
			String sql = "INSERT INTO userinfo VALUES (?, ?, ?, ?)";
         PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setString(1, formId);
         pstmt.setString(2, formPw);
         pstmt.setString(3, formName);
         pstmt.setString(4, formEmail);
         pstmt.executeUpdate();
         
			rs = pstmt.executeQuery(); // formId에 해당하는 계정정보(아이디, 패스워드,이메일,이름)
		}catch(Exception e) {
			e.printStackTrace();
		}
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