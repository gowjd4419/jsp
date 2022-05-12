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

제목 : ${board.postTitle}
<br/>
postID : ${board.postID}
<br/>
타입 : ${board.postType }
<br/>
내용 : ${board.postContent}
<br/>
postAuthor : ${board.postAuthor}
<br/>
조회수 : ${board.viewCount}
<br/>
작성시간 : ${board.postTime}
<br/>
최근 수정 : ${board.postLastModified}
<br/>
<div class="mb-12">
		<br/>
		<label for="type" class="form-label">타입</label>
		<input type="text" name="postType" class="form-control" id="title" value="${board.postType}">
		<br/>
		<label for="textarea1" class="form-label"> 본 문 </label>
		<textarea class="form-control" name="postContent" id="textarea1" cols="40" rows="20" readonly>${board.postContent}</textarea>
		<br/>
		<br/>
		<a href="/HFprj/boardList.do" class="btn btn-success btn-mb-3">목록으로</a>
	<div>
		<form action= "/HFprj/boardDelete.do" method="post">
			<input type="hidden" name="postID" value="${board.postID}">
			<input type="submit" class="btn btn-danger btn-mb-3" value="삭제하기">
		</form>
	</div>
	<div>
		<form action= "/HFprj/boardUpdateForm.do" method="post">
			<input type="hidden" name="postID" value="${board.postID}">
			<input type="submit" class="btn btn-primary btn-mb-3" value="수정하기">
		</form>
	</div>
</div>


</body>
</html>