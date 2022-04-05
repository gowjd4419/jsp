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

   // 2. DB연동 후
        String dbType = "com.mysql.cj.jdbc.Driver";
		String connectUrl = "jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC";
		String connectId = "root";
		String connectPw = "5613";
		
		ResultSet rs = null; // SELECT구문에만 쓰임
		try {
			
			Class.forName(dbType);
			
			Connection con = DriverManager.getConnection(connectUrl,connectId,connectPw);
			String sql = "SELECT * FROM userinfo WHERE user_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
   // 3. 해당 아이디의 정보만 ResultSet에 받아와서
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
   // 4. body 내부에 XX 유저의 정보입니다 라는 문장과 함께 전체 정보나오게코딩
   // 5. 폼에서 전달한 아이디를 처리할 수 있도록 getUserInfoForm.jsp를 추가하기
   
   if(rs.next()){//user_id는 프라이머리 키가 걸려있기 때문에 한개 아니면 0개 이기때문에 if문 반복문을 쓸 이유가 없음
 %>
    <h1><%= rs.getString(1) %>유저의 정보입니다</h1>
    비번 : <%= rs.getString(2) %><br>
    이름 : <%= rs.getString(3) %><br>
    이메일 : <%= rs.getString(4) %><br>
   <% } else {%>
   <h3><%= userId %>계정은 존재하지 않습니다.</h3>
   <%} %>
    	 
</body>
</html>