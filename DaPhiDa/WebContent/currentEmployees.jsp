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
    <div style="height: 54px;"></div>
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
       <h2>Current Roster of employed members</h2> <br>
          		<table border = "5" style="width:100%">
          			<tr>
          				<th>First Name</th>
          				<th>Last Name</th>
          				<th>Role</th>
          				<th>Start Date</th>
          				<th>Email</th>
          				<th>Telephone</th>
          				<th>State</th>
          				<th>Zipcode</th>
          			</tr>
          			<c:forEach items="${employees}" var="emp">
          				<tr>
          					<td> 
          							<c:out value="${emp.firstName}"/>
          					</td>
          					<td> 
          							<c:out value="${emp.lastName}"/> 
          					</td>
          					<td> 
          							<c:out value="${emp.role}"/> 
          					</td>
          					<td> 
          							<c:out value="${emp.startDate}"/> 
          					</td>
          					<td> 
          							<c:out value="${emp.email}"/> 
          					</td>
          					<td> 
          							<c:out value="${emp.telephone}"/> 
          					</td>
          					<td> 
          							<c:out value="${emp.state}"/> 
          					</td>
          					<td> 
          							<c:out value="${emp.zipcode}"/> 
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
