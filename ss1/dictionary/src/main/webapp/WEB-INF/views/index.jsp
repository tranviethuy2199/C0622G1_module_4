<%--
  Created by IntelliJ IDEA.
  User: Viet Huy
  Date: 13/10/2022
  Time: 4:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/result" method="get">
    <h2>Translation</h2>
    <input type="text" name="word" placeholder="nhập từ cần tìm kiếm">
    <input type="submit">
  </form>
  <p>Result :${vocabulary}</p>
  </body>
</html>
