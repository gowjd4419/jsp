<%@page import="kr.co.ict.domain.UserVO"%>
<%@page import="kr.co.ict.domain.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


     // 회원 수정페이지는
     // 비번, 이름, 이메일을 수정할 수 있는 페이지다.
     // 이름, 이메일은 이미 내가 가입할때 썼던 정보가 채워지게 해야함
     // 로그인 여부를 체크해서 로그인 안 한 사람은 메인으로 가게
     // 로그인 한 사람은 아래 "아이디"부분에 대신 실제아이디가 들어가게
      String sId = (String)session.getAttribute("s_id");

		if(sId == null){
			response.sendRedirect("userLoginForm.jsp");
		    }
		
	// sId 유저의 정보를 ResultSet에 받아온 다음
	// value="<%= rs.get~~~~()%"> 형식으로 입력하면
	// 해당 유저의 이름과 이메일을 사전에 미리 입력된 상태로 만들 수 있음
	// SELECT * FROM userinfo WHERE user_id=? 를 이용해서
	// 로그인한 유저의 정보를 ResultSet rs변수에 받아주기
	 UserDAO dao = new UserDAO();
	 UserVO user = dao.getUserInfo(sId);
     
			
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1> <%= sId %>님의 정보를 수정합니다.</h1>
   <form action="userUpdateCheck.jsp" method="post">
       <input type="hidden" name="fId" value="<%= sId %>"><br>
       비밀번호 : <input type="password" name="fPw"><br>
       이름 : <input type="text" name="fName" value="<%= user.getUserName()%>"><br>
       이메일 : <input type="email" name="fEmail" value="<%= user.getEmail()%>"><br>
       <input type="submit" value="수정하기">
       
   </form>
</body>
</html>


<%-- 

	    String dbType = "com.mysql.cj.jdbc.Driver";
		String connectUrl = "jdbc:mysql://localhost:3306/jdbcprac2?serverTimezone=UTC";
		String connectId = "root";
		String connectPw = "5613";
		
		ResultSet rs = null;
		
		try {
			
			Class.forName(dbType);
			Connection con = DriverManager.getConnection(connectUrl,connectId,connectPw);
			String sql = "SELECT * FROM userinfo WHERE user_id = ?";
         PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setString(1, sId);
         rs = pstmt.executeQuery();

		}catch(Exception e) {
			e.printStackTrace();
		}
		rs.next();// 0번인덱스 조회를 위해 한번 실행해줘야함.--%>