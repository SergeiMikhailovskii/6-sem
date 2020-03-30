<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 09.02.2020
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab2</title>
</head>
<body>
<p>
<form method="get" action="${pageContext.request.contextPath}/calculatePaymentForSeveralSemesters">
    Period: <input type="number" name="period" value="${period}" size="50"> <br>
    Faculty: <input type="text" name="faculty" value="${faculty}" size="50"> <br>
    <button type="submit">Calculate payment for several semesters</button>
</form>

<form method="get" action="${pageContext.request.contextPath}/showTwoSmallestFaculties">
    <button type="submit">Show two smallest faculties</button>
</form>
</p>
</body>
</html>