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
            <c:if test = "${date1 == null}">
            	<h2> Error loading profile </h2> <br>
            </c:if>
        	<c:if test = "${date1 != null}"> 
        		<h2>Enter Information Here</h2>          	
            	<form action="receipt" method="post">
					<div class="container">
						<label for="profile1"><b>Profile1</b></label>
					    <input type="text" value="${date1.profile1}" name="profile1" required>
						<br>
						<label for="profile2"><b>Profile2</b></label>
					    <input type="text" value="${date1.profile2}" name="profile2" required>
						<br>
						<label for="custRep"><b>CustRep</b></label>
					    <input type="text" value="${date1.custRep}" name="custRep" required>
						<br>
					    <label for="dateTime"><b>Date_Time</b></label>
					    <input type="datetime-local" value="${date1.dateTime}" name="dateTime" required>
						<br>
					    <label for="location"><b>Location</b></label>
					    <input type="text" value="${date1.location}" name="location" required>
						<br>
					    <label for="bookingFee"><b>BookingFee</b></label>
					    <input type="text" value="${date1.bookingFee}" name="bookingFee" required>
						<br>
					    <label for="comments"><b>Comments</b></label>
					    <input type="text" value="${date1.comments}" name="comments" required>
						<br>
					    <label for="user1Rating"><b>User1Rating</b></label>
					    <input type="number" value="${date1.user1Rating}" name="user1Rating" required>
						<br>
					    <label for="user2Rating"><b>User2Rating</b></label>
					    <input type="number" value="${date1.user2Rating}" name="user2Rating" required>
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
