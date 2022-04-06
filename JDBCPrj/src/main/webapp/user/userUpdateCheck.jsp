<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%      // 한글깨짐 방지는 항상 가장 위쪽에 해야함
        request.setCharacterEncoding("utf-8");
		String formId = request.getParameter("fId");
		String formPw = request.getParameter("fPw");
		String formName = request.getParameter("fName");
		String formEmail = request.getParameter("fEmail");
		
		
		String dbType = "com.mysql.cj.jdbc.Driver";
			String connectUrl = "jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC";
			String connectId = "root";
			String connectPw = "5613";
			
			ResultSet rs = null;
			try {
				
				Class.forName(dbType);
				
				Connection con = DriverManager.getConnection(connectUrl,connectId,connectPw);
				String sql = "UPDATE userinfo SET user_pw=?, user_name=?, email=? WHERE user_id=?";
		    PreparedStatement pstmt = con.prepareStatement(sql);
		    pstmt.setString(4, formId);
		    pstmt.setString(1, formPw);
		    pstmt.setString(3, formEmail);
		    pstmt.setString(2, formName);
		    pstmt.executeUpdate();
		    
				rs = pstmt.executeQuery(); 
			}catch(Exception e) {
				e.printStackTrace();
			}
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