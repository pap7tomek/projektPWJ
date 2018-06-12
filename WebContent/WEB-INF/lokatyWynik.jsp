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
	<label>Kwota<input value="${kwota}" name="kwota" type="text" required></label><br>
	<label>Oprocentowanie<input value="${oprocentowanie}" name="oprocentowanie" type="text" required>%</label><br>
	<label>Okres deponowania<input value="${okres}" name="okres" type="text" required>
		<select name="okres2">
	    	<option ${okres2==1 ? "selected": ""} value="1">lat</option>
	    	<option ${okres2==2 ? "selected": ""} value="2">miesiecy</option>
	    	<option ${okres2==3 ? "selected": ""} value="3">tygodni</option>
	    	<option ${okres2==4 ? "selected": ""} value="4">dni</option>
	 	</select>
 	</label><br>
	<label>Kapitalizacja
	<select name="kapitalizacja">
	    	<option ${kapitalizacja==1 ? "selected": ""} value="1">15 dni</option>
	    	<option ${kapitalizacja==2 ? "selected": ""} value="2">1 miesiąc</option>
	    	<option ${kapitalizacja==3 ? "selected": ""} value="3">3 miesiące</option>
	    	<option ${kapitalizacja==4 ? "selected": ""} value="4">6 miesiecy</option>
	    	<option ${kapitalizacja==5 ? "selected": ""} value="5">rok</option>
	 	</select>
	</label><br>
	<input style="display:none;" value="${telefon}" name="telefon" type="text" value="${telefon}">
	<input type="submit" value="Oblicz">
	<p>Jeśli dzisiaj włożysz ${kwota} zł na lokatę, to za ${okres} będziesz mieć ${miec}</p>
	<table>
	<thead>
    	<tr>
          <th>Wartość</th>
          <th>Kwota</th>
        </tr>
	</thead>
	<tbody>
		<tr>
			<td>Deponowana kwota</td>
			<td>${kwota} zł</td>
		</tr>
		<tr>
			<td>Podatek</td>
			<td>${podatek} zł</td>
		</tr>
		<tr>
			<td>Zysk netto</td>
			<td>${zysk} zł</td>
		</tr>
	</tbody>
	</table>
</form>
</body>
</html>