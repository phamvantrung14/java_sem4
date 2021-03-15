<%--
  Created by IntelliJ IDEA.
  User: asuspc
  Date: 3/12/2021
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="product" method="get">
        <span style="color: red">

            <c:out value="${param.msg}" />
        </span>
    <input type="text" name="name"  />
    <input type="submit" />
</form>
</body>
</html>
