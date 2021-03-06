<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='main.js'></script>
    <link rel="stylesheet" href="stylesheet.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
</head>
<body>
    <div>
        <div class="container">
            <!-- #header -->
            <div id="headBarPrimary">
    
            </div>
            <div id="headPrimary">
                <h1>header</h1>
            </div>
        </div>

        <div style="display: flex; position: absolute; z-index: 2; top: 0; height: 100%;">
            <div class="collapse collapse-horizontal" id="collapseWidthExample">
              <div style="width: 200px; height: 100%; background-color: #ecf4ff;">
    
                <div class="row" id="sidebarElement" style="background-color:  #f0b968; padding-bottom: 20px; margin-right: 0;">
                    <br>
                    <button class="btn" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
                        <img src="logosvgwhite.svg" style="width: 95%; padding-top: 20px; padding-right: 10px; display: inline-block;">
                    </button>
                    <!-- note: make js function to stop page scroll when sidebar is open-->
                    <!--
                        <img src="logosvgwhite.svg" style="width: 60%; padding-top: 20px; display: inline-block;">
                    <br><br>
                    <button style="display: inline-block; width: 20%; margin-left: 40px; margin-top: 20px;" class="btn btn-outline-light" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
                        
                    </button> -->
                </div>
                <div class="row" id="sidebarElement" style="margin-top: 10px;">
                    <h4 style="color: #f0b968; font-weight: 1000;">Hungry & Full</h4>
                </div>
                <div class="row" id="sidebarElement">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                          <a class="nav-link active" href="#">Active</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link disabled" href="#">Disabled</a>
                        </li>
                      </ul>
                </div>
                <hr>
                <div class="row" id="sidebarElement" style="margin-right: 10px;">
                    <button type="button" class="btn btn-light">Homepage</button>
                </div>
              </div>
            </div>
          </div>
    
        <div class="container-fluid">
            <!-- #body -->
            <div id="bodyPrimary">
                <p>
                </p>
            </div>
            <div id="searchPrimary">
                <div class="row justify-content-center">
                    <h1>body</h1>
                    <div class="col-6 align-self-center rounded-pill" id="searchBar">
                        <form>
                            <!-- #submit is kb-enter -->
                            <div class="form-group">
                                <input type="text" class="form-control border-0"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div id="rankBox" class="row justify-content-center">
                <div id="rankContents" class="col-8 rounded-3">
                    <div id="rankTitle" class="row">
                        <h1>rankTitle</h1>
                    </div>
                    <div id="rankPost" class="row">
                        <h1>rankPost</h1>
                        <!-- #add forEach logic, 3 elements -->
                        <div id></div>
                    </div>
                </div>
            </div>
            <div id="postList">
    
            </div>
        </div>
    
        <div class="container" id="recipeBody">
            <div class="row justify-content-center">
                <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
                    Toggle width collapse
                </button>
                <div class="col-10">
                    <div class="recipeTitle">
                        <h1>recipeTitle</h1>
                    </div>
                    <div class="recipePost">
                        <h1>recipePost</h1>
                        <!-- #add forEach logic, 5 elements -->
                        <!-- limit is defined in service -->
						<c:forEach var="board" items="${boardList}">
                            <div class="row justify-content-center">
                            <div class="col rounded" id="recipeDetail">
								${board.postID}
								${board.postAuthor}
								<a href="/HFprj/recipeDetail.do?postID=${board.postID}"/>${board.postTitle}</a>
								${board.postContent}
								${board.postTime}
								${board.postLastModified}
								${board.viewCount}
								${board.postType}
                                <hr>
                            </div>
                            </div>
						</c:forEach>
                        <!-- #end of logic -->
                        <!-- #temporary elements -->
                        <!-- #end of temporary elements -->
                    </div>
                </div>
            </div>
        </div>
    
        <br>
        <br>
    
        <div class="container" id="pagination">
            <div class="row justify-content-center">
                <div class="col-6">
                    <hr>
                    <br>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                          <li class="page-item">
                            <a class="page-link" href="#" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>
                          <form>

                          </form>
                          <li class="page-item"><a class="page-link" href="#">1</a></li>
                          <li class="page-item"><a class="page-link" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item"><a class="page-link" href="#">4</a></li>
                          <li class="page-item"><a class="page-link" href="#">5</a></li>
                          <li class="page-item">
                            <a class="page-link" href="#" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                            </a>
                          </li>
                        </ul>
                      </nav>
                </div>
            </div>
        </div>
    
        <div class="container">
            <!-- #footer -->
            <div id="footerPrimary">
                <div class="row">
                    <div>
                        <img id="logoWhite" src="logosvgwhite.svg">
                    </div>
                    <div id="linkTableA">
    
                    </div>
                    <div id="linkTableB">
            
                    </div>
                </div>
                <div class="row">
                    <div id="footerInfo" class="">
                        <span>A Web Project by ** | Repository: </span><a href="https://github.com/gonkmetrics/hungryFull">gonkmetrics/hungryFull</a>
                        <br><span>Copyright ??HungryAndFull | All Rights Reserved</span>
                    </div>
                </div>
    
            </div>
        </div>
    </div>
</body>
</html>