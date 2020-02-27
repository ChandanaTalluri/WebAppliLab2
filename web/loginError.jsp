<%-- 
    Document   : loginError
    Created on : 26 Feb, 2020, 9:36:21 PM
    Author     : Chandana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style=" background-image: url(images/other4.jpg)">
        
        <h1> <spam>${customer.strLoginStatus}</spam> !!</h1>

        
        <form action="login.html" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Login">
        <td><input type="submit" name ="register" value="Register" formaction="register.html"></td>
    </form>
    </body>
</html>
