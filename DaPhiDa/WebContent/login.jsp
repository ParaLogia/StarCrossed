<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                <h2>Log In</h2> <br>
                <br>
                <form action="login/submit" method="post">
					<div class="container">
						<label for="email"><b>Email</b></label>
					    <input type="text" placeholder="Enter Email" name="email" required>
						<br>
					    <label for="password"><b>Password</b></label>
					    <input type="password" placeholder="Enter Password" name="password" required>
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
