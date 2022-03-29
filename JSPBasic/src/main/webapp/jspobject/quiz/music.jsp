<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action=http://localhost:8181/JSPBasic/jspobject/quiz/music_result.jsp >
    <table border="1">
    <thead>
        <th>가수명</th>
        <th>노래명</th>
        <th>선택하기</th>
    </thead>
    <tbody>
    <tr>
       <td>아이들</td>
       <td>Tomboy</td>
       <td><input type = "radio" name="music" value ="1번"><br></td>
    </tr>
    <tr>
       <td>태연</td>
       <td>INVU</td>
       <td><input type = "radio" name="music" value="2번"><br></td>
    </tr>
    <tr>
       <td>K/DA</td>
       <td>POP STARS</td>
       <td><input type = "radio" name="music" value="3번"><br></td>
    </tr>
    </tbody>
    </table>
    <input type="submit" value="노래 듣기"><br>
    
    </form>
</body>
</html>