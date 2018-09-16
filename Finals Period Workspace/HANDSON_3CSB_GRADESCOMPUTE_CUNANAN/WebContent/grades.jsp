<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Computed Grades</title>
</head>
<body>
	<h2>Grade Computation Details</h2>
	<p>Midterm Grade: ${midterm}</p>
	<p>Pre-Final Grade: ${prefinal}</p>
	<p>${message}</p>

	<hr>
	<p>
		Midterm Grade:
		<s:property value="midterm" />
	</p>
	<p>
		Pre-Final Grade:
		<s:property value="prefinal" />
	</p>
	<p>
		<s:property value="message" />
	</p>
	<hr>

	<form action="index.jsp">
		<input type="submit" value="Go Back">
	</form>
</body>
</html>