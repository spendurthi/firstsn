<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script language="Javascript">
function setMode(id,mode){
	document.frmDept.action="department.htm?methodName="+mode;
	document.frmDept.deptId.value=id;
	//document.frmDept.submit();
}
function customButton(mode){
	document.frmDept.action="department.htm?methodName="+mode;
	//document.frmDept.submit();
}
</script>
<html>
<head>
	<title>Departments</title>
</head>
<body>
<form:form method="POST" action="department.htm" name="frmDept" modelAttribute="department">
<table>
	<tr>
		<td>	
			<fmt:message key="deptId"  /> 
			<form:label path="name">Name</form:label>
			<td><form:label path="deptId"><spring:message code="deptId"/></form:label>
			</td>
		<td>
			<form:input path="deptId" cssClass="required" />			
		</td>
		</tr>
<tr>

<td><fmt:message key="deptName" /> </td>
<td><input type="text" name="deptName" id="deptName" value="${deptVo.deptName}" class="required"> </td>
</tr>
<tr>
<td></td>
<c:if test="${deptVo==null}">
<td align="right"><input type="button" value="Add" onclick="javascript:customButton('addDepartment')" class="deptActions"> </td>
</c:if>
<c:if test="${deptVo!=null}">
<td align="right"><input type="button" value="Update" onclick="javascript:customButton('updateDepartment')"> </td>
</c:if>
</tr>
</table>
</form:form>
<table>
<tr>
<th><fmt:message key="deptId" /></th>
<th><fmt:message key="deptName" /></th>
</tr>
<c:forEach items = "${listOfDepts}" var="dept">
<tr>
	<td><c:out value="${dept.deptId}"/></td>
	<td><c:out value="${dept.deptName}"/></td><td><input type="button" name="viewName" value="Delete" onclick="javascript:setMode('<c:out value="${dept.deptId}"/>','deleteDepartment')" /> </td><td><input type="button" name="viewName" value="Update" onclick="javascript:setMode('<c:out value="${dept.deptId}"/>','updateMode')" /> </td>
</tr>	
</c:forEach>
</table>
</body>
</html>