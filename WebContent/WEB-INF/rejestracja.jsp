<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Rejestracja</h1>
<form action="Registration" method="post">
	<label>Login<input name="login" type="text" required></label><br>
	<label>Hasło<input name="haslo" type="text" required></label><br>
	<label>E-mail <input name="email" type="email" required></label><br>
	<label>Telefon <input name="telefon" type="text" required></label><br>
	<input type="submit" value="Zarejestruj">
</form>
</body>
</html>