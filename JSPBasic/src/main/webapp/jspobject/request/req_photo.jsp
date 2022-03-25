<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%--아래에 폼을 만들기 
    목적지는 req_photo_result.jsp
    테이블을 이용해 사진 제목, 라디오로 만들고
    아래에 제출 버튼은 "그림 보러 가기" 로 적고
    해당 버튼을 눌렀을때 req_photo_result에 어떤 그림을 선택했는지
    체크박스로 구분하고 구분한 그림에 맞는 사진이 결과페이지에 나오도록
    if~else문을 구성해보기
    그림파일은 <img src="파일명(01.pang나 02.pang)">을 이용해 출력가능 
    --%>
    <!-- 1. 1번 그림을 선택했는지 2번 그림을 선택했는지 확인만 할 수 있도록 체크박스를 만들고 결과페이지에 나오게한다.
         2. if~else문을 이용해서 1번을 골랐다면 1번 그림을 골랐습니다. 2번을 골랐다면 2번 그림을 골랐습니다 라고 나오게 한다.
         3. img태그를 이용해 글 대신 그림이 나오게 처리한다. -->
    <form action=http://localhost:8181/JSPBasic/jspobject/request/req_photo_result.jsp >
    <input type = "radio" name="photo" value ="1번">1번<br>
    <input type = "radio" name="photo" value="2번">2번<br>
    <input type="submit" value="그림 보러 가기"><br>
    </form>
</body>
</html>