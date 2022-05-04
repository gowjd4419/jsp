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
<div class="container-lg">
		<div class="col-sm-12">
			<form action="/HFprj/boardUpdate.do" method="post">		
					<div class="col-sm-9">
						<br/>
						<br/>
		  				<label for="title" class="form-label">제목</label>
		  				<input type="text" name="postTitle" class="form-control" id="title" value="${board.postTitle}">
		  				<br/>
		  				<label for="type" class="form-label">타입</label>
		  				<input type="text" name="postType" class="form-control" id="title" value="${board.postType}">
		  				<br/>
					</div>
					<div class="col-sm-3">
		  				<label for="author" class="form-label">글쓴이</label>
		  				<input type="text" name="postAuthor" class="form-control" id="author" value="${board.postAuthor}" readonly>
						<br/>
					</div>
				<div class="mb-12">
				 	<label for="textarea" class="form-label"> 본 문 </label>
					<textarea class="form-control" name="postContent" id="textarea" cols="40" rows="20">${board.postContent}</textarea>
					<br/>
				</div>
				<br/>
				<input type="hidden" name="postID" value="${board.postID}">
				<input type="submit" value="수정완료" class="btn btn-primary btn-mb-3">
			</form>
		</div>
	</div> <!-- container END -->
</body>
</html>