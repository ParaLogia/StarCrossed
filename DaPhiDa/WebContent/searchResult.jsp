<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Results from various searches -->
<head>
    <title>StarCrossedDaPhiDa</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="WEB-INF/main.css">
</head>
<body>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
       <h2>Search Results</h2> <br>
       	<p>Height search has a radius of 0.3 and Weight search has a radius of 20</p>
          		<table border = "5" style="width:100%">
          			<tr>
          				<th>Found these Profiles: </th>
          				<th>Rating</th>
          				<th>Height</th>
          				<th>Weight</th>
          				<th>Hair Color</th>
          				<th>City</th>
          				<th>State</th>
          				<th>Last Seen</th>
          			</tr>
          			<c:forEach items="${outputs}" var="out">
          				<tr>
          					<td> <a href = ../profiles/<c:out value="${out.profileId}"/>>
          							<c:out value="${out.profileId}"/> </a>
          					</td>
          					<td> 
          							<c:out value="${out.rating}"/> 
          					</td>
          					<td> 
          							<c:out value="${out.height}"/> 
          					</td>
          					<td> 
          							<c:out value="${out.weight}"/> 
          					</td>
          					<td> 
          							<c:out value="${out.hairColor}"/> 
          					</td>
          					<td> 
          							<c:out value="${out.city}"/> 
          					</td>
          					<td> 
          							<c:out value="${out.state}"/> 
          					</td>
          					<td> 
          							<c:out value="${out.dateOfLastAct}"/> 
          					</td>
          				</tr>
          			</c:forEach>
          		</table>
            <br>
    </div>
    <jsp:include page="footer.html"></jsp:include> 
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
