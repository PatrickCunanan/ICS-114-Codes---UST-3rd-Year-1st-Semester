<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="st" type="java.sql.ResultSet" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>ID</th>
			<th>Input String</th>
			<th>Input Letters</th>
			<th>Input Numbers</th>
			<th>Total Letters</th>
			<th>Total Numbers</th>
		</tr>

		<%
						boolean isEmpty = true;
						while (st.next()) {
							isEmpty = false;
					%>
		<tr>
			<td><%=st.getInt("id")%></td>
			<td><%=st.getString("inputString")%></td>
			<td><%=st.getString("inputLetters")%></td>
			<td><%=st.getString("inputNumbers")%></td>
			<td><%=st.getInt("totalLetters")%></td>
			<td><%=st.getInt("totalNumber")%></td>
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
	<form action="index.jsp" method="post">
		<button type="submit" class="btn btn-primary">Go Back</button>
	</form>
</body>
</html>