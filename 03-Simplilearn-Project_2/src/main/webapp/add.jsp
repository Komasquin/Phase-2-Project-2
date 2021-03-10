<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Hello Add a Product</h1>
	<div align="center">
		<form action="AddServlet" method="post">
			Item Name: <input type="text" name="name" />
			Number Received: <input type="text" name="count" />
			<input type="submit" value="add">
		</form>	
	</div>
</body>
</html>