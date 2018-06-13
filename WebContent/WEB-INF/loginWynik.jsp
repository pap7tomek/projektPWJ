<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${info}</h1>
<c:if test="${!empty lokaty}">
<h2>Lokaty</h2>
<table>
  <tr>
    <th>Kwota</th>
    <th>Oprocentowanie</th>
    <th>Okres deponowania</th>
    <th>Kapitalizacja</th>
    <th>Odbierzesz</th>
  </tr>

<c:forEach items="${lokaty}" var="item">
<tr>
    <td>${item.kwota}</td>
    <td>${item.oprocentowanie}%</td>
    <td>${item.okres} 
    <c:if test="${item.okres2 == 1}">
    	lat
    </c:if>
    <c:if test="${item.okres2 == 2}">
    	miesiecy
    </c:if>
    <c:if test="${item.okres2 == 3}">
    	tygodni
    </c:if>
    <c:if test="${item.okres2 == 4}">
    	dni
    </c:if>
    </td>
    <td>
    <c:if test="${item.kapitalizacja == 1}">
    	15 dni
    </c:if>
    <c:if test="${item.kapitalizacja == 2}">
    	1 miesiac
    </c:if>
    <c:if test="${item.kapitalizacja == 3}">
    	3 miesiace
    </c:if>
    <c:if test="${item.kapitalizacja == 4}">
    	6 miesiacy
    </c:if>
    <c:if test="${item.kapitalizacja == 5}">
    	rok
    </c:if>
    </td>
    <td>${item.wynik}zł</td>
</tr>

</c:forEach>
</table>
</c:if>
<c:if test="${!empty kredyty}">
<h2>Kredyt</h2>
<table>
  <tr>
    <th>Kwota</th>
    <th>Oprocentowanie</th>
    <th>Okres spłaty</th>
    <th>Typ</th>
    <th>Razem do spłaty</th>
  </tr>

<c:forEach items="${kredyty}" var="item">
<tr>
    <td>${item.kwota}</td>
    <td>${item.oprocentowanie}%</td>
    <td>${item.okres}</td>
    <td>
    <c:if test="${item.typ == 1}">
    	raty równe
    </c:if>
    <c:if test="${item.typ == 2}">
    	raty rosnące
    </c:if>
    </td>
    <td>${item.wynik}zł</td>
</tr>

</c:forEach>
</table>
</c:if>
<a href="Home">Strona główna</a>
</body>
</html>