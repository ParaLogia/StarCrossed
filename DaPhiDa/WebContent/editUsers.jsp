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
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
        <div class="col-md-12">
            <c:if test = "${users == null}">
            	<h2> Error loading profile </h2> <br>
            </c:if>
        	<c:if test = "${users != null}"> 
        		<h2>Enter Information Here</h2>          	
            	<form action="update" method="post">
					<div class="container">
						<label for="ssn"><b>SSN</b></label>
					    <input type="text" value="${users.ssn}" name="ssn" required>
						<br>
						<label for="ppp"><b>PPP</b></label>
					    <input type="text" value="${users.ppp}" name="ppp" required>
						<br>
						<label for="rating"><b>Rating</b></label>
					    <input type="number" value="${users.rating}" name="rating" required>
						<br>
					    <label for="dateOfLastAct"><b>Last Seen</b></label>
					    <input type="datetime-local" value="${users.dateOfLastAct}" name="dateOfLastAct" required>
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
