<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="pinagpalitanNgPera" type="bpi.forex.model.ForexBean" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>BPI Forex Web Appilication</h1>
	
	<p>The amount of <b>Php<jsp:getProperty property="phpAmount" name="pinagpalitanNgPera"/>
		is <jsp:getProperty property="currency" name="pinagpalitanNgPera"/> 
		<jsp:getProperty property="result" name="pinagpalitanNgPera"/></b> 
		
		</p>
		<hr/>
		<form action = "index.jsp" method="post">
			<p><input type="submit" value="GO BACK">
		</form>
</body>
</html>