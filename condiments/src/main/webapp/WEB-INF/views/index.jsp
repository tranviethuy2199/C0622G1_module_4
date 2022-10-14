<%--
  Created by IntelliJ IDEA.
  User: Viet Huy
  Date: 14/10/2022
  Time: 2:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/save" method="get">
    <h2>Sandwich Condiments</h2>
    <input type="checkbox" value="Lettuce" name="condiment">Lettuce
    <input type="checkbox" value="Tomato" name="condiment">Tomato
    <input type="checkbox" value="Mustard" name="condiment">Mustard
    <input type="checkbox" value="Sprouts" name="condiment">Sprouts
    <input type="submit" value="save">
</form>
<c:forEach var="c" items="${condiment}" varStatus="count">
    <p>
        The number ${count.getCount()} condiment is ${c}
    </p>
</c:forEach>
</body>
</html>
