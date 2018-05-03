<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Search -->
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
            <h2>Record dates</h2> <br>        
	            <form id="recordDate" method="post" action="employee/recordDate">
	            	<label for="profile1"><b>Profile Name 1</b></label><br>
	            	<input type="text" placeholder="Profile Name 1" name="profile1" style="height:25px" required><br>
	            	<label for="profile2"><b>Profile Name 2</b></label><br>
	            	<input type="text" placeholder="Profile Name 2" name="profile2" style="height:25px" required><br>
	            	<label for="custRep"><b>Employee ID</b></label><br>
	            	<input type="text" placeholder="Employee ID" name="custRep" style="height:25px" required><br>
	            	<label for="date_time"><b>Date Time</b></label><br>
	            	<input type="text" placeholder="Date Time" name="date_Time" style="height:25px" required><br>
	            	<label for="location"><b>Location</b></label><br>
	            	<input type="text" placeholder="Location" name="location" style="height:25px" required><br>
	            	<label for="bookingFee"><b>Booking Fee</b></label><br>
	            	<input type="text" placeholder="Booking Fee" name="bookingFee" style="height:25px" required><br>
	            	<button type="submit">Submit</button>
	            </form>
            <br>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include>   
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
