<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 메세지가 나오는 오류는 혼자 해결하기
    // 몇행에서 몇번에서 에러가 났는지 확인하고
    // 근본 원인 에러 메세지를 복사해서 구글링
    
    // try~ catch 구문을 이용해서 int a = 3 / 0; 이 에러가 났을때
    // 브라우저 화면에 "에러가 발생했습니다."라는 문장이 띄워지게 코드 작성하기
    // 에러가 나지 않았다면 나눗셈의 결과를 body 태그 안에 출력되게 만들기
    
    try{
    	int a = 3 / 0;
    	out.println("나눗셈 결과 : " + a); // 에러가 안났다면 결과가 나오고
    }catch(Exception e){
    	out.println("에러가 발생했습니다."); // 에러가 나왔다면 에러 발생 뜸
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>