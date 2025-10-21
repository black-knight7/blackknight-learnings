<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Here..</h2>
	<form action="verifyLogin" method="post">
		Email<input type="text" name="email">
		Password<input type="password" name="pass">
		<input type="submit" value="login">
	</form>
<h2>Save Login Here..</h2>
	<form action="saveLogin" method="post">
		Email<input type="text" name="email">
		Password<input type="password" name="pass">
		<input type="submit" value="save">
	</form>
<h2>Delete Login Here..</h2>
    <form action="deleteLogin" method="post">
		Email<input type="text" name="email">
		<input type="submit" value="delete">
	</form>
</body>
</html> 