<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${policiesList ne null || !empty policiesList }">
			<table border="1">
				<tr>
					<th>PolicyId</th>
					<th>PolicyName</th>
					<th>PolicyType</th>
					<th>Company</th>
					<th>Tenure</th>
				</tr>
			</table>
		</c:when>
	</c:choose>

</body>
</html>