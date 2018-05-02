<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- when the user wants to view his own profile from a public perspective -->
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
            <h2>Please select a profile to view</h2> <br>
          		<table border = "5" style="width:100%">
          			<tr>
          				<th>Your Current Profiles</th>
          			</tr>
          			<c:forEach items="${profiles}" var="profile">
          				<tr>
          					<td> <a href = profiles&profile=<c:out value="${profile.profileID}"/>><c:out value="${profile.profileID}"/></a></td>
          				</tr>
          			</c:forEach>
          		</table>
            <br>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include> 
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
