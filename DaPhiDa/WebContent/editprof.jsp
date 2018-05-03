<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>StarCrossedDaPhiDa</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="WEB-INF/main.css">
</head>
<body>
	<jsp:include page="NavBar.jsp"></jsp:include>
    <div style="height: 54px;"></div>

    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
        <div class="col-md-12">
            <c:if test = "${profile == null}">
            	<h2> Error loading profile </h2> <br>
            </c:if>
        	<c:if test = "${profile != null}">
            	<h1> <c:out value="Editing ${profile.profileID}"/> </h1> <br>
            	
            	<form action="edit/submit" method="post">
					<div class="container">
						<label for="age"><b>Age</b></label>
					    <input type="number" value="${profile.age}" name="age" required>
						<br>
						<label for="datingAgeRangeStart"><b>datingAgeRangeStart</b></label>
					    <input type="number" value="${profile.datingAgeRangeStart}" name="datingAgeRangeStart" required>
						<br>
						<label for="datingAgeRangeEnd"><b>datingAgeRangeEnd</b></label>
					    <input type="number" value="${profile.datingAgeRangeEnd}" name="datingAgeRangeEnd" required>
						<br>
					    <label for="datingGeoRange"><b>datingGeoRange</b></label>
					    <input type="number" value="${profile.datingGeoRange}" name="datingGeoRange" required>
						<br>
					    <label for="m_f"><b>Gender</b></label>
					    <input type="text" value="${profile.m_f}" name="m_f" required>
						<br>
					    <label for="height"><b>height</b></label>
					    <input type="number" value="${profile.height}" name="height" required>
						<br>
					    <label for="weight"><b>weight</b></label>
					    <input type="number" value="${profile.weight}" name="weight" required>
						<br>
					    <label for="hairColor"><b>hairColor</b></label>
					    <input type="text" value="${profile.hairColor}" name="hairColor" required>
						<br>
					    <label for="hobbies"><b>hobbies</b></label>
					    <input type="text" value="${profile.hobbies}" name="hobbies" required>
						<br>
  						<input type="hidden" name="profileID" value="${profile.profileID}">
  						<br>
					    <button type="submit">Submit</button>
					</div>
				</form> 
            </c:if>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include>  
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
