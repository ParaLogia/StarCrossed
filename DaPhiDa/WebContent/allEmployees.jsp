<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Results from user searches -->
<head>
    <title>StarCrossedDaPhiDa</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="WEB-INF/main.css">
</head>
<body>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
       <h2>List of dates</h2> <br>
       		<c:if test = "${outputs == null}">
            	<h2> Error displaying search </h2> <br>
            </c:if>
            <c:if test = "${outputs != null}">
            	<h2> Employee List </h2> <br>
            	<table border = "5" style="width:100%">
          			<tr>
          				<th>Social Security Number</th>
          				<th>Role</th>
          				<th>Start Date</th>
          				<th>Hourly Rate</th>
          				<th>Edit</th>
          				<th>Delete</th>
          			</tr>
          			<c:forEach items="${outputs}" var="out">
          				<tr>
          					<td> 
          							<c:out value="${out.ssn}"/>
          					</td>
          					<td> 
          							<c:out value="${out.role}"/> 
          					</td>
          					<td> 
          							<c:out value="${out.startDate}"/> 
          					</td>
          					<td> 
          							<c:out value="${out.hourlyRate}"/> 
          					</td>
          					<td> 
          							<a href="editEmployee/:${out.ssn}:.editEmployeeCheck">Edit</a>
          					</td>
          					<td> 
          							<a href="deleteEmployee/:${out.ssn}:.deleteEmployeeCheck">Delete</a>
          					</td>
          				</tr>
          			</c:forEach>
          		</table>
            </c:if>
            <br>
    </div>
    <jsp:include page="footer.html"></jsp:include> 
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
