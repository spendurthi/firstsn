<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items = "${users}" var="usr">
<tr>
	<td><c:out value="${usr.userId}"/></td>
	<td><c:out value="${usr.password}"/></td>	
</tr>	
</c:forEach>