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
                <h2>Register an Account</h2> <br>
                <br>
                <form action="RegisterServlet" method="post">
					<div class="container">
						<label for="email"><b>Email</b></label>
					    <input type="text" placeholder="Enter Email" name="email" required>
						<br>
					    <label for="password"><b>Password</b></label>
					    <input type="password" placeholder="Enter Password" name="password" required>
						<br>
						<label for="passwordRepeat"><b>Repeat Password</b></label>
					    <input type="password" placeholder="Enter Password Again" name="passwordRepeat" required>
						<br>
						
						<label for="ssn"><b>SSN</b></label>
					    <input type="text" placeholder="Enter SSN" name="ssn" required>
						<br>
						<label for="firstName"><b>First Name</b></label>
					    <input type="text" placeholder="Enter First Name" name="firstName" required>
						<br>
						<label for="lastName"><b>Last Name</b></label>
					    <input type="text" placeholder="Enter Last Name" name="lastName" required>
						<br>
						<label for="street"><b>Street</b></label>
					    <input type="text" placeholder="Enter Street" name="street">
						<br>
						<label for="city"><b>City</b></label>
					    <input type="text" placeholder="Enter City" name="city">
						<br>
						<label for="state"><b>State</b></label>
					    <input type="text" placeholder="Enter State" name="state">
						<br>
						<label for="zipcode"><b>Zipcode</b></label>
					    <input type="number" placeholder="Enter Zipcode" name="zipcode">
						<br>
						<label for="telephone"><b>Telephone</b></label>
					    <input type="text" placeholder="Enter Telephone" name="telephone">
						<br>
						
					    <button type="submit">Login</button>    
					</div>
				</form> 
                <br>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
