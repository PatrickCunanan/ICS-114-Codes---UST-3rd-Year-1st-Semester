<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Sales Commission Web Application</title>
<meta charset="utf-8">
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
				<a class="navbar-brand" href="#">SCWA</a>
			</div>
			<ul class="nav navbar-nav">
			</ul>
		</div>
	</nav>
	<p class="bg-danger text-center text-danger">${error}</p>
	<div class="container">
		<h1 class="bg-primary">Sales Commission Web Application</h1>
		<fieldset class="form-border">
			<legend class="form-border">Input Information</legend>
			<form action="processpay.html" method="post">
				<div class="form-group">
					<label for="empName">Employee Name</label> <input type="text"
						class="form-control" name="eName" required="required"
						maxlength="50" pattern="[A-Za-z.\s]{1,100}"
						title="Enter only letters!" placeholder="Enter employee name">
				</div>
				<div class="form-group">
					<label for="sCode">Sales Code</label> <select name="sCode"
						class="form-control" id="sCodes">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
					</select>
				</div>
				<div class="form-group">
					<label for="sAmount">Sales Amount</label> <input type="text"
						class="form-control" name="sAmount" required="required"
						placeholder="Enter sales amount">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="reset" class="btn">Reset</button>
			</form>
			<hr />
			<form action="listrecord.html" method="post" class="form-inline">
				<button type="submit" class="btn btn-primary">View Tables</button>
			</form>
		</fieldset>
	</div>
</body>
</html>