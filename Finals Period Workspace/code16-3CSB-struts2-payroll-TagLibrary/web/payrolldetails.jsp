<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content=text/html;>
<title>Insert title here</title>
</head>
<body>
	<h2>Payroll Computation Details using JSP Expression Language</h2>

	<p>Hours Worked: ${hours}</p>
	<p>Payrate: PHP${payRate}</p>
	<p>Basic Payment: PHP${basicPay}</p>
	<p>Overtime Pay: PHP${overtimePay}</p>
	<p>Gross Pay: PHP${grossPay}</p>
	<p>Withholding Tax: PHP${withHoldingTax}</p>
	<p>Net Payment: PHP${netPay}</p>
	
	<hr>
	
	<h2>Payroll Computation Details using Struts 2 Custom Tag Library</h2>
	
	<p>Hours Worked: <s:property value="hours"/></p>
	<p>Payrate: PHP<s:property value="payRate"/></p>
	<p>Basic Payment: PHP<s:property value="basicPay"/></p>
	<p>Overtime Pay: PHP<s:property value="overtimePay"/></p>
	<p>Gross Pay: PHP<s:property value="grossPay"/></p>
	<p>Withholding Tax: PHP<s:property value="withHoldingTax"/></p>
	<p>Net Payment: PHP<s:property value="netPay"/></p>
</body>
</html>