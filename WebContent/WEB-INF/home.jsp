<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kalkulator home</title>
</head>
<body>
<h1>Kalkulator</h1>
<a href="Registration">Rejestracja</a>
<a href="Login">Zaloguj się</a>
<form action="Home" method="post">
	<label><input name="imie" type="text" required>Imie</label><br>
	<label><input name="nazwisko" type="text" required>Nazwisko</label><br>
	<label><input name="telefon" type="text" required>Telefon</label><br>
	<label><input type="radio" name="type" value="1" checked>Kredyt</label>
	<label><input type="radio" name="type" value="2">Lokata</label><br>
	<input type="submit" value="Włacz kalkulator">
</form>
</body>
</html>