<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tbody>
	
	<tr>
		<td>kwota kredytowana:</td>
		<td>${kwota}</td>
	</tr>
	<tr>
		<td>kwota do wypłaty:</td>
		<td>${kwota}</td>
	</tr>
	<tr>
		<td>suma spłat:</td>
		<td>${suma}</td>
	</tr>
</tbody>
</table>
<% int i = 0; %>
<c:forEach items="${lista}" var="item">
	<% out.print(++i); %>
    ${item}<br>
</c:forEach>
<c:if test = "${typ == 1}">
	<p>Rata: ${rata}</p>
</c:if>
<a href="Home">Strona główna</a>
</body>
</html>