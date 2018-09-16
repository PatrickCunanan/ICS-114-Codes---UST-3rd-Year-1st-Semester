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
	<h2>Payroll Form Using Struts 2 Custom Tag</h2>
	<s:form action="compute.action" method="post">
		<s:textfield label="Enter first name" 
			key="firstName"/>
		<s:textfield label="Enter last name" 
			key="lastName"/>	
		<s:textfield label="Enter hours worked" 
			key="hoursWorked"/>
		<s:textfield label="Enter payrate" 
			key="payRate"/>
		<s:submit value="Compute Payroll"/>
		<s:reset/>
	</s:form>
</body>
</html>