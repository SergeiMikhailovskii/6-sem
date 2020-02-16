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
<form>
    Period: <input type="number" name="period" size="50"> <br>
    Faculty: <input type="text" name="faculty" size="50"> <br>
    <a href="${pageContext.request.contextPath}/calculatePaymentForSeveralSemesters?period=<%=request.getParameter("period")%>&faculty=<%=request.getParameter("faculty")%>">Calculate
        payment for several semesters</a>
    <br>
    <a href="${pageContext.request.contextPath}/showTwoSmallestFaculties">Show two smallest faculties</a>
    <input type="submit">
</form>
</p>
</body>
</html>