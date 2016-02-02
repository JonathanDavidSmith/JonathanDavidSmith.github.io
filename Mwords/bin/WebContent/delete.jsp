<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="imageResults.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Images</title>
</head>

<body>
<div id="container">
        <nav>
             <ul>
                <li><a href="http://localhost:8080/mwords/index.html">Home</a></li>
                <li><a href="#">Images</a>
                  <ul>
                      <li><a href="animals.do">Animals</a></li>
                      <li><a href="technology.do">Technology</a></li>
                      <li><a href="food.do">Food</a></li>
                      <li><a href="holiday.do">Holiday</a></li>
                  </ul>
                </li>
                <li><a href="NewImage.do">Upload</a></li>
                <li><a href="#">Delete</a>
                <!-- First Tier Drop Down -->
                  <ul>
                      <li><a href="deleteanimals.do">Animals</a></li>
                      <li><a href="deletetechnology.do">Technology</a></li>
                      <li><a href="deletefood.do">Food</a></li>
                      <li><a href="deleteholiday.do">Holiday</a></li>
                  </ul>        
                </li> 
            </ul>
        </nav>
    </div>
    
	<div class="output">
	<c:choose>
		<c:when test="${! empty image}">
			<c:forEach var="photo" items="${image}"> 	
			<a href="deleteImage.do?photoLink=${photo.url}"><img id="photo" src="${photo.url}"/> </a>
			</c:forEach>
		</c:when>
		<c:when test="${empty image}">	
		<p>Your image(s) have been deleted.</p>
		<a href="index.html">Home</a>	
		<p> All your stuff is GONE! </p> 	
		</c:when>
		
		<c:otherwise>
		<p>Your image(s) have been deleted.</p>
		<a href="index.html">Home</a>
	</c:otherwise>
	</c:choose>
	</div>
</body>
</html>