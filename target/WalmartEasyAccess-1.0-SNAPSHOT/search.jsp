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
    </head>
    <body>
		<input type="text" name="query" id="query" placeholder="Enter the name of a product" />
		<input type="button" name="search" id="search" value="Search" />

		<div id="results"></div>
		<script type="text/javascript" src="src/jquery.min.js"></script>
		<script type="text/javascript" src="src/search.js"></script>
    </body>
</html>
