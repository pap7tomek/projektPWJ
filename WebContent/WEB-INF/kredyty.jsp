<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Kalkulator kredytowy - kredyt gotówkowy</h1>
<p>Oblicz, ile wyniesie rata Twojego kredytu, jak długo będziesz spłacać zadłużenie, i ile zapłacisz odsetek.</p>
<form action="Kredyty" method="post">
	<label><input name="kwota" type="text" required>Kwota kredytu</label><br>
	<label><input name="oprocentowanie" type="text" required>% Oprocentowanie kredytu</label><br>
	<label><input name="okres" type="text" required>Na ile lat
	</label><br>
	<select name="typ">
	    	<option value="1">raty równe</option>
	    	<option value="2">raty malejące</option>
	 	</select>Rodzaj rat<br>
	<input style="display:none;" name="telefon" type="text" value="${telefon}">
	<input type="submit" value="Oblicz">
</form>
</body>
</html>