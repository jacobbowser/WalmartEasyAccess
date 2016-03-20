<%-- 
    Document   : error.jsp
    Created on : Mar 1, 2016, 10:34:50 AM
    Author     : Jacob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <link href="bootstrapStuff.css" rel="stylesheet">
        <link href="bootstrapSignIn.css" rel="stylesheet">
    </head>
    <body>
        <div class="container" style="text-align:center">
            <img src="RedX.png" height="150" width="150" />
            <h2 style="color:red"><br />Incorrect Username and/or Password</h2><br />
            <div class="form-signin">
                <a href="AmazonSignIn.jsp" class="btn btn-lg btn-primary btn-block">
                Try Sign In Again</a>
            </div>
        </div>
        
    </body>
</html>
