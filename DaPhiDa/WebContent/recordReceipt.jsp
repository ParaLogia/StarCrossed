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
       <h2>List of dates</h2> <br>
          		<table border = "5" style="width:100%">
          			<tr>
          				<th>Profile 1</th>
          				<th>Profile 2</th>
          				<th>Customer Representative</th>
          				<th>Date Time</th>
          				<th>Location</th>
          				<th>Booking Fee</th>
          				<th>Comments</th>
          				<th>User1Rating</th>
          				<th>User2Rating</th>
          				<th>Edit Date</th>
          			</tr>
          			<c:forEach items="${dates}" var="date">
          				<tr>
          					<td> 
          							<c:out value="${date.profile1}"/>
          					</td>
          					<td> 
          							<c:out value="${date.profile2}"/> 
          					</td>
          					<td> 
          							<c:out value="${date.custRep}"/> 
          					</td>
          					<td> 
          							<c:out value="${date.dateTime}"/> 
          					</td>
          					<td> 
          							<c:out value="${date.location}"/> 
          					</td>
          					<td> 
          							<c:out value="${date.bookingFee}"/> 
          					</td>
          					<td> 
          							<c:out value="${date.comments}"/> 
          					</td>
          					<td> 
          							<c:out value="${date.user1Rating}"/> 
          					</td>
          					<td> 
          							<c:out value="${date.user2Rating}"/> 
          					</td>
          					<td> 
          							<a href="editReceipt/:${date.profile1}:${date.profile2}:${date.dateTime}:.receiptCheck">Edit</a>
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
