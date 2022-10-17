<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: viet huy
  Date: 10/17/2022
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" action="/index" method="get">
    <table>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="languages">
                    <form:options items="${languageList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>Show
                <form:select path="pageSize">
                    <form:options items="${pageSize}"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>Spams Filter</td>
            <td>
                <form:checkbox path="spamFilter" value="spam Filter"/>
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td style="boder:50px">
                <form:input path="signature"/>
            </td>
        </tr>
        <tr>
            <td style="border:1px ; background-color: cornflowerblue ; color: aliceblue"><a href="#">Update</a></td>
            <td style="border:1px ; background-color: white ; color: black"><a href="#">Cancel</a></td>
        </tr>
    </table>
</form:form>


</body>
</html>
