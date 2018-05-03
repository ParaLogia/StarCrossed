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
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
        <div class="col-md-12">
            <h2>Profiles liked by <c:out value="${profile}"/></h2> <br>
          		<table border = "5" style="width:100%">
          			<c:if test="${!likes.isEmpty()}">
	          			<c:forEach items="${likes}" var="like">
	          				<tr>
	          					<td> <a href = profiles/<c:out value="${like.likee}"/>>
	          							<c:out value="${like.likee}"/> </a>
	          					</td>
	          					<td>
	          						<c:out value="${like.dateTime}"/>
	          					</td>
	          				</tr>
	          			</c:forEach>
          			</c:if>
          			<c:if test="${likes.isEmpty()}">
          				<tr>
          					<td> 
								No Likes here yet!
          					</td>
          				</tr>
          			</c:if>
          		</table>
            <br>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include> 
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
