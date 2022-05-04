<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  반복해서 출력하려면 JSTL을 활용해야함 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 포워딩으로 먼저 넘어온 다음 리다이렉트를 이어서 실행하도록 해야
포워딩/리다이렉트 호출이 겹쳐서 에러가 나는걸 막을 수 있으므로
이 경우만 예외적으로 스크립트릿을 리다이렉트를 사용한다. -->
세션값 : ${sessionScope.s_id }<br>
<c:if test="${sessionScope.s_id eq null}">
   <!--<script>location.href="http://localhost:8181/MyFirstWeb/"</script> 스크립트릿이 아닌 자바스크립트 사용법 -->
   <%// response.sendRedirect("http://localhost:8181/MyFirstWeb/"); %> <!-- 스크립트릿 사용법 이 방법 추천 -->
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
           <!-- JSTL c:forEach와 ${boardList}를 활용하면 된다.
           전체 글 정보를 테이블 형식으로 -->
          <tbody>
             <c:forEach var="board" items="${boardList }">
              <tr>
                 <td>${board.boardNum }</td>
                 <td><a href="http://localhost:8181/MyFirstWeb/boardDetail.do?board_num=${board.boardNum}">${board.title }</td>
                 <td>${board.writer }</td>
                 <td>${board.bdate }</td>
                 <td>${board.mdate }</td>
                 <td>${board.hit }</td>
              </tr>
              </c:forEach>
          </tbody>
     </table>
      <c:if test="${sessionScope.s_id != null }">
         <a href="http://localhost:8181/MyFirstWeb/boardInsertForm.do"><button>글쓰기</button></a>
     </c:if>
</body>
</html>