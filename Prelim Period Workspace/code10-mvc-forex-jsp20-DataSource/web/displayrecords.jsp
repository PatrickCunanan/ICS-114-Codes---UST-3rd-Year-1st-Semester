<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<jsp:useBean id="forexRecords" type="java.sql.ResultSet" 
scope="request"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Forex Web Application</title>
</head>
<body>
	<h1 align="center">Forex Web Application</h1>
	
	<table align="center" border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>Transaction ID</th>
			<th>Php Amount</th>
			<th>Currency</th>
			<th>Converted Amount</th>
		</tr>
		
		<% while (forexRecords.next()) { %>
		<tr>
			<td align="center"><%=forexRecords.getInt("id") %></td>
			<td align="center">
				<%=forexRecords.getInt("phpAmount") %></td>
				<td align="center">
					<%=forexRecords.getString("currency") %></td>
					<td align="center">
						<%=forexRecords.getDouble("result") %></td>		
					</tr>	
					<% } %>
				</table>
				<hr/>
				<form action="index.jsp" method="post">	
					<p><input type="submit" value="<< GO BACK >>">
					</form>
				</body>
				</html>



