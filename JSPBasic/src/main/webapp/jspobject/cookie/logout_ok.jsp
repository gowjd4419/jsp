<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   // 쿠키는 사용자 PC에 설치해두는것이기 때문에 명시적으로 삭제하는건 불가능함.
   // 대신 유효시간을 0으로 만들어 삭제하는것처럼 처리한다.
   // login_id 라는 이름의 쿠키가 여기서 발견이되면
   // 유효시간을 0으로 만든다음 cookie_login.jsp로 보내주는 로직을 작성하기
   Cookie[] cookies = request.getCookies();// 쿠키 목록 가져오기
   
   // login_id인 쿠키가 발견되면 해당 쿠키 유효기간 0초로 만들고 (*cookie.setMaxAge(유효초))
	 for(Cookie cookie : cookies){
		 String cookieName = cookie.getName();
	     if(cookieName.equals("login_id")){
	    	 cookie.setMaxAge(0); // 쿠키 유효기간을 0초로 만들고
	    	 response.addCookie(cookie); // 갱신 발급까지 꼭 마쳐줘야함
	     }
	 }
   // 리다이렉트로 로그인창으로 보내기. for문 밖에서 돌리는 이유는 바깥쪽에 위치를해야 login_id 쿠키가 없다해도 돌려보내야하기때문
   response.sendRedirect("http://localhost:8181/JSPBasic/jspobject/cookie/cookie_login.jsp");
   
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