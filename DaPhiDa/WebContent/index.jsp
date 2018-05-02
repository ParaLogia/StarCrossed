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
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;" >
        <div class="col-md-12">
        <!-- centered text  -->
                <h2>Welcome to StarCrossed by DaPhiDa</h2> <br>
                <img src="Logo.PNG" width = "250" height = "250" class ="center-image"/> <br>
				Welcome to the best Dating Website. Here, you can search our database for lots of people. <br>
				Start searching here:
                <br>
                <a href="search.html" class="btn btn-primary hvr-grow">Click here to find your soulmate</a>
        </div>
    </div>

	<jsp:include page="footer.html"></jsp:include>    
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
