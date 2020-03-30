<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 01.03.2020
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all customers</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Theme</th>
        <th>Payment</th>
    </tr>
    <c:forEach items="${customers}" var="customer" varStatus="status">
        <tr>
            <td>${customer.discount}</td>
            <td>${customer.zip}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.stateCode}</td>
            <td>${customer.creditLimit}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
