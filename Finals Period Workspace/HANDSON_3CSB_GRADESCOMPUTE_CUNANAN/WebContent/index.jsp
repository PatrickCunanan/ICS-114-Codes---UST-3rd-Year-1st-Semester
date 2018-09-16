<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
</head>
<body>
	<form action="compute.action" method="post">
		<p>
			Midterm raw score:<input type="text" name="midterm" id="midterm">
		</p>
		<p>
			Pre-final raw score:<input type="text" name="prefinal" id="prefinal">
		</p>
		<input type="submit" value="Compute"> <input type="reset">
	</form>

	<hr>
	<s:form action="compute.action" method="post">
		<s:textfield label="Mideterm raw score: " key="midterm" />
		<s:textfield label="Pre-final raw score: " key="prefinal" />
		<s:submit type="submit" value="Compute Grade" />
		<s:reset />
	</s:form>
</body>
</html>