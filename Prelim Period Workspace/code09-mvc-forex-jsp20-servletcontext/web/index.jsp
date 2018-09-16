<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forex Web Application</title>
</head>
<body>
	<h1>Forex Web Application</h1>
	
	<fieldset>
		<legend>UST Foreign Currency Exchange</legend>
		<form action="processconversion.html" method="post">
			<p>Enter Philippine Peso: Php<input type="number" name="phpAmount"
				id="phpAmount"/></p>
			<p>Select currency:
				<select name="currencyType" id="currencyType">
					<option value="US$">US$</option>
					<option value="EURO">&euro;uro</option>
					<option value="YEN">&yen;en</option>
					<option value="AUS$">AUS$</option>
				</select>
			</p>	
			<p><input type="submit" value="Convert">&nbsp;&nbsp;&nbsp;
			<input type="reset"/>
		</form>
	</fieldset>
	<hr/>
	<form action="listrecords.html" method="post">	
		<p><input type="submit" value="Display All Records">
	</form>
</body>
</html>