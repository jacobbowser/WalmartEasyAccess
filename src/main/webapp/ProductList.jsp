<%-- 
    Document   : ProductList
    Created on : Mar 12, 2016, 4:04:04 PM
    Author     : Jacob
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="Dao.ProductDao"%>
<%@page import="java.util.List"%>
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
            <h1 class="theBlue">${user.username}'s Products</h1>
            <!--for loop with getlist-->
            
            <br /><a href="search.jsp" class="btn btn-primary">Add New Product</a><br/><br />
            
            	<c:forEach var="item" items="${items}">
                    <a href="${item.addToCartUrl}" class="btn btn-primary silver">
			<img class="left" src="${item.imageUrl}" />
			<span class="wrap">${item.name} 
                            <span class="price">${item.price}</span>
                        </span>
                    </a> <br />
               </c:forEach>
            
            
        </div>
    </body>
</html>
