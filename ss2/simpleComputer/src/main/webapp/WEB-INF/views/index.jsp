<%--
  Created by IntelliJ IDEA.
  User: Viet Huy
  Date: 14/10/2022
  Time: 10:57 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="result" method="get" >
    <h2>Simple Computer</h2>
    <input type="text" name="a" placeholder="input number">
    <input type="text" name="b" placeholder="input number"><br>
    <button type="submit" value="summation" name="submit">Addation(+)</button>
    <button type="submit" value="subtraction" name="submit">subtraction(-)</button>
    <button type="submit" value="multiplication" name="submit">multiplication(*)</button>
    <button type="submit" value="division" name="submit">division(/ )</button>
  </form>
  <p>Result : ${result}</p>
  </body>
</html>
