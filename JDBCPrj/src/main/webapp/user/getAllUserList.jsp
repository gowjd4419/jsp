<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 스크립트릿 내부에 전체 회원정보를 가져오도록 코드를 작성해서
    // ResultSet 변수에 저장까지 하기.
        String dbType = "com.mysql.cj.jdbc.Driver";
		String connectUrl = "jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC";
		String connectId = "root";
		String connectPw = "5613";
	// try블럭이 닫히는 순간, 내부에서 최초로 선언된 변수들도 다 사라짐
	// 그래서 body태그에 출력해야하는 필수요소는 try 진입 전 선언해놔야함
	ResultSet rs = null;
		
		
		try {
		
			Class.forName(dbType);
			
			Connection con = DriverManager.getConnection(connectUrl,connectId,connectPw);
		
			String sql = "SELECT * FROM userinfo";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace(); // 에러발생지 단계 알려주는 것
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1">
	<thead>
	<tr>
		<th>유저아이디</th>
		<th>유저비밀번호</th>
		<th>유저이름</th>
		<th>이메일</th>
		</tr>
	</thead>
	<tbody>
     <%-- ResultSet에 든 정보를 여기에 out.println()이나
     표현식<%= % >을 이용해 출력시도해보기--%>
     
    <% while(rs.next()){%>
        <tr>
    	 <td><%= rs.getString(1) %></td> 
    	 <td><%= rs.getString(2) %></td>
    	 <td><%= rs.getString(3) %></td>
    	 <td><%= rs.getString(4) %><br></td>
    	 </tr> <!-- 테이블 행 중요-->
     <%}%>
     </tbody>
   </table>
</body>
</html>