<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- post방식으로 /spring주소로 보내는 폼을 생성하기 -->
    <form action ="http://localhost:8181/MyFirstWeb/spring" method="post">
           <input type="text" name="jsp"><br>
           <input type="text" name="boot"><br>
           <input type="text" name="jpa"><br>
           <input type="submit" value="제출하기">
    </form>

</body>
</html>