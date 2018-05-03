<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- when the user wants to view his own profile from a public perspective -->
<head>
    <title>StarCrossedDaPhiDa</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="WEB-INF/main.css">
</head>
<body>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
        <div class="col-md-12">
        	<c:if test = "${profile == null}">
            	<h2> Error loading profile </h2> <br>
            </c:if>
        	<c:if test = "${profile != null}">
            	<h1> <c:out value="${profile.profileID}"/> </h1> <br>
            	
          		<table border = "5" style="width:100%">
          			<tr>
          				<th>age</th>
          				<td><c:out value = "${profile.age}"/></td>
          			</tr>
          			<tr>
          				<th>datingAgeRangeStart</th>
          				<td><c:out value = "${profile.datingAgeRangeStart}"/></td>
          			</tr>
          			<tr>
          				<th>datingAgeRangeEnd</th>
          				<td><c:out value = "${profile.datingAgeRangeEnd}"/></td>
          			</tr>
          			<tr>
          				<th>datingGeoRange</th>
          				<td><c:out value = "${profile.datingGeoRange}"/></td>
          			</tr>
          			<tr>
          				<th>m_f</th>
          				<td><c:out value = "${profile.m_f}"/></td>
          			</tr>
          			<tr>
          				<th>height</th>
          				<td><c:out value = "${profile.height}"/></td>
          			</tr>
          			<tr>
          				<th>weight</th>
          				<td><c:out value = "${profile.weight}"/></td>
          			</tr>
          			<tr>
          				<th>hairColor</th>
          				<td><c:out value = "${profile.hairColor}"/></td>
          			</tr>
          			<tr>
          				<th>creationDate</th>
          				<td><c:out value = "${profile.creationDate}"/></td>
          			</tr>
          			<tr>
          				<th>lastModDate</th>
          				<td><c:out value = "${profile.lastModDate}"/></td>
          			</tr>
          			<tr>
          				<th>Hobbies</th>
          				<td><c:out value = "${profile.hobbies}"/></td>
          			</tr>
          		</table>
          		<c:if test="${emp != null}">
        			<br>
        			<a href="${profile.profileID}?edit=true">Edit</a>
          		</c:if>
          		<c:if test="${emp == null}">
	          		<c:forEach items="${profiles}" var="prof">
	          			<c:if test="${prof.equals(profile.profileID)}">
	          				<br>
	          				<a href="${profile.profileID}?edit=true">Edit</a>
	          			</c:if>
	          		</c:forEach>
          		</c:if>
          		<c:if test="${!profiles.isEmpty() && !profiles.contains(profile.profileID)}">
        				<br>
        				<c:if test="${liked }">
        				<h4>Liked.</h4>
        				<br>
        				</c:if>
        				<a href="${profile.profileID}?like=true">Like</a>
          		</c:if>
            </c:if>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include> 
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
