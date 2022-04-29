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
<table class = "table table-primary">

	<thead>
		<tr>
			<th>postID</th>
			<th>postAuthor</th>
			<th>postTitle</th>
			<th>postContent</th>
			<th>postTime</th>
			<th>postLastModified</th>
			<th>viewCount</th>
			<th>postType</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.postID}</td>
				<td>${board.postAuthor}</td>
				<td><a href="http://localhost:8181/HFprj/boardDetail?postID=${board.postID}"/>${board.postTitle}</td>
				<td>${board.postContent}</td>
				<td>${board.postTime}</td>
				<td>${board.postLastModified}</td>
				<td>${board.viewCount}</td>
				<td>${board.postType}</td>
			</tr>
		</c:forEach>
		</tbody>
</table>


</body>
</html>