<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script language="Javascript">
function setMode(id,mode){
	document.frmDesig.action="designation.htm?methodName="+mode;
	document.frmDesig.desigId.value=id;
	document.frmDesig.submit();
}
function customButton(mode){
	document.frmDesig.action="designation.htm?methodName="+mode;
	document.frmDesig.submit();
}
</script>
<html>
<head>
<title><fmt:message key="hDesignation" /></title>
</head>
<body>
<form method="POST" action="designation.htm?methodName=addDesignation" name="frmDesig">

<table>
<tr>
<td><fmt:message key="desigId" /></td>
<td>
<input type="text" name="desigId" value="${desigVo.desigId}">
</td>
</tr>
<tr>
<td><fmt:message key="desigName" /> </td>
<td><input type="text" name="desigName" value="${desigVo.desigName}"> </td>
</tr>
<tr>
<td><fmt:message key="deptId" /> </td>
<td>
<input type="text" name="deptId" value="${desigVo.deptId}"> </td>
</tr>
<tr>
<td></td>
<c:if test="${desigVo==null}">
<td align="right"><input type="button" value="Add" onclick="javascript:customButton('addDesignation')"> </td>
</c:if>
<c:if test="${desigVo!=null}">
<td align="right"><input type="button" value="Update" onclick="javascript:customButton('updateDesignation')"> </td>
</c:if>
</tr>
</table>
</form>
<table>
<tr>
<th><fmt:message key="desigId" /></th>
<th><fmt:message key="desigName" /></th>
</tr>
<c:forEach items = "${listOfDesigs}" var="desig">
<tr>
	<td><c:out value="${desig.desigId}"/></td>
	<td><c:out value="${desig.desigName}"/></td><td><input type="button" name="viewName" value="Delete" onclick="javascript:setMode('<c:out value="${desig.desigId}"/>','deleteDesignation')" /> </td><td><input type="button" name="viewName" value="Update" onclick="javascript:setMode('<c:out value="${desig.desigId}"/>','updateMode')" /> </td>
</tr>	
</c:forEach>
</table>
</body>
</html>