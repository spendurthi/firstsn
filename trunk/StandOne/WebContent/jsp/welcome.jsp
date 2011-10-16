<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="POST" commandName="user" action="login.htm">

<table>
<tr>
<td>User Name :</td>
<td><input type="text" name="userId"/></td>
</tr>
<tr>
<td>Password :</td>
<td><input type="password" name="password" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit"  /></td>
</tr>
</table>
</form:form>