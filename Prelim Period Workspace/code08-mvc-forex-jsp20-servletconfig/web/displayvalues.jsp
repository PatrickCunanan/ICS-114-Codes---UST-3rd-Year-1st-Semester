<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="palitanNgPera" type="edu.ust.iics.forex.model.ForexBean" 
	scope="application"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forex Web Application</title>
</head>
<body>
	<h2>Forex Web Application</h2>
	<p>The amount of <b>Php${applicationScope.palitanNgPera.phpAmount}</b>
		is equivalent to <b>${applicationScope.palitanNgPeraph.currency}&nbsp;
		${applicationScope.palitanNgPera.result}</b></p>
	<hr/>
	<form action="index.jsp" method="post">
		<p><input type="submit" value="<< GO BACK >>">
	</form>
	<form action="listrecords.html" method="post">	
		<p><input type="submit" value="Display All Records">
	</form>
</body>
</html>