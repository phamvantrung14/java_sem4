<%--
  Created by IntelliJ IDEA.
  User: asuspc
  Date: 3/12/2021
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .center{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="center">
    <a href="product?status=1">Sort DESC</a>
    <a href="product?status=2">Sort ASC</a>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Desc</td>
            <td>Detail</td>
        </tr>
        <c:forEach  var="product" items="${list}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.desc}"/></td>
                <td><a href="product?id=${product.id}">Detail</a></td>
            </tr>
        </c:forEach>

    </table>
    <a href="product/addProduct.jsp">add product</a>
</div>



</body>
</html>
