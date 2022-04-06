<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // userLoginCheck.jsp에서 발급한 세션 저장
    String sId = (String)session.getAttribute("s_id");
    // 조회하고 null이면 userLoginForm.jsp로 보내고
    if(sId == null){
    	response.sendRedirect("userLoginForm.jsp");
	    }
   
    // 아이디가 존재하면 body태그 내에 XXX님 환영합니다
    
    // 라는 문장과 아래쪽에 userLogout.jsp로 가는 링크와 함께
    // "로그아웃" a태그 이용 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1><%= sId%>님 로그인을 환영합니다!</h1><br>
   <a href="userLogout.jsp">로그아웃</a><br>
   <a href="userDelete.jsp">회원탈퇴</a><br>
   <a href="userUpdateForm.jsp">정보수정</a><br>
</body>
</html>