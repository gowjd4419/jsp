<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
       request.setCharacterEncoding("utf-8");
       String userId = request.getParameter("id");
       String userPw = request.getParameter("pw");
       
       System.out.println("유저의 아이디 : " + userId);
       System.out.println("유저의 비밀번호 : " + userPw);
       
       // 세션 로그인처리를 해보기
       // 세션 로그인처리는 쿠키 로그인 처리와는 달리 모든 세션목록을 반복문으로 뒤질 필요가 없어서 효율적임
       // 아이디 : "abc1234", 비밀번호 : "1111"
       // 위 고정 문자열을 아이디, 비밀번호로 사용하여
       
       // 아이디가 있는 경우와 없는경우
       if(userId.equals("abc1234")){
    	   // 비밀번호가 맞는경우와 틀린경우
    	   // 를 나눠서 성공시 세션을 발급하고
    	   if(userPw.equals("1111")){
    		   // 세션 발급 후 session_login_ok.jsp로 보내주기
    		   // 세션값은 "s_id"
    		   session.setAttribute("s_id",userId);
    		   response.sendRedirect("session_login_ok.jsp");// 이렇게만해줘도 이동함 같은 폴더 내부에있을경우에만
    	   }else{
    		   // session_pw_fail.jsp로 보내주기
    		   response.sendRedirect("session_pw_fail.jsp");
    	   }
       }else{
    	   // session_id_fail.jsp로 보내주기
    	   response.sendRedirect("session_id_fail.jsp");
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