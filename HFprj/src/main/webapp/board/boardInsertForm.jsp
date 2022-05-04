<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/HFprj/boardInsert.do" method="post">
	postTitle : <input type="text" name="postTitle" placeholder="제목을 적어주세요."><br/>
	postContent : <textarea name="postContent" placeholder="내용을 적어주세요."></textarea><br/>
	postType : <input type="text" name="postType" placeholder="현재 구현되는 0만 적어주세요"><br/>
	postAuthor : <input type="text" name="postAuthor" placeholder="현재 구현되는 1만 쓸 것"><br/>
	<input type="submit" value="확인" class="btn btn-success btn-mb-3">
</form>

</body>
</html>