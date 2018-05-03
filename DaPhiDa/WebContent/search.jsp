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
    <div class="container" style="padding-top: 100px; text-align: center; padding-bottom:50px;">
        <div class="col-md-12">
        <!-- So ideally with search, we need to fulfill the following -->
        <!-- Profile ID -->
        <!-- Phyiscal Characteristics (i.e. Gender, Height, Weight, & Haircolor)(Cause that's what we support) -->
        <!-- Location -->
        <!-- Most active profiles? (Sort by last login?) -->
        <!-- Highly rated -->
            <h2>Search for Amazing Matches, like Phillip Huang</h2> <br>        
	            <form id="searchBar" method="get" action="search/submit">
	            	<div class="container">
		            	<select name="searchType" id="searchValue" style="height:25px">
		            		<option value="ProfileID">Profile Name</option>
		            		<option value="Height">Height</option>
		            		<option value="Weight">Weight</option>
		            		<option value="HairColor">Hair</option>
		            		<option value="City">City</option>
		            		<option value="State">State</option>
		            		<option value="DateOfLastAct">Activity</option>
		            		<option value="Rating">Rating</option>
		            		<option value="Hobbies">Hobbies</option>
		            	</select>
		            	<input type="text" placeholder="Search" name="searchTerm" style="height:25px" required>
		            	<input id="searchButton" type="submit" value="Search" style="height:25px">
	            	</div>
	            </form>
            <br>
        </div>
    </div>
    <jsp:include page="footer.html"></jsp:include>   
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
