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
            <h2>Dates for <c:out value="${profile}"/></h2> <br>
          		<table border = "5" style="width:100%">
          			<c:if test="${!dates.isEmpty()}">
          			<tr>
          			<td>Profile 1</td>
          			<td>Profile 2</td>
          			<td>Customer Rep</td>
          			<td>Date Time</td>
          			<td>Location</td>
          			<td>Fee</td>
          			<td>Comments</td>
          			<td>Profile 1 Rating</td>
          			<td>Profile 2 Rating</td>
          			</tr>
	          			<c:forEach items="${dates}" var="date">
	          				<tr>
	          					<td> <a href = /CSE_305/profiles/<c:out value="${date.profile1}"/>>
	          							<c:out value="${date.profile1}"/> </a>
	          					</td>
	          					<td> <a href = /CSE_305/profiles/<c:out value="${date.profile2}"/>>
	          							<c:out value="${date.profile2}"/> </a>
	          					</td>
	          					<td>
          							<c:out value="${date.custRep}"/>
          						</td>
	          					<td>
          							<c:out value="${date.dateTime}"/>
          						</td>
	          					<td>
          							<c:out value="${date.location}"/>
          						</td>
	          					<td>
          							<c:out value="${date.bookingFee}"/>
          						</td>
	          					<td>
          							<c:out value="${date.comments}"/>
          						</td>
	          					<td>
          							<c:out value="${date.user1Rating}"/>
          						</td>
	          					<td>
          							<c:out value="${date.user2Rating}"/>
          						</td>
	          				</tr>
	          			</c:forEach>
          			</c:if>
          			<c:if test="${dates.isEmpty()}">
          				<tr>
          					<td> 
								No dates here yet!
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
