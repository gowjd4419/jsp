<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<link href="../css/custom2.css" rel="stylesheet">
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
        

        
        div.container{
        width:10000px; 
        background:#e9ecef;
        margin:10px;
        margin-left:55px;
        padding:10px;
        float:center;
        border-radius:10px 10px 10px 10px;
        }
        
        .box{
        padding:10px;
        border-radius:10px 10px 10px 10px;
        }
        
        .header{
        background:#f8f9fa;
        padding:10px;
        margin:10px;
        border-radius:10px 10px 10px 10px;
        }
        
        .author{
        padding:10px;
        margin:10px;
        border-radius:10px 10px 10px 10px;
        }
        
        .wrtier{
        padding:10px;
        margin:10px;
        background:#f8f9fa;
        border-radius:10px 10px 10px 10px;
        
        }
        .update{
        margin:10px;
        padding:10px;
        }
        
        .box{
        padding:10px;
        margin:10px;
        border-radius:10px 10px 10px 10px;
        }
        
        #textarea1{
        height:50vh;
        margin-right:40px;
        border-radius:10px 10px 10px 10px;
        }
   
   
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="grid">
			<form action="/HFprj/boardUpdate.do" method="post">	
			<br>	
					<div class="header">
					    <label for="postTitle" class="form-label" style="margin : 10px; ">레시피 제목</label>
		  				  <input type="text" name="postTitle" value="${board.postTitle}" style="margin : 10px;">
		  				<br/>
		  		
					     <div class="dropdown">
					     <label for="postType" class="form-label" style="margin : 10px; ">카테고리</label>
							<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" style="margin : 10px;">
							  종류
							</button>
  				            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							  <li><a class="dropdown-item active" id="dropdown1" href="#" onclick="setValue1()">다이어트</a></li>
							  <li><a class="dropdown-item active" id="dropdown2"href="#" onclick="setValue2()">간편식</a></li>
							  <li><a class="dropdown-item active" id="dropdown3"href="#" onclick="setValue3()">이유식</a></li>
							  <li><a class="dropdown-item active" id="dropdown4"href="#" onclick="setValue4()">건강식</a></li>
							  <li><a class="dropdown-item active" id="dropdown5"href="#" onclick="setValue5()">특별식</a></li>
							</ul>
						  </div>
						 <script>
						 function setValue1() { document.getElementById('buttonType').value = "1"; }
						 function setValue2() { document.getElementById('buttonType').value = "2"; }
						 function setValue3() { document.getElementById('buttonType').value = "3"; }
						 function setValue4() { document.getElementById('buttonType').value = "4"; }
						 function setValue5() { document.getElementById('buttonType').value = "5"; }
						 
						 function 
						 </script>
						 <form>
		  				  <input type="hidden" name="postType" id="buttonType" value="${board.postType}" style="margin : 10px;">
		  				 </form>
		  				<br/>
					  </div>
					</div><!-- grid끝 -->
					<div class="author">
		  				<label for="author" class="form-label" style="margin : 10px;">글쓴이</label>
		  				<input type="text" name="postAuthor" value="${board.postAuthor}" readonly style="margin : 10px;">
						<br/>
					</div>
				<div class="wrtier">
				 	<label for="textarea" class="form-label" style="margin : 10px;"> 요리 소개 </label>
					<textarea class="form-control" name="postContent" id="textarea1" rows="30">${board.postContent}</textarea>
					<br/>
				</div>
				<div class="box">
				  <input type="textarea" style="height:100px;">
				</div>
				<div class="update">
				 <input type="hidden" name="postID" value="${board.postID}">
				 <input type="submit" value="수정완료" class="btn btn-primary btn-dark">
			    </div>
			</form>
		</div>
	</div> <!-- container END -->
</body>
</html>