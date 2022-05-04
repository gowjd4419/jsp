<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${board.boardNum }번 글 조회중입니다.</h1><br>
제목 : <input type="text" value="${board.title }">조회수 : ${board.hit }<br>
본문 : <textarea cols="40" rows="10">${board.content }</textarea><br>
글쓴이 : <input type="text" value="${board.writer }"><br>
쓴날짜 : ${board.bdate }
마지막 수정날짜 : ${board.mdate }
<hr>
<a href="http://localhost:8181/MyFirstWeb/boardList.do"><button>목록</button></a>
	 <c:if test="${sessionScope.s_id eq board.writer }">
		<!-- 삭제번호를 서블릿 boardDelete로 보내야함 -->
		<form action="http://localhost:8181/MyFirstWeb/boardDelete.do" method="post">
		  <!-- 삭제용 글 번호는 노출시킬 필요가 없으므로 hidden타입으로 숨겨서 보냄 -->
		  <input type="hidden" name="num" value="${board.boardNum}">
		  <input type="hidden" name="board_writer" value="${board.writer }">
		  <input type="submit" value="삭제" ><br>
		</form>
		<form action="http://localhost:8181/MyFirstWeb/boardUpdateForm.do" method="post">
		   <input type="hidden" name="board_num" value="${board.boardNum }">
		   <input type="submit" value="수정">
		</form>
	 </c:if>
</body>
</html>