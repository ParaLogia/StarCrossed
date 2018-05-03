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
            <h2>Employee Homepage</h2> <br>
			<p>Clicking home will always bring you back here where you can perform special employee functions</p>
			<br>
			<a href="/CSE_305/recordDate.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Record a Date</a>
            <a href="/CSE_305/manager.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Manager Page</a>
            <a href="/CSE_305/changeCustomerInfo.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Change Customer Info</a>
            <a href="/CSE_305/mailingList.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Generate Mailing List</a>
            <div style="height: 30px;"></div>
            <a href="/CSE_305/suggestionGenerator.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Suggestion Generator</a>
            <a href="/CSE_305/recordReceipt.jsp" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Record a Receipt</a>
            <a href="/CSE_305/currentEmployees" style="color: black; background: pink; border: 10px solid; border-radius: 10px; border-color: pink">Current Employee List</a>
            
        </div>
    </div>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>