<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="pinagpalitanNgPera" type="bpi.forex.model.ForexBean" scope="application"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>
	<h1>BPI Forex Web Appilication</h1>
	
	<p>The amount of <b>Php${pinagpalitanNgPera.phpAmount} is ${pinagpalitanNgPera.currency}
		${pinagpalitanNgPera.result}</b> 
		
		</p>
		<hr/>
		<form action = "index.jsp" method="post">
			<p><input type="submit" value="GO BACK">
		</form>
		<hr/>
	<form action="listrecords.html" method="post">
		<p><input type="submit" value="Display All Records">
	</form>
	<form action="listrecord.html" method="post">
		<button type="submit" class="btn btn-primary">View Tables</button>
	</form>
</body>
</html>