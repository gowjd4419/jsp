<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
  List<String> party = new ArrayList<>(); 
%>
<%
   String[] jobs = {"전사","도적","사냥꾼","마법사","사제"};
   int r = (int)(Math.random() * jobs.length);// 정수로 돌려놓은다음에 r에 저장
   String job = jobs[r];// 새로고침할때마다 job이라는 변수에 저장될것이다
   
   party.add(job);
   
   // 파티에 같은 직업이 몇 명있는지 찾는 작업.
   int cnt = 0; 
   for(String player: party){
	   if(job.equals(player)){ // 비교연산자 쓰면 안됨
		   cnt += 1;
	   }
   }
%>
<h2>당신의 역할</h2>
<p>
	당신에게 부여된 역할은 <b>[<%= job %>]</b>입니다.<br>
	현재 파티에 당신과 같은 역할을 가진 플레이어는 <%= cnt %>명입니다.<br>
</p>
<p>
	현재 파티 구성<br>
	<%= party %>(<%= party.size() %>명 참가중)
</p>
<%
   if(party.size() == 10){
	   party.clear();
   }
%>


</body>
</html>