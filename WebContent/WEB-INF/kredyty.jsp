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
	<label>
		<select name="prowizjaJest">
	    	<option value="1">nie uwzględniaj</option>
	    	<option value="2">powiększa kwotę kredytu</option>
	    	<option value="3">zmniejsza kwotę wypłaty</option>
	    	<option value="4">opłacona osobno</option>
	 	</select>
	 	Prowizja
 	</label><br>
	<label><input name="prowizja" type="text" required>
	<select name="prowizjaOpcja">
	    	<option value="1">%</option>
	    	<option value="2">zł</option>
	 	</select>
	Wysokość prowizji</label><br>
	<label><input name="oprocentowanie" type="text" required>% Oprocentowanie kredytu</label><br>
	<label><input name="okres" type="text" required>
	<select name="okres2">
	    	<option value="1">lat</option>
	    	<option value="2">miesięcy</option>
	 	</select>Okres kredytu
	</label><br>
	<input style="display:none;" name="telefon" type="text" value="${telefon}">
	<input type="submit" value="Oblicz">
</form>
</body>
</html>