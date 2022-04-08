<%@page import="com.ict.domain.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ict.domain.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   // 아래쪽에 원래 작성된 접속 로직 저장되어있음.
   UserDAO dao = new UserDAO(); // 생성과 동시에 Class.forName(디비타입)까지 호출
   List<UserVO> userList = dao.getAllUserList();// DB연결해 전체 목록 가져다 주고 종료.
   out.println("DAO에서 전달받은 자료들 : " + userList);
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
        <% for(UserVO user : userList){ %>
           <tr>
              <td><%= user.getUserId() %></td><!-- </td>슬래시로 꼭 닫을것 닫는 습관 들이기 -->
              <td><%= user.getUserPw() %></td>  
              <td><%= user.getUserName() %></td>  
              <td><%= user.getEmail() %></td>  
           </tr>
         <%} %>
     </tbody>
   </table>
</body>
</html>