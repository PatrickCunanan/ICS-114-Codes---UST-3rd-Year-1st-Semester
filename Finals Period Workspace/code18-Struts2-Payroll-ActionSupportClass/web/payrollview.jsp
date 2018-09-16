<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payroll Details</title>
</head>
<body>
	<h2>Payroll Computational Details 
		Using Struts 2 Custom Tag Library</h2>
	<p>Name: <b><s:property value="firstName"/>&nbsp;
		<s:property value="lastName"/></b></p>
	<p>Hours Worked: <b><s:property value="hoursWorked"/></b></p>
	<p>Pay Rate: <b>Php<s:property value="payRate"/></b></p>
	<p>Basic Pay: <b>Php<s:property value="basicPay"/></b></p>
	<p>Overtime Pay: <b>Php<s:property value="overTimePay"/></b></p>
	<p>Gross Pay: <b>Php<s:property value="grossPay"/></b></p>
	<p>Withholding Tax: <b>Php<s:property value="taxRate"/></b></p>
	<p>Net Pay: <b>Php<s:property value="netPay"/></b></p>
	
	<hr/>
	<form action="payrollform.jsp">
	<p><input type="submit" 
		value="<< GO BACK >>" /></p>
	</form>
</body>
</html>

