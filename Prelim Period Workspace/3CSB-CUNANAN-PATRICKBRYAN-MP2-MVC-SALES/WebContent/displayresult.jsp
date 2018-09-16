<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Sales Commission Web Application</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
fieldset.form-border {
	border: 1px groove #ddd !important;
	padding: 0 1.4em 1.4em 1.4em !important;
	margin: 0 0 1.5em 0 !important;
	-webkit-box-shadow: 0px 0px 0px 0px #000;
	box-shadow: 0px 0px 0px 0px #000;
}

legend.form-border {
	width: inherit;
	padding: 0 10px;
	border-bottom: none;
}
</style>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">SWCA</a>
		</div>
		<ul class="nav navbar-nav">
		</ul>
	</div>
	</nav>
	<div class="container">
		<h1 class="bg-primary">Sales Commission Web Application</h1>
		<fieldset class="form-border">
			<legend class="form-border">${PayKey.eName}</legend>
			<form action="index.jsp" method="post">
				<p>Employee Name: ${PayKey.eName}</p>
				<p>Sales Code: ${PayKey.sCode}</p>
				<p>Sales Amount: ${PayKey.sAmount}</p>
				<p>Sales Gross Commission: ${PayKey.sGross}</p>
				<p>Sales Commission: ${PayKey.sCommission}</p>
				<p>Take Home Pay: ${PayKey.takeHomePay}</p>
				<button type="submit" class="btn btn-primary">Go Back</button>
			</form>
			<hr />
			<form action="listrecord.html" method="post" class="form-inline">
				<button type="submit" class="btn btn-primary">View Tables</button>
			</form>
		</fieldset>
	</div>
</body>
</html>