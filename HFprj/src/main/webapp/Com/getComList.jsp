<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<style>

    body{
    font:15px/1.5 "굴림",Gulim;
    margin:10px;
    padding:50px;
    }
</style>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <table class="table table-bordered table-hover table-dark">
         <thead>
             <tr>
                <td>댓글번호</td>
                <td>글쓴이</td>
                <td>내용</td>
             </tr>
         </thead>
          <tbody>
             <c:forEach var="com" items="${ComList}">
              <tr>
                <td><a href="http://localhost:8181/HFprj/ComDetail?commentID=${com.commentID}">${com.commentID }</td>
                 <td>${com.getCommentAuthor()}</td>
                 <td>${com.getCommentContent()}</td>
              </tr>
              </c:forEach>
          </tbody>
     </table>
     <a href="http://localhost:8181/HFprj/Com/ComInsertForm.jsp"><button>댓글쓰기</button></a>
</body>
</html>