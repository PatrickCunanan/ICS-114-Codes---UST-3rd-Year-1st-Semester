<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payroll Form</title>
</head>
<body>
	<h2>Payroll Form Using HTML</h2>
	<form action="compute.action" method="post">
		<p>
			Enter hours worked: <input type="text" name="hours" id="hours">
		</p>
		<p>
			Enter pay rate: <input type="text" name="payRate" id="payRate">
		</p>
		<input type="submit" value="Compute Payroll"> <input
			type="reset">
	</form>

	<hr>

	<h2>Payroll Form Using Struts 2 Custom Tag Library</h2>

	<s:form action="compute.action" method="post">
		<s:textfield label="Enter hours worked: " key="hours" />
		<s:textfield label="Enter pay rate: " key="payRate" />
		<s:submit type="submit" value="Compute Payroll" />
		<s:reset />
	</s:form>
</body>
</html>