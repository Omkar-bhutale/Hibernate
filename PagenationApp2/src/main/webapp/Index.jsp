<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input page</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Welcome to LIC</h1>
	<form action='./controller' method="get">
		<table align="center" bgcolor="cyan">
			<tr>
				<td>Enter input page</td>
				<td><input type='text' name='pageSize' /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value='generatereport' name='s1' /></td>
			</tr>
		</table>
	</form>

</body>
</html>