<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
request.setCharacterEncoding("utf-8");

String uName = request.getParameter("uname");
String uId = request.getParameter("uid");
String uPw = request.getParameter("upw");

String[] hobby = request.getParameterValues("hobby");// 체크박스는 같은 명칭으로 데이터가 여럿 넘어오므로 배열처리해주면 여러개를 체크해도 그대로 나올수있게됨
String blood = request.getParameter("blood");// 여러개 선택하는것이 아닌 하나만 선택이되는것은 getParameter
String region = request.getParameter("region");
%>

이름 : <%= uName %><br>
아이디 : <%= uId %><br>
비밀번호 : <%= uPw %><br>
취미 : <%= Arrays.toString(hobby) %><br><%--배열의 경우 Arrays.toString(출력배열)로 나열할수있다. --%>
혈액형 : <%= blood %><br>
지역 : <%= region %><br>
</body>
</html>