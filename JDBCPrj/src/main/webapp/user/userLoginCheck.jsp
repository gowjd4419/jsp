<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
     // userLoginForm.jsp에서 보내온 아이디 비번 받기
     String formId = request.getParameter("formId");
     String formPw = request.getParameter("formPw");
     
     // 추후 DB에서 꺼낸 아이디와 패스워드를 저장할 변수
     String dbId = null;
     String dbPw = null;
     
     // DB와 연동해서 formId에 해당하는 유저 전체 정보를 받아주고
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
            pstmt.setString(1, formId);
            
			rs = pstmt.executeQuery(); // formId에 해당하는 계정정보(아이디, 패스워드,이메일,이름)
		}catch(Exception e) {
			e.printStackTrace();
		}
     // DB에 들어있던 id와 formId를 비교하고, DB에 들어있던 pw와 formPw를 비교해 구문짜기
     
     // rs에 들어있던 정보(아이디, 비번, 이메일 , 이름)를 화면에 출력
     // out.println(); 이용
     if(rs.next()){
    	//dbId = rs.getString(1); 아이디는 DB데이터 조회 시점에 이미 유무 판단이 끝나 필요없음
    	dbPw = rs.getString(2);
    	 // id가 존재한다면 pw일치여부를 확인
    	if(formPw.equals(dbPw)){// form에 적은 비밀번호가 DB비밀번호와 일치하는지 말그대로 순서임
    		session.setAttribute("s_id", formId);
    		response.sendRedirect("loginWelcome.jsp");
    	}else{
    		response.sendRedirect("userPwFail.jsp");
    	}
     }else{
    	 // rs.next()가 false라는것은 DB에 해당 아이디가 존재하지 않는것이므로 아이디 없음 페이지
    	 response.sendRedirect("userIdFail.jsp");
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