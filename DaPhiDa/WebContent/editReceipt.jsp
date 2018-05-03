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
            	<form action="receipt/submit" method="post">
					<div class="container">
						<label for="Profile1"><b>Profile1</b></label>
					    <input type="text" value="${date1.profile1}" name="profile1" required>
						<br>
						<label for="Profile2"><b>Profile2</b></label>
					    <input type="text" value="${date1.profile2}" name="profile2" required>
						<br>
						<label for="CustRep"><b>CustRep</b></label>
					    <input type="text" value="${date1.CustRep}" name="custRep" required>
						<br>
					    <label for="Date_Time"><b>Date_Time</b></label>
					    <input type="text" value="${date1.dateTime}" name="dateTime" required>
						<br>
					    <label for="Location"><b>Location</b></label>
					    <input type="text" value="${date1.location}" name="location" required>
						<br>
					    <label for="BookingFee"><b>BookingFee</b></label>
					    <input type="text" value="${date1.bookingFee}" name="bookingFee" required>
						<br>
					    <label for="Comments"><b>Comments</b></label>
					    <input type="text" value="${date1.comments}" name="comments" required>
						<br>
					    <label for="User1Rating"><b>User1Rating</b></label>
					    <input type="text" value="${date1.user1Rating}" name="user1Rating" required>
						<br>
					    <label for="User2Rating"><b>User2Rating</b></label>
					    <input type="text" value="${date1.user1Rating}" name="user1Rating" required>
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
