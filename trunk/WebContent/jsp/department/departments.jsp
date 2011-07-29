<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Departments</title>
</head>
<body>
<c:forEach items = "${allContacts}" var="contact">
	<c:out value="${contact.firstname}"/><br>
	<c:out value="${contact.lastname}"/><br>
</c:forEach>
</body>
</html>