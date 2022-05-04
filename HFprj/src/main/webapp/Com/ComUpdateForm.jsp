<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8181/HFprj/ComUpdate.do" method="post">
  <input type="hidden" name="commentID" value="${com.commentID }">
  <input type="hidden" name="postID" value="${com.postID }">
   작성자 : <input type="text" name="commentAuthor" value="${com.commentAuthor}" readonly><br>
   내용 : <textarea cols="30" rows="10" name="commentContent">${com.commentContent}</textarea><br>
      <!-- textarea는 value값이 안들어감 괄호 사이에 넣어주기 -->
   <input type="reset" value="초기화">
   <input type="submit" value="수정하기">
</body>
</html>