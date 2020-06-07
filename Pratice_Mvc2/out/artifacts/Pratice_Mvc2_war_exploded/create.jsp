<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/5/2020
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New Product</title>
    <c:if test="${sessionScope.bean == null}">
        <jsp:forward page="index.jsp"></jsp:forward>
    </c:if>
</head>
<body>
<h2>Create New Product</h2>
<form action="CreateController" method="post">
    ID : <input type="text" name="id"><br>
    Name : <input type="text" name="name"><br>
    Desc : <input type="text" name="desc"><br>
    <input type="submit" value="Save">
</form>
</body>
</html>
