<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

   // 로그인 안한사람이 loginWelcom.jsp 주소를 직접 쳐서 들어갈수 있는 것을 방지하는 구문
	String userId = (String)session.getAttribute("s_id");
	
	 if(userId != null){ // 한줄 이면 {}빼도됨
	 	response.sendRedirect("loginWelcome.jsp");
		    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "userLoginCheck.jsp" method="post">
      아이디 : <input type = "text" name="formId"><br>
      비밀번호 : <input type = "password" name="formPw"><br>
      <input type="submit" value="로그인"><br>
      <a href="userJoinForm.jsp">회원가입하기</a>
  </form>
</body>
</html>