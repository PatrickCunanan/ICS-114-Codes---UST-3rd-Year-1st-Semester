<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="gt" type="java.sql.ResultSet" scope="request" />
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
			<div class="panel-heading">View Table</div>
			<div class="panel-body">
				<h4 class="bg-success">Customer Purchase Table</h4>
				<table class="table table-hover table-bordered">
					<tr>
						<th>ID</th>
						<th>Gasoline Type</th>
						<th>Gasoline Liters</th>
						<th>Price Per Liter</th>
						<th>Purchase Amount</th>
						<th>VAT</th>
						<th>Total Amount</th>
					</tr>

					<%
						boolean isEmpty = true;
						while (gt.next()) {
							isEmpty = false;
					%>
					<tr>
						<td><%=gt.getInt("id")%></td>
						<td><%=gt.getString("gType")%></td>
						<td><%=gt.getDouble("gLiters")%></td>
						<td><%=gt.getDouble("pPerLiter")%></td>
						<td><%=gt.getDouble("pAmount")%></td>
						<td><%=gt.getDouble("vTax")%></td>
						<td><%=gt.getDouble("tAmount")%></td>
					</tr>
					<%
						}
					%>
				</table>
				<%
					if (isEmpty) {
				%>
				<p class="bg-danger text-center text-danger">There are no
					records inside the table</p>
				<%
					}
				%>
				<form action="index.jsp" method="post" class="form-inline">
					<button type="submit" class="btn btn-success">Go Back</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>