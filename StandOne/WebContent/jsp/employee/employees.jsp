<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script language="Javascript">
function setMode(id,mode){
	document.frmEmp.action="employee.htm?methodName="+mode;
	document.frmEmp.empId.value=id;
	document.frmEmp.submit();
}
function customButton(mode){
	document.frmEmp.action="employee.htm?methodName="+mode;
	document.frmEmp.submit();
}
</script>
<html>
<head>
<title><fmt:message key="hEmployee" /></title>
</head>
<body>
<form method="POST" action="employee.htm?methodName=addEmployee" name="frmEmp">

<table>
<tr>
<td><fmt:message key="empId" /></td>
<td>
<input type="text" name="empId" value="${empVo.empId}">
</td>
</tr>
<tr>
<td><fmt:message key="empName" /> </td>
<td><input type="text" name="empName" value="${empVo.empName}"> </td>
</tr>
<tr>
<td><fmt:message key="deptId" /> </td>
<td>
<input type="text" name="deptId" value="${empVo.deptId}"> </td>
</tr>
<tr>
<td></td>
<c:if test="${empVo==null}">
<td align="right"><input type="button" value="Add" onclick="javascript:customButton('addEmployee')"> </td>
</c:if>
<c:if test="${empVo!=null}">
<td align="right"><input type="button" value="Update" onclick="javascript:customButton('updateEmployee')"> </td>
</c:if>
</tr>
</table>
</form>
<table>
<tr>
<th><fmt:message key="empId" /></th>
<th><fmt:message key="empName" /></th>
</tr>
<c:forEach items = "${listOfEmps}" var="emp">
<tr>
	<td><c:out value="${emp.empId}"/></td>
	<td><c:out value="${emp.empName}"/></td><td><input type="button" name="viewName" value="Delete" onclick="javascript:setMode('<c:out value="${emp.empId}"/>','deleteEmployee')" /> </td><td><input type="button" name="viewName" value="Update" onclick="javascript:setMode('<c:out value="${emp.empId}"/>','updateMode')" /> </td>
</tr>	
</c:forEach>
</table>
</body>
</html>