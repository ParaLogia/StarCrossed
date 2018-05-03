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
    <div style="height: 54px;"></div>
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
        <div class="col-md-12">
                <h2>Create a Profile</h2> <br>
                <br>
                <form action="profiles/create" method="post">
					<div class="container">	
						<label for="profileID"><b>Profile Name</b></label>
					    <input type="text" placeholder="Enter profileID" name="profileID">
						<br>
						<label for="age"><b>age</b></label>
					    <input type="number" placeholder="Enter age" name="age" required>
						<br>
						<label for="datingAgeRangeStart"><b>datingAgeRangeStart</b></label>
					    <input type="number" placeholder="Enter datingAgeRangeStart" name="datingAgeRangeStart" required>
						<br>
						<label for="datingAgeRangeEnd"><b>datingAgeRangeEnd</b></label>
					    <input type="number" placeholder="Enter datingAgeRangeEnd" name="datingAgeRangeEnd" required>
						<br>
						<label for="datingGeoRange"><b>datingGeoRange</b></label>
					    <input type="number" placeholder="Enter datingGeoRange" name="datingGeoRange" required>
						<br>
						<label for="m_f"><b>Gender</b></label>
					    <input type="text" placeholder="Enter Gender" name="m_f">
						<br>
						<label for="height"><b>height</b></label>
					    <input type="number" step="0.1" placeholder="Enter height" name="height" required>
						<br>
						<label for="weight"><b>weight</b></label>
					    <input type="number" placeholder="Enter weight" name="weight" required>
						<br>
						<label for="hairColor"><b>hair Color</b></label>
					    <input type="text" placeholder="Enter hairColor" name="hairColor">
						<br>
						<label for="hobbies"><b>hobbies</b></label>
					    <input type="text" placeholder="Enter hobbies" name="hobbies">
					    <br>
						<label for="PPP"><b>Profile Placement Priority</b></label>
					    <select name="PPP">
						  <option value="Super-User">Super-User</option>
						  <option value="Good-User">Good-User</option>
						  <option value="User-User">User-User</option>
						</select>
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
