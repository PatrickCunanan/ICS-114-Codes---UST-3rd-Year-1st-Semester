<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Patrick's Gasoline eStore</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	background-color: #323232
}
</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Gasoline eStore</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">Buy Gasoline</a></li>
				<li><a href="listrecords.html">View Table</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<div class="container">
		<div class="panel panel-success">
			<div class="panel-heading">Show Result</div>
			<div class="panel-body">
				<table class="table table-bordered">
					<tr>
						<td><b>Gasoline Type:</b></td>
						<td>${gas.gType}</td>
					</tr>
					<tr>
						<td><b>Number of Liters Bought:</b></td>
						<td>${gas.gLiters}</td>
					</tr>
					<tr>
						<td><b>Credit Card Type:</b></td>
						<td>${gas.cType}</td>
					</tr>
					<tr>
						<td><b>Credit Card Number:</b></td>
						<td>${gas.cNumber}</td>
					</tr>
					<tr>
						<td><b>Price Per Liter Amount:</b></td>
						<td>P ${gas.pPerLiter}</td>
					</tr>
					<tr>
						<td><b>Purchased Amount:</b></td>
						<td>P ${gas.pAmount}</td>
					</tr>
					<tr>
						<td><b>VAT:</b></td>
						<td>P ${gas.vTax}</td>
					</tr>
					<tr>
						<td><b>Total Amount:</b></td>
						<td>P ${gas.tAmount}(${gas.tConvert})</td>
					</tr>
				</table>
				<form action="index.jsp" method="post">
					<button type="submit" class="btn btn-success">Go Back</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>