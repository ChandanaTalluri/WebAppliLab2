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
        <title>Login</title>
    </head>
    <body style=" background-image: url(images/other4.jpg)">
        <h1>Welcome <spam>${customer.strLastName}</spam> !!</h1>
        <form action="index.html" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
    </body>
</html>
