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
            <h2>Manager Homepage</h2> <br>
			<p>Here you can perform very high level tasks as the manager</p>
			<br>
			<a href="/CSE_305/manager/editEmployee" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Edit Employee</a>
            <a href="/CSE_305/manager/salesReport.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Sale Report</a>
            <a href="/CSE_305/manager/allUsers" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">All Users</a>
            <a href="/CSE_305/manager/listOfDates.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">List of Dates</a>
            <div style="height: 30px;"></div>
            <a href="/CSE_305/manager/revenueBy.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Revenue by date or calendar</a>
            <a href="/CSE_305/manager/mostRevenue.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Most Revenue</a>
            <a href="/CSE_305/manager/customerToCustomer.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Customer to Customer List</a>
            <a href="/CSE_305/manager/highestRated.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Highest Rated</a>
        </div>
    </div>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>