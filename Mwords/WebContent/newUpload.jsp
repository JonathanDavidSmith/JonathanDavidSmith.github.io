<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" type="text/css" href="newUpload.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
                      <li><a href="deleteanimals.do">Delete ALL</a></li>
                      <li><a href="deletetechnology.do">Technology</a></li>
                      <li><a href="deletefood.do">Food</a></li> 
                      <li><a href="deleteholiday.do">Holiday</a></li>
                  </ul>        
                </li> 
            </ul>
        </nav>
	  </div>
	  <div class="headline">
			<h1>Welcome to Mwords where a picture is worth a thousand words!</h1>
	  		<p>psst... M is the Roman numeral for 1000.</p>
	  		<h2>Want to store an image? Use the box below!</h2>
				<form:form action="NewImage.do" modelAttribute="upload">
				<form:input path="url" />
				<form:errors path="url" />
				<input type="submit" value="Upload">
				</form:form>
	  </div>
</body>
</html>