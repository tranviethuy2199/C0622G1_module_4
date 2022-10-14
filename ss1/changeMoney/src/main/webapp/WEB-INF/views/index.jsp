<%--
  Created by IntelliJ IDEA.
  User: Viet Huy
  Date: 13/10/2022
  Time: 3:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/result" method="get">
    <h2>Change Money</h2>
    <input type="number" name=" usd">
    <input type="submit" placeholder="tinh tien">
  </form>
  <p>Result :${vnd}</p>
  </body>
</html>
