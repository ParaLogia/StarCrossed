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
            	<h1> <c:out value="${profile.profileID}"/> </h1> <br>
            	
            	<form action="login/submit" method="post">
					<div class="container">
						<label for="email"><b>Email</b></label>
					    <input type="text" placeholder="Enter Email" name="email" required>
						<br>
					    <label for="password"><b>Password</b></label>
					    <input type="password" placeholder="Enter Password" name="password" required>
						<br>
					    <button type="submit">Login</button>    
					</div>
				</form> 
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
          				<td>
	          			<c:forEach items="${hobbies}" var="hobby">
         					<c:out value = "${hobby}"/> <br>
	          			</c:forEach>
	          			</td>
          			</tr>
          		</table>
            </c:if>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include>  
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
