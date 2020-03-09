<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>

<body>

<form method="get" action="${pageContext.request.contextPath}/addNewCustomer">
    <button type="submit">Add new Customer</button>
</form>

<form method="get" action="${pageContext.request.contextPath}/showAllCustomers">
    <button type="submit">Show all Customers</button>
</form>

<form method="get" action="${pageContext.request.contextPath}/searchCustomerByStateCodeAndCreditLimit">
    <input type="text" placeholder="State code" name="stateCode" value="${stateCode}" size="50"/><br>
    <input type="number" placeholder="Credit limit" name="creditLimit" value="${creditLimit}" size="50"/><br>
    <button type="submit">Search customer by state code and credit limit</button>
</form>

</body>
</html>