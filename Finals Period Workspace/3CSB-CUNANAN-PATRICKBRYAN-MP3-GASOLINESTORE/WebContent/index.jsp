<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Patrick's Gasoline eStore</title>
<meta charset="utf-8">
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
panel {
   background-color: rgba(245, 245, 245, 0.4);
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
	<p class="bg-danger text-center text-danger">${error}</p>
	<div class="container">
		<div class="panel panel-success">
			<div class="panel-heading">Input form</div>
			<div class="panel-body">
				<form action="processgas.html" method="post">

					<h4>Choose Gasoline Type:</h4>
					<label class="radio-inline"><input type="radio"
						name="gType" value="Unleaded" required="required">Unleaded</label>
					<label class="radio-inline"><input type="radio"
						name="gType" value="Diesel">Diesel</label> <label
						class="radio-inline"><input type="radio" name="gType"
						value="Premium">Premium</label>

					<div class="form-group">
						<h4>Gasoline Liters:</h4>
						<input type="text" class="form-control" name="gLiters"
							required="required"
							placeholder="Enter how many liters of gasoline.">
					</div>

					<h4>Choose Credit Card Type:</h4>
					<label class="radio-inline"><input type="radio"
						name="cType" value="VISA" required="required">VISA</label> <label
						class="radio-inline"><input type="radio" name="cType"
						value="MASTERCARD">MASTERCARD</label> <label class="radio-inline"><input
						type="radio" name="cType" value="JCB">JCB</label> <label
						class="radio-inline"><input type="radio" name="cType"
						value="AMEX">AMEX</label> <label class="radio-inline"><input
						type="radio" name="cType" value="DINERS">DINERS</label>

					<div class="form-group">
						<h4>Credit Card Number:</h4>
						<input type="text" class="form-control" name="cNumber"
							required="required" placeholder="Enter credit card number.">
					</div>

					<div class="btn-group" role="group">
						<div class="btn-group">
							<button type="submit" class="btn btn-success">Submit</button>
						</div>
						<div class="btn-group">
							<button type="reset" class="btn">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>