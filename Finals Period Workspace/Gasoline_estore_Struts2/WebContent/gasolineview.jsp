<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<p>Fuel type: <s:property value="gasolineType"/> </p>
	<p>Price per liter amount: <s:property value="pricePerLiter"/> </p>
	<p>Purchase: <s:property value="purchaseAmount"/> </p>
	<p>Vat: <s:property value="vat"/> </p>
	<p>Total purchase amount: <s:property value="totalPurchaseAmount"/> - <s:property value="message"/></p>
	<p>Credit card number: <s:property value="creditNumber"/> successfully charged</p>
</body>
</html>