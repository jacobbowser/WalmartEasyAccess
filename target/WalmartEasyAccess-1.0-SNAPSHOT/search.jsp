<%-- 
    Document   : searchForProduct
    Created on : Mar 21, 2016, 6:14:02 PM
    Author     : Quade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrapStuff.css" rel="stylesheet">
        <link href="css/bootstrapSignIn.css" rel="stylesheet">
        <link href="css/other.css" rel="stylesheet">
    </head>
    <body>
        <div class="center">
            <h1 class="theBlue">Add New Product</h1>
            <input type="text" name="query" id="query" placeholder="Enter Product" /><br />
            <br /><input type="button" name="search" id="search" value="Search" class="btn btn-primary" />
            <br />
            <div id="results"></div>
            <script type="text/javascript" src="src/jquery.min.js"></script>
            <script type="text/javascript" src="src/search.js"></script>
        </div>
    </body>
</html>
