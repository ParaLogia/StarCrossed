<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- this is out entry point into the program -->
<head>
    <title>StarCrossedDaPhiDa</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="WEB-INF/main.css">
</head>
<body>
	<!-- top nav bar, because it's going to be on everypage, same with footer below -->
   <jsp:include page="NavBar.jsp"></jsp:include>
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;" >
        <div class="col-md-12">
        <!-- front page  -->
        	<h2>List of Dates</h2> <br>
 			
 			<ul>
	 			<c:forEach items="$(dates)" var="date">
	 				
	 				<li>
	 					$(date.profile2) : $(date.location) at $(date.dateTime)
	 				</li>
	 			
	 			</c:forEach>
 			</ul>
        </div>
    </div>
	<jsp:include page="footer.html"></jsp:include>    
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
