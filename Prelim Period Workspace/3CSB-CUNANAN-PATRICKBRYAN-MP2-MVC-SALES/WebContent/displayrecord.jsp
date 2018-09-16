<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="salesRecordsA" type="java.sql.ResultSet"
	scope="request" />
<jsp:useBean id="salesRecordsB" type="java.sql.ResultSet"
	scope="request" />
<jsp:useBean id="salesRecordsC" type="java.sql.ResultSet"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Sales Commission Web Application</title>
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
	<div class="container">
		<h1 class="bg-primary">Sales Commission Web Application</h1>
		<fieldset class="form-border">
			<legend class="form-border">Sales Code Tables</legend>
			<h4 class="bg-primary">Sales Code A</h4>
			<table class="table table-hover table-bordered">
				<tr>
					<th>id</th>
					<th>Employee Name</th>
					<th>Sales Amount</th>
					<th>Sales Gross Commission</th>
					<th>Sales Commission</th>
					<th>Take Home Pay</th>
				</tr>

				<%
					boolean isEmpty = true;
					while (salesRecordsA.next()) {
						isEmpty = false;
				%>
				<tr>
					<td><%=salesRecordsA.getInt("id")%></td>
					<td><%=salesRecordsA.getString("name")%></td>
					<td><%=salesRecordsA.getDouble("amount")%></td>
					<td><%=salesRecordsA.getDouble("grossCommission")%></td>
					<td><%=salesRecordsA.getDouble("salesCommission")%></td>
					<td><%=salesRecordsA.getDouble("takeHomePay")%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				if (isEmpty) {
			%>
			<p class="bg-danger text-center text-danger">There are no records
				inside the table</p>
			<%
				}
			%>
			<hr />
			<h4 class="bg-primary">Sales Code B</h4>
			<table class="table table-hover table-bordered">
				<tr>
					<th>id</th>
					<th>Employee Name</th>
					<th>Sales Amount</th>
					<th>Sales Gross Commission</th>
					<th>Sales Commission</th>
					<th>Take Home Pay</th>
				</tr>

				<%
					isEmpty = true;
					while (salesRecordsB.next()) {
						isEmpty = false;
				%>
				<tr>
					<td><%=salesRecordsB.getInt("id")%></td>
					<td><%=salesRecordsB.getString("name")%></td>
					<td><%=salesRecordsB.getDouble("amount")%></td>
					<td><%=salesRecordsB.getDouble("grossCommission")%></td>
					<td><%=salesRecordsB.getDouble("salesCommission")%></td>
					<td><%=salesRecordsB.getDouble("takeHomePay")%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				if (isEmpty) {
			%>
			<p class="bg-danger text-center text-danger">There are no records
				inside the table</p>
			<%
				}
			%>
			<hr />
			<h4 class="bg-primary">Sales Code C</h4>
			<table class="table table-hover table-bordered">
				<tr>
					<th>id</th>
					<th>Employee Name</th>
					<th>Sales Amount</th>
					<th>Sales Gross Commission</th>
					<th>Sales Commission</th>
					<th>Take Home Pay</th>
				</tr>

				<%
					isEmpty = true;
					while (salesRecordsC.next()) {
						isEmpty = false;
				%>
				<tr>
					<td><%=salesRecordsC.getInt("id")%></td>
					<td><%=salesRecordsC.getString("name")%></td>
					<td><%=salesRecordsC.getDouble("amount")%></td>
					<td><%=salesRecordsC.getDouble("grossCommission")%></td>
					<td><%=salesRecordsC.getDouble("salesCommission")%></td>
					<td><%=salesRecordsC.getDouble("takeHomePay")%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				if (isEmpty) {
			%>
			<p class="bg-danger text-center text-danger">There are no records
				inside the table</p>
			<%
				}
			%>
			<hr />
			<form action="index.jsp" method="post" class="form-inline">
				<button type="submit" class="btn btn-primary">Go Back</button>
			</form>
		</fieldset>
	</div>
</body>
</html>