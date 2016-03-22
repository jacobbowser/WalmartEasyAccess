<%-- 
    Document   : searchResults.jsp
    Created on : Mar 21, 2016, 8:02:33 PM
    Author     : Quade
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ul>
	<c:forEach var="item" items="${result}">
		<li data-product-id="${item.id}">
			<img src="${item.imageUrl}" />
			${item.name}
			${item.price}
		</li>
	</c:forEach>
</ul>
