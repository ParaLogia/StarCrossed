<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Search -->
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
        <!-- So ideally with search, we need to fulfill the following -->
        <!-- Profile ID -->
        <!-- Phyiscal Characteristics (i.e. Gender, Height, Weight, & Haircolor)(Cause that's what we support) -->
        <!-- Location -->
        <!-- Most active profiles? (Sort by last login?) -->
        <!-- Highly rated -->
            <h2>Search for Amazing Matches, like Phillip Huang</h2> <br>
            <input type="text" placeholder="Search by ProfileID">
            <br>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include>   
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
