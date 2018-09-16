<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b>Input:</b>${s.input}<br>
	<b>Letters:</b>${s.inputChar}<br>
	<b>Numbers:</b>${s.inputNumbers}<br>
	<b>Total letters:</b>${s.totalChar}<br>
	<b>Total Numbers:</b>${s.totalNum}<br>
	<br>
	<form action="index.jsp" method="post">
		<button type="submit" class="btn btn-primary">Go Back</button>
	</form>
	<form action="listrecord.html" method="post">
		<button type="submit" class="btn btn-primary">View Tables</button>
	</form>
</body>
</html>