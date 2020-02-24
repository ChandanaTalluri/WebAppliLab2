<%-- 
    Document   : login
    Created on : Feb 20, 2020, 11:09:17 AM
    Author     : 0809379
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="styles/main.css" type="text/css"/>    

    </head>
    <body style=" background-image: url(images/other4.jpg)">
    <h1> Welcome<span>${customer.strFirstName}</span> </h1>
    <h1>Thanks for registering in Easy Banking</h1>

    <p>Here is the information that you entered:</p>

    <label>User ID</label>
    <span>${customer.custID}</span><br>
    <label>First Name:</label>
    <span>${customer.strFirstName}</span><br>
    <label>Last Name:</label>
    <span>${customer.strFirstName}</span><br>
    <label>Email ID:</label>
    <span>${customer.emialID}</span><br>
    <label>Contact Number:</label>
    <span>${customer.strPhoneNumber}</span><br>
    
    <form action="index.html" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
    </body>
</html>
