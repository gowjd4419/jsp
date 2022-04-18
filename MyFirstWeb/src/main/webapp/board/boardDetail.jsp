<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>/boardDetail 임시 페이지</h1>
     <table border="1">
         <thead>
             <tr>
                <td>글번호</td>
                <td>글제목</td>
                <td>글쓴이</td>
                <td>쓴날짜</td>
                <td>수정날짜</td>
                <td>조회수</td>
             </tr>
         
         </thead>
          <tbody>
             <c:forEach var="board" items="${boardDetail }">
              <tr>
                 <td>${board.boardNum }</td>
                 <td>${board.title }</td>
                 <td>${board.writer }</td>
                 <td>${board.bdate }</td>
                 <td>${board.mdate }</td>
                 <td>${board.hit }</td>
              </tr>
              </c:forEach>
          </tbody>
     </table>

</body>
</html>