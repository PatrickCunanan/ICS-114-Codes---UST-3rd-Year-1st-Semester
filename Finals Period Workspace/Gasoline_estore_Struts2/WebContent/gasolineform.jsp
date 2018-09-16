<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gasoline eStore</title>
</head>
<body>
	<s:form action="compute.action" method="post">
		<s:textfield label="Enter the number of liters" key="gasolineLiter" />

		<s:radio label="Fuel types" name="gasolineType"
			list="{'Diesel','Unleaded','Premium'}" />

		<s:textfield label="Enter the credit card number" key="creditNumber" />


		<s:radio label="Credit card types" name="creditType"
			list="{'Visa','Mastercard','JCB','AMEX','Diners'}" />

		<s:submit value="Compute Payroll" />
		<s:reset />
	</s:form>
</body>
</html>