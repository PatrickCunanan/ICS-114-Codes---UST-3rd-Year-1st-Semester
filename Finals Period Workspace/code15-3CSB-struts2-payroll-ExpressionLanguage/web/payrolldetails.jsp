<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content=text/html;>
<title>Insert title here</title>
</head>
<body>
	<h2>Payroll Computation Details</h2>

	<p>Hours Worked: ${hours}</p>
	<p>Payrate: PHP${payRate}</p>
	<p>Basic Payment: PHP${basicPay}</p>
	<p>Overtime Pay: PHP${overtimePay}</p>
	<p>Gross Pay: PHP${grossPay}</p>
	<p>Withholding Tax: PHP${withHoldingTax}</p>
	<p>Net Payment: PHP${netPay}</p>
	
</body>
</html>