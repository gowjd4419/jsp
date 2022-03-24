<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
         * 요청 파라미터
         
         - 클라이언트 측에서 서버로 데이터를 요청할 때 전달되는 변수를
         요청 파라미터라고 부른다
         
         - 요청 파라미터는 URL주소 뒤에 ?를 붙인 이후에 [파라미터변수명=값]을
         통해 서버로 데이터를 전달할 수 있다
         
         - 요청 파라미터를 여러개 전달할때는 두 번째부터 &를 붙여서 한다.
 --%>
 <%
     // post방식 전달시 한글 깨지는걸 방지(제일 윗줄에 위치해야함)
     request.setCharacterEncoding("utf-8");
     // 클라이언트의 전송 데이터를 받아오는 방법
     // 내장객체 request의 getParameter("변수명")을 사용
     String a = request.getParameter("apple");
     String b = request.getParameter("banana");
     String c = request.getParameter("mango");
     String d = request.getParameter("water");
     String pw = request.getParameter("pw");
     // 임의로 받아올 수 있는 request.getParameter("변수명")을 작성하고 c에 저장한후 body에서 출력해보기
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    apple로 전송된 데이터 : <%= a %><br>
    banana로 전송된 데이터 : <%= b %><br>
    mango로 전송된 데이터 : <%= c %><br>
    water로 전송된 데이터 : <%= d %><br>
    pw로 전송된 데이터 : <%= pw %><br>
    

</body>
</html>