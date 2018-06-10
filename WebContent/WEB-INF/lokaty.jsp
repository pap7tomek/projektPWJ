<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Ile zarobię na lokacie? Oblicz odsetki.</h1>
<p>Oblicz, ile możesz zarobić na lokacie. Jeśli dziś odłożysz 100 zł, to za 500 lat możesz stać się miliarderem.</p>
<form action="Lokaty" method="post">
	<label>Kwota<input name="kwota" type="text" required></label><br>
	<label>Oprocentowanie<input name="oprocentowanie" type="text" required>%</label><br>
	<label>Okres deponowania<input name="okres" type="text" required>
		<select name="okres2">
	    	<option value="1">lat</option>
	    	<option value="2">miesiecy</option>
	    	<option value="3">tygodni</option>
	    	<option value="4">dni</option>
	 	</select>
 	</label><br>
	<label>Kapitalizacja
	<select name="kapitalizacja">
	    	<option value="1">15 dni</option>
	    	<option value="2">1 miesiąc</option>
	    	<option value="3">3 miesiące</option>
	    	<option value="4">6 miesiecy</option>
	    	<option value="5">rok</option>
	 	</select>
	</label><br>
	<input type="submit" value="Oblicz">
</form>
</body>
</html>