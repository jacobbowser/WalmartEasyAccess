<%-- 
    Document   : searchResults.jsp
    Created on : Mar 21, 2016, 8:02:33 PM
    Author     : Quade
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="item" items="${result}">
    <a href="AddProduct?productId=${item.id}" class="btn btn-primary silver">
	<img class="left" src="${item.imageUrl}" />
        <span class="wrap">${item.name}
            <span class="price">${item.price}</span>
        </span>
    </a>
</c:forEach>
