<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 09.03.2020
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new customer</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/addNewCustomer" method="post">
        <input type="text" placeholder="Discount" name="discount" value="${discount}" size="50"/><br>
        <input type="text" placeholder="Zip" name="zip" value="${zip}" size="50"/><br>
        <input type="text" placeholder="Name" name="name" value="${name}" size="50"/><br>
        <input type="text" placeholder="Address" name="address" value="${address}" size="50"/><br>
        <input type="text" placeholder="State code" name="stateCode" value="${stateCode}" size="50"/><br>
        <input type="text" placeholder="Credit limit" name="creditLimit" value="${creditLimit}" size="50"/><br>
        <button type="submit">Add user</button>
    </form>
</body>
</html>
