<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "jstl_if.jsp">
<!-- jstl_if.jsp에서 c:set을 이용해 변수를 저장할 때 저장할 수 있는 요소를 하나 더 추가하기
name속성은 자율
jstl_if.jsp에서 해당 전송 데이터를 받아서 c:set으로 저장하고 해당 변수를 c:out으로 출력 -->
          이름 : <input type = "text" name="name"><br>
          <input type = "number" name="age"><br>
          <input type = "submit" value = "제출">
        </form>

</body>
</html>