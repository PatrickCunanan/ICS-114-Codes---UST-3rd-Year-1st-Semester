<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payroll Form</title>
</head>
<body>
	<h2>Payroll Form using Struts2 Custom Tag Library</h2>
	<s:form action="compute.action" method="post">
		<s:textfield label="Enter First Name " key="firstName"/>
		<s:textfield label="Enter Last Name " key="lastName"/>
		<s:textfield label="Enter hours worked " key="hours"/>
		<s:textfield label="Enter pay rate " key="payRate"/>
		<s:submit type="submit" value="Compute Payroll"/>
		<s:reset/>
	</s:form>
</body>
</html>