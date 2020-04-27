<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27.04.2020
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/searchPersonById">
    <input type="text" placeholder="Person id" name="personId" value="${personId}" size="50"/><br>
    <button type="submit">Search person by id</button>
</form>
</body>
</html>
