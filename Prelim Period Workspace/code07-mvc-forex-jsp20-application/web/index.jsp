 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BPI Forex Web Application Currency Exchange</title>
</head>
<body>
	<img src= "images/bpi.JPG"/>
	<h2>BPI Forex Web Application Currency Exchange</h2>
	<fieldset>
		<legend>Forex Input Form</legend>
		<form action="processconversion.html" method="post">
			<p> Enter Philippine Peso Amount: <input type = "text" name="phpAmount" id="phpAmount" required="required"/></p>
			<p> Select Currency:
				<select name="currency" id="currency">
					<option value="US$"> US$ </option>
					<option value="EURO"> EURO </option>
					<option value="YEN"> YEN </option>
					<option value="AUS$"> AUS$ </option>
				</select> 
			</p>
			<p><input type="submit" value="Convert"/>&nbsp;&nbsp;&nbsp;
			<p><input type="reset">
		</form>
	</fieldset>
	<hr/>
	<form action="listrecords.html" method="post">
		<p><input type="submit" value="Display All Records">
	</form>
</body>
</html>