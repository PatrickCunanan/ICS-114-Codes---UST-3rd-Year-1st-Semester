<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Output</title>
</head>
<body>
	<h2>Output</h2>
	<p>
		Investment Fund Type: <b><s:property value="fundType" />&nbsp; <s:property
				value="lastName" /></b>
	</p>
	<p>
		Amount Invested: <b><s:property value="amount" /></b>
	</p>
	<p>
		NAVPS: <b>Php<s:property value="navps" /> (as of December 1, 2016)</b>
	</p>
	<p>
		Sales Load Amount: <b>Php<s:property value="slAmount" /></b>
	</p>
	<p>
		Net Amount: <b>Php<s:property value="netAmount" /></b>
	</p>
	<p>
		Total Shares: <b>Php<s:property value="totalShares" /></b>
	</p>

	<hr />
	<form action="fundinvestmentform.jsp">
		<p>
			<input type="submit" value="GO BACK" />
		</p>
	</form>
</body>
</html>

