<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 01.03.2020
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new customer</title>
</head>
<body>
<form method="post">
    <input type="text" placeholder="Discount" name="discount" value="${discount}" size="50"/><br>
    <input type="text" placeholder="Zip" name="zip" value="${zip}" size="50"/><br>
    <input type="text" placeholder="Name" name="name" value="${name}" size="50"/><br>
    <input type="text" placeholder="Address" name="address" value="${address}" size="50"/><br>
    <input type="text" placeholder="State code" name="stateCode" value="${stateCode}" size="50"/><br>
    <input type="number" placeholder="Credit limit" name="creditLimit" value="${creditLimit}" size="50"/><br>
    <button type="submit">Save</button>
</form>
</body>
</html>
