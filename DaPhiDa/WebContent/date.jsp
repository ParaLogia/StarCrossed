<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Called when the user needs to login -->
<head>
    <title>StarCrossedDaPhiDa</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="WEB-INF/main.css">
</head>
<body>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
        <div class="col-md-12">
                <h2>Set Up Date with <%= request.getParameter("profile") %></h2> <br>
                <br>
                <form action="date/submit" method="post">
					<div class="container">
					     <input type="hidden" value="<%= request.getParameter("profile") %>" name="profile1" required>
						<!--<c:if test="${emp != null && !emp.isEmpty()}">
							<label for="profile2"><b>Profile 2</b></label>
						    <input type="text" placeholder="Enter profile2" name="profile2" required>
							<br>
							<input type="hidden" value="${emp}" name="custRep" required>
							
							<label for="bookingFee"><b>bookingFee</b></label>
						    <input type="number" step=0.01 placeholder="Enter bookingFee" name="bookingFee" required>
							<br>
						</c:if> -->
					    <input type="hidden" value="${profiles.get(0)}" name="profile2" required>
						
					    <input type="hidden" value="222-22-2222" name="custRep">
						<input type="hidden" value="${emp}" name="custRep" required>
						<input type="hidden" value="24.99" name="bookingFee" required>
						<br>
						<label for="dateTime"><b>Date/Time</b></label>
					    <input type="datetime-local" placeholder="Enter dateTime" name="dateTime" required>
						<br>
					    <label for="location"><b>location</b></label>
					    <input type="text" placeholder="Enter location" name="location" required>
						<br>
						
					    <button type="submit">Submit</button>    
					</div>
				</form> 
                <br>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
