<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Investment Form</title>
</head>
<body>
	<h2>Investment Form</h2>
	<s:form action="compute.action" method="post">
	<s:radio label="Choose mutual fund type:" name="fundType"
			list="{'SALEF','SALBF','SALFIF'}" />
		<s:textfield label="Enter Investment amount: " key="amount" />
		<s:submit value="Submit" />
		<s:reset />
	</s:form>
</body>
</html>