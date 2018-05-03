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
            <h2>Brief rationale for the E-R model</h2> <br>
            	
    Our E-R Diagram consists of three major entities: Profile, Customer, and Employee. The Customer represents the entity associated with a unique individual, specified by their User ID. This individual may have multiple payment methods which are represented with the attributes, account creation date, credit card number, and account number. 
    <br>Each Customer can own one or more Profiles, from which they can participate on the site. Each Customer has their personal information kept private from other Customers and only information on Profiles will be viewable to other people. We have a relationship between Customer and Profile, which designates the Profiles that a given Customer owns. In the Profiles entity, we have Hobbies and Photos as set attributes, since a profile entity can have more than one hobby/photo.
    <br>The Employee entity represents the workers in our company, who have their personal information hidden too. They are uniquely identified by their social security number, which is specified by the SSN attribute. Employees have a relationship with Profiles: when profiles start a Date, an Employee will act as a Customer Representative for said date. Also, this Date relationship relates two profiles to each other.
    <br>Then, we have two more relationships: Referral and Likes. Referral creates a relationships between three profiles: Profile A refers Profile B to Profile C for a date. The Likes relationship relates two Profiles: User 1 likes User 2.
            	<br>
            	<img src="ER1.png" height = "864" width = "625" class = "center-image"/>
            	<br>
            	<img src="ER2.png" height = "864" width = "625" class = "center-image"/>
            <br>
            <h2>Brief rationale for the relational model</h2> <br>
            
    The Profile table holds basic data for the Profiles we have.  The Profiles table has a single primary key and a restriction on age to be greater than or equal to 18. Following the Profiles table, we have two smaller tables for the hobbies and photos that both have foreign key references to Profile. For the Photos table, the Photos will be stored as a path to the image itself, hence the character storage.
<br>Next, we have Customer with its basic attributes, except for the set valued ones. The Customer table has a primary key of UserID. We have another table called CustomerPayingAccount, which directly references the UserID in Customer to allow each customer to have different payment methods associated to their name. After this, we have the Employee table, which has a primary key of their SSN.
<br>Then, we have all of the relationships--  starting with Dates, which is the first table that references Employee. Dates is an interesting relationship, as it has a primary key that consists of only the DateID attribute. It also has various foreign keys referencing their respective places. The next table is the Likes table, which has a check to make sure that a user cannot like their own profile. Next is the Referral table, which has a series of checks to make sure that all three profiles that are participating in the referral are distinct individuals. Lastly, we have the Owns table, which is a table that makes a relationship between Customers and Profiles to show which Profiles belong to which Customers.
<br>
<br>

            
        </div>
    </div>
	<jsp:include page="footer.html"></jsp:include>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
