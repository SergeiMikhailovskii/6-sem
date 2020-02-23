<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 23.02.2020
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Smallest Faculties</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Theme</th>
        <th>Payment</th>
    </tr>
    <c:forEach items="${facultyList}" var="faculty" varStatus="status">
        <tr>
            <td>${faculty.name}</td>
            <td>${faculty.size}</td>
            <td>${faculty.payment}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
