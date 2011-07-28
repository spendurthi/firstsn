<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organization</title>
</head>
<body>
<!-- Start of FORM -->
<form method="post" action="organization.htm">
<table width="100%">
  <tr><!-- Row 1 -->
     <td>Organization Name</td><!-- Col 1 -->
     <td><input type="text" name="org.orgName" value=""></td><!-- Col 2 -->
  </tr>
  <tr><!-- Row 2 -->
     <td>Organization Logo</td><!-- Col 1 -->
     <td><input type="file" name="" value=""></td><!-- Col 2 -->
  </tr>
  <tr><!-- Row 3 -->
     <!-- Col 1 -->
     <td colspan="2" align="center"><input type="reset" value="Rest"><input type="submit" name="submit" value="Save"></td><!-- Col 2 -->
  </tr>
</table>
</form>
<!-- End of FORM -->
</body>
</html>